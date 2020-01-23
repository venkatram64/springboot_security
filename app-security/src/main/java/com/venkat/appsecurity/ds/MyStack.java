package com.venkat.appsecurity.ds;

import java.util.Arrays;

public class MyStack<T> {

    private int currentElementPosition = 0;
    private Object[] elements;
    private int INIT_SIZE = 10;

    public MyStack(){
        this.elements = new Object[INIT_SIZE];
    }

    public void push(T element){
        if(this.elements.length == INIT_SIZE){
            expandSize();
        }
        elements[currentElementPosition++] = element;
    }

    private void expandSize(){
        int increasedSize = this.elements.length * 2;
        elements = Arrays.copyOf(elements, increasedSize);
    }

    @SuppressWarnings("unchecked")
    public T pop(){
        T t = (T) elements[--currentElementPosition];
        elements[currentElementPosition] = null;
        return t;
    }
}
