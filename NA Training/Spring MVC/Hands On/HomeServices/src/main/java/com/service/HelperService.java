package com.service;

import org.springframework.stereotype.Service;


import com.model.HelperBean;

@Service
public class HelperService {
	
	public double calculateTotalCost(HelperBean helperBean){
        switch (helperBean.getServiceType()) {
            case "ACService":
                helperBean.setServiceCostPerHour(400);
                break;
            case "WashingMachineService":
                helperBean.setServiceCostPerHour(500);
                break;
            case "RefrigeratorService":
                helperBean.setServiceCostPerHour(300);
                break;
        }
        double totalCost = helperBean.getServiceCostPerHour() * helperBean.getNoOfHours();
        return totalCost;
	}
}
