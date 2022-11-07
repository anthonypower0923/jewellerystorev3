package com.example.jewellerystorev3;

public class DisplayTrayNode {
    private JewelleryLinkedList linkedList = null;
    static int identifierNumber;
    static char identifierLetter = 65;
    private String identifier;
    private String inlayColour;
    private double width;
    private double length;
    private String gender;
    private double averagePrice = 0.0;

    public DisplayTrayNode() {

    }

    public DisplayTrayNode(String inlayColour, double width, double length, String gender) {
        this.identifier = generateId();
        this.inlayColour = inlayColour;
        this.width = width;
        this.length = length;
        this.gender = gender;
        this.linkedList = new JewelleryLinkedList();
    }

    @Override
    public String toString() {
        return "DisplayTrayNode{" +
                "identifier='" + identifier + '\'' +
                ", inlayColour='" + inlayColour + '\'' +
                ", width=" + width +
                ", length=" + length +
                ", averagePrice" + averagePrice +
                ", JewelleryLL " + getLLContents() + '\'' +
                '}';
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

    public void calculateAveragePrice() {
        CustomLinkedList.Node<JewelleryNode> current = linkedList.getHead();
        double averagePrice = 0;
        int counter = 0;
        while (current != null) {
            if (current.val.getRetailPrice() > 0) {
                averagePrice = averagePrice + current.val.getRetailPrice();
                counter++;
            }
            current = current.next;
        }
        averagePrice = averagePrice/counter;
        setAveragePrice(averagePrice);
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

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public JewelleryLinkedList getLinkedList() {
        return linkedList;
    }

    public String getGender() {
        return gender;
    }

    public double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(double averagePrice) {
        this.averagePrice = averagePrice;
    }
}
