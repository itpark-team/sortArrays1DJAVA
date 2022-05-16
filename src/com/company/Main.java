package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        int masCount = 9;
        int maxRandomNumber = 15;
        int[] mas = new int[masCount];


        for (int i = 0; i < mas.length; i++) {
            mas[i] = random.nextInt(maxRandomNumber + 1);
        }

        System.out.println("Original array");
        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i] + " ");
        }
        System.out.println();

        //sorting
        boolean isSorted;
        int temp;
        int offset = 0;

        do {
            isSorted = true;

            for (int i = 0; i < mas.length - 1 - offset; i++) {
                if (mas[i + 1] < mas[i]) {
                    temp = mas[i];
                    mas[i] = mas[i + 1];
                    mas[i + 1] = temp;

                    isSorted = false;
                }
            }

            offset++;

        } while (isSorted == false);

        System.out.println("Sorted array");
        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i] + " ");
        }
        System.out.println();

        int searchValue = 5;
        int foundIndex = -1;
        int searchIterations = 0;

        int leftIndex = 0;
        int rightIndex = mas.length - 1;

        while (rightIndex - leftIndex > 1) {
            searchIterations++;

            int middleIndex = (leftIndex + rightIndex) / 2;

            if (mas[middleIndex] == searchValue) {
                foundIndex = middleIndex;
                break;
            }

            if (searchValue > mas[middleIndex]) {
                leftIndex = middleIndex;
            } else if (searchValue < mas[middleIndex]) {
                rightIndex = middleIndex;
            }
        }


        System.out.println("search iterations = " + searchIterations);

        if (foundIndex == -1) {
            System.out.println("value not found");
        } else {
            System.out.println("value " + searchValue + " at " + foundIndex + " index");
        }
    }
}
