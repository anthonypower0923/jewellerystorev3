package com.example.jewellerystorev3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.*;
import java.util.*;
public class IndexController implements Serializable {

    //JewelleryItem
    @FXML
    TextField itemDescription;
    @FXML
    ChoiceBox<String> type;
    @FXML
    ChoiceBox<String> targetGender;
    @FXML
    TextField url;
    @FXML
    ChoiceBox<Double> retailPrice;
    //Material
    @FXML
    ChoiceBox<String> name;
    @FXML
    TextField description;
    @FXML
    ChoiceBox<Integer> quantity;
    @FXML
    ChoiceBox<Integer> quality;

    @FXML
    TextField searchString;

    @FXML
    Button addjewellery;

    @FXML
    Button smartadd;

    //DisplayTray

    public ChoiceBox<String> inlayColour;
    public ChoiceBox<Double> width;
    public ChoiceBox<Double> depth;

    //Display Case

    public ChoiceBox<String> type1;
    public ChoiceBox<String> lighting;

    public TreeView<String> tree = new TreeView<>();
    public AnchorPane rootPane = new AnchorPane();
    public AnchorPane pane1 = new AnchorPane();
    public AnchorPane pane2 = new AnchorPane();
    public AnchorPane pane3 = new AnchorPane();

    TreeItem<String> rootItem = new TreeItem<String>("Jewellery Store");

    TreeItem<String> caseContents1 = new TreeItem<String>("Contents");
    TreeItem<String> tray1Contents = new TreeItem<String>("Tray-Contents");

    public DisplayCaseLinkedList dcll = new DisplayCaseLinkedList();
    DisplayTrayLinkedList dtll = new DisplayTrayLinkedList();
    JewelleryLinkedList jll = new JewelleryLinkedList();

    public void addJewelleryItem(ActionEvent actionEvent) {
        JewelleryNode node = new JewelleryNode(itemDescription.getText() , type.getValue() , targetGender.getValue() , url.getText() , retailPrice.getValue());
        Material material = new Material(name.getValue() , description.getText() , quantity.getValue() , quality.getValue());
        node.setMaterial(material);
        jll.addFirst(node);

        TreeItem<String> jew1 = new TreeItem<String>(node.toString());
        TreeItem<String> drillDown = new TreeItem<>("Drill Down");
        TreeItem<String> material1 = new TreeItem<>(material.toString());

        //Get selected item
        TreeItem<String> selectedItem = tree.getSelectionModel().getSelectedItem();
        //If there is no selection or root is selected do nothing
        if (selectedItem == null || selectedItem == rootItem)
            return;

        //Otherwise, get the index of the Node from the children of its parent
        //and append the new item right after it
        int index = selectedItem.getParent().getChildren().indexOf(selectedItem);
        selectedItem.getParent().getChildren().add(index+1, jew1);

        jew1.getChildren().addAll(drillDown);
        drillDown.getChildren().addAll(material1);

        pane2.setDisable(false);
        dcll.print();
    }

    public void addDisplayCase(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
            DisplayCaseNode node = new DisplayCaseNode(type1.getValue(), lighting.getValue());
            dcll.addFirst(node);
            TreeItem<String> case1 = new TreeItem<String>(node.toString() + "Total value=  €" + dcll.calculateValueOfJewelleryItems());
            dtll = node.getLinkedList();


        TreeItem<String> selectedItem = tree.getSelectionModel().getSelectedItem();
        //If there is no selection or root is selected do nothing
        if (selectedItem == null || selectedItem == rootItem)
            return;

        //Otherwise, get the index of the Node from the children of its parent
        //and append the new item right after it
        int index = selectedItem.getParent().getChildren().indexOf(selectedItem);
        selectedItem.getParent().getChildren().add(index+1, case1);

        case1.getChildren().addAll(caseContents1);

        pane3.setDisable(false);
        pane2.setDisable(true);
        dcll.print();
        dtll = node.getLinkedList();
    }

    public void addDisplayTray(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        TreeItem<String> selectedItem = tree.getSelectionModel().getSelectedItem();
        //If there is no selection or root is selected do nothing
        if (selectedItem == null || selectedItem == rootItem)
            return;

        //Otherwise, get the index of the Node from the children of its parent
        //and append the new item right after it
        int index = selectedItem.getParent().getChildren().indexOf(selectedItem);
        DisplayTrayNode tray = new DisplayTrayNode(inlayColour.getValue() , width.getValue() , depth.getValue());
        dtll.addToIndex(index , tray);
        TreeItem<String> tray1 = new TreeItem<String>(tray.toString() + "Total value=  €" + dtll.calculateValueOfJewelleryItems());
        selectedItem.getParent().getChildren().add(index+1, tray1);

        tray1.getChildren().addAll(tray1Contents);

        dcll.print();
        pane3.setDisable(true);
        itemDescription.setDisable(false);
        type.setDisable(false);
        targetGender.setDisable(false);
        url.setDisable(false);
        retailPrice.setDisable(false);
        name.setDisable(false);
        description.setDisable(false);
        quality.setDisable(false);
        quantity.setDisable(false);
        addjewellery.setDisable(false);
        smartadd.setDisable(false);
        jll = tray.getLinkedList();
    }

    public void delete(ActionEvent actionEvent) {
        TreeItem<String> selectedItem = tree.getSelectionModel().getSelectedItem();
        //If there is no selection or root is selected do nothing
        if (selectedItem == null || selectedItem == rootItem)
            return;

        //Otherwise, get the index of the Node from the children of its parent
        //and append the new item right after it
        int index = selectedItem.getParent().getChildren().indexOf(selectedItem);
        selectedItem.getParent().getChildren().remove(index);
//
//        if (!dcll.isEmpty()) {
//            dcll.deleteAtIndex(index -1);
//            return;
//        }
//        if (!dtll.isEmpty()) {
//            dtll.deleteAtIndex(index -1);
//            return;
//        }
        if (!jll.isEmpty()) {
            jll.deleteAtIndex(index);
            return;
        }

        System.out.println(index);
        dcll.print();

        pane2.setDisable(false);
    }

    public void searchTree(ActionEvent actionEvent) {
        String term = searchString.getText();
        List<CustomLinkedList.Node<JewelleryNode>> list = jll.searchJewelleryByTerm(term);
        for (int i = 0; i < list.size(); i++) {
            CustomLinkedList.Node<JewelleryNode> node = list.get(i);
            TreeItem<String> foundItem = new TreeItem<String>("Item that matched your search=" + term + "  " +node.val.toString());
            TreeItem<String> selectedItem = tree.getSelectionModel().getSelectedItem();
            //If there is no selection or root is selected do nothing
            if (selectedItem == null || selectedItem == rootItem)
                return;

            //Otherwise, get the index of the Node from the children of its parent
            //and append the new item right after it
            int index = selectedItem.getParent().getChildren().indexOf(selectedItem);
            selectedItem.getParent().getChildren().add(index + 1, foundItem);
        }
    }

    public void reload() throws IOException, ClassNotFoundException {
            loadTree();
    }

    public void reset() throws IOException {
        initialize();
        dcll = new DisplayCaseLinkedList();
        saveCase("dcll" , dcll);
    }

    public void saveTree(ActionEvent actionEvent) throws IOException {
        saveCase("dcll", dcll);
    }

    public void loadTree() throws IOException, ClassNotFoundException {
        dcll = readCase("dcll");
        CustomLinkedList.Node<DisplayCaseNode> displayNode = dcll.getHead();
        DisplayTrayLinkedList dtll = displayNode.val.getLinkedList();
        CustomLinkedList.Node<DisplayTrayNode> trayNode = dtll.getHead();
        JewelleryLinkedList jll = trayNode.val.getLinkedList();
        CustomLinkedList.Node<JewelleryNode> jewelleryNode = jll.getHead();
        Material materials = jewelleryNode.val.getMaterial();
        TreeItem<String> cases = new TreeItem<>();
        TreeItem<String> trays = new TreeItem<>();
        TreeItem<String> jewellery = new TreeItem<>();
        TreeItem<String> material = new TreeItem<>();
        TreeItem<String> caseContents = new TreeItem<>();
        TreeItem<String> trayContents = new TreeItem<>();
        TreeItem<String> selectedItem = tree.getSelectionModel().getSelectedItem();
        //If there is no selection or root is selected do nothing
        if (selectedItem == null || selectedItem == rootItem)
            return;

        //Otherwise, get the index of the Node from the children of its parent
        //and append the new item right after it
        int index = selectedItem.getParent().getChildren().indexOf(selectedItem);

                while (displayNode != null) {
                    cases = new TreeItem<>(displayNode.val.toString()  + "Total value=  €" + dcll.calculateValueOfJewelleryItems());
                    caseContents = new TreeItem<>("Contents");
                    selectedItem.getParent().getChildren().add(index+1, cases);
                    cases.getChildren().addAll(caseContents);
                    System.out.println(displayNode.val.toString());
                    displayNode = displayNode.next;
                }
                //check if type and price are the same
                while (trayNode != null) {
                    trays = new TreeItem<>(trayNode.val.toString()  + "Total value=  €" + dtll.calculateValueOfJewelleryItems());
                    trayContents = new TreeItem<>("Tray-Contents");
                    caseContents.getChildren().addAll(trays);
                    trays.getChildren().addAll(trayContents);
                    trayNode = trayNode.next;
//                        System.out.println(trayNode.val.toString());
                }
                //adds to first node if none of conditions are met
                while (jewelleryNode != null) {
                    jewellery = new TreeItem<>(jewelleryNode.val.toString());
                    material = new TreeItem<>(materials.toString());
                    TreeItem<String> drillDown = new TreeItem<>("Drill Down");
                    trayContents.getChildren().addAll(jewellery);
                    jewellery.getChildren().addAll(drillDown);
                    drillDown.getChildren().addAll(material);
                    jewelleryNode = jewelleryNode.next;
                }
    }

    public void smartAdd(ActionEvent actionEvent) {
        JewelleryNode jewelleryNode = new JewelleryNode(itemDescription.getText() , type.getValue() , targetGender.getValue() , url.getText() , retailPrice.getValue());
        Material material = new Material(name.getValue() , description.getText() , quantity.getValue() , quality.getValue());
        jewelleryNode.setMaterial(material);
        smartAdd(jewelleryNode);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText("Save , leave and reload and to see changes");
        alert.showAndWait();
    }

    public void smartAdd(JewelleryNode node) {
        CustomLinkedList.Node<DisplayCaseNode> displayNode = dcll.getHead();
        DisplayTrayLinkedList dtll = displayNode.val.getLinkedList();
        CustomLinkedList.Node<DisplayTrayNode> trayNode = dtll.getHead();
        JewelleryLinkedList jll = trayNode.val.getLinkedList();
        int pos = 0;
        while (displayNode != null) {
            while (trayNode != null) {
                String gender = dtll.getMostCommonGender();
                String type = dtll.getMostCommonJewelleryType();
                double price = jll.getAverageValueOfJewelleryItems();
                pos++;
                //check if all three fields are the same
                if ((gender.equals(node.getTargetGender())) && (type.equals(node.getType())) && (price == node.getRetailPrice()) && (dtll.isWithinPercentage(price , 30))) {
                    jll.addToIndex(pos , node);
                    System.out.println(displayNode.val.toString());
                    return;
                }
                //checks if gender and type are the same
                if ((gender.equals(node.getTargetGender())) && (type.equals(node.getType())) && (price != node.getRetailPrice()) && (dtll.isWithinPercentage(price , 30))) {
                    jll.addToIndex(pos , node);
                    System.out.println(displayNode.val.toString());
                    return;
                }
                //check if type and price are the same
                if (!(gender.equals(node.getTargetGender())) || (type.equals(node.getType()))) {
                    jll.addToIndex(pos , node);
                    System.out.println(displayNode.val.toString());
                    return;
                }
                //adds to first node if none of conditions are met
                if (!(gender.equals(node.getTargetGender())) && !(type.equals(node.getType()))) {
                    jll.addFirst(node);
                    System.out.println(displayNode.val.toString());
                    return;
                }
                trayNode = trayNode.next;
            }
            displayNode = displayNode.next;
        }

    }

    public DisplayCaseLinkedList readCase(String path) throws FileNotFoundException, IOException, ClassNotFoundException {
        DisplayCaseLinkedList infoList;
        //Point to the file
        File fileToRead = new File(path);
        //Read the information from a file using FileInputStream
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileToRead));
        //Read object
        infoList = (DisplayCaseLinkedList) objectInputStream.readObject();
        //Close the stream
        objectInputStream.close();
        return infoList;
    }

    public void saveCase(String path, DisplayCaseLinkedList list) throws FileNotFoundException, IOException {
        //Point to the file
        File file = new File(path);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        //Write the object to a file
        objectOutputStream.writeObject(list);
        //Close the streams
        objectOutputStream.close();
    }

    public void initialize() {
        type.getItems().addAll("Watch" , "Ring" , "Necklace");
        targetGender.getItems().addAll("Male" , "Female" , "Unisex");
        retailPrice.getItems().addAll(5.00,10.00,15.00,20.00,25.00,30.00,35.00,40.00,45.00,50.00,55.00,60.00);
        name.getItems().addAll("Gold","Silver","Platinum","Diamond","Pearl");
        quantity.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
        quality.getItems().addAll(1,2,3,4,5);

        inlayColour.getItems().addAll("Green" ,"Blue","Red","Purple","Yellow","Pink","Black","White");
        width.getItems().addAll(5.0,10.0,15.0,20.0,25.0,30.0,35.0,40.0);
        depth.getItems().addAll(0.1,0.2,0.3,0.4,0.5,0.6,0.7,0.8,0.9,1.00);

        type1.getItems().addAll("Freestanding", "Wall mounted");
        lighting.getItems().addAll("Unlit", "Lit");

        pane3.setDisable(true);

        TreeItem<String> rootItem = new TreeItem<String>("Jewellery Store");
        TreeItem<String> case1 = new TreeItem<String>("Cases");

        tree.setRoot(rootItem);
        itemDescription.setDisable(true);
        type.setDisable(true);
        targetGender.setDisable(true);
        url.setDisable(true);
        retailPrice.setDisable(true);
        name.setDisable(true);
        description.setDisable(true);
        quality.setDisable(true);
        quantity.setDisable(true);
        addjewellery.setDisable(true);
        smartadd.setDisable(true);

        rootItem.getChildren().addAll(case1);


    }
}
