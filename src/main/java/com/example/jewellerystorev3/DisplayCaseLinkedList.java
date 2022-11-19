package com.example.jewellerystorev3;

import java.io.*;

public class DisplayCaseLinkedList extends CustomLinkedList<DisplayCaseNode> implements Serializable{


    public void getAllDisplayIds(){
        Node<DisplayCaseNode> current = head;
        while (current != null) {
            System.out.println(current.val.getDisplayId() + " \n");
            current = current.next;
        }
    }

    // check if node already exists with id
    public boolean checkNodeIdExists(String searchId) {
        Node<DisplayCaseNode> current = head;
        while (current != null) {
            if (current.val.getDisplayId().equals(searchId)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public double calculateValueOfJewelleryItems() {
        double totalValue = 0.0;
        Node<DisplayCaseNode> current = getHead();
        if (current != null){
            DisplayTrayLinkedList dtll = current.val.getLinkedList();
            while (current != null) {
                if (dtll.calculateValueOfJewelleryItems() > 0) {
                    totalValue = totalValue + dtll.calculateValueOfJewelleryItems();
                }
                current = current.next;
            }
            totalValue = dtll.roundDoubleToTwoPlaces(totalValue);
        }

        return totalValue;
    }
}
