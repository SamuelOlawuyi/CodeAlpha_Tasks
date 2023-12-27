   package dev.samuelolawuyi.AtmInterface.Entities;

import lombok.Data;

@Data
public class ATM {
    private double depositAmount;
    private double withdrawAmount;
    private double balance;

    public void withdraw(double withdrawAmount) {
    }

    public void deposit(double depositAmount) {
    }
}
