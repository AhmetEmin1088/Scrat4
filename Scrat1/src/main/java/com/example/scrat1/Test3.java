package com.example.scrat1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test3 {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String metin;
        System.out.println("Lütfen 7 harf giriniz:");
        metin = scanner.nextLine();
        List<String> letters = new ArrayList<>(metin.length());
        if (isValid(metin)) {
            for (int i = 0; i < metin.length(); i++) {
                String harf = metin.substring(i, i + 1);
                letters.add(harf);
            }
        } else {

        }

        File file = new File("src/main/resources/sozluk.txt");

        // list that holds strings of a file
        List<String> listOfStrings = new ArrayList<String>();

        // load data from file
        BufferedReader bf = new BufferedReader(new FileReader(file));

        // read entire line as string
        String line = bf.readLine();

        // checking for end of file
        while (line != null) {
            listOfStrings.add(line);
            line = bf.readLine();
        }

        // closing bufferreader object
        bf.close();

        // storing the data in arraylist to array
        String[] array = listOfStrings.toArray(new String[0]);

        findWord(array, letters);


    }

    public static boolean isValid(String str) {
        boolean result = true;
        StringBuilder letters = new StringBuilder(str);
        String regex = " ";

        if (str.length() != 7)
            result = false;
        if (!str.contains("q") || !str.contains("w") || !str.contains("x"))
            result = false;

        for (int i = 0; i < 7; i++) {
            for (int j = i + 1; j < 7; j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    result = false;
                }


                return result;
            }
        }

        return result;
    }

    // Function to print the words
    public static void printWord(String str, String s) {
        for (int i = 0; i < str.length(); i++) {
            if (s.indexOf(str.charAt(i)) < 0) {
                return;
            }
        }
        if (str.length() >= 4) {
            System.out.println(str);
        }
    }

    // Function to find the words
    public static void findWord(String[] str1, List<String> str2) {
        String s = "";
        double puan = 0;
        for (int i = 0; i < str2.size(); i++) {
            s += str2.get(i);
        }
        for (int i = 0; i < str1.length; i++) {
            printWord(str1[i], s);
        }
    }
}





