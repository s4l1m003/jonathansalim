package penjualankredit;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TabeldetailpenjualanController implements Initializable {

    @FXML
    private Button btnbatal;
    @FXML
    private Button btnkeluar;
    @FXML
    private Button btnsimpan;
    @FXML
    private TextField txtsalesdetailid;
    @FXML
    private TextField txtsalesid;
    @FXML
    private TextField txtproductid;
    @FXML
    private TextField txtjumlah;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnsimpan.setOnAction(event -> simpanData());
        btnkeluar.setOnAction(event -> keluarAplikasi());
        btnbatal.setOnAction(event -> resetForm());
    }

    private void simpanData() {
        String salesDetailId = txtsalesdetailid.getText();
        String salesId = txtsalesid.getText();
        String productId = txtproductid.getText();
        String jumlah = txtjumlah.getText();

        if (salesDetailId.isEmpty() || salesId.isEmpty() || productId.isEmpty() || jumlah.isEmpty()) {
            showAlert("Form tidak lengkap", "Harap isi semua field!");
        } else {
            try {
                int salesDetailIdValue = Integer.parseInt(salesDetailId);
                int salesIdValue = Integer.parseInt(salesId);
                int productIdValue = Integer.parseInt(productId);
                int jumlahValue = Integer.parseInt(jumlah);

                System.out.println("Data Detail Penjualan Disimpan:");
                System.out.println("Sales Detail ID: " + salesDetailIdValue);
                System.out.println("Sales ID: " + salesIdValue);
                System.out.println("Product ID: " + productIdValue);
                System.out.println("Jumlah: " + jumlahValue);

                showAlert("Berhasil", "Data detail penjualan berhasil disimpan!");
                resetForm();
            } catch (NumberFormatException e) {
                showAlert("Error", "Semua field harus diisi dengan angka.");
            }
        }
    }

    private void keluarAplikasi() {
        Stage stage = (Stage) btnkeluar.getScene().getWindow();
        stage.close();
    }

    private void resetForm() {
        txtsalesdetailid.clear();
        txtsalesid.clear();
        txtproductid.clear();
        txtjumlah.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
