package com.example.jewellerystorev3;

import java.io.Serializable;

public class Material implements Serializable {
    private String name;
    private String description;
    private Integer quality;
    private Integer quantity;

    public Material() {

    }

    public Material(String name, String description, Integer quality, Integer quantity) {
        this.name = name;
        this.description = description;
        this.quality = quality;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Material { " +
                "name= " + name +
                ", description= " + description +
                ", quality= " + quality +
                ", quantity= " + quantity +
                " }";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
