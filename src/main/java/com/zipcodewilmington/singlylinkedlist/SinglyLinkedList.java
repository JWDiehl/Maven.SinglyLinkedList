package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList <E extends Comparable<E>> {

    //Node inner class to represent each element in the linked list
    public class Node {
        E data;
        Node next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    //Head of the list
    public Node head;

    //Size of the list
    private int size;

    //Constructor
    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    //Methods --

    //Add an element to end of List
    public void add(E element) {
        Node newNode = new Node(element);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index ==0) {
            head = head.next;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    //Method to check if the lists contains specific element
    public boolean contains(E element) {
        Node current = head;
        while(current != null) {
            if(current.data.equals(element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    //Method to find the index of a spec element
    public int find(E element) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if(current.data.equals(element)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    //Size method
    public int size() {
        return size;
    }

    //Method to create a COPY
    public SinglyLinkedList<E> copy() {
        SinglyLinkedList<E> newList = new SinglyLinkedList<>();
        Node current = head;
        while(current != null) {
            newList.add(current.data);
            current = current.next;
        }
        return newList;
    }

    private void add(int data) {
    }

    //Method to get the element at a spec index
    public E get(int index) {
        if (index < 0 || index>= size) {
            throw new IndexOutOfBoundsException("Index" + index + ", Size: " + size);
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    //Method to sort the list - bubble sort algo
    public SinglyLinkedList<E> sort() {
        if (size > 1) {
            boolean swapped;
            do {
                swapped = false;
                Node current = head;
                Node previous = null;
                while (current.next != null) {
                    if (current.data.compareTo(current.next.data) > 0) {
                        //Swap
                        Node temp = current.next;
                        current.next = temp.next;
                        temp.next = current;
                        if (previous == null) {
                            head = temp;
                        } else {
                            previous.next = temp;
                        }
                        previous = temp;
                        swapped = true;
                    } else {
                        previous = current;
                        current = current.next;
                    }
                }
            } while (swapped);
        }
        return null;
    }

    //Method to reverse linked list
    public void reverse() {
        if (head == null || head.next == null) {
            return;
        }
        Node previous = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }

    //Method to slice the list and reutrn copy of elements
    public SinglyLinkedList<E> slice(int start, int end) {
        if (start < 0 || end > size || start >= end) {
            throw new IllegalArgumentException("Invalid slice indices");
        }
        SinglyLinkedList<E> slicedList = new SinglyLinkedList<>();
        Node current = head;
        int index = 0;
        while (current != null) {
            if (index >= start && index < end) {
                slicedList.add(current.data);
            }
            current = current.next;
            index++;
        }
        return slicedList;
    }
}
