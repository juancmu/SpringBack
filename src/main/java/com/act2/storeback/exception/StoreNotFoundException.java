package com.act2.storeback.exception;

public class StoreNotFoundException extends RuntimeException{
    public StoreNotFoundException(Long id){


            super("No se encontrom la tienda con id" + id);
    }
    
}
