package com.example.jewellerystorev3;

import java.net.URL;

public class JewelleryNode {
    private Material material = null;
    private String itemDescription;
    private String type;
    private String targetGender;
    private String image;
    private double retailPrice;

    public JewelleryNode() {

    }

    public JewelleryNode(String itemDescription, String type, String targetGender, String image, double retailPrice) {
        this.itemDescription = itemDescription;
        this.type = type;
        this.targetGender = targetGender;
        this.image = image;
        this.retailPrice = retailPrice;
        this.material = new Material();
    }

    @Override
    public String toString() {
        return "JewelleryNodes{" +
                "itemDescription='" + itemDescription + '\'' +
                ", type='" + type + '\'' +
                ", targetGender='" + targetGender + '\'' +
                ", image=" + image +
                ", retailPrice=" + retailPrice + '\'' +
                ",  Material= " + material.toString() + '\'' +
                '}';
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTargetGender() {
        return targetGender;
    }

    public void setTargetGender(String targetGender) {
        this.targetGender = targetGender;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}
