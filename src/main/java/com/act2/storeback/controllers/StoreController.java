package com.act2.storeback.controllers;

import java.util.ArrayList;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.act2.storeback.models.StoreModel;
import com.act2.storeback.services.StoreService;

@RestController
@RequestMapping("/store")
public class StoreController {
    
    @Autowired
    private StoreService storeService;

    @GetMapping
    public ArrayList<StoreModel> getStores(){

        return this.storeService.getStores();
    }

    @PostMapping

    public StoreModel saveStore(@RequestBody StoreModel store){

    return this.storeService.saveStore(store);
    
    }

    @GetMapping(path = "/{id}")
    public Optional<StoreModel> getStoreById(@PathVariable("id") Long id){

            return this.storeService.getById(id);
    }

    @PutMapping
    public StoreModel updateStoreById(@RequestBody StoreModel request, @PathVariable("id") Long id){

        return this.storeService.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){


        boolean ok = this.storeService.deleteStore(id);
        if (ok){

            return "Tienda con id" + id + "borrada";
        } else {

            return "Error, tebnemos unproblem con el id" + id ;
        }
    }




}
