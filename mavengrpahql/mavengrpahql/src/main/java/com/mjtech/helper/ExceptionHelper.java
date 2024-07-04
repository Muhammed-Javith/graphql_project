package com.mjtech.helper;

public class ExceptionHelper {
    public static RuntimeException throwResourceNotFoundException() {
        return new RuntimeException("Resource wasn't found!!");
    }
}
