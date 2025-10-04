package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyCalculator {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] ins = {7, 8, 9};
        int pos = 3;

        System.out.println(Arrays.toString(add(arr, ins, pos)));
    }

    public static int[] add(int[] arr, int[] ins, int pos) {
        int[] newArr = new int[arr.length + ins.length];
        for (int i = 0; i < pos; i++) {
            newArr[i] = arr[i];
        }
        for (int i = 0; i < ins.length; i++) {
            newArr[pos+i] = ins[i];
        }
        for (int i = pos; i < arr.length; i++) {
            newArr[i + ins.length] = arr[i];
        }
        return newArr;
    }
    public static int[] deleteNegative(int[] arr) {
        ArrayList<Integer> resultList = new ArrayList<>();
        for (int i=0; i< arr.length; i++) {
            if (arr[i] > 0) { resultList.add(arr[i]);}
        }
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
    public static int[] findAll(int[] arr, int x) {
        List<Integer> indices = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                indices.add(i);
            }
        }

        // Преобразуем список в массив
        int[] result = new int[indices.size()];
        for (int i = 0; i < indices.size(); i++) {
            result[i] = indices.get(i);
        }

        return result;
    }
    public static int[] concat(int[] arr1, int[] arr2){
        int[] arr12 = new int[arr1.length + arr2.length];
        int index=0;

        for (int i = 0; i < arr1.length; i++) {
            arr12[index] = arr1[i];
            index++;
        }

        // Копируем элементы второго массива
        for (int i = 0; i < arr2.length; i++) {
            arr12[index] = arr2[i];
            index++;
        }

        return arr12;
    }
    public static int[] reverseBack(int[] arr) {
        int[] reversed = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i];
        }
        return reversed;
    }
    public static void reverse(int[] arr) {
        int i = 0;
        int j = arr.length-1;
        while (i<j) {
            int temp = arr[i];
            arr[i] =arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static boolean palindrom(int[] arr) {
        int i =0;
        int j = arr.length-1;
        while (i < j) {
            if (arr[i] != arr[j]) {return false;}
            i++;
            j--;
        }
        return true;
    }
    public static int countPositive(int[] arr) {
        int res = 0;
        for (int i=0; i < arr.length; i++) {
            if (arr[i] > 0) {
                res++ ;
            }
        }
        return res;
    }
    public static int countPositive2(int[] arr) {
        int i =0;
        for (int value : arr) {
            if (value > 0) {
                i++ ;
            }
        }
        return i;
    }
    public static int maxAbs(int[] arr) {
        int max = arr[0];
        for (int i=1; i< arr.length; i++) {
            if (Math.abs(arr[i]) > Math.abs(max)) {
                max = arr[i];
            }
        }
        return max;
    }
    public static int findLast(int[] arr, int x){
        int j = -1;
        for (int i=0; i<arr.length; i++) {
            if (arr[i]==x){j = i;}
        }
        return j;
    }
    public static int findFirst(int[] arr, int x){
        for (int i=0; i<arr.length; i++) {
            if (arr[i]==x){return i;}
        }
        return -1;
    }

    public static void guessGame() {
        int randomNum = 3;
        int attempts = 0;
        java.util.Scanner sc = new java.util.Scanner(System.in);

        System.out.println("What number am I thinking (0 to 9)? :");

        while (true) {
            int x = sc.nextInt();
            attempts++;
            if (x > randomNum) {
                System.out.println("No, try again");
                System.out.println("Ваше число больше загаданного");}
            else if (x < randomNum) {
                System.out.println("No, try again");
                System.out.println("Ваше число меньше загаданного");
            } else {
                System.out.println("Yes, it's " + randomNum);
                System.out.println("Поздравляем, число отгадано");
                break;
            }
        }

        System.out.println("Вам потребовалось " + attempts + " попытки (п2опыток), чтобы угадать число"); // Выводим количество попыток
    }
    public static void guessGame1() {
        int randomNum = 3;
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("What number am I thinking (0 to 9)? :");
        int x = sc.nextInt();
        if (x != randomNum) {
            System.out.println("No, try again");
        } else {
            System.out.println("Yes, it`s " + randomNum);
        }
    }
    public static void rightTriangle(int x) {
        for (int i =1; i<=x; i++) {
            for (int j =1; j<=x-i; j++) {
                 System.out.print(' ');
                }
            for (int g=1; g<=i; g++) {
                System.out.print('*');
            }
            System.out.println();
        }

    }
    public static boolean equalNum(int x) {
        while (x > 10) {
            int y1 = x % 10;
            x /= 10;
            int y2 = x % 10;
            if (y1 != y2) {return false;}
        }
        return true;
    }
    public static int numLen(long x) {
        if (x == 0) {
            return 1;
        }
        int i = 0;
        while (x > 0) {
            x /= 10;
            i++;
        }
        return i;
    }

    // return String.valueOf(123/10).length();
    public static int pow(int x, int y) {
        int res = 1;
        for (int i=1; i <=y ; i++) {
            res *=x;
        }
        return res;
    }

    public static String chet(int x) {
        String res = " ";
        for (int i = 0; i <=x; i+=2) {
            res=i + " ";
        }
        return res;
    }
    public static String reverseListNums(int x) {
        String res = "";
        for (int i = x; i >= 0; i--) {
            res+=i + " ";
        }
     return res;
    }

};