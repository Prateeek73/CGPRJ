package com.util;

import com.exception.InvalidConsumerException;
import com.model.Consumer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class CreditScoreReport {

	List<Consumer> consumerList=new ArrayList<>();

	public List<Consumer> getConsumerList() {
		return consumerList;
	}
	public void setConsumerList(List<Consumer> consumerList) {
		this.consumerList = consumerList;
	}
		
 	  	 		  	     	      	 	
	public Map<Integer,Integer> totalConsumerCountForEachCreditScoreRange() throws InvalidConsumerException
	{
		if(consumerList.size()==0)
			throw new InvalidConsumerException("Consumer List is empty");
		else
		{
			Map<Integer,Integer> result= new LinkedHashMap<>();
			for(Consumer c : consumerList){
				if(!result.containsKey(c.getCreditScore())){
					result.put(c.getCreditScore(),1);
				}
				else
				{
					int temp=result.get(c.getCreditScore());					
					result.put(c.getCreditScore(), temp+1);
				}				
			}
			return result;
		}
		
	}
	public String viewConsumerReportBasedOnCreditScore(int creditScore) throws InvalidConsumerException
	{
		String report="";
		if(creditScore>=800 && creditScore<=900)
			report="EXCELLENT";
		else if(creditScore>=600 && creditScore<=799)
			report="GOOD";
		else if(creditScore>=500 && creditScore<=599)
			report="FAIR";
		else if(creditScore>=300 && creditScore<=499)
			report="POOR";
		else
			throw new InvalidConsumerException("Credit Score is not valid");
		return report;
			
	}	 	  	  	 		  	     	      	 	
}

