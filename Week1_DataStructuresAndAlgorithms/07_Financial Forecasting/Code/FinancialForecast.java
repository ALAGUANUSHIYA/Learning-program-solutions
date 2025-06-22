import java.util.Scanner;

public class FinancialForecast {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Principal Amount (Rs): ");
        double principal = sc.nextDouble();

        System.out.print("Enter the Growth Rate (%)      : ");
        double rate = sc.nextDouble() / 100;

        System.out.print("Enter the Years                : ");
        int years = sc.nextInt();

        System.out.println("\n--- Year-wise Forecast ---");

        for (int i = 1; i <= years; i++) {
            double value = calculateFutureValue(principal, rate, i);
            System.out.printf("Year %2d: Rs.%.2f\n", i, value);
        }

        double finalValue = calculateFutureValue(principal, rate, years);
        System.out.println("\n--- Final Result ---");
        System.out.printf("Future Value after %d years: Rs.%.2f\n", years, finalValue);

        sc.close();
    }

    public static double calculateFutureValue(double amount, double rate, int years) {
        if (years == 0) return amount;
        return calculateFutureValue(amount, rate, years - 1) * (1 + rate);
    }
}
