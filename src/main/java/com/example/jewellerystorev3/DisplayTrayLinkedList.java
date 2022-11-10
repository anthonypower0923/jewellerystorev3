package com.example.jewellerystorev3;

import java.util.ArrayList;

public class DisplayTrayLinkedList extends CustomLinkedList<DisplayTrayNode> {
    private double averagePrice =0.0;

    //check if identifier is unique


    //calculate value of jewellery items in-tray
    public double valueOfJewelleryItems() {
        double totalValue = 0.0;
        Node<DisplayTrayNode> current = head;
        JewelleryLinkedList jewellery = current.val.getLinkedList();
        while (current != null) {
            if (jewellery.calculateValueOfJewelleryItems() > 0) {
                totalValue = totalValue + jewellery.calculateValueOfJewelleryItems();
            }
            current = current.next;
        }
        return jewellery.roundDoubleToTwoPlaces(totalValue);
    }

    public boolean identifierExists(String identifier) {
        DisplayTrayNode trayNode = new DisplayTrayNode();
        Node<DisplayTrayNode> current = head;
        while (current != null) {
            String currIdentifier = current.val.getIdentifier();
            System.out.println("Curr identifier = " + currIdentifier + " identifier = " + identifier);
            if (current.val.getIdentifier().equals(identifier)) {
                return true;
            }
            current = current.next;
        }
        return  false;
    }

    //checks each display tray for jewellery items of common gender
    public String getMostCommonGender() {
        String mostCommonGender;
        Node<DisplayTrayNode> current = head;
        int maleCounter = 0;
        int femaleCounter = 0;
        int unisexCounter = 0;
        //loop through each display tray
        while (current != null) {
            JewelleryLinkedList jll = current.val.getLinkedList();
            //get the head of the jewellery linked list
            Node<JewelleryNode> jewelleryNode = jll.getHead();
            while ((jewelleryNode != null) && !(jewelleryNode.val.getTargetGender().equals(""))) {
                mostCommonGender = jewelleryNode.val.getTargetGender();
                if (mostCommonGender.equals("Male"))
                    maleCounter++;
                if (mostCommonGender.equals("Female")) {
                    femaleCounter++;
                }
                if (mostCommonGender.equals("Unisex")) {
                    unisexCounter++;
                }
                //iterate through jewellery linked list
                jewelleryNode = jewelleryNode.next;
            }
            //iterate through display trays
            current = current.next;
        }
        return ((maleCounter > femaleCounter) && (maleCounter > unisexCounter)) ? "Male" : ((femaleCounter > maleCounter) && (femaleCounter > unisexCounter)) ? "Female" : ((unisexCounter > maleCounter) && (unisexCounter > femaleCounter)) ? "Unisex" : "Two or more genders are the most common gender:  Male: " + maleCounter + "," + "  Female: " + femaleCounter + "," + " Unisex: " + unisexCounter;
    }

    //checks each display tray for jewellery items of common type
    public String getMostCommonJewelleryType() {
        String mostCommonType;
        Node<DisplayTrayNode> current = head;
        int watchCounter = 0;
        int ringCounter = 0;
        int necklaceCounter = 0;
        //loop through each display tray
        while (current != null) {
            JewelleryLinkedList jll = current.val.getLinkedList();
            //get the head of the jewellery linked list
            Node<JewelleryNode> jewelleryNode = jll.getHead();
            while ((jewelleryNode != null) && !(jewelleryNode.val.getType().equals(""))) {
                mostCommonType = jewelleryNode.val.getType();
                if (mostCommonType.equals("Watch"))
                    watchCounter++;
                if (mostCommonType.equals("Ring")) {
                    ringCounter++;
                }
                if (mostCommonType.equals("Necklace")) {
                    necklaceCounter++;
                }
                jewelleryNode = jewelleryNode.next;
            }
            current = current.next;
        }
        return ((watchCounter > necklaceCounter) && (watchCounter > ringCounter)) ? "Watch" : ((ringCounter > watchCounter) && (ringCounter > necklaceCounter)) ? "Ring" : ((necklaceCounter > watchCounter) && (necklaceCounter > ringCounter)) ? "Necklace" : "Two or more types are the most common type:  Watches: " + watchCounter + "," + "  Rings: " + ringCounter + "," + " Necklaces: " + necklaceCounter;
    }

    public boolean isWithinPercentage(double number , double range) {
        Node<DisplayTrayNode> current = head;
        JewelleryLinkedList jll = current.val.getLinkedList();
        //get the head of the jewellery linked list
        Node<JewelleryNode> jewelleryNode = jll.getHead();
        double percentage = 0;
        percentage = ((jewelleryNode.val.getRetailPrice() - number) * 100) / number;

        return percentage <= range;
    }

    public double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(double averagePrice) {
        this.averagePrice = averagePrice;
    }
}
