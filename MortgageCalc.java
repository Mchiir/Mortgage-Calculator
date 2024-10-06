package Mortgage_calculator;
import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalc {
    private int principal;
    private float monthly_interest_rate;
    private byte period;
    private final int MONTHS_IN_YEAR = 12;
    final int PERCENT = 100;
    final double interest = 0.0391;

    public static String Mortgage;

    Scanner sc = new Scanner(System.in);
    public String start() {
        this.principal = setPrincipal();
        this.monthly_interest_rate = setMonthly_interest_rate();
        this.period = setPeriod();
        sc.close();
        return mortgage();
    }

    public String mortgage(){
        double numerator = monthly_interest_rate * Math.pow(1 + monthly_interest_rate, period);
        double denominator = Math.pow(1 + monthly_interest_rate, period) - 1;
        double result = principal * (numerator / denominator);
        return NumberFormat.getCurrencyInstance().format(result);
    }

    private int setPrincipal() {
        while(true){
            System.out.print("Principal ($1k - $1M): ");
            principal = sc.nextInt();
            if (!(principal >= 1000 && principal <= 1000_000) ) {
                System.out.println("Enter a number between 1000 and 1000_000.");
                continue;
            }
            break;
        }
        return principal;
    }

    private byte setPeriod() {
        while(true){
            System.out.print("Period (Years): ");
            period = sc.nextByte();
            if (!(period >= 1 && period  <= 30) ) {
                System.out.println("Enter a value between 1 and 30");
                continue;
            }
            break;
        }
        return (byte) period;
    }


    private float setMonthly_interest_rate() {
        while(true){
            System.out.print("Annual interest rate: ");
            monthly_interest_rate = sc.nextFloat();
            if (!(monthly_interest_rate > 0 && monthly_interest_rate  <= 30) ) {
                System.out.println("Enter a value greater than 1 and less than or equal to 30");
                continue;
            }
            break;
        }
        return (float) monthly_interest_rate;
    }

    public int getPrincipal() {
        return principal;
    }

    public float getMonthly_interest_rate() {
        return monthly_interest_rate;
    }

    public int getPeriod() {
        return period;
    }
}