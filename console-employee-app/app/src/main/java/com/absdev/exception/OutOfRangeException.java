package com.absdev.exception;

public class OutOfRangeException extends IllegalArgumentException{
    public OutOfRangeException() {
        super("Значение вышло за пределы допустимого");
    }

}
