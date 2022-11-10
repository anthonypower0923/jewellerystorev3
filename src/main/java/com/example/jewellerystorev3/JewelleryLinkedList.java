package com.example.jewellerystorev3;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class JewelleryLinkedList extends CustomLinkedList<JewelleryNode> {


    //search jewellery items by description
    public List<Node<JewelleryNode>> searchJewelleryByTerm(String term){
        List<Node<JewelleryNode>> matchedNodes = new ArrayList<>();

        Node<JewelleryNode> current = head;
        while (current != null) {
            if ((current.val.toString().toLowerCase()).contains(term.toLowerCase())) {
                matchedNodes.add(current);
            }
            current = current.next;
        }
        return matchedNodes;
    }


    //calculate value of jewellery items
    public double calculateValueOfJewelleryItems() {
        double totalValue = 0.0;
        Node<JewelleryNode> current = getHead();
        while (current != null) {
            if (current.val.getRetailPrice() > 0) {
                totalValue = totalValue + current.val.getRetailPrice();
            }
            current = current.next;
        }
        System.out.println(totalValue);
        return roundDoubleToTwoPlaces(totalValue);
    }

    public double getAverageValueOfJewelleryItems() {
        double totalValue = 0.0;
        Node<JewelleryNode> current = getHead();
        int size = getSize();
        while (current != null) {
            if (current.val.getRetailPrice() > 0) {
                totalValue = totalValue + current.val.getRetailPrice();
            }
            current = current.next;
        }
        //System.out.println(totalValue / size);
        return roundDoubleToTwoPlaces(totalValue / size);
    }




}
