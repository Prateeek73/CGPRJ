package com.spring.app;

import java.util.Scanner;

import org.springframework.stereotype.Component;

// Type your code here
@Component
public class EasyBank {

	private int pinCode = 6789;
	private int balance = 10000;
	private int tempPin;

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getTempPin() {
		return tempPin;
	}

	public void setTempPin(int tempPin) {
		this.tempPin = tempPin;
	}

	public void doDeposit(int amount){
	    balance+=amount;
        System.out.println("Your  balance is "+balance);
	}

	public void doWithdraw(int amount) {
         if(balance<amount){
             System.out.println("Insufficient Fund");
         }else{
             balance-=amount;
             System.out.println("You have successfully withdrawn "+amount);
         }
	}

	public void doChangePin(int oldPin, int pin) {
         try{
             if(oldPin!=pinCode && pin >= 1000 && pin <= 9999 ){
                 throw new Exception("Invalid Pin");
             }
             else {
            	 pinCode=pin;
             }
         }
             catch(Exception e) {
            	 
             }
//             }if(pin >= 1000 && pin <= 9999 && pin%1000!=0){
//                 pinCode=pin; 
//             }else{
//                 throw new Exception("Invalid new pin");
//             }
//         }catch(Exception e){
//             System.out.println(e.getMessage());
//         }
		// Type your code here

	}

	public void showBalance(){
		System.out.println("Your balance is "+balance);
		
	}

}
