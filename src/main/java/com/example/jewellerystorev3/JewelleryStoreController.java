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


public class JewelleryStoreController implements Serializable {
    public ChoiceBox<String> type;
    public ChoiceBox<String> lighting;
    public ListView<String> apt = new ListView<>();
    File saveFile = new File("displaycases");
    public CheckBox orientcheck;
    DisplayCaseLinkedList dcll = new DisplayCaseLinkedList();

    private Stage stage;
    private Scene scene;

    public void goBackCases(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("index.fxml")));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSecondScene(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("displaytrays.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void addDisplayCase(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        if (apt.getItems().isEmpty()) {
        }
        DisplayCaseNode node = new DisplayCaseNode(type.getValue(), lighting.getValue());
        dcll.addFirst(node);
        apt.getItems().add("DCN_" + dcll.size  + "  " + type.getValue() + "  and  " + lighting.getValue() + "  " + " DisplayCase  ");
        dcll.print();
//        jewelleryStore.addFirst(new DisplayCaseNode(type.getValue() , lighting.getValue()));
    }

    public void deleteDisplayCase(ActionEvent actionEvent) {
        if (apt.getSelectionModel().getSelectedIndex() >= 0) {
            apt.getItems().remove(apt.getSelectionModel().getSelectedIndex());
            dcll.deleteAtIndex(apt.getSelectionModel().getSelectedIndex());
        }
    }

    public DisplayTrayLinkedList selectDisplayCase() {
        DisplayTrayLinkedList dtll = new DisplayTrayLinkedList();
        if (apt.getSelectionModel().getSelectedIndex() >= 0) {
            apt.getSelectionModel().getSelectedIndex();
            CustomLinkedList.Node<DisplayCaseNode> head = dcll.getNodeAtIndex(apt.getSelectionModel().getSelectedIndex());
            dcll.print();
            dtll = head.val.getLinkedList();
        }
        return dtll;
    }

    public void saveFile(ActionEvent actionEvent) throws IOException {
        try {
            saveFile.createNewFile();
            Files.write(saveFile.toPath(), apt.getItems().subList(0, apt.getItems().size()));
            saveFile.getAbsolutePath();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        saveCase("dcll" + apt.getSelectionModel().getSelectedIndex(), dcll);
    }

    public void loadFile() throws IOException, ClassNotFoundException {
        if (saveFile.exists()) {
            try {
                List<String> linesLoadedFromFile = Files.readAllLines(saveFile.toPath());
                apt.getItems().addAll(linesLoadedFromFile);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        dcll = readCase("dcll"+ apt.getSelectionModel().getSelectedIndex());
    }

    public void saveCase(String path, DisplayCaseLinkedList list) throws FileNotFoundException, IOException {
        //1. Point to your file using File
        File file = new File(path);
        //2. Then use OOS but to serialize into a file you should use FileOutputStream inside the invocation
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        //3. Just write the object to a file using the method "writeObject"
        objectOutputStream.writeObject(list);
        //4. Close the streams
        objectOutputStream.close();
    }

    /**
     * This method will read the information of the stock in a file
     *
     * @param path Is the file from which you will read the info
     * @return
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    public DisplayCaseLinkedList readCase(String path) throws FileNotFoundException, IOException, ClassNotFoundException {
        DisplayCaseLinkedList infoList;
        //1. Point to your file (the one you want to read)
        File fileToRead = new File(path);
        //2. Use OIS to read the information from a file using FileInputStream
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileToRead));
        //3. Just read the object and cast to make sure you obtain the right object
        infoList = (DisplayCaseLinkedList) objectInputStream.readObject();
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
        type.getItems().addAll("Freestanding", "Wall mounted");
        lighting.getItems().addAll("Unlit", "Lit");
    }
}

