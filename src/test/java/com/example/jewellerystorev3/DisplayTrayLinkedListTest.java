package com.example.jewellerystorev3;

import org.hibernate.metamodel.relational.Identifier;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DisplayTrayLinkedListTest {

    @AfterEach
    void resetIndex() {
        DisplayTrayNode.identifierNumber = 0;
        DisplayTrayNode.identifierLetter = 65;
    }

    @Test
    void identifierExistsWhenCorrectIdentifierIsSearched() {
        DisplayTrayLinkedList ll = Setup.getPopulatedDisplayTrayLinkedList();
        ll.print();
        String identifier = "A1";
        assertTrue(ll.identifierExists(identifier));
    }

    @Test
    void testUniqueIdentifierCreation() {

        DisplayTrayLinkedList ll = new DisplayTrayLinkedList();

        String color = "red";
        double width = 0.0;
        double length = 0.1;

        int max = 150;
        int counter = 0;

        while (counter < max) {
            ll.addLast(new DisplayTrayNode(color, width, length));
            // check if there is now
            counter++;
        }

        ll.print();

    }

    @Test
    void getMostCommonGenderReturnsCorrectMessageForTwoOrMoreGendersOfTheSameValue() {
        DisplayTrayLinkedList ll = Setup.getPopulatedDisplayTrayLinkedList();
        CustomLinkedList.Node<DisplayTrayNode> current = ll.head;
        int counter = 0;
        int max = 15;

        while (counter < max) {
            CustomLinkedList.Node<DisplayTrayNode> head = ll.getHead();
            JewelleryLinkedList jll = head.val.getLinkedList();
            jll.addFirst(new JewelleryNode("Watch" ,"watch" , "Male" , "\"http://baeldung.com\"", 20.90));
            jll.addFirst(new JewelleryNode("Ring" ,"ring" , "Female" , "\"http://baeldung.com\"", 20.90));
            //jll.addFirst(new JewelleryNode("Ring" ,"ring" , "Female" , "\"http://baeldung.com\"", 20.90));
            jll.addFirst(new JewelleryNode("Ring" ,"ring" , "Unisex" , "\"http://baeldung.com\"", 20.90));
            counter++;
            current.val.setLinkedList(jll);
            }
        System.out.println(ll.getMostCommonGender());
        assertTrue(ll.getMostCommonGender().contains("Two or more genders are the most common gender:"));
        }

    @Test
    void getMostCommonGenderReturnsCorrectMessageForGenderWhenItsMostCommon() {
        DisplayTrayLinkedList ll = Setup.getPopulatedDisplayTrayLinkedList();
        CustomLinkedList.Node<DisplayTrayNode> current = ll.head;
        int counter = 0;
        int max = 15;

        while (counter < max) {
            CustomLinkedList.Node<DisplayTrayNode> head = ll.getHead();
            JewelleryLinkedList jll = head.val.getLinkedList();
            jll.addFirst(new JewelleryNode("Watch" ,"Watch" , "Male" , "\"http://baeldung.com\"", 20.90));
            jll.addFirst(new JewelleryNode("Ring" ,"Necklace" , "Female" , "\"http://baeldung.com\"", 20.90));
            jll.addFirst(new JewelleryNode("Ring" ,"Ring" , "Female" , "\"http://baeldung.com\"", 20.90));
            jll.addFirst(new JewelleryNode("Ring" ,"Ring" , "Unisex" , "\"http://baeldung.com\"", 20.90));
            counter++;
            current.val.setLinkedList(jll);
        }
        System.out.println(ll.getMostCommonGender());
        assertTrue(ll.getMostCommonGender().equals("Female"));
    }

    @Test
    void getMostCommonJewelleryTypeReturnsCorrectMessageForTwoOrMoreTypesOfTheSameValue() {
        DisplayTrayLinkedList ll = Setup.getPopulatedDisplayTrayLinkedList();
        CustomLinkedList.Node<DisplayTrayNode> current = ll.head;
        int counter = 0;
        int max = 15;

        while (counter < max) {
            CustomLinkedList.Node<DisplayTrayNode> head = ll.getHead();
            JewelleryLinkedList jll = head.val.getLinkedList();
            jll.addFirst(new JewelleryNode("Watch" ,"Watch" , "Male" , "\"http://baeldung.com\"", 20.90));
            jll.addFirst(new JewelleryNode("Ring" ,"Necklace" , "Female" , "\"http://baeldung.com\"", 20.90));
            jll.addFirst(new JewelleryNode("Ring" ,"Ring" , "Female" , "\"http://baeldung.com\"", 20.90));
//            jll.addFirst(new JewelleryNode("Ring" ,"Ring" , "Unisex" , "\"http://baeldung.com\"", 20.90));
            counter++;
            current.val.setLinkedList(jll);
        }
        System.out.println(ll.getMostCommonJewelleryType());
        assertTrue(ll.getMostCommonJewelleryType().contains("Two or more types are the most common type:"));
    }

    @Test
    void getMostCommonJewelleryTypeReturnCorrectTypeWhenItsMostCommon() {
        DisplayTrayLinkedList ll = Setup.getPopulatedDisplayTrayLinkedList();
        CustomLinkedList.Node<DisplayTrayNode> current = ll.head;
        int counter = 0;
        int max = 15;

        while (counter < max) {
            CustomLinkedList.Node<DisplayTrayNode> head = ll.getHead();
            JewelleryLinkedList jll = head.val.getLinkedList();
            jll.addFirst(new JewelleryNode("Watch", "Watch", "Male", "\"http://baeldung.com\"", 20.90));
            jll.addFirst(new JewelleryNode("Ring", "Necklace", "Female", "\"http://baeldung.com\"", 20.90));
            jll.addFirst(new JewelleryNode("Ring", "Ring", "Female", "\"http://baeldung.com\"", 20.90));
            //jll.addFirst(new JewelleryNode("Ring", "Necklace", "Female", "\"http://baeldung.com\"", 20.90));
            jll.addFirst(new JewelleryNode("Ring", "Ring", "Female", "\"http://baeldung.com\"", 20.90));
            counter++;
            current.val.setLinkedList(jll);
        }
        System.out.println(ll.getMostCommonJewelleryType());
        assertTrue(ll.getMostCommonJewelleryType().equals("Ring"));
    }


    @Test
    void testValueOfJewelleryItemsForDifferingValues() {
        DisplayTrayLinkedList dtll = new DisplayTrayLinkedList();
        dtll.addFirst(new DisplayTrayNode("",4.0,3.0));
        CustomLinkedList.Node<DisplayTrayNode> current = dtll.getHead();
        JewelleryLinkedList jll = current.val.getLinkedList();
        jll.addFirst(new JewelleryNode("Watch" ,"Watch" , "Male" , "\"http://baeldung.com\"", 79.1));
        jll.addFirst(new JewelleryNode("Ring" ,"Necklace" , "Female" , "\"http://baeldung.com\"", 24.67));
        jll.addFirst(new JewelleryNode("Ring" ,"Ring" , "Female" , "\"http://baeldung.com\"", 40.31));
        current.val.setLinkedList(jll);
        System.out.println(dtll.valueOfJewelleryItems());
        assertTrue(dtll.valueOfJewelleryItems() == 144.08);
    }
}
