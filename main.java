import java.util.Date;
import java.time.LocalDate;
public class main {
    public static void main(String[] args){
        Bank b = new Bank("SKCAB", "00001");
        Branch Vnsp = new Branch("Br0001", "Vanasthalipuram", "Road No. 5, Vanasthalipuram, Hyderabad, Telangana - 50070", "040-487673");
        Date join_date = new Date();
        Employee e = new Employee("Sai", b, Vnsp,"Loan Verifier", "Loan", 100000.00, 898965342, "employee_vnsp@SKCAB.com", join_date);
        Manager m = new Manager("Satish", b, Vnsp, 200000.00 , 956735925, "manager_vnsp@SKCAB.com", join_date);

        Customer Sam = new Customer("Sam", "H.No 79, Shiva Ganga Colony, L.B. Nagar, Hyderabad - 500071", "+91 9673247379");
        Customer Max = new Customer("Max", "H.no 69, Shiva Ganga Colony, L.B. Nagar, Hyderabad - 500071", "+91 6748945379");
        Vnsp.addCustomer(Sam);
        Vnsp.addCustomer(Max);
        CurrentAccount a1 = new CurrentAccount(Sam, Vnsp, 50000);
        SavingsAccount a2 = new SavingsAccount(Sam, Vnsp, 10000.0, 100000.0, 5);
        CurrentAccount a3 = new CurrentAccount(Max, Vnsp, 100000);
        SavingsAccount a4 = new SavingsAccount(Max, Vnsp, 10000.0, 100000.0, 5);

        Vnsp.addAccount(a1);
        Vnsp.addAccount(a2);
        Vnsp.addAccount(a3);
        Vnsp.addAccount(a4);
        Sam.addAccount(a1);
        Sam.addAccount(a2);
        Max.addAccount(a3);
        Max.addAccount(a4);

        LoanApplication la = new LoanApplication(Sam, 1000000.00, "Personal", LocalDate.now());
        Sam.applyLoan(la);
        Vnsp.addLoanApplication(la);

        e.verifyLoan(la);
        m.approveLoan(la);

        LoanAccount l1 = new LoanAccount("ld03422", Sam, 1000000, 3.2, 12, LocalDate.now());
        a1.addLoanAccount(l1);

        FixedDeposit fd = new FixedDeposit(100000.00, 12, 5.00, 12.00);
        a3.addFD(fd);
        Vnsp.addFixedDeposit(fd);

        RecurringDeposit rd = new RecurringDeposit("RD0003212", 3.2, 30, 100000, LocalDate.now());
        a1.addRD(rd);
        Vnsp.addRecurringDeposit(rd);

        Sam.addDebitCard(a1);
        Max.addCreditCard(200000.0,5.0);


        // depositing amt to all accounts
        Transaction d = new Transaction(null, a1, "Deposit", 5000);
        Transaction d1 = new Transaction(null, a2, "Deposit", 10000);
        Transaction d2 = new Transaction(null, a3, "Deposit", 20000);
        Transaction d3 = new Transaction(null, a4, "Deposit", 50000);

        d.processTransaction();
        d1.processTransaction();
        d2.processTransaction();
        d3.processTransaction();

        // withdraw
        Transaction w = new Transaction(a1, null, "Withdraw", 1000);
        Transaction w1 = new Transaction(a2, null, "Withdraw", 2000);
        Transaction w2 = new Transaction(a3, null, "Withdraw", 30000);
        Transaction w3 = new Transaction(a4, null, "Withdraw", 75000);

        w.processTransaction();
        w1.processTransaction();
        w2.processTransaction();
        w3.processTransaction();

        // Transferring btw Accounts

        Transaction t = new Transaction(a1, a3, "Transfer", 5000);
        Transaction t1 = new Transaction(a3, a4, "Transfer", 6000);

        t.processTransaction();
        t1.processTransaction();


    }
}
