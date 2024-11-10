// Source code is decompiled from a .class file using FernFlower decompiler.
import java.io.PrintStream;
import java.time.LocalDate;

public class LoanApplication {
   private static int applicationCounter = 1;
   private String applicationId = this.generateApplicationId();
   private Customer customer;
   private double loanAmount;
   private String loanType;
   private String loanStatus;
   private boolean verified;
   private Employee verifiedBy;
   private LocalDate applicationDate;
   private LocalDate approvalDate;

   public LoanApplication(Customer var1, double var2, String var4, LocalDate var5) {
      this.customer = var1;
      this.loanAmount = var2;
      this.loanType = var4;
      this.applicationDate = var5;
      this.loanStatus = "Pending";
      this.verified = false;
   }

   private String generateApplicationId() {
      String var1 = String.format("%09d", applicationCounter);
      ++applicationCounter;
      return "LAP" + var1;
   }

   public String getLoanStatus() {
      return this.loanStatus;
   }

   public void getLoanDetails() {
      System.out.println("Loan Application ID: " + this.applicationId);
      System.out.println("Customer: " + this.customer.getName());
      System.out.println("Loan Amount: " + this.loanAmount);
      System.out.println("Loan Type: " + this.loanType);
      System.out.println("Application Date: " + String.valueOf(this.applicationDate));
      PrintStream var10000 = System.out;
      String var10001 = String.valueOf(this.approvalDate != null ? this.approvalDate : "Not Approved");
      var10000.println("Approval Date: " + var10001);
      var10001 = this.loanStatus;
      System.out.println("Status: " + var10001);
      System.out.println("Verified: " + (this.verified ? "Yes" : "No"));
      var10001 = this.verifiedBy != null ? this.verifiedBy.getEmployeeName() : "Not Verified";
      System.out.println("Verified By: " + var10001);
   }

   public String getCustomerName() {
      return this.customer.getName();
   }

   public void updateLoanStatus(String var1) {
      this.loanStatus = var1;
      if ("Approved".equalsIgnoreCase(var1)) {
         this.approvalDate = LocalDate.now();
      } else {
         this.approvalDate = null;
      }

   }

   public void updateVerification(boolean var1, Employee var2) {
      this.verified = var1;
      this.verifiedBy = var2;
   }

   public boolean isVerified() {
      return this.verified;
   }

   public String getApplicationId() {
      return this.applicationId;
   }
}
