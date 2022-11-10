package com.example.jewellerystorev3;

public class Setup {
    // returns a linked list with 3 nodes in it
    public static CustomLinkedList<DisplayCaseNode> getPopulatedList(){
        CustomLinkedList<DisplayCaseNode> populatedList = new CustomLinkedList<>();
        DisplayCaseNode n0 = new DisplayCaseNode("Freestanding" , "Lit"); // ID DCN_0
        DisplayCaseNode n1 = new DisplayCaseNode("Freestanding" , "Lit"); // ID DCN_1
        DisplayCaseNode n2 = new DisplayCaseNode("Freestanding" , "Lit"); // ID DCN_2

        populatedList.addLast(n0);
        populatedList.addLast(n1);
        populatedList.addLast(n2);
        return populatedList;
    }

    public static DisplayCaseLinkedList getPopulatedDisplayCaseLinkedList(){
        DisplayCaseLinkedList populatedList = new DisplayCaseLinkedList();
        DisplayCaseNode n0 = new DisplayCaseNode("Freestanding" , "Lit"); // ID DCN_0
        DisplayCaseNode n1 = new DisplayCaseNode("Freestanding" , "Lit"); // ID DCN_1
        DisplayCaseNode n2 = new DisplayCaseNode("Freestanding" , "Lit"); // ID DCN_2

        populatedList.addLast(n0);
        populatedList.addLast(n1);
        populatedList.addLast(n2);
        return populatedList;
    }

    public static DisplayTrayLinkedList getPopulatedDisplayTrayLinkedList() {
        DisplayTrayLinkedList populatedList = new DisplayTrayLinkedList();
        DisplayTrayNode n0 = new DisplayTrayNode("green",3.90,4.0);
        DisplayTrayNode n1 = new DisplayTrayNode("green",3.90,4.0);
        DisplayTrayNode n2 = new DisplayTrayNode("green",3.90,4.0);

        populatedList.addLast(n0);
        populatedList.addLast(n1);
        populatedList.addLast(n2);
        return populatedList;
    }

    public static JewelleryLinkedList getPopulatedJewelleryLinkedList(){
        JewelleryLinkedList populatedList = new JewelleryLinkedList();
        JewelleryNode n0 = new JewelleryNode("Watch" ,"watch" , "Male" , "\"http://baeldung.com\"", 20.90);
        JewelleryNode n1 = new JewelleryNode("Watch" ,"watch" , "Male" , "\"http://baeldung.com\"", 20.90);
        JewelleryNode n2 = new JewelleryNode("Watch" ,"watch" , "Male" , "\"http://baeldung.com\"", 20.90);

        populatedList.addLast(n0);
        populatedList.addLast(n1);
        populatedList.addLast(n2);
        return populatedList;
    }
}
