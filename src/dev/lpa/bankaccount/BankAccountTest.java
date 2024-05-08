package dev.lpa.bankaccount;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BankAccountTest {
    private BankAccount account;
    private static int count;

    @org.junit.BeforeClass
    public static void beforeClass(){
        System.out.println("This executes before the test cases. Count: " + count++);

    }
    @BeforeEach
    public void setUp() {
        System.out.println("test executing");
        this.account = new BankAccount("Gil", "Araújo", 10000000.0, BankAccount.CHECKING);
    }

    @Test
    void deposit() {
        double balance = account.deposit(100000.0, true);
        assertEquals(10100000.0, balance, 0);
    }

    @Test
    void withdraw() {
        double balance = account.withdraw(600.0,true);
        assertEquals(10000000.0-600.0, balance,0.0);
    }

    @Test
    void getBalance_deposit() {
        account.deposit(100000.0, true);
        assertEquals(10100000.0, account.getBalance(), 0);
    }

    @Test
    void getBalance_withdraw_branch() {
        account.withdraw(100000.0, true);
        assertEquals(9900000.0, account.getBalance(), 0);
    }

    @Test()
    public void getBalance_withdraw_notBranch(){
        IllegalArgumentException illegalArg = assertThrows(IllegalArgumentException.class, () ->{
            account.withdraw(600.0, false);
        });
        String expectedMessage = "Amount not permitted for non-branch operations!";
        String actualMessage = illegalArg.getMessage();
        Assert.assertTrue(expectedMessage.contains(actualMessage));
    }

    @Test
    public void isChecking_true() {
        assertTrue("The account is Not a CHECKING account", account.isChecking());
    }

    @org.junit.AfterClass
    public static void afterClass(){
        System.out.println("This executes after any test cases. Count: " + count++);
    }

    @AfterEach
    public void tearDown(){
        System.out.println("Count: " + count++);
    }

}