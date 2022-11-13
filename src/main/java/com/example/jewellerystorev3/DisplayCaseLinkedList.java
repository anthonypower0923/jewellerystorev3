package com.example.jewellerystorev3;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DisplayCaseLinkedList extends CustomLinkedList<DisplayCaseNode> implements Serializable{
//    private DisplayCaseLinkedList linkedList = new DisplayCaseLinkedList();

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
        Node<DisplayCaseNode> current = head;
        DisplayTrayLinkedList dtll = current.val.getLinkedList();
        while (current != null) {
            if (dtll.calculateValueOfJewelleryItems() > 0) {
                totalValue = totalValue + dtll.calculateValueOfJewelleryItems();
            }
            current = current.next;
        }
        return dtll.roundDoubleToTwoPlaces(totalValue);
    }

    public static void smartAdd(JewelleryNode node) {
        DisplayCaseLinkedList dcll = new DisplayCaseLinkedList();
        dcll.addFirst(new DisplayCaseNode("Freestanding" , "lit"));
        dcll.addFirst(new DisplayCaseNode("Freestanding" , "lit"));
        CustomLinkedList.Node<DisplayCaseNode> displayNode = dcll.getHead();
        DisplayTrayLinkedList dtll = displayNode.val.getLinkedList();
        dtll.addFirst(new DisplayTrayNode("green",3.90,4.0));
        dtll.addFirst(new DisplayTrayNode("green",3.90,4.0));
        CustomLinkedList.Node<DisplayTrayNode> trayNode = dtll.getHead();
        JewelleryLinkedList jll = trayNode.val.getLinkedList();
        jll.addFirst(new JewelleryNode("Anything" ,"anything" , "Male" , "\"http://baeldung.com\"", 20.90));
        jll.addFirst(new JewelleryNode("Necklace" ,"Necklace" , "Female" , "\"http://baeldung.com\"", 20.90));
        int pos = 0;
        while (displayNode != null) {
            while (trayNode != null) {
                String gender = dtll.getMostCommonGender();
                String type = dtll.getMostCommonJewelleryType();
                double price = jll.getAverageValueOfJewelleryItems();
                pos++;
                //check if all three fields are the same
                if ((gender.equals(node.getTargetGender())) && (type.equals(node.getType())) && (price == node.getRetailPrice()) && (dtll.isWithinPercentage(price , 30))) {
                    jll.addToIndex(pos , node);
                    System.out.println(displayNode.val.toString());
                    return;
                }
                //checks if gender and type are the same
                if ((gender.equals(node.getTargetGender())) && (type.equals(node.getType())) && (price != node.getRetailPrice()) && (dtll.isWithinPercentage(price , 30))) {
                    jll.addToIndex(pos , node);
                    System.out.println(displayNode.val.toString());
                    return;
                }
                //check if type and price are the same
                if (!(gender.equals(node.getTargetGender())) || (type.equals(node.getType()))) {
                    jll.addToIndex(pos , node);
                    System.out.println(displayNode.val.toString());
                    return;
                }
                //adds to first node if none of conditions are met
                if (!(gender.equals(node.getTargetGender())) && !(type.equals(node.getType()))) {
                    jll.addFirst(node);
                    System.out.println(displayNode.val.toString());
                    return;
                }
                trayNode = trayNode.next;
            }
            displayNode = displayNode.next;
        }

    }

}
