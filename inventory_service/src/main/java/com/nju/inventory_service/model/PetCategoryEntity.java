package com.nju.inventory_service.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pet_category", schema = "pet_store_inventory", catalog = "")
public class PetCategoryEntity {
    private int id;
    private String category;
    private String description;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "category")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PetCategoryEntity that = (PetCategoryEntity) o;
        return id == that.id &&
                Objects.equals(category, that.category) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, category, description);
    }
}
