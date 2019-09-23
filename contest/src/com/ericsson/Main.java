package com.ericsson;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int range = in.nextInt();

        if (size == 1) {  // only one options
            System.out.println("1");
            return;
        }

        List<Integer> numbers = new ArrayList<>();
        isOk(numbers,size,range);
    }


    private static void isOk(List<Integer> numbers, int size, int range) {
        for (int k = 0; k < numbers.size(); k++) {
            System.out.printf("current numbers %2d \n", numbers.get(k));
        }


        if (numbers.size() == size) {
            if (isOk(numbers)) {
                for (int k = 0; k < numbers.size(); k++) {
                    System.out.printf("%2d");
                }
                System.out.println();
            }
            return;
        }

        for (int i = 1; i <= range; i++) {
            numbers.add(i);
            isOk(numbers, size, range);
        }

    }

    private static boolean isOk(List<Integer> numbers) {
        long devidedby = 1;

        for (int number : numbers) {
            devidedby *= number;
        }

        long toDevided = 0;

        for (int i = 0; i < numbers.size(); i++) {
            long part = 1;
            for (int j = 0; j < numbers.size(); j++) {
                if (j != i) {
                    part *= numbers.get(j);
                }
            }
            toDevided += part;
        }

        return toDevided == devidedby;
    }
}
