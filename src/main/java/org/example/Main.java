package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

// Определяем собственное исключение
class LineTooLongException extends RuntimeException {
    public LineTooLongException(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int validFileCount = 0;

        try {
            while (true) {
                System.out.print("Введите путь к файлу: ");
                String path = scanner.nextLine();
                File file = new File(path);

                boolean fileExists = file.exists();
                boolean isDirectory = file.isDirectory();

                // Проверка существования файла и того, что это не директория
                if (!fileExists || isDirectory) {
                    System.out.println("Не верно указан путь к файлу");
                    continue;
                }

                validFileCount++;
                System.out.println("Путь указан верно: " + validFileCount);

                // Чтение файла построчно
                try (FileReader fileReader = new FileReader(file);
                     BufferedReader reader = new BufferedReader(fileReader)) {

                    String line;
                    int lineNumber = 0; // Переменная для нумерации строк
                    int maxLength = 0; // Длина самой длинной строки
                    int minLength = Integer.MAX_VALUE; // Длина самой короткой строки
                    int totalLines = 0; // Общее количество строк

                    while ((line = reader.readLine()) != null) {
                        int length = line.length();

                        // Проверка длины строки
                        if (length > 1024) {
                            throw new LineTooLongException("Строка " + (totalLines + 1) + " превышает максимальную длину в 1024 символа.");
                        }

                        totalLines++; // Увеличиваем общее количество строк
                        maxLength = Math.max(maxLength, length); // Обновляем максимальную длину
                        minLength = Math.min(minLength, length); // Обновляем минимальную длину

                        // Выводим номер строки и её длину
                        System.out.println("Строка " + (totalLines) + ": Длина строки = " + length);
                    }

                    // Выводим статистику по файлу
                    System.out.println("Общее количество строк: " + totalLines);
                    System.out.println("Длина самой длинной строки: " + maxLength);
                    System.out.println("Длина самой короткой строки: " + (minLength == Integer.MAX_VALUE ? 0 : minLength)); // Если файл пустой, выводим 0

                } catch (LineTooLongException e) {
                    System.err.println("Ошибка: " + e.getMessage());
                    break; // Завершаем выполнение программы при возникновении исключения
                } catch (IOException e) {
                    System.err.println("Ошибка чтения файла: " + e.getMessage());
                }

                // Завершение программы после успешного чтения файла
                break; // Убираем бесконечный цикл после успешного чтения
            }
        } catch (Exception ex) {
            ex.printStackTrace(); // Обработка всех исключений
        } finally {
            scanner.close(); // Закрываем сканер в блоке finally
        }
    }
}