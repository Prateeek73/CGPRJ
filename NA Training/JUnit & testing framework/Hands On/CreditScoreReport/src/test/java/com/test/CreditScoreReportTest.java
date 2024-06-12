package com.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.*;

import com.exception.InvalidConsumerException;
import com.model.Consumer;
import com.util.CreditScoreReport;

public class CreditScoreReportTest{
	private static CreditScoreReport csrObj;
	
	@BeforeAll
	public static void setUp() throws Exception {
	    csrObj = new CreditScoreReport();
	}
	
	@BeforeEach
	public void setUpConsumerList(){
	    csrObj.setConsumerList(new ArrayList<>());
	}
	@Test
	public void test11TotalConsumerCountForEachCreditScoreRange() throws InvalidConsumerException{
	    
	    List<Consumer> consumerList = new ArrayList<>();
	    consumerList.add(new Consumer("1", "John Wick", "01-01-1999", "123456789", 500.0, 800));
	    consumerList.add(new Consumer("2", "John Weak", "01-01-1998", "123456788", 300.0, 750));
	    consumerList.add(new Consumer("3", "John Kicks", "01-01-1997", "123456787", 400.0, 650));
	    consumerList.add(new Consumer("4", "John Snitch", "01-01-1996", "123456786", 400.0, 550));
	    consumerList.add(new Consumer("5", "John Risk", "01-01-1996", "123456786", 400.0, 450));
	    csrObj.setConsumerList(consumerList);
	    
	    Map<Integer, Integer> actualConsumerCountMap = csrObj.totalConsumerCountForEachCreditScoreRange();
	    Map<Integer, Integer> expectedConsumerCountMap = new HashMap<>();
	    expectedConsumerCountMap.put(800, 1);
	    expectedConsumerCountMap.put(750, 1);
	    expectedConsumerCountMap.put(650, 1);
	    expectedConsumerCountMap.put(550, 1);
	    expectedConsumerCountMap.put(450, 1);
	    
	    assertEquals(expectedConsumerCountMap, actualConsumerCountMap);
	}

    @Test
	public void test12TotalConsumerCountForEachCreditScoreRangeForEmptyList() {
	    assertThrows(InvalidConsumerException.class, () ->
	            csrObj.totalConsumerCountForEachCreditScoreRange());
	}

    @Test
	public void test13ViewConsumerReportBasedOnCreditScoreWhenExcellent() throws InvalidConsumerException{
	    assertEquals("EXCELLENT", csrObj.viewConsumerReportBasedOnCreditScore(820));
	}
	
	@Test
	public void test14ViewConsumerReportBasedOnCreditScoreWhenGood() throws InvalidConsumerException{
	    assertEquals("GOOD", csrObj.viewConsumerReportBasedOnCreditScore(700));
	}
	
	@Test
	public void test15ViewConsumerReportBasedOnCreditScoreWhenFair() throws InvalidConsumerException{
	    assertEquals("FAIR", csrObj.viewConsumerReportBasedOnCreditScore(500));
	}
	
	@Test
	public void test16ViewConsumerReportBasedOnCreditScoreWhenPoor() throws InvalidConsumerException{
	    assertEquals("POOR", csrObj.viewConsumerReportBasedOnCreditScore(400));
	}
	
	@Test
	public void test17ViewConsumerReportBasedOnCreditScoreForEmptyList(){
	    assertThrows(InvalidConsumerException.class, 
	        () -> csrObj.viewConsumerReportBasedOnCreditScore(1000));
	}
}
	 	  	  	 		  	     	      	 	
