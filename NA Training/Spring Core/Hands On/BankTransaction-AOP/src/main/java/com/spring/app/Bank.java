package com.spring.app;

import java.util.ArrayList;

public class Bank {
	
	ArrayList<Account> accntList=new ArrayList<Account>();

	public Bank(){
		
	}
	
	public ArrayList<Account> getAccntList() {
		return accntList;
	}

	public void setAccntList(ArrayList<Account> accntList) {
		this.accntList = accntList;
	}
	
	public boolean withDraw(int accntId, float withdrawAmt){
		boolean flag=false;
		for(Account a:accntList){
			if(a.getAccountNo()==accntId){
				a.setAccntBalance(a.getAccntBalance()-withdrawAmt);
				flag=true;
				break;
			}
		}
		return flag;
	}
}
