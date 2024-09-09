package Mortgage_calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Mortgage calculation");
        var mortgage1 = new MortgageCalc();
        String Kalisa_mortgage = mortgage1.getMortgage();
        System.out.println("Kalisa's mortgage is "+ Kalisa_mortgage);
    }
}
