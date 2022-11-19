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
        DisplayCaseNode n0 = new DisplayCaseNode("Freestanding" , "Lit"); // ID DCN_0
        DisplayCaseNode n1 = new DisplayCaseNode("Freestanding" , "Lit"); // ID DCN_1
        DisplayCaseNode n2 = new DisplayCaseNode("Freestanding" , "Lit"); // ID DCN_2

        populatedList.addLast(n0);
        populatedList.addLast(n1);
        populatedList.addLast(n2);
        return populatedList;
    }


    @Test
    void testAddFirstToEmptyList() {
        CustomLinkedList<DisplayCaseNode> displayCases = new CustomLinkedList<>();
        // test basic add to empty list
        DisplayCaseNode n1 = new DisplayCaseNode("Freestanding" , "Lit");
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
        DisplayCaseNode node = new DisplayCaseNode("Freestanding" , "Lit");
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
        DisplayCaseNode n1 = new DisplayCaseNode("Freestanding" , "Lit");
        displayCases.addLast(n1);
        assertEquals(displayCases.getSize(), 1);
        CustomLinkedList.Node<DisplayCaseNode> tail = displayCases.getTail();
        assertEquals("DCN_0", tail.val.getDisplayId());
    }

    @Test
    void addLastToListNotEmpty() {
        CustomLinkedList<DisplayCaseNode> displayCases = getPopulatedList();

        DisplayCaseNode node = new DisplayCaseNode("Freestanding" , "Lit");
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
        DisplayCaseNode node = new DisplayCaseNode("Freestanding" , "Lit");
        displayCases.addToIndex(2,node);
        //assertEquals(displayCases.getSize(), 4);
        displayCases.print();
    }

    @Test
    void deleteFirstNodeInListWithOneNode() {
        CustomLinkedList<DisplayCaseNode> displayCases = new CustomLinkedList<>();
        DisplayCaseNode n1 = new DisplayCaseNode("Freestanding" , "Lit");
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
        DisplayCaseNode n1 = new DisplayCaseNode("Freestanding" , "Lit");
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
    void roundDoubleToTwoPlacesWorks() {
        CustomLinkedList cll = new CustomLinkedList<>();
        double value = 3.45878990;
        double zero = 0.0000;
        double oneDecimalPlace = 1.2;
        double interger = 1.0;
        assertEquals(3.46 , cll.roundDoubleToTwoPlaces(value));
        assertEquals(0.00 , cll.roundDoubleToTwoPlaces(zero));
        assertEquals(1.20 , cll.roundDoubleToTwoPlaces(oneDecimalPlace));
        assertEquals(1.00 , cll.roundDoubleToTwoPlaces(interger));
    }

    @Test
    void doublesCalculationWorks() {
        CustomLinkedList cll = new CustomLinkedList<>();
        assertEquals(cll.roundDoubleToTwoPlaces((29.20 + 30.45 + 11.93) / 3 ), cll.roundDoubleToTwoPlaces(29.20 + 30.45 + 11.93) / 3);
    }

    @Test
    void isEmptyWorksForListThatIsEmpty() {
        DisplayCaseLinkedList dcll = new DisplayCaseLinkedList();
        assertTrue(dcll.isEmpty());
    }

    @Test
    void isEmptyWorksForListThatIsNotEmpty() {
        DisplayCaseLinkedList dcll = new DisplayCaseLinkedList();
        dcll.addFirst(new DisplayCaseNode());
        assertFalse(dcll.isEmpty());
    }

    @Test
    void addFirstAddsANode() {
        DisplayCaseLinkedList dcll = new DisplayCaseLinkedList();
        DisplayCaseNode n0 = new DisplayCaseNode();
        dcll.addFirst(n0);
        assertTrue(dcll.getSize() == 1);
    }

    @Test
    void addFirstAddsANodeToTheHeadOfList() {
        DisplayCaseLinkedList dcll = new DisplayCaseLinkedList();
        DisplayCaseNode n0 = new DisplayCaseNode();
        DisplayCaseNode n1 = new DisplayCaseNode("Freestanding" , "Lit");
        dcll.addFirst(n0);
        dcll.addFirst(n1);
        assertTrue(dcll.getSize() == 2);
        assertTrue(dcll.getHead().val.equals(n1));
    }

    @Test
    void addLastAddsANode() {
        DisplayCaseLinkedList dcll = new DisplayCaseLinkedList();
        DisplayCaseNode n0 = new DisplayCaseNode();
        dcll.addLast(n0);
        assertTrue(dcll.getSize() == 1);
    }

    @Test
    void addFirstAddsANodeToTheTailOfList() {
        DisplayCaseLinkedList dcll = new DisplayCaseLinkedList();
        DisplayCaseNode n0 = new DisplayCaseNode();
        DisplayCaseNode n1 = new DisplayCaseNode("Freestanding" , "Lit");
        dcll.addLast(n0);
        dcll.addLast(n1);
        assertTrue(dcll.getSize() == 2);
        assertTrue(dcll.getTail().val.equals(n1));
    }

    @Test
    void addToIndexAddsNodeAtThatIndex() {
        DisplayCaseLinkedList dcll = new DisplayCaseLinkedList();
        DisplayCaseNode n0 = new DisplayCaseNode();
        DisplayCaseNode n1 = new DisplayCaseNode("Freestanding" , "Lit");
        dcll.addToIndex(0,n0);
        dcll.addLast(n1);
        System.out.println(dcll.getSize());
        assertTrue(dcll.getSize() == 2);
        assertTrue(dcll.getNodeAtIndex(0).val.equals(n0));
    }

    @Test
    void deleteFirstRemovesANode() {
        DisplayCaseLinkedList dcll = new DisplayCaseLinkedList();
        DisplayCaseNode n0 = new DisplayCaseNode();
        DisplayCaseNode n1 = new DisplayCaseNode("Freestanding" , "Lit");
        dcll.addToIndex(0,n0);
        dcll.addLast(n1);
        dcll.deleteFirst();
        assertTrue(dcll.getSize() == 1);
    }

    @Test
    void deleteLastRemovesLastNode() {
        DisplayCaseLinkedList dcll = new DisplayCaseLinkedList();
        DisplayCaseNode n0 = new DisplayCaseNode();
        DisplayCaseNode n1 = new DisplayCaseNode("Freestanding" , "Lit");
        DisplayCaseNode n2 = new DisplayCaseNode("Freestanding" , "Lit");
        dcll.addToIndex(0,n0);
        dcll.addLast(n1);
        dcll.addLast(n2);
        dcll.deleteLast();
        System.out.println(dcll.getSize());
        assertTrue(dcll.getSize() == 2);
        assertFalse(dcll.getTail().val.equals(n2));
    }

    @Test
    void deleteNodeAtIndexRemovesNodeAtSpecifiedIndex() {
        DisplayCaseLinkedList dcll = new DisplayCaseLinkedList();
        DisplayCaseNode n0 = new DisplayCaseNode();
        DisplayCaseNode n1 = new DisplayCaseNode("Freestanding" , "Lit");
        DisplayCaseNode n2 = new DisplayCaseNode("Freestanding" , "Lit");
        dcll.addToIndex(0,n0);
        dcll.addLast(n1);
        dcll.addLast(n2);
        dcll.deleteAtIndex(3);
        assertTrue(dcll.getSize() == 2);
        assertFalse(dcll.getTail().val.equals(n2));
    }

    @Test
    void getNodeAtIndex() {
        DisplayCaseLinkedList dcll = new DisplayCaseLinkedList();
        DisplayCaseNode n0 = new DisplayCaseNode();
        DisplayCaseNode n1 = new DisplayCaseNode("Freestanding" , "Lit");
        DisplayCaseNode n2 = new DisplayCaseNode("Freestanding" , "Lit");
        dcll.addToIndex(0,n0);
        dcll.addLast(n1);
        dcll.addLast(n2);
        assertTrue(dcll.getSize() == 3);
        assertFalse(dcll.getNodeAtIndex(3).val.equals(n2));
    }

    @Test
    void testExistsWorkWithListThatIsPopulated() {
        DisplayCaseLinkedList dcll = new DisplayCaseLinkedList();
        DisplayCaseNode n0 = new DisplayCaseNode();
        DisplayCaseNode n1 = new DisplayCaseNode("Freestanding" , "Lit");
        DisplayCaseNode n2 = new DisplayCaseNode("Freestanding" , "Lit");
        dcll.addToIndex(0,n0);
        dcll.addLast(n1);
        dcll.addLast(n2);
        assertTrue(dcll.getSize() == 3);
        assertTrue(dcll.exists(n2));
    }
}