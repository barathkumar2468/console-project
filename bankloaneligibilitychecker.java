import java.util.Scanner;

public class BankLoanEligibilityChecker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("----- Bank Loan Eligibility Checker -----");

        System.out.print("Enter Monthly Income: ");
        double income = sc.nextDouble();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        System.out.print("Enter Credit Score: ");
        int creditScore = sc.nextInt();

        LoanApplicant applicant = new LoanApplicant(income, age, creditScore);
        LoanCalculator calculator = new LoanCalculator();

        boolean eligible = calculator.checkEligibility(applicant);

        System.out.println("\n----- Eligibility Result -----");
        if (eligible) {
            System.out.println("Status: ELIGIBLE");

            double maxLoan = calculator.calculateMaxLoan(applicant);
            System.out.println("Maximum Loan Amount: ₹" + maxLoan);

            System.out.print("Enter Loan Tenure (in years): ");
            int years = sc.nextInt();

            double emi = calculator.calculateEMI(maxLoan, years);
            System.out.printf("Monthly EMI: ₹%.2f\n", emi);

        } else {
            System.out.println("Status: NOT ELIGIBLE");
        }

        System.out.println("\n----- Summary Report -----");
        System.out.println("Income: ₹" + income);
        System.out.println("Age: " + age);
        System.out.println("Credit Score: " + creditScore);
        System.out.println("Eligibility: " + (eligible ? "Yes" : "No"));

        sc.close();
    }
}
