package com.example.jewellerystorev3;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DisplayCaseLinkedList extends CustomLinkedList<DisplayCaseNode>{
    private DisplayCaseLinkedList linkedList = null;
    private double totalValue;

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

    public void valueOfJewelleryItems() {
        Node<DisplayCaseNode> current = head;
        DisplayTrayLinkedList tray = new DisplayTrayLinkedList();
        while (current != null) {
            if (tray.getTotalValue() > 0) {
                totalValue = totalValue + tray.getTotalValue();
                totalValue = Math.round(totalValue*100.0)/100.0;
            }
            current = current.next;
        }
        setTotalValue(totalValue);
    }

    public void load() throws Exception {
        Class<?>[] classes = new Class[]{DisplayTrayNode.class, JewelleryNode.class, DisplayCaseNode.class};

        XStream xStream = new XStream(new DomDriver());
//        XStream.setupDefaultSecurity(xStream);
//        xStream.allowTypes(classes);

        ObjectInputStream is = xStream.createObjectInputStream(new
                FileReader("cases.xml"));
        linkedList = (DisplayCaseLinkedList) is.readObject();
        is.close();
    }

    //saves the contents of the list into a .xml file
    public void save() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out =
                xstream.createObjectOutputStream(new FileWriter("jewellerystore.xml"));
        out.writeObject(linkedList);
        out.close();
    }
    //get index of case with same type
    ArrayList<Integer> getCasesWithType(String type) {
        ArrayList<Integer> possibleCases = new ArrayList<Integer>();
        Node<DisplayCaseNode> current = head;
        int counter = 0;
        while (current != null) {
            if (current.val.getJewelleryType().contains(type)) {
                possibleCases.add(counter-1);
            }
            counter++;
            current = current.next;
        }
        return possibleCases;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

}
