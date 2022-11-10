package com.example.jewellerystorev3;

public class Material {
    private String name;
    private String description;
    private int quality;
    private int quantity;

    public Material() {

    }

    public Material(String name, String description, int quality, int quantity) {
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

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
