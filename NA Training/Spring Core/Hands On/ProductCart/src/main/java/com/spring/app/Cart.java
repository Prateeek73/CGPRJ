package com.spring.app;

import java.util.ArrayList;

public class Cart {
    
    private ArrayList<Product> productList;
    
    public Cart(){
        productList = new ArrayList<>();
    }
    public ArrayList<Product> getProductList(){
        return this.productList;
    }
    public void setProductList(ArrayList<Product> productList){
        this.productList = productList;
    }
}
