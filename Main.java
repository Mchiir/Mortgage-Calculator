package Mortgage_calculator;
public class Main {
    public static void main(String[] args) {
        var mortgage1 = new MortgageCalc();
        String mortgage = mortgage1.start();
        System.out.println(mortgage);
    }
}