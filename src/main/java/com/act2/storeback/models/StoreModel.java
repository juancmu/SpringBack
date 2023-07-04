package com.act2.storeback.models;



import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity

@Table(name="stores")

public class StoreModel implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotBlank
    private String nameStore;

    @Column
    private String adresStore;

    @Column
    @NotBlank
    private Double lat;

    @Column
    @NotBlank
    private Double lon;


  //getters ans setters

     public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

      public String getNameStore() {
        return nameStore;
    }

    public void setNameStore(String nameStore) {
        this.nameStore = nameStore;
    }

      public String getAdresStore() {
        return adresStore;
    }

    public void setAdresStore(String adresStore) {
        this.adresStore = adresStore;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

}
