package com.scala.base;

/**
 * Created by Who on 2014/4/10.
 */
public class Parameter<T> {
    private T value;
    private String name;

    public Parameter(T value) {
        this.value = value;
    }

    public Parameter(T value, String name) {
        this.value = value;
        this.name = name;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public String getName() {
        if (name == null || name == "") {
            return value.getClass().getSimpleName();
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
