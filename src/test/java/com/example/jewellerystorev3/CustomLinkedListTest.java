package com.example.jewellerystorev3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomLinkedListTest {

    @AfterEach
    void resetIndex(){
        DisplayCaseNode.idCounter = 0;
    }

    @Test
    void isEmptyForEmptyList() {
        CustomLinkedList<DisplayCaseNode> displayCases = new CustomLinkedList<>();
        assertTrue(displayCases.isEmpty());
    }

    @Test
    void isEmptyForPopulatedList() {
        CustomLinkedList<DisplayCaseNode> displayCases = getPopulatedList();
        assertFalse(displayCases.isEmpty());
    }

    // returns a linked list with 3 nodes in it
    CustomLinkedList<DisplayCaseNode> getPopulatedList(){
        CustomLinkedList<DisplayCaseNode> populatedList = new CustomLinkedList<>();
        DisplayCaseNode n0 = new DisplayCaseNode("","Freestanding" , "Lit"); // ID DCN_0
        DisplayCaseNode n1 = new DisplayCaseNode("","Freestanding" , "Lit"); // ID DCN_1
        DisplayCaseNode n2 = new DisplayCaseNode("","Freestanding" , "Lit"); // ID DCN_2

        populatedList.addLast(n0);
        populatedList.addLast(n1);
        populatedList.addLast(n2);
        return populatedList;
    }


    @Test
    void testAddFirstToEmptyList() {
        CustomLinkedList<DisplayCaseNode> displayCases = new CustomLinkedList<>();
        // test basic add to empty list
        DisplayCaseNode n1 = new DisplayCaseNode("","Freestanding" , "Lit");
        displayCases.addFirst(n1);
        displayCases.print();
        assertEquals(displayCases.getSize(), 1);
        CustomLinkedList.Node<DisplayCaseNode> head = displayCases.getHead();
        // assert the id of the head is now DCN_0
        assertEquals("DCN_0", head.val.getDisplayId());
        //displayCases.print();
    }

    @Test
    void testAddFirstToListNotEmpty(){
        // 3 nodes already
        CustomLinkedList<DisplayCaseNode> displayCases = getPopulatedList();

        // test when nodes already exist. Assert the new node is the new head of the list
        DisplayCaseNode node = new DisplayCaseNode("","Freestanding" , "Lit");
        displayCases.addFirst(node);
        assertEquals(displayCases.getSize(), 4);
        CustomLinkedList.Node<DisplayCaseNode> head = displayCases.getHead();
        // assert the id of the new head has changed from DCN_0 to DCN_1
        assertEquals("DCN_3", head.val.getDisplayId());
    }


    @Test
    void addLastToEmptyList() {
        CustomLinkedList<DisplayCaseNode> displayCases = new CustomLinkedList<>();

        // test basic add to empty list
        DisplayCaseNode n1 = new DisplayCaseNode("","Freestanding" , "Lit");
        displayCases.addLast(n1);
        assertEquals(displayCases.getSize(), 1);
        CustomLinkedList.Node<DisplayCaseNode> tail = displayCases.getTail();
        assertEquals("DCN_0", tail.val.getDisplayId());
    }

    @Test
    void addLastToListNotEmpty() {
        CustomLinkedList<DisplayCaseNode> displayCases = getPopulatedList();

        DisplayCaseNode node = new DisplayCaseNode("","Freestanding" , "Lit");
        displayCases.addLast(node);
        assertEquals(displayCases.getSize(), 4);
        CustomLinkedList.Node<DisplayCaseNode> tail = displayCases.getTail();
        // assert the id of the new head has changed from DCN_0 to DCN_1
        assertEquals("DCN_3", tail.val.getDisplayId());
        //displayCases.print();
    }

    @Test
    void addToIndexReturnsCorrectForAddingNode() {
        CustomLinkedList<DisplayCaseNode> displayCases = getPopulatedList();
        DisplayCaseNode node = new DisplayCaseNode("NEW NODE","Freestanding" , "Lit");
        displayCases.addToIndex(2,node);
        //assertEquals(displayCases.getSize(), 4);
        displayCases.print();
    }

    @Test
    void deleteFirstNodeInListWithOneNode() {
        CustomLinkedList<DisplayCaseNode> displayCases = new CustomLinkedList<>();
        DisplayCaseNode n1 = new DisplayCaseNode("","Freestanding" , "Lit");
        displayCases.addFirst(n1);
        displayCases.deleteFirst();
        assertEquals(displayCases.getSize(), 0);
    }

    @Test
    void deleteFirstNodeWithPopulatedList() {
        CustomLinkedList<DisplayCaseNode> displayCases = getPopulatedList();
        displayCases.deleteFirst();
        assertEquals(displayCases.getSize(), 2);
        CustomLinkedList.Node<DisplayCaseNode> head = displayCases.getHead();
        assertEquals("DCN_1", head.val.getDisplayId());
        displayCases.print();
    }

    @Test
    void deleteLastNodeInListWithOneNode() {
        CustomLinkedList<DisplayCaseNode> displayCases = new CustomLinkedList<>();
        DisplayCaseNode n1 = new DisplayCaseNode("","Freestanding" , "Lit");
        displayCases.addFirst(n1);
        displayCases.deleteLast();
        assertEquals(displayCases.getSize(), 0);
    }

    @Test
    void deleteLastNodeInPopulatedList() {
        CustomLinkedList<DisplayCaseNode> displayCases = getPopulatedList();
        displayCases.deleteLast();
        assertEquals(displayCases.getSize(), 2);
        CustomLinkedList.Node<DisplayCaseNode> tail = displayCases.getTail();
        assertEquals("DCN_1", tail.val.getDisplayId());
    }

    @Test
    void getNodeAtIndexReturnsCorrectNodeIfNodeExists() {
        CustomLinkedList<DisplayCaseNode> ll = Setup.getPopulatedList();
        ll.print();
        CustomLinkedList.Node<DisplayCaseNode> n = ll.getNodeAtIndex(2);
        System.out.println(n.val.toString());
    }

    @Test
    void getNodeAtIndexReturnsTailIfIndexIsOutOfBounds() {
        CustomLinkedList<DisplayCaseNode> ll = Setup.getPopulatedList();
        CustomLinkedList.Node<DisplayCaseNode> n = ll.getNodeAtIndex(5);
        System.out.println(n.val.toString());
    }

    @Test
    void getNodeAtIndexReturnsHeadIfIndexIsZero() {
        CustomLinkedList<DisplayCaseNode> ll = Setup.getPopulatedList();
        CustomLinkedList.Node<DisplayCaseNode> n = ll.getNodeAtIndex(0);
        System.out.println(n.val.toString());
    }

//    @Test
//    void getNodeAtIndexReturnsCorrectStringIfListIsEmpty() {
//        CustomLinkedList<DisplayCaseNode> ll = new CustomLinkedList<>();
//        CustomLinkedList.Node<DisplayCaseNode> n = ll.getNodeAtIndex(0);
//        System.out.println(n.val.toString());
//    }

    @Test
    void exists() {
        CustomLinkedList<DisplayCaseNode> displayCases = new CustomLinkedList<>();

    }

    @Test
    void print() {
    }

//    @Test
//    void getHead() {
//    }
//
//    @Test
//    void setHead() {
//    }
//
//    @Test
//    void getTail() {
//    }
//
//    @Test
//    void setTail() {
//    }
//
//    @Test
//    void getSize() {
//    }
//
//    @Test
//    void setSize() {
//    }
}