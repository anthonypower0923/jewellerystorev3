package com.example.jewellerystorev3;

public class DisplayCaseNode {
    private DisplayTrayLinkedList linkedList = null;
    private String jewelleryType;
    static int idCounter;
    private String displayId;
    private String type;
    private String lighting;

    public DisplayCaseNode() {

    }

    public DisplayCaseNode(String jewelleryType, String type, String lighting) {
        this.jewelleryType = jewelleryType;
        this.displayId = "DCN_"+ idCounter;
        this.type = type;
        this.lighting = lighting;
        this.linkedList = new DisplayTrayLinkedList();
        idCounter++;
    }

    @Override
    public String toString() {
        return "DisplayCaseNode{" +
                "displayId=" + displayId +
                ", type='" + type + '\'' +
                ", lighting='" + lighting + '\'' +
                ", JewelleryType " + jewelleryType + '\'' +
                ", DisplayTrayLL " + getLLContents() + '\'' +
                '}';
    }

    public String getLLContents() {

        CustomLinkedList.Node<DisplayTrayNode> current = linkedList.getHead();
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

    public String getJewelleryType() {
        return jewelleryType;
    }

    public void setJewelleryType(String jewelleryType) {
        this.jewelleryType = jewelleryType;
    }

    public String getDisplayId() {
        return displayId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLighting() {
        return lighting;
    }

    public void setLighting(String lighting) {
        this.lighting = lighting;
    }

    public DisplayTrayLinkedList getLinkedList() {
        return linkedList;
    }

    public void setLinkedList(DisplayTrayLinkedList linkedList) {
        this.linkedList = linkedList;
    }
}
