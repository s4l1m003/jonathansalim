package penjualankredit;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

/**
 * FXML Controller class
 */
public class TabelpenjualanController implements Initializable {

    @FXML
    private DatePicker txttanggalpenjualan;
    @FXML
    private ComboBox<String> txtstatuspembayaran; // ComboBox untuk status pembayaran
    @FXML
    private TextField txtsaleid;
    @FXML
    private TextField txtcustomerid;
    @FXML
    private Button btnsimpan;
    @FXML
    private Button btnkeluar;
    @FXML
    private Button btnbatal;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtstatuspembayaran.getItems().addAll("Belum Lunas", "Lunas");

        btnsimpan.setOnAction(event -> simpanData());

        btnkeluar.setOnAction(event -> keluarAplikasi());

        btnbatal.setOnAction(event -> resetForm());
    }

    private void simpanData() {
        String saleId = txtsaleid.getText();
        String customerId = txtcustomerid.getText();
        String tanggalPenjualan = txttanggalpenjualan.getValue() != null ? txttanggalpenjualan.getValue().toString() : "";
        String statusPembayaran = txtstatuspembayaran.getValue();

        if (saleId.isEmpty() || customerId.isEmpty() || tanggalPenjualan.isEmpty() || statusPembayaran == null) {
            showAlert("Form tidak lengkap", "Harap isi semua field");
        } else {
            System.out.println("Data Disimpan: ");
            System.out.println("Sales ID: " + saleId);
            System.out.println("Customer ID: " + customerId);
            System.out.println("Tanggal Penjualan: " + tanggalPenjualan);
            System.out.println("Status Pembayaran: " + statusPembayaran);

            showAlert("Berhasil", "Data berhasil disimpan!");
            resetForm();
        }
    }

    private void keluarAplikasi() {
        Stage stage = (Stage) btnkeluar.getScene().getWindow();
        stage.close();
    }

    private void resetForm() {
        txtsaleid.clear();
        txtcustomerid.clear();
        txttanggalpenjualan.setValue(null);
        txtstatuspembayaran.getSelectionModel().clearSelection();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
