package com.act2.storeback.controllers;

import java.util.ArrayList;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.act2.storeback.exception.StoreNotFoundException;
import com.act2.storeback.models.StoreModel;
import com.act2.storeback.services.StoreService;

@RestController
@CrossOrigin
@RequestMapping("/store")
public class StoreController {
    
    @Autowired
    private StoreService storeService;

     @GetMapping("/hello")
    public String SayHello(){

        return "Hello Juan, working";
    }


    // busqueda general READ
    @GetMapping
    public ArrayList<StoreModel> getStores(){

        return this.storeService.getStores();
    }

    // insertar registro CREATE
    @PostMapping

    public StoreModel saveStore(@Validated @RequestBody StoreModel store){

    return this.storeService.saveStore(store);
    
    }

    // busqueda especifica FIND
    @GetMapping(path = "/{id}")
    public Optional<StoreModel> getStoreById(@PathVariable("id") Long id){

            return this.storeService.getById(id);
                
    }

        // actualizar  UPDATE
    @PutMapping(path = "/{id}")
    public ResponseEntity<?> updateStore(@Validated @PathVariable(value= "id") Long id, @RequestBody StoreModel request) {

        Optional<StoreModel> store = storeService.getById(id);

        if(!store.isPresent()) {

            return ResponseEntity.notFound().build();

        } else {
            store.get().setNameStore(request.getNameStore());
            store.get().setAdresStore(request.getAdresStore());
            store.get().setLat(request.getLat());
            store.get().setLon(request.getLon());

        return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.CREATED).body(storeService.saveStore(store.get()));

        }

    }


        // borrar DELETE
    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){


        boolean ok = this.storeService.deleteStore(id);
        if (ok){

            return "Tienda con id " + id + " borrada";
        } else {

            return "Error, tebnemos un problema con el id " + id ;
        }
    }


    


}
