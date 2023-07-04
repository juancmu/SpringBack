package com.act2.storeback.services;


import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.act2.storeback.models.StoreModel;
import com.act2.storeback.repositories.IStoreRepository;

@Service
public class StoreService {
   
    @Autowired
    IStoreRepository storeRepository;

    public ArrayList<StoreModel> getStores(){

        return (ArrayList<StoreModel>) storeRepository.findAll();

    }

     public StoreModel saveStore(StoreModel store){

        return storeRepository.save(store);

    }

    public Optional<StoreModel> getById(Long id){

        return storeRepository.findById(id);  

    }



    


    public Boolean deleteStore (long id){
            try{

                    storeRepository.deleteById(id);
                    return true;

            } catch (Exception e){

        return false;

            }


    }
    



        
    }

    



