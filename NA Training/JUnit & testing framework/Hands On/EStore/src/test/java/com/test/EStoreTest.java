package com.test;
import com.exception.InvalidOnlineOrderException;
import com.model.OnlineOrder;
import com.test.Main;
import com.util.EStore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.*;

import static org.junit.Assert.*;

public class EStoreTest {
	private static EStore bObj;
	
	@BeforeAll
	public static void setUp() throws Exception {
	    bObj = new EStore();
        bObj.setOnlineOrderList(createOnlineOrderList());
    }

	@Test
	public void test11ValidateItemTypeWhenElectronics() throws InvalidOnlineOrderException{
	    assertTrue(bObj.validateItemType("Electronics"));
	}

	@Test
	public void test12ValidateItemTypeWhenMobiles() throws InvalidOnlineOrderException{
		assertTrue(bObj.validateItemType("Mobiles"));
	}

	@Test
	public void test13ValidateItemTypeWhenEssentials() throws InvalidOnlineOrderException{
		assertTrue(bObj.validateItemType("Essentials"));
	}

	@Test
	public void test14ValidateItemTypeWhenFashion() throws InvalidOnlineOrderException{
		assertTrue(bObj.validateItemType("Fashion"));
	}

	@Test
	public void test15ValidateItemTypeWhenInvalid(){
	    try{
	        bObj.validateItemType("InvalidType");
	        fail("Expected InvalidOnlineOrderException not thrown");
	    } catch(InvalidOnlineOrderException e){
	        assertEquals("Item Type is invalid", e.getMessage());
	    }
	}

	@Test
	public void test16ViewOnlineOrdersByOrderIdWhenValid() throws InvalidOnlineOrderException{
        int orderId = 123;
        OnlineOrder onlineOrder = bObj.viewOnlineOrdersByOrderId(orderId);
        assertNotNull(onlineOrder);
        assertEquals(orderId, onlineOrder.getOrderId());
	}

	@Test
	public void test17ViewOnlineOrdersByOrderIdWhenInvalid() throws InvalidOnlineOrderException{
        int orderId = 999;
        try{
	        bObj.viewOnlineOrdersByOrderId(orderId);
	        fail("Expected InvalidOnlineOrderException not thrown");
	    } catch(InvalidOnlineOrderException e){
	        assertEquals("Order Id is invalid", e.getMessage());
	    }
   	}
	
	private static List<OnlineOrder> createOnlineOrderList(){
	    List<OnlineOrder> onlineOrderList = new ArrayList<>();
	    onlineOrderList.add(new OnlineOrder(123, "John Doe", "Item 1", "Electronics", 2, "Express", 100.0));
	    onlineOrderList.add(new OnlineOrder(124, "Jane Smith", "Item 2", "Mobiles", 1, "Standard", 100.0));
	    onlineOrderList.add(new OnlineOrder(125, "David Johnson", "Item 3", "Essentials", 3, "Standard", 50.0));
	    return onlineOrderList;
	}   
}