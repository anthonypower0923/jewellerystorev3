package com.example.jewellerystorev3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DisplayTrayNodeTest {

    @Test
    void  mkfvmrv() {
        DisplayTrayLinkedList ll = Setup.getPopulatedDisplayTrayLinkedList();
        DisplayTrayNode trayNode = new DisplayTrayNode();
        ll.print();
        System.out.println(trayNode.getIdentifier());
    }
}