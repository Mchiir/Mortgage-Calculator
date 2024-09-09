package Mortgage_calculator;
import java.nio.ByteBuffer;
import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalc {
    private int principal;
    private float monthly_interest_rate;
    private int period;
    private final int MONTHS_IN_YEAR = 12;
    final int PERCENT = 100;
    final double interest = 0.0391;

    public static String Mortgage;

    public String getMortgage() {
        Scanner sc1 = new Scanner(System.in);
        System.out.print("Principal: ");
        setPrincipal(sc1.nextInt());

        System.out.print("Annual Interest Rate: ");
        setMonthly_interest_rate(sc1.nextFloat());

        System.out.print("Period (years): ");
        setPeriod(sc1.nextInt());
        sc1.close();
        return mortgage();
    }

    public String mortgage(){
        double numerator = monthly_interest_rate * Math.pow(1 + monthly_interest_rate, period);
        double denominator = Math.pow(1 + monthly_interest_rate, period) - 1;
        double result = principal * (numerator / denominator);
        return NumberFormat.getCurrencyInstance().format(result);
    }

    private void setPrincipal(int principal) {
        if (principal < 0)
            throw new IllegalArgumentException("Principal must start from 0 and above");
        this.principal = principal;
    }
    private void setPeriod(int period) {
        if (period < 0)
            throw new IllegalArgumentException("Period must start from 0 and above");
        this.period = period * MONTHS_IN_YEAR;
    }
    private void setMonthly_interest_rate(float annual_interest_rate) {
        if (annual_interest_rate < 0)
            throw new IllegalArgumentException("Annual interest rate must start from 0 and above");
        float monthly = annual_interest_rate / PERCENT / MONTHS_IN_YEAR;
        this.monthly_interest_rate = monthly;
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