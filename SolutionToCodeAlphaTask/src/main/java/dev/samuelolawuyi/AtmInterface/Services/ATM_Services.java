package dev.samuelolawuyi.AtmInterface.Services;

public interface ATM_Services {
   void viewBalance();
   void withdrawAmount(double withdrawAmount);
   void depositAmount(double depositAmount);
   void viewMiniStatement();
}
