package com.scala.base;

import com.scala.common.Reflection;
import com.scala.interfaces.IExercise;
import com.scala.listeners.PrintConsoleListener;
import com.scala.listeners.SetParameterListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Who on 2014/4/4.
 */
public class MainForm {
    private JFrame frame;
    private JPanel pnlMain;
    private JPanel pnlTop;
    private JComboBox cmbExercises;
    private JButton btRun;
    private JTextArea txtConsole;
    private JScrollPane pnlScroll;

    private IExercise currentExercise = null;
    private ConsoleWorker consoleWorker = null;
    private boolean running = false;
    private long startTime = 0l;
    private long endTime = 0l;
    private List<Parameter> parameterList = null;
    private long parameterSettingTime = 0l;

    public MainForm() {
    }

    public static void main(String[] args) {
        MainForm mainForm = new MainForm();
        mainForm.init();
    }

    private void init() {
        initForm();
        initListener();
        initExercises();
    }

    private void initForm() {
        frame = new JFrame("Scala") {
            public JFrame init() {
                enableEvents(ConsoleAWTEvent.EVENT_ID);
                return this;
            }

            @Override
            protected void processEvent(AWTEvent paramAWTEvent) {
                if ((paramAWTEvent instanceof ConsoleAWTEvent)) {
                    ConsoleAWTEvent consoleAWTEvent = (ConsoleAWTEvent) paramAWTEvent;
                    printConsole(consoleAWTEvent.getString());
                } else {
                    super.processEvent(paramAWTEvent);
                }
            }
        }.init();
        frame.setContentPane(this.pnlMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
        } catch (ClassNotFoundException e) {
        } catch (InstantiationException e) {
        } catch (IllegalAccessException e) {
        } catch (UnsupportedLookAndFeelException e) {
        }

        txtConsole.setBackground(Color.black);
        txtConsole.setForeground(Color.green);
        txtConsole.setCaretColor(Color.green);
    }

    private void initExercises() {
        List<Object> exerciseList = null;
        try {
            exerciseList = Reflection.getInstancesByInterface(Class.forName("com.scala.interfaces.IExercise"), "com.scala");
        } catch (ClassNotFoundException e) {
        }
        Collections.sort(exerciseList, new ExercisesComparator());
        for (int i = exerciseList.size() - 1; i >= 0; i--) {
            IExercise exercise = (IExercise) exerciseList.get(i);
            cmbExercises.addItem(exercise);
        }
    }

    private void initListener() {
        cmbExercises.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentExercise = (IExercise) cmbExercises.getSelectedItem();
                resetConsole(currentExercise);
            }
        });

        btRun.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (btRun.getText() == "Run") {
                    resetConsole(currentExercise);
                    consoleWorker = null;
                    consoleWorker = new ConsoleWorker(frame);
                    startTime = System.currentTimeMillis();
                    running = true;
                    consoleWorker.start();
                } else {
                    printConsole("\n\nExercise has stopped manually.");
                    bottomConsole();
                    endTime = System.currentTimeMillis();
                    String parameterInfo = "";
                    for (Parameter parameter : parameterList) {
                        parameterInfo += "\n" + parameter.getName() + ": " + parameter.getValue().toString();
                    }
                    if (parameterInfo != "") {
                        parameterInfo = "\n\nParameters:" + parameterInfo;
                        printConsole(parameterInfo);
                    }
                    printConsole("\n\nTotal running time: " + String.valueOf(getRunTime()) + " ms.");
                    running = false;
                    consoleWorker.stop();
                    consoleWorker = null;
                    btRun.setText("Run");
                }
            }
        });
    }

    private void resetConsole(IExercise exercise) {
        txtConsole.setText(null);
        txtConsole.append("Source code: " + exercise.getClass().getName() + "\n");
        if (exercise.getSummary() == null) {
            txtConsole.append("\n" + exercise.getName() + "\n");
        } else {
            txtConsole.append("\n" + exercise.getSummary() + "\n");
        }
    }

    private void printConsole(String string) {
        if (running) {
            txtConsole.append(string);
        }
    }

    private void bottomConsole() {
        txtConsole.setCaretPosition(txtConsole.getText().length());
    }

    private long getRunTime() {
        return endTime - startTime - parameterSettingTime;
    }

    public String getExceptionMessage(Exception e) {
        StringBuffer stringBuffer = new StringBuffer("null");
        if (e != null) {
            stringBuffer = new StringBuffer("");
            String message = e.toString();
            int length = e.getStackTrace().length;
            if (length > 0) {
                stringBuffer.append(message + "\n");
                for (int i = 0; i < length; i++) {
                    stringBuffer.append("\t at " + e.getStackTrace()[i]);
                    if (i != length - 1) {
                        stringBuffer.append("\n");
                    }
                }
            } else {
                stringBuffer.append(message);
            }
        }
        return stringBuffer.toString();
    }

    class ConsoleAWTEvent extends AWTEvent {
        public static final int EVENT_ID = AWTEvent.RESERVED_ID_MAX + 1;
        private String string = null;

        ConsoleAWTEvent(Object object, String string) {
            super(object, EVENT_ID);
            this.string = string;
        }

        public String getString() {
            return this.string;
        }
    }

    class ConsoleWorker extends Thread {
        private EventQueue eventQueue = null;
        private Component component = null;

        ConsoleWorker(Component paramComponent) {
            component = paramComponent;
        }

        public void run() {
            parameterList = new ArrayList<Parameter>();
            parameterSettingTime = 0l;
            eventQueue = Toolkit.getDefaultToolkit().getSystemEventQueue();
            currentExercise.addPrintConsoleListener(new PrintConsoleListener() {
                @Override
                public void print(String string) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                    }
                    eventQueue.postEvent(new ConsoleAWTEvent(component, string));
                }
            });
            currentExercise.addSetParameterListener(new SetParameterListener() {
                @Override
                public void set(Parameter... parameters) {
                    for (Parameter parameter : parameters) {
                        ParameterDialog parameterDialog = new ParameterDialog(parameter);
                        parameterDialog.pack();
                        parameterDialog.setLocationRelativeTo(component);
                        long parameterSettingStart = System.currentTimeMillis();
                        parameterDialog.setVisible(true);
                        long parameterSettingEnd = System.currentTimeMillis();
                        parameterSettingTime += parameterSettingEnd - parameterSettingStart;
                        if (!parameterList.contains(parameter)) {
                            parameterList.add(parameter);
                        }
                    }
                }
            });
            btRun.setText("Stop");
            try {
                currentExercise.run();
            } catch (Exception e) {
                printConsole("\n\nException:\n" + getExceptionMessage(e));
            }
            endTime = System.currentTimeMillis();
            String parameterInfo = "";
            for (Parameter parameter : parameterList) {
                parameterInfo += "\n" + parameter.getName() + ": " + parameter.getValue().toString();
            }
            if (parameterInfo != "") {
                parameterInfo = "\n\nParameters:" + parameterInfo;
                eventQueue.postEvent(new ConsoleAWTEvent(component, parameterInfo));
            }
            eventQueue.postEvent(new ConsoleAWTEvent(component, "\n\nTotal running time: " + String.valueOf(getRunTime()) + " ms."));
            btRun.setText("Run");
            bottomConsole();
        }
    }

    class ExercisesComparator implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            if (((IExercise) o1).getID() > ((IExercise) o2).getID()) {
                return 1;
            }
            return -1;
        }
    }
}