package com.masaischool;

import java.util.HashMap;
import java.util.Map;

public class AtmServiceImpl implements AtmService{

	ATM atm=new ATM();
	
	Map<Double,String> map=new HashMap<>();
	
	
	@Override
	public void viewBalance() {
		// TODO Auto-generated method stub
		System.out.println("Available Balance is :  "+ atm.getBalance());
	}

	@Override
	public void withdrawAmount(double amount) {
		// TODO Auto-generated method stub
		   if(amount%500==0) {
	            if (amount <= atm.getBalance()) {
	                map.put(amount, " Amount Withdrawn");
	                System.out.println("Collect the Cash " + amount);
	                atm.setBalance(atm.getBalance() - amount);
	                viewBalance(); 
	                System.out.println("WITHDRAWN TRANSACTION SUCCESSFUL.");
	        		System.out.println("THANK YOU");
	            } else {
	                System.out.println("Insufficient Balance !!");
	            }
	        }
	        else {
	            System.out.println("Please enter the amount in multipal of 500");
	        }

	}

	@Override
	public void depositAmount(double amount) {
		// TODO Auto-generated method stub
		map.put(amount, " Amount Deposited " );
		 
		
		System.out.println("DEPOSIT AMOUNT: "+amount);
		atm.setBalance(atm.getBalance()+ amount);
		viewBalance();
		System.out.println("DEPOSIT TRANSACTION IS SUCCESSFUL.");
		System.out.println("THANK YOU");
	}

	@Override
	public void viewMiniStatement() {
		// TODO Auto-generated method stub
		for(Map.Entry<Double,String> e : map.entrySet()) {
			System.out.println(e.getKey()+" "+e.getValue());
		}
	}
    
}