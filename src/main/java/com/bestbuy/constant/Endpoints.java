package com.bestbuy.constant;

public class Endpoints {

    // Products Endpoints

    public static final String GET_ALL_PRODUCTS = "/products";
    public static final String CREATE_PRODUCTS = "/products";
    public static final String DELETE_PRODUCTS_BY_ID = "/products/{productId}";
    public static final String GET_PRODUCTS_BY_ID = "/products/{productId}";
    public static final String UPDATE_PRODUCTS_BY_ID = "/products/{productId}";
    public static final String INVALID_ENDPOINT_PRODUCT = "/products123";



    // Stores Endpoints
    public static final String GET_ALL_STORES = "/stores";
    public static final String CREATE_STORES = "/stores";
    public static final String DELETE_STORES_BY_ID = "/stores/{storeId}";
    public static final String GET_STORES_BY_ID = "/stores/{storeId}";
    public static final String UPDATE_STORES_BY_ID = "/stores/{storeId}";
    public static final String INVALID_ENDPOINT_STORE = "/store123";
}

