/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package penjualankredit;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class TabelprodukController implements Initializable {

    @FXML
    private TextField txtproductid;
    @FXML
    private TextField txtnamacustomer;
    @FXML
    private TextArea txtdeskripsi;
    @FXML
    private TextField txtstok;
    @FXML
    private Button btnsimpan;
    @FXML
    private Button btnkeluar;
    @FXML
    private Button btnbatal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
