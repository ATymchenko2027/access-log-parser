package org.example;

import java.io.IOException;

public class ExceptionHandler {
    // Метод для обработки исключений длины строки
    public static void handleLineTooLongException(LineTooLongException e) {
        System.err.println("Ошибка: " + e.getMessage());
    }

    // Метод для обработки общих исключений ввода-вывода
    public static void handleIOException(IOException e) {
        System.err.println("Ошибка чтения файла: " + e.getMessage());
    }
}
