package com.nju.inventory_service.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pet_product", schema = "pet_store_inventory", catalog = "")
public class PetProductEntity {
    private int id;
    private String petName;
    private int petStore;
    private double singlePrice;
    private int categoryId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "pet_name")
    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    @Basic
    @Column(name = "pet_store")
    public int getPetStore() {
        return petStore;
    }

    public void setPetStore(int petStore) {
        this.petStore = petStore;
    }

    @Basic
    @Column(name = "single_price")
    public double getSinglePrice() {
        return singlePrice;
    }

    public void setSinglePrice(double singlePrice) {
        this.singlePrice = singlePrice;
    }

    @Basic
    @Column(name = "category_id")
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PetProductEntity that = (PetProductEntity) o;
        return id == that.id &&
                petStore == that.petStore &&
                Double.compare(that.singlePrice, singlePrice) == 0 &&
                categoryId == that.categoryId &&
                Objects.equals(petName, that.petName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, petName, petStore, singlePrice, categoryId);
    }
}
