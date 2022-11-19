package com.example.jewellerystorev3;

import java.io.Serializable;

public class DisplayTrayNode implements Serializable {
    private JewelleryLinkedList linkedList = null;
    static int identifierNumber;
    static char identifierLetter = 65;
    private String identifier;
    private String inlayColour;
    private double width;
    private double depth;

    public DisplayTrayNode() {

    }

    public DisplayTrayNode(String inlayColour, double width, double depth) {
        this.identifier = generateId();
        this.inlayColour = inlayColour;
        this.width = width;
        this.depth = depth;
        this.linkedList = new JewelleryLinkedList();
    }

    @Override
    public String toString() {
        return "\n" + "DisplayTrayNode  " +
                "identifier= " + identifier +
                ", inlayColour= " + inlayColour +
                ", width= " + width +
                ", depth= " + depth + "\n";
//                " JewelleryLL: " + getLLContents() +;
    }

    public String getLLContents() {
        CustomLinkedList.Node<JewelleryNode> current = linkedList.getHead();
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.val.toString());
            sb.append(System.getProperty("line.separator"));
            //System.out.println(current.val + " /n");
            current = current.next;
        }
        //System.out.println(" sb contents =" +  "\n" + sb.toString());
        return sb.toString();
    }

    public String generateId() {
        // at this point the number and letter is equal to what the previously created node is.
            //if the identifierNumber is above 99 the letter increases by one (ex. A to B)
            if (identifierNumber >= 99) {
                identifierNumber = 0;
                identifierLetter++;
            }
            else{
                identifierNumber++;
            }
            //adds identifier values to string
            identifier = "" + identifierLetter + identifierNumber;
            return identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public char getIdentifierLetter() {
        return identifierLetter;
    }

    public void setIdentifierLetter(char identifierLetter) {
        identifierLetter = Character.toUpperCase(identifierLetter);
        if ((identifierLetter>= 65) && (identifierLetter<=90))
        this.identifierLetter = identifierLetter;
    }

    public int getIdentifierNumber() {
        return identifierNumber;
    }

    public void setIdentifierNumber(int identifierNumber) {
        if ((identifierNumber>=0) && (identifierNumber<=99)) {
            identifierNumber = identifierNumber;
        }
        else throw new IllegalArgumentException("Illegal number "+identifierNumber);
    }

    public String getInlayColour() {
        return inlayColour;
    }

    public void setInlayColour(String inlayColour) {
        this.inlayColour = inlayColour;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public JewelleryLinkedList getLinkedList() {
        return linkedList;
    }

    public void setLinkedList(JewelleryLinkedList linkedList) {
        this.linkedList = linkedList;
    }
}
