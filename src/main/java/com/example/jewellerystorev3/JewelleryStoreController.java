package com.example.jewellerystorev3;

import javafx.event.ActionEvent;
import javafx.geometry.Orientation;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.UUID;

public class JewelleryStoreController {
    public ChoiceBox<String> type;
    public ChoiceBox<String> lighting;
    public ListView<String> apt;
    public CheckBox orientcheck;


    private final DisplayCaseLinkedList jewelleryStore = new DisplayCaseLinkedList();


    public void addDisplayCase(ActionEvent actionEvent) {
        apt.getItems().add(type.getValue() + " and " + lighting.getValue() + " DisplayCase ");
//        jewelleryStore.addFirst(new DisplayCaseNode(type.getValue() , lighting.getValue()));
    }

    public void deleteDisplayCase(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.DELETE &&
                apt.getSelectionModel().getSelectedIndex() >= 0)
            apt.getItems().remove(apt.getSelectionModel()
                    .getSelectedIndex());
        jewelleryStore.deleteFirst();

    }

    public void changeOrientation(ActionEvent actionEvent) {
        apt.setOrientation(orientcheck.isSelected() ?
                Orientation.HORIZONTAL :
                Orientation.VERTICAL);
    }

    public void initialize() {
        type.getItems().addAll("Freestanding" , "Wall mounted");
        lighting.getItems().addAll("Unlit", "Lit");
    }
}
