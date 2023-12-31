package dev.samuelolawuyi.AtmInterface.Services.ATM_ServiceImpl;


import dev.samuelolawuyi.AtmInterface.Entities.ATM;
import dev.samuelolawuyi.AtmInterface.Services.ATM_Services;

import java.util.HashMap;
import java.util.Map;

public class ATM_ServiceImpl implements ATM_Services {
    private final ATM atm = new ATM();
    private final Map<Double, String> miniStatement = new HashMap<>();

    @Override
    public void viewBalance() {
        double balance = atm.getBalance();
        System.out.println("Available Balance is : " + balance);
    }

    @Override
    public void withdrawAmount(double withdrawAmount) {
        if (isValidWithdrawAmount(withdrawAmount)) {
            if (withdrawAmount <= atm.getBalance()) {
                miniStatement.put(withdrawAmount, " Amount Withdrawn");
                atm.withdraw(withdrawAmount);
                System.out.println("Collect the Cash " + withdrawAmount);
                viewBalance();
            } else {
                System.out.println("Insufficient Balance !!");
            }
        } else {
            System.out.println("Please enter the amount in multiples of 500");
        }
    }

    @Override
    public void depositAmount(double depositAmount) {
        miniStatement.put(depositAmount, " Amount Deposited");
        atm.deposit(depositAmount);
        System.out.println(depositAmount + " Deposited Successfully !!");
        viewBalance();
    }

    @Override
    public void viewMiniStatement() {
        for (Map.Entry<Double, String> entry : miniStatement.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    private boolean isValidWithdrawAmount(double amount) {
        return amount % 500 == 0;
    }
}
