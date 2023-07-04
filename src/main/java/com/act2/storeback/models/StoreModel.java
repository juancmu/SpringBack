package com.act2.storeback.models;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="stores")

public class StoreModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   

    @Column
    private String nameStore;

  

    @Column
    private String adresStore;

  

    @Column
    private Double lat;



    @Column
    private Double lon;


    
  //getters ans setters

     public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

      public String getNameStore() {
        return this.nameStore;
    }

    public void setNameStore(String nameStore) {
        this.nameStore = nameStore;
    }

      public String getAdresStore() {
        return this.adresStore;
    }

    public void setAdresStore(String adresStore) {
        this.adresStore = adresStore;
    }

        public Double getLat() {
        return this.lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

       public Double getLon() {
        return this.lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

}
