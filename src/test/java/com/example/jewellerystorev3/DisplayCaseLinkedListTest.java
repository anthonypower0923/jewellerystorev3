package com.example.jewellerystorev3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DisplayCaseLinkedListTest {

    @Test
    void getAllDisplayIds() {
    }

    @Test
    void checkNodeIdExists() {
        DisplayCaseLinkedList ll = Setup.getPopulatedDisplayCaseLinkedList();
        assertTrue(ll.checkNodeIdExists("DCN_0"));
    }

}