package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Курсовой проект. Задание по теме \"\"Синтаксис языка\" и “Базовые типы данных”\"");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число и нажмите <Enter>:");
        int firstNumber = Integer.parseInt(scanner.nextLine()); // необходимо преобразовать string в int
        System.out.println("Введите второе число и нажмите <Enter>:");
        int secondNumber = Integer.parseInt(scanner.nextLine()); // необходимо преобразовать string в int

        System.out.println("Сумма двух чисел = " + (firstNumber + secondNumber));
        System.out.println("Разность двух чисел = " + (firstNumber - secondNumber));
        System.out.println("Произведение двух чисел = " + (firstNumber * secondNumber));
        System.out.println("Частное = " + ((double) firstNumber / secondNumber));
        scanner.close(); // Закрываем сканер
    }
}