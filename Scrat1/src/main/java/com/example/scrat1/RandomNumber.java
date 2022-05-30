package com.example.scrat1;

import java.util.ArrayList;
import java.util.Collections;


public class RandomNumber {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=1; i<11; i++) list.add(i);
        Collections.shuffle(list);
        for (int i=0; i<3; i++) System.out.println(list.get(i));

    }


}
