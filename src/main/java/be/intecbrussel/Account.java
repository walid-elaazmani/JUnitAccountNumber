package be.intecbrussel;

public class Account {
    private String accountNumber;

    public Account(String accountNumber) {
        setAccountNumber(accountNumber);
    }

    private void setAccountNumber(String accountNumber) {
        
        if (accountNumber.matches("(\\d{3})-(\\d{7})-(\\d{2})")){

            String stringToLong = accountNumber.replaceAll("-", "");

            long splitNumber1 = Long.parseLong(stringToLong.substring(0,10));
            long splitNumber2 = Long.parseLong(stringToLong.substring(10,12));

            if ((splitNumber1) % 97 == (splitNumber2)){
                this.accountNumber = accountNumber;
            }
       }
        else throw new RuntimeException("The number is too short/long or contains other characters");
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
