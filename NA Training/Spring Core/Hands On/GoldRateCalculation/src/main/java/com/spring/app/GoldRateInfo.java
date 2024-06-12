package com.spring.app;

import java.util.Map;

public class GoldRateInfo {

	private Map<Integer,Double> rateInfo;

	public Map<Integer, Double> getRateInfo() {
		return rateInfo;
	}

	public void setRateInfo(Map<Integer, Double> rateInfo) {
		this.rateInfo = rateInfo;
	}
	
	public double calculateGoldRate(int goldCarat, double grams) {
		return rateInfo.get(goldCarat) * grams;
	}
}
