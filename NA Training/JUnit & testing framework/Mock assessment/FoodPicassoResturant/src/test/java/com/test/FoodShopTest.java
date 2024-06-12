package com.test;

import com.model.FoodOrder;
import com.exception.InvalidFoodOrderException;
import com.util.FoodShop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FoodShopTest {

	private static FoodShop bObj;

	@BeforeEach
	public void setUp() throws Exception {

		bObj = new FoodShop();
		
		FoodOrder dummyOrder1 = new FoodOrder(1, "John Doe", "Burger", "Veg", 2, "NormalDelivery", 15.99);
	    FoodOrder dummyOrder2 = new FoodOrder(2, "Jane Smith", "Pizza", "NonVeg", 1, "FastDelivery", 12.49);
	    FoodOrder dummyOrder3 = new FoodOrder(3, "Alice Johnson", "Salad", "Veg", 3, "NormalDelivery", 8.99);

	    List<FoodOrder> dummyOrders = new ArrayList<>();
	    dummyOrders.add(dummyOrder1);
	    dummyOrders.add(dummyOrder2);
	    dummyOrders.add(dummyOrder3);

	    bObj.setFoodOrderList(dummyOrders);

	}

	@Test
	public void test11ValidateFoodTypeWhenVeg() throws InvalidFoodOrderException {
		assertTrue(bObj.validateFoodType("Veg"));
	}

	@Test
	public void test12ValidateFoodTypeWhenNonVeg() throws InvalidFoodOrderException {
		assertTrue(bObj.validateFoodType("NonVeg"));
	}
	
	@Test
	public void test13ValidateDeliveryTypeWhenFastDelivery() throws InvalidFoodOrderException {
		assertTrue(bObj.validateDeliveryType("FastDelivery"));
	}

	@Test
	public void test14ValidateDeliveryTypeWhenNormalDelivery() throws InvalidFoodOrderException {
		assertTrue(bObj.validateDeliveryType("NormalDelivery"));
	}

	@Test
	public void test15ValidateFoodTypeWhenInvalid() throws InvalidFoodOrderException {
		assertThrows(InvalidFoodOrderException.class, () -> bObj.validateFoodType("InvalidType"));
	}

	@Test
	public void test16ValidateDeliveryTypeWhenInvalid() {
		assertThrows(InvalidFoodOrderException.class, () -> bObj.validateDeliveryType("InvalidType"));
	}

	@Test
	public void test17ViewFoodOrdersByOrderIdWhenValid() throws InvalidFoodOrderException {
		FoodOrder result = bObj.viewFoodOrdersByOrderId(1);
		assertNotNull(result);
		assertEquals("John Doe", result.getCustomerName());
		assertEquals("Burger", result.getFoodName());
	}

	@Test
	public void test18ViewFoodOrdersByOrderIdWhenInvalid() {
		assertThrows(InvalidFoodOrderException.class, () -> bObj.viewFoodOrdersByOrderId(69));
	}

	@Test
	public void test19ViewFoodOrdersByFoodType() throws InvalidFoodOrderException {
		List<FoodOrder> vegOrders = bObj.viewFoodOrdersByFoodType("Veg");
	    List<FoodOrder> nonVegOrders = bObj.viewFoodOrdersByFoodType("NonVeg");

	    assertNotNull(vegOrders);
	    assertNotNull(nonVegOrders);
	    assertEquals(2, vegOrders.size());
	    assertEquals(1, nonVegOrders.size());

	    for (FoodOrder order : vegOrders) {
	        assertEquals("Veg", order.getFoodType());
	    }
	    for (FoodOrder order : nonVegOrders) {
	        assertEquals("NonVeg", order.getFoodType());
	    }
	}

	@Test
	public void test20ViewFoodOrdersByFoodTypeWise() throws InvalidFoodOrderException {
		Map<String, List<FoodOrder>> ordersByType = bObj.viewFoodOrdersByFoodTypeWise();

	    assertTrue(ordersByType.containsKey("Veg"));
	    assertTrue(ordersByType.containsKey("NonVeg"));

	    List<FoodOrder> vegOrders = ordersByType.get("Veg");
	    List<FoodOrder> nonVegOrders = ordersByType.get("NonVeg");

	    assertEquals(2, vegOrders.size());
	    assertEquals(1, nonVegOrders.size());
	}

	@Test
	public void test21CountTotalFoodOrdersForEachDeliveryType() throws InvalidFoodOrderException {
		Map<String, Integer> orderCountByDeliveryType = bObj.countTotalFoodOrdersForEachDeliveryType();

		assertTrue(orderCountByDeliveryType.containsKey("NormalDelivery"));
	    assertTrue(orderCountByDeliveryType.containsKey("FastDelivery"));

	    assertEquals(2, orderCountByDeliveryType.get("NormalDelivery").intValue());
	    assertEquals(1, orderCountByDeliveryType.get("FastDelivery").intValue());
	}

	@Test
	public void test22ViewFoodOrdersByFoodTypeForEmptyList() {
		bObj.setFoodOrderList(new ArrayList<>());
		assertThrows(InvalidFoodOrderException.class, () -> bObj.viewFoodOrdersByFoodType("Veg"));
	}

	@Test
	public void test23ViewFoodOrdersByFoodTypeWiseForEmptyList() {
		bObj.setFoodOrderList(new ArrayList<>());
		assertThrows(InvalidFoodOrderException.class, bObj::viewFoodOrdersByFoodTypeWise);
	}

	@Test
	public void test24CountTotalFoodOrdersForEachDeliveryTypeForEmptyList() {
		bObj.setFoodOrderList(new ArrayList<>());
		assertThrows(InvalidFoodOrderException.class, bObj::countTotalFoodOrdersForEachDeliveryType);
	}
}