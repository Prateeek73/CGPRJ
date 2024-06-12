package com.util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.exception.InvalidOnlineOrderException;
import com.model.OnlineOrder;

public class EStore {

	List<OnlineOrder> onlineOrderList = new ArrayList<>();

	public List<OnlineOrder> getOnlineOrderList() {
		return onlineOrderList;
	}

	public void setOnlineOrderList(List<OnlineOrder> onlineOrderList) {
		this.onlineOrderList = onlineOrderList;
	}
	
	public boolean validateItemType(String itemType) throws InvalidOnlineOrderException  {
		   if(itemType.equalsIgnoreCase("Electronics")||itemType.equalsIgnoreCase("Essentials")||itemType.equalsIgnoreCase("Fashion")||itemType.equalsIgnoreCase("Mobiles"))
			   return true;
		   else
			   throw new InvalidOnlineOrderException("Item Type is invalid");
		}
	

	
	public OnlineOrder viewOnlineOrdersByOrderId(int orderId) throws InvalidOnlineOrderException {
		if(onlineOrderList.size()==0){
			throw new InvalidOnlineOrderException("List is empty");
		}
		else {
			for(OnlineOrder b : onlineOrderList){
				if(b.getOrderId()== orderId)
					return b;
			}
			throw new InvalidOnlineOrderException("Order Id is invalid");	
		}
	}
	
}
