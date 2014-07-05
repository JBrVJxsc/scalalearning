package com.scala.interfaces;

import com.scala.listeners.PrintConsoleListener;
import com.scala.listeners.SetParameterListener;

/**
 * Created by Who on 2014/4/4.
 */
public interface IExercise {
    long getID();

    String getName();

    String getSummary();

    void run();

    void addPrintConsoleListener(PrintConsoleListener printConsoleListener);

    void addSetParameterListener(SetParameterListener setParameterListener);
}
