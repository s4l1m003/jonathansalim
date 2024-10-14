/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package penjualankredit;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 */
public class TabelcustomerController implements Initializable {

    @FXML
    private Button btnkeluar;
    @FXML
    private Button btnsimpan;
    @FXML
    private Button btnbatal;
    @FXML
    private TextField txtnama;
    @FXML
    private TextField txtalamat;
    @FXML
    private TextField txttelepon;
    @FXML
    private TextField txttanggalbergabung;  
    @FXML
    private TextField txtcustomerid;

    
    private final String url = "jdbc:mysql://localhost:3306/your_database";
    private final String user = "root";
    private final String password = "password";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void handleSave() {
        try {
            int customerId = Integer.parseInt(txtcustomerid.getText());

            String nama = txtnama.getText();
            String alamat = txtalamat.getText();
            String telepon = txttelepon.getText();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate tanggalBergabung = LocalDate.parse(txttanggalbergabung.getText(), formatter);

            if (nama.isEmpty() || alamat.isEmpty() || telepon.isEmpty() || tanggalBergabung == null) {
                showAlert("Semua field harus diisi", Alert.AlertType.ERROR);
                return;
            }
            try (Connection connection = DriverManager.getConnection(url, user, password)) {
                String sql = "INSERT INTO customers (customer_id, nama, alamat, tanggal_bergabung, telepon) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, customerId);
                preparedStatement.setString(2, nama);
                preparedStatement.setString(3, alamat);
                preparedStatement.setDate(4, java.sql.Date.valueOf(tanggalBergabung));
                preparedStatement.setString(5, telepon);

                int rowsInserted = preparedStatement.executeUpdate();
                if (rowsInserted > 0) {
                    showAlert("Data berhasil disimpan!", Alert.AlertType.INFORMATION);
                    clearFields();
                }
            } catch (SQLException e) {
                showAlert("Error: " + e.getMessage(), Alert.AlertType.ERROR);
            }

        } catch (NumberFormatException e) {
            showAlert("Customer ID harus berupa angka!", Alert.AlertType.ERROR);
        }
    }

    private void handleCancel() {
        clearFields();
    }

    private void handleExit() {
        Stage stage = (Stage) btnkeluar.getScene().getWindow();
        stage.close();
    }

    private void clearFields() {
        txtcustomerid.clear();
        txtnama.clear();
        txtalamat.clear();
        txttelepon.clear();
        txttanggalbergabung.clear();
    }

    private void showAlert(String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType, message);
        alert.showAndWait();
    }
}
