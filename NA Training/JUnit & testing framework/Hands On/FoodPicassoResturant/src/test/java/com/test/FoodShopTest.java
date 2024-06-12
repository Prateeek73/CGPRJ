package com.test;


import com.test.Main;
import com.model.FoodOrder;
import com.exception.InvalidFoodOrderException;
import com.util.FoodShop;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


public class FoodShopTest {
	
	private static FoodShop bObj;

	@BeforeAll
	public static void setUp() throws Exception {
	    bObj = new FoodShop();
	}
	
	@BeforeEach
	public void setUpOrderList(){
	    List<FoodOrder> foodOrderList = new ArrayList<>();
	    
	    foodOrderList.add(new FoodOrder(1, "John Wick", "Burger", "Veg", 2, "NormalDelivery", 40.0));
		foodOrderList.add(new FoodOrder(2, "John Risk", "Pizza", "Veg", 1, "FastDelivery", 60.0));
		foodOrderList.add(new FoodOrder(3, "John Snitch", "Steak", "NonVeg", 1, "NormalDelivery", 120.0));
		
		bObj.setFoodOrderList(foodOrderList);
	}
	
	@Test
	public void test11ViewFoodOrdersByFoodType() throws InvalidFoodOrderException{
	     List<FoodOrder> vegFoodOrders = bObj.viewFoodOrdersByFoodType("Veg");
	     List<FoodOrder> nonVegFoodOrders = bObj.viewFoodOrdersByFoodType("NonVeg");
	     
	     assertEquals(2, vegFoodOrders.size());
		 assertEquals(1, nonVegFoodOrders.size());
	}
	
	@Test 
	public void test12ViewFoodOrdersByFoodTypeWise() throws InvalidFoodOrderException{
	    
	    Map<String, List<FoodOrder>> foodOrdersByFoodType = bObj.viewFoodOrdersByFoodTypeWise();
    
        assertEquals(2, foodOrdersByFoodType.size());
     
        assertTrue(foodOrdersByFoodType.containsKey("Veg"));
	    assertTrue(foodOrdersByFoodType.containsKey("NonVeg"));
	    assertEquals(2, foodOrdersByFoodType.get("Veg").size());
	    assertEquals(1, foodOrdersByFoodType.get("NonVeg").size());
	}
	 
    @Test
	public void test13ViewFoodOrdersByFoodTypeForEmptyList() {
        bObj.setFoodOrderList(new ArrayList<>());
        try{
            List<FoodOrder> vegFoodOrders = bObj.viewFoodOrdersByFoodType("Veg");
            fail("Expected InvalidFoodOrderException but got none.");
        } catch(InvalidFoodOrderException ex){
            assertEquals(ex.getMessage(), "List is empty");
        }
	}
	 
	@Test
	public void test14ViewFoodOrdersByFoodTypeWiseForEmptyList() throws InvalidFoodOrderException{
        bObj.setFoodOrderList(new ArrayList<>());
        assertThrows(InvalidFoodOrderException.class, 
                    () -> bObj.viewFoodOrdersByFoodTypeWise());
	}
}

