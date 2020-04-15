package com.jin.codetest;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class NoRepeatInt {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String num = input.next();

        LinkedHashSet<Character> linkedHashSet = new LinkedHashSet<>();
        for (int i = num.length() - 1; i >= 0; i--) {
            linkedHashSet.add(num.charAt(i));
        }
        linkedHashSet.forEach(o -> System.out.print(o));

    }


}