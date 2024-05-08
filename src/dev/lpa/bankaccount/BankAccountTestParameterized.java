package dev.lpa.bankaccount;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BankAccountTestParameterized {

    private BankAccount account;
    private double amount;
    private boolean branch;
    private double expected;


    public BankAccountTestParameterized(double amount, boolean branch, double expected) {
        this.amount = amount;
        this.branch = branch;
        this.expected = expected;
    }

    @Before
    public void setUp() {
        account = new BankAccount("Gil", "Araújo", 6700.0, BankAccount.CHECKING);
        System.out.println("Running test");
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testConditions() {
        return Arrays.asList(new Object[][]{
                {100.00, true, 6800.00},
                {200.00, true, 6900.00},
                {113.90, true, 6813.90},
                {99.99, true, 6799.99}
        });
    }

    @Test
    public void deposit() {
        double balance = account.deposit(amount, branch);
        assertEquals(expected, account.getBalance(), 0.01);
    }


    // in JUnit 5 we use Streams to parameterized Tests along with the MethodSource


    @ParameterizedTest
    @MethodSource("depositValues")
    public void depositParameterizedStream(double amount, boolean branch, double expected) {
        double actual = account.deposit(amount, branch);
        Assertions.assertEquals(actual, expected, 0.01);
    }

    public static Stream<Arguments> depositValues() {
        return Stream.of(
                Arguments.of(100.00, true, 6800.00),
                Arguments.of(200.00, true, 6900.00),
                Arguments.of(113.90, true, 6813.90),
                Arguments.of(99.99, true, 6799.99));
    }
}
