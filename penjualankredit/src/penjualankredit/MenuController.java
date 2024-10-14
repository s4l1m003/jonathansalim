/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package penjualankredit;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class MenuController implements Initializable {

    @FXML
    private TableColumn<?, ?> customerColumn;
    @FXML
    private TableColumn<?, ?> cicilanColumn;
    @FXML
    private TableColumn<?, ?> productColumn;
    @FXML
    private TableColumn<?, ?> penjualanColumn;
    @FXML
    private TableColumn<?, ?> detailpenjualanColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void handleCustomerColumnClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("tabelcustomer.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Tabel Customer");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void handleCicilanColumnClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("tabelcicilan.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Tabel Cicilan");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void handleProductColumnClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("tabelproduct.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Tabel Product");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void handlePenjualanColumnClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("tabelpenjualan.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Tabel Penjualan");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void handleDetailPenjualanColumnClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("tabeldetailpenjualan.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Tabel Detail Penjualan");
        stage.setScene(new Scene(root));
        stage.show();
    }
}