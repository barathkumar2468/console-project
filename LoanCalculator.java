public class LoanCalculator {
    public boolean checkEligibility(LoanApplicant applicant) {
        return applicant.age >= 21 &&
                applicant.age <= 60 &&
                applicant.creditScore >= 650 &&
                applicant.income >= 15000;
    }

    public double calculateMaxLoan(LoanApplicant applicant) {
        return applicant.income * 20; 
    }

    public double calculateEMI(double loanAmount, int years) {
        double interestRate = 0.10; 
        int months = years * 12;
        double monthlyRate = interestRate / 12;

        return (loanAmount * monthlyRate * Math.pow(1 + monthlyRate, months)) /
                (Math.pow(1 + monthlyRate, months) - 1);
    }
}
