package com.util;
import com.exception.InvalidFoodOrderException;
import com.model.FoodOrder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
public class FoodShop {
	
	List<FoodOrder> foodOrderList = new ArrayList<>();

	public List<FoodOrder> getFoodOrderList() {
		return foodOrderList;
	}

	public void setFoodOrderList(List<FoodOrder> foodOrderList) {
		this.foodOrderList = foodOrderList;
	}
	
	public List<FoodOrder> viewFoodOrdersByFoodType(String foodType) throws InvalidFoodOrderException {
		if(foodOrderList.size()==0){
			throw new InvalidFoodOrderException("List is empty");
		}
		else {
			List<FoodOrder> result = new ArrayList<>();
			for(FoodOrder b : foodOrderList){
				if(b.getFoodType().equals(foodType))
					result.add(b);
			}
			return result;	
		}
	}
	
	public Map<String,List<FoodOrder>>viewFoodOrdersByFoodTypeWise() throws InvalidFoodOrderException {
		if(foodOrderList.size()==0){
			throw new InvalidFoodOrderException("List is empty");
		}
		else {
			Map<String,List<FoodOrder>> result = new LinkedHashMap<>();
			
			for(FoodOrder b : foodOrderList){
				if(!result.containsKey(b.getFoodType())){
					result.put(b.getFoodType(),new ArrayList<FoodOrder>());
				}
				List<FoodOrder> temp=result.get(b.getFoodType());
				temp.add(b);
				result.put(b.getFoodType(), temp);			
			}
			return result;
		}
	}
}
