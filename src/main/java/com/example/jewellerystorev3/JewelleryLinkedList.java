package com.example.jewellerystorev3;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class JewelleryLinkedList extends CustomLinkedList<JewelleryNode> {
    private  double totalValue = 0;


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
    public void calculateValueOfJewelleryItems() {
        Node<JewelleryNode> current = head;
        while (current != null) {
            if (current.val.getRetailPrice() > 0) {
                totalValue = totalValue + current.val.getRetailPrice();
                totalValue = Math.round(totalValue*100.0)/100.0;
            }
            current = current.next;
        }
        setTotalValue(totalValue);
    }
    //view all stock


    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }
}
