package com.example.jewellerystorev3;

import java.util.ArrayList;

public class DisplayTrayLinkedList extends CustomLinkedList<DisplayTrayNode> {
    private double totalValue;

    //check if identifier is unique


    //calculate value of jewellery items in-tray
    public void valueOfJewelleryItems() {
        Node<DisplayTrayNode> current = head;
        JewelleryLinkedList jewellery = new JewelleryLinkedList();
        while (current != null) {
            if (jewellery.getTotalValue() > 0) {
                totalValue = totalValue + jewellery.getTotalValue();
                totalValue = Math.round(totalValue*100.0)/100.0;
            }
            current = current.next;
        }
        setTotalValue(totalValue);
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




    //smart add jewellery items
    ArrayList<Integer> getTraysByGender(ArrayList<Integer> indexes, String gender) {
        ArrayList<Integer> possibleTrays = new ArrayList<Integer>();
        Node<DisplayTrayNode> current = head;
        int counter = 0;
        // loop through everything
        while (current != null) {
            // only check nodes with an index in indexes
            if(indexes.contains(counter)){
                // check if the current nodes gender.equals the
                if (current.val.getGender().equals(gender)){
                    // add as a possible display tray
                    possibleTrays.add(counter);
                }
            }
            counter++;
            current = current.next;
        }
        return possibleTrays;
    }

    ArrayList<Integer> getTraysByPrice(ArrayList<Integer> indexes, double number) {
        ArrayList<Integer> possibleTrays = new ArrayList<Integer>();
        Node<DisplayTrayNode> current = head;
        int counter = 0;
        // loop through everything
        while (current != null) {
            // only check nodes with an index in indexes
            if(indexes.contains(counter)){
                // check if the current nodes averagePrice is within 30% of value of tray
                if (isWithinPercentage(number, 30)){
                    // add as a possible display tray
                    possibleTrays.add(counter);
                }
            }
            counter++;
            current = current.next;
        }
        return possibleTrays;
    }

    private boolean isWithinPercentage(double number , double range) {
        Node<DisplayTrayNode> current = head;
        double percentage = 0;
        percentage = ((current.val.getAveragePrice() - number) * 100) / number;

        return percentage <= range;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }
}
