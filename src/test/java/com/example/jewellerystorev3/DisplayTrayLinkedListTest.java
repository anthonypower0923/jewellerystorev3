package com.example.jewellerystorev3;

import org.hibernate.metamodel.relational.Identifier;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DisplayTrayLinkedListTest {

    @AfterEach
    void resetIndex(){
        DisplayTrayNode.identifierNumber = 0;
        DisplayTrayNode.identifierLetter = 65;
    }


    @Test
    void valueOfJewelleryItems() {
    }

    @Test
    void getTotalValue() {
    }

    @Test
    void setTotalValue() {
    }

    @Test
    void identifierExistsWhenCorrectIdentifierIsSearched() {
        DisplayTrayLinkedList ll = Setup.getPopulatedDisplayTrayLinkedList();
        ll.print();
        String identifier = "A01";
        assertTrue(ll.identifierExists(identifier));
    }

    @Test
    void testUniqueIdentifierCreation(){

        DisplayTrayLinkedList ll = new DisplayTrayLinkedList();

        String color = "red";
        double width = 0.0;
        double length = 0.1;
        String gender = "Male";

        int max = 150;
        int counter = 0;

        while (counter < max){
            ll.addLast(new DisplayTrayNode(color, width, length, gender));
            // check if there is now
            counter++;
        }

        ll.print();

    }
}