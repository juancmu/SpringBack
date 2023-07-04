package com.act2.storeback.repositories;

import com.act2.storeback.models.StoreModel;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IStoreRepository extends JpaRepository<StoreModel, Long>{
    


}
