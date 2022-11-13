package com.example.jewellerystorev3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.List;
import java.util.Objects;

public class JewelleryItemController extends DisplayTrayController implements Serializable {
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

    public ListView<String> apt = new ListView<>();
    File saveFile = new File("jewelleryitems");
    public CheckBox orientcheck;
    JewelleryLinkedList jll = selectDisplayTray();

    private Stage stage;
    private Scene scene;

    public JewelleryItemController() throws IOException, ClassNotFoundException {
    }

    public void goBackJewellery(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("displaytrays.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void addJewelleryItem(ActionEvent actionEvent) {
        apt.getItems().add(itemDescription.getText() + " " + type.getValue() + "   " + targetGender.getValue() + "  " + url.getText() + "  " + retailPrice.getValue() + "  JewelleryItem  " + "\n" +
        name.getValue() + "  " + description.getText() + "  Quantity: " + quantity.getValue() + " Quality1-5: " + quality.getValue());
        jll.addFirst(new JewelleryNode(itemDescription.getText() , type.getValue() , targetGender.getValue() , url.getText() , retailPrice.getValue()));
        CustomLinkedList.Node<JewelleryNode> node = jll.getHead();
        node.val.setMaterial(new Material(name.getValue() , description.getText() , quantity.getValue() , quality.getValue()));
        jll.print();
    }

    public void deleteJewelleryItem(ActionEvent actionEvent) {
        if (apt.getSelectionModel().getSelectedIndex() >= 0) {
            apt.getItems().remove(apt.getSelectionModel().getSelectedIndex());
            jll.deleteAtIndex(apt.getSelectionModel().getSelectedIndex());
        }
    }

    public void saveFile(ActionEvent actionEvent) {
        try
        {
            saveFile.createNewFile();
            Files.write(saveFile.toPath(), apt.getItems().subList(0, apt.getItems().size()));
            saveFile.getAbsolutePath();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public void loadFile() {
        if(saveFile.exists())
        {
            try
            {
                List<String> linesLoadedFromFile = Files.readAllLines(saveFile.toPath());
                apt.getItems().addAll(linesLoadedFromFile);
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
    }

    public void changeOrientation(ActionEvent actionEvent) {
        apt.setOrientation(orientcheck.isSelected() ?
                Orientation.HORIZONTAL :
                Orientation.VERTICAL);
    }

    public void initialize() {
        type.getItems().addAll("Watch" , "Ring" , "Necklace");
        targetGender.getItems().addAll("Male" , "Female" , "Unisex");
        retailPrice.getItems().addAll(5.00,10.00,15.00,20.00,25.00,30.00,35.00,40.00,45.00,50.00,55.00,60.00);
        name.getItems().addAll("Gold","Silver","Platinum","Diamond","Pearl");
        quantity.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
        quality.getItems().addAll(1,2,3,4,5);
    }
}
