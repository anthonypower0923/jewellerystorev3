package com.example.jewellerystorev3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class JewelleryLinkedListTest {

    @Test
    void testCalculateValueOfJewelleryItemsInPopulatedList() {
        JewelleryLinkedList ll = Setup.getPopulatedJewelleryLinkedList();
        ll.calculateValueOfJewelleryItems();
        ll.print();
        System.out.print(ll.getTotalValue());
        assertTrue(ll.getTotalValue() == 62.70);
    }

    @Test
    void testCalculateValueOfJewelleryItems() {
        JewelleryLinkedList ll = new JewelleryLinkedList();
        ll.calculateValueOfJewelleryItems();
        System.out.print(ll.getTotalValue());
        assertTrue(ll.getTotalValue() == 0);
    }

    @Test
    void toStringPrintsMaterial() {
        JewelleryNode newNode = new JewelleryNode("Watch","watch","male","baeldung.com",20.90);
        newNode.setMaterial(new Material("name","description",3,6));
        System.out.println(newNode.toString());
    }

    @Test
    void testSearchJewellery(){
        JewelleryLinkedList ll = new JewelleryLinkedList();

        JewelleryNode n1 = new JewelleryNode("Unicorn","watch","male","baeldung.com",20.90);
        n1.setMaterial(new Material("searchTerm","description",3,6));

        JewelleryNode n2 = new JewelleryNode("Watch","watch","male","baeldung.com",20.90);
        n2.setMaterial(new Material("useless","description",3,6));

        ll.addLast(n1);
        ll.addLast(n2);

        ArrayList<CustomLinkedList.Node<JewelleryNode>> matchedNodes = (ArrayList<CustomLinkedList.Node<JewelleryNode>>) ll.searchJewelleryByTerm("unicorn");
        matchedNodes.forEach(n ->System.out.println(n.val.toString()));

        assertTrue(matchedNodes.size() > 0);





    }
}