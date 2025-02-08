package EmoryUniv.FinancialAlgorithms.PaymentPlan;
import java.util.*;
public class PaymentPlan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Principal of loan: ");
        double amountOwed = sc.nextDouble();
        System.out.println("Enter yearly interest rate: ");
        double yearlyInterestRate = sc.nextDouble();
        double monthlyInterestRate = ((yearlyInterestRate / 100) / 12);
        System.out.println("Enter Duration of Loan: ");
        double yearPayments = sc.nextDouble();
        double totalPayments = (yearPayments * 12);
        double monthlyPayment = monthlyInterestRate * (amountOwed * Math.pow((monthlyInterestRate + 1), totalPayments)) / (Math.pow((1 + monthlyInterestRate), totalPayments) - 1);
        System.out.printf("%-12s%-12s%-20s%-20s%-1s%n", "Payment#", "Payment", "Payment-Interest", "Payment-Principal", "Amt Owed");
        for (int paymentNumber = 1; paymentNumber <= totalPayments; paymentNumber++) {
            double paymentInterest = amountOwed * monthlyInterestRate;
            double paymentPrincipal = monthlyPayment - paymentInterest;
            amountOwed -= paymentPrincipal;
            System.out.printf("%-12d%-15.2f%-20.2f%-20.2f%-12.2f%n", paymentNumber, monthlyPayment, paymentInterest, paymentPrincipal, amountOwed);
        }
    }
}

