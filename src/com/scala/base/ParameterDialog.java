package com.scala.base;

import javax.swing.*;
import java.awt.event.*;

public class ParameterDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtValue;

    private Parameter parameter = null;

    public ParameterDialog(Parameter parameter) {
        this.parameter = parameter;
        setResizable(false);
        setContentPane(contentPane);
        setModal(true);
        setTitle(parameter.getName());
        getRootPane().setDefaultButton(buttonOK);

        txtValue.setText(parameter.getValue().toString());
        txtValue.setCaretPosition(txtValue.getText().length());
        txtValue.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    enter();
                }
            }
        });

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        enter();
    }

    private void onCancel() {
        dispose();
    }

    private void enter() {
        String value = txtValue.getText();
        String typeName = parameter.getValue().getClass().getSimpleName();
        if (typeName.equals("Integer")) {
            Integer i = 0;
            Long l = 0l;
            try {
                l = Long.parseLong(value);
            } catch (Exception e) {
                l = (long) Integer.MAX_VALUE;
            }
            if (l >= Integer.MAX_VALUE) {
                i = Integer.MAX_VALUE;
            } else if (l <= Integer.MIN_VALUE) {
                i = Integer.MIN_VALUE;
            } else {
                i = l.intValue();
            }
            parameter.setValue(i);
        } else if (typeName.equals("String")) {
            parameter.setValue(value);
        } else if (typeName.equals("Long")) {
            Long l = 0l;
            try {
                l = Long.parseLong(value);
            } catch (Exception e) {
                l = Long.MAX_VALUE;
            }
            parameter.setValue(l);
        }
        dispose();
    }
}
