package com.example.jewellerystorev3;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Files;
import java.util.List;
import java.util.Objects;

public class DisplayTrayController extends JewelleryStoreController implements Serializable {
    public ChoiceBox<String> inlayColour;
    public ChoiceBox<Double> width;
    public ChoiceBox<Double> depth;
    public ListView<String> apt = new ListView<>();
    File saveFile = new File("displaytrays");
    public CheckBox orientcheck;
    DisplayTrayLinkedList dtll = selectDisplayCase();

    private Stage stage;
    private Scene scene;

    public void switchToJewellery(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("jewelleryitems.fxml")));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goBackTrays(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("jewellerystorev2.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void addDisplayTray(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        if (apt.getItems().isEmpty()) {
           loadTrayFile();
        }
        apt.getItems().add(inlayColour.getValue() + "      " + width.getValue() + " x " + depth.getValue() + "cm" + "  DisplayTray  ");
        dtll.addFirst(new DisplayTrayNode(inlayColour.getValue() , width.getValue() , depth.getValue()));
        dtll.print();
//        jewelleryStore.addFirst(new DisplayCaseNode(type.getValue() , lighting.getValue()));
    }

    public void deleteDisplayTray(ActionEvent actionEvent) {
        if (apt.getSelectionModel().getSelectedIndex() >= 0) {
            apt.getItems().remove(apt.getSelectionModel().getSelectedIndex());
            dtll.deleteAtIndex(apt.getSelectionModel().getSelectedIndex());
        }
    }

    public JewelleryLinkedList selectDisplayTray() {
        JewelleryLinkedList jll = new JewelleryLinkedList();
        if (apt.getSelectionModel().getSelectedIndex() >= 0) {
            apt.getSelectionModel().getSelectedIndex();
            CustomLinkedList.Node<DisplayTrayNode> head = dtll.getNodeAtIndex(apt.getSelectionModel().getSelectedIndex());
            jll = head.val.getLinkedList();
        }
        return jll;
    }

    public void saveTrayFile(ActionEvent actionEvent) throws IOException {
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
        saveTray("dtll", dtll);
    }

    public void loadTrayFile() throws IOException, ClassNotFoundException {
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
        dtll = readTray("dtll");
    }

    public void saveTray(String path, DisplayTrayLinkedList list) throws FileNotFoundException, IOException {
        //1. Point to your file using File
        File file = new File(path);
        //2. Then use OOS but to serialize into a file you should use FileOutputStream inside the invocation
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        //3. Just write the object to a file using the method "writeObject"
        objectOutputStream.writeObject(list);
        //4. Close the streams
        objectOutputStream.close();
    }

    public DisplayTrayLinkedList readTray(String path) throws FileNotFoundException, IOException, ClassNotFoundException {
        DisplayTrayLinkedList infoList;
        //1. Point to your file (the one you want to read)
        File fileToRead = new File(path);
        //2. Use OIS to read the information from a file using FileInputStream
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileToRead));
        //3. Just read the object and cast to make sure you obtain the right object
        infoList = (DisplayTrayLinkedList) objectInputStream.readObject();
        //4. Close the stream
        objectInputStream.close();
        return infoList;
    }

    public void changeOrientation(ActionEvent actionEvent) {
        apt.setOrientation(orientcheck.isSelected() ?
                Orientation.HORIZONTAL :
                Orientation.VERTICAL);
    }

    public void initialize() {
        inlayColour.getItems().addAll("Green" ,"Blue","Red","Purple","Yellow","Pink","Black","White");
        width.getItems().addAll(5.0,10.0,15.0,20.0,25.0,30.0,35.0,40.0);
        depth.getItems().addAll(0.01,0.2,0.3,0.4,0.5,0.6,0.7,0.8,0.9,1.00);
    }
}
