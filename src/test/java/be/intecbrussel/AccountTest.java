package be.intecbrussel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {


    @Test
    void ANumberThatFulfillsTheRulesShouldDisplayTheNumber(){

        Account account = new Account("456879652106");

        String expectedNumber = "456-8796521-06";

        String actualNumber = account.getAccountNumber();

        assertEquals(expectedNumber, actualNumber);

    }

    @Test
    void ANumberOfWhichTheTwoLastNumbersAreNotEqualToTheRestOfTheModuloOfTheTenFirstNumbersBy97ShouldReturnNull(){

        Account account = new Account("456879652108");

        String expectedNumber = null;

        String actualNumber = account.getAccountNumber();

        assertNull(actualNumber);
    }


    @Test
    public void testUsernameTooShortShouldThrowAnException() {
        Throwable exception = assertThrows(
                RuntimeException.class, () -> {
                    Account user = new Account("45");
                }
        );
        assertEquals("The number is too short/long or contains other characters", exception.getMessage());
    }
}