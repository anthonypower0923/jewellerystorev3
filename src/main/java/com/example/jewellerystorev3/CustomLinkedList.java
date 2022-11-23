package com.example.jewellerystorev3;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;


public class CustomLinkedList<E> implements Serializable {
    Node<E> head;
    Node<E> tail;
    int size;

    static class Node<E> implements Serializable {
        E val;
        Node<E> next;

        Node(E val) {
            this.val = val;
        }
    }

    public CustomLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(E val) {
        if (isEmpty()) {
            head = new Node<E>(val);
            tail = head;
            size++;
            return;
        }
        Node<E> newNode = new Node<E>(val);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addLast(E val) {
        if (isEmpty()) {
            head = new Node<E>(val);
            tail = head;
            size++;
            return;
        }
        Node<E> newNode = new Node<E>(val);
        tail.next = newNode;
        tail = newNode;
        size++;


    }

    public void addToIndex(int pos, E val) {
        if (pos == 0) {
            addFirst(val);
            return;
        }

        if (pos > size - 1) {
            System.out.println("pos > head");
            addLast(val);
            return;
        }

        Node<E> current = head;
        int count = 1;
        while (size < pos) {
            count++;
            current = current.next;
        }
        Node<E> newNode = new Node<>(val);
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    public void deleteFirst() {
        if (isEmpty()) {
            return;
        }
        Node<E> current = head;
        head = head.next;
        current.next = null;
        size--;
    }

    public void deleteLast() {
        if (isEmpty()) {
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
            size--;
            return;
        }
        Node<E> current = head;
        Node<E> previous = null;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        previous.next = null;
        tail = previous;
        size--;
    }

    public void deleteAtIndex(int pos) {
        if (isEmpty()) {
            return;
        }

        if (pos == 0) {
            deleteFirst();
            return;
        }

        if (pos > size - 1) {
            System.out.println("pos > head");
            deleteLast();
            return;
        }

        Node<E> current = head;
        Node<E> prev = null;
        int count = 0;
        while (count < pos) {
            count++;
            prev = current;
            current = current.next;
        }
        prev.next = current.next;
        current.next = null;
        size--;
    }

    public Node<E> getNodeAtIndex(int index) {
        if (isEmpty()) {
            throw new RuntimeException("List is Empty");
        }
        //if position is equal to the head, return head
        if (index == 0) {
            return head;
        }
        //if position is greater than the size, return tail
        if (index > size) {
            System.out.println("index > tail");
            return tail;
        }

        //if position is inside the list , return DisplayCaseNode
        Node<E> current = head;
        int count = 1;
        while (count < size - 1) {
            count++;
            current = current.next;
        }
        size++;
        return current;
    }

    public boolean exists(E val) {
        Node<E> current = head;
        while (current != null) {
            if (val == current.val) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void print() {
        System.out.print("number of elements in list: " + size + " \n");
        Node<E> current = head;
        while (current != null) {
            System.out.println(current.val + " \n");
            current = current.next;
        }
    }

    public Node<E> getHead() {
        return head;
    }

    public void setHead(Node<E> head) {
        this.head = head;
    }

    public Node<E> getTail() {
        return tail;
    }

    public void setTail(Node<E> tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public double roundDoubleToTwoPlaces(double value) {
        return round(value, 2);
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
