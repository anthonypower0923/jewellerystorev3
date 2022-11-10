package com.example.jewellerystorev3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Objects;

public class Driver extends Application {
    DisplayCaseLinkedList linkedlist = new DisplayCaseLinkedList();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("jewellerystorev2.fxml")));
        primaryStage.setTitle("Jewellery Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    //Testing
    public static void main(String[] args) {

//        printAllDisplayCases();
        smartAdd(new JewelleryNode("Necklace" ,"Necklace" , "Female" , "helicopter", 20.90));
        smartAdd(new JewelleryNode("Anything" ,"anything" , "Helicopter" , "\"http://baeldung.com\"", 3.50));
//        launch(args);

        // ll -> DisplayCaseLinkedList
//        DisplayCaseLinkedList dcll = new DisplayCaseLinkedList();
//
//        // populate ll with nodes -> DisplayCaseNodes
//        dcll.addFirst(new DisplayCaseNode("Freestanding" , "lit"));
//        dcll.addFirst(new DisplayCaseNode("Freestanding" , "lit"));
//
//        // each node contains a ll -> DisplayTrayLinkedList
//        //dcll.print();
//
//        // populate ll with nodes -> DisplayTrayNodes
//        CustomLinkedList.Node<DisplayCaseNode> head = dcll.getHead();
//        DisplayTrayLinkedList dtll = head.val.getLinkedList();
//        dtll.addFirst(new DisplayTrayNode("ID_1", "red",3.0, 45.0));
//        dtll.addFirst(new DisplayTrayNode("ID_2", "green",3.0, 45.0));
//
//        String contents = head.val.getLLContents();
//        //System.out.println(" sb contents ::" +  "\n" + contents);
////        System.out.println("HEAD CONTENTS " + "/n" + head.val.toString());
//
//        CustomLinkedList.Node<DisplayTrayNode> Head = dtll.getHead();
//        JewelleryLinkedList jll = Head.val.getLinkedList();
//        jll.addFirst(new JewelleryNode("Watch" ,"watch" , "Male" , "\"http://baeldung.com\"", 20.90));
//        jll.addFirst(new JewelleryNode("Ring" ,"ring" , "Female" , "\"http://baeldung.com\"", 20.90));
//        String jewelleryContents = Head.val.getLLContents();
//
//        CustomLinkedList.Node<DisplayTrayNode> tail = dtll.getTail();
//        JewelleryLinkedList tailJll = tail.val.getLinkedList();
//        tailJll.addFirst(new JewelleryNode("Anything" ,"anything" , "Male" , "\"http://baeldung.com\"", 20.90));
//        tailJll.addFirst(new JewelleryNode("Necklace" ,"necklace" , "Female" , "\"http://baeldung.com\"", 20.90));
//
//        System.out.println("HEAD CONTENTS " + "/n" + head.val.toString());

//        DisplayCaseLinkedList displayCase = new DisplayCaseLinkedList();
//        DisplayCaseNode displayCaseNode = null;
//        DisplayTrayLinkedList displayTray = new DisplayTrayLinkedList();
//        DisplayTrayNode displayTrayNode = null;
//
//        // add a new Node at the start
//        displayCase.addFirst(new DisplayCaseNode("Freestanding" , "lit"));
//        displayCase.addFirst(new DisplayCaseNode("Freestanding" , "lit"));
//        displayCase.addFirst(new DisplayCaseNode("Freestanding" , "lit"));
//        displayCase.addFirst(new DisplayCaseNode("Freestanding" , "lit"));
//        displayCase.addFirst(new DisplayCaseNode("Freestanding" , "lit"));
//        displayTray.addFirst(new DisplayTrayNode("A01","green",20.3,20.3));
//        displayCaseNode.getLinkedList();

        // add a new Node at the end
        //displayCase.addLast(new DisplayCaseNode("Freestanding" , "lit"));
        // remove the first node
        //displayCase.deleteFirst();
        // remove the last node
        //displayCase.deleteLast();
        //displayTray.print();
        //displayCase.getAllDisplayIds();


        /*
            After each step print the contents of the linked list and print the size of it.
         */
    }

    public static void printAllDisplayCases() {
        DisplayCaseLinkedList dcll = new DisplayCaseLinkedList();
        dcll.addFirst(new DisplayCaseNode("Freestanding" , "lit"));
        dcll.addFirst(new DisplayCaseNode("Freestanding" , "lit"));
        CustomLinkedList.Node<DisplayCaseNode> head = dcll.getHead();
        DisplayTrayLinkedList dtll = head.val.getLinkedList();
        dtll.addFirst(new DisplayTrayNode("green",3.90,4.0));
        dtll.addFirst(new DisplayTrayNode("green",3.90,4.0));

        String contents = head.val.getLLContents();
        //System.out.println(" sb contents ::" +  "\n" + contents);
//        System.out.println("HEAD CONTENTS " + "/n" + head.val.toString());

        CustomLinkedList.Node<DisplayTrayNode> Head = dtll.getHead();
        JewelleryLinkedList jll = Head.val.getLinkedList();
        jll.addFirst(new JewelleryNode("Watch" ,"watch" , "Male" , "\"http://baeldung.com\"", 20.90));
        jll.addFirst(new JewelleryNode("Ring" ,"ring" , "Female" , "\"http://baeldung.com\"", 20.90));
        String jewelleryContents = Head.val.getLLContents();

        CustomLinkedList.Node<DisplayTrayNode> Tail = dtll.getTail();
        JewelleryLinkedList tailJll = Tail.val.getLinkedList();
        tailJll.addFirst(new JewelleryNode("Anything" ,"anything" , "Male" , "\"http://baeldung.com\"", 20.90));
        tailJll.addFirst(new JewelleryNode("Necklace" ,"Necklace" , "Female" , "\"http://baeldung.com\"", 20.90));

        //CustomLinkedList.Node<DisplayCaseNode> current = head;
//        while (current != null){
        System.out.println(head.val.toString());
            //current = current.next
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

    //save method
    private void save() {
        try{
            linkedlist.save();
        } catch (Exception e){
            System.err.println("Error writing to file " + e);
        }

    }

    //load method
    private void load() {
        try {
            linkedlist.load();
        } catch (Exception e){
            System.err.println("Error reading to file " + e);
        }

    }


}
