package be.intecbrussel;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Account {
    private String accountNumber;

    public Account(String accountNumber) {
        setAccountNumber(accountNumber);
    }

    private void setAccountNumber(String accountNumber) {

        if (accountNumber.length() == 12 && accountNumber.matches("[0-9]+")){
            long splitNumber1 = Long.parseLong(accountNumber.substring(0,10));
            long splitNumber2 = Long.parseLong(accountNumber.substring(10,12));

            if ((splitNumber1) % 97 == (splitNumber2)){
                this.accountNumber = String.valueOf(accountNumber).replaceFirst("(\\d{3})(\\d{7})(\\d{2})", "$1-$2-$3");
            }
       }
        else throw new RuntimeException("The number is too short/long or contains other characters");
    }

    public String getAccountNumber() {
        return accountNumber;
    }

}
