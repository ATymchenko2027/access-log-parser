package org.example;
import java.io.File;
import java.util.Scanner;

public class FileParser {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int validFileCount = 0;

            while (true) {
                System.out.print("Введите путь к файлу: ");
                String patch = scanner.nextLine();
                File file = new File(patch);

                boolean fileExists = file.exists();
                boolean isDirectory = file.isDirectory();

                if (!fileExists || isDirectory) {
                    System.out.println("Не верно указан путь к файлу");
                    continue;
                }

                validFileCount++;
                System.out.println("Путь указан верно " + validFileCount);
            }
        }
    }
