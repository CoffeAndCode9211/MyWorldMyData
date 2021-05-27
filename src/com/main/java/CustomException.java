package com.main.java;

public class CustomException extends Exception {

    private static final long serialVersionUID = 1L;

    public CustomException(String msg) {
        super(msg);
    }

    private int detail;

    CustomException(int a) {
        detail = a;
    }

    public String toString() {
        return "MyException[" + detail + "]";
    }


}
