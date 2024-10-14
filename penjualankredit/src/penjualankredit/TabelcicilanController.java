package penjualankredit;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TabelcicilanController implements Initializable {

    @FXML
    private TextField txtinstallmentid;
    @FXML
    private TextField txtsalesid;
    @FXML
    private Slider txtjumlahcicilan;
    @FXML
    private ChoiceBox<String> txtmetodepembayaran;
    @FXML
    private Button btnsimpan;
    @FXML
    private Button btnbatal;
    @FXML
    private Button btnkeluar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtmetodepembayaran.getItems().addAll("Transfer Bank", "Kartu Kredit", "Tunai");
        txtjumlahcicilan.setMin(0);
        txtjumlahcicilan.setMax(100000000);
        txtjumlahcicilan.setShowTickMarks(true);
        txtjumlahcicilan.setShowTickLabels(true);
        txtjumlahcicilan.setMajorTickUnit(25000000);
        txtjumlahcicilan.setMinorTickCount(5);
        txtjumlahcicilan.setBlockIncrement(1000000);
        btnsimpan.setOnAction(event -> simpanData());
        btnkeluar.setOnAction(event -> keluarAplikasi());
        btnbatal.setOnAction(event -> resetForm());
    }

    private void simpanData() {
        String installmentId = txtinstallmentid.getText();
        String salesId = txtsalesid.getText();
        double jumlahCicilan = txtjumlahcicilan.getValue();
        String metodePembayaran = txtmetodepembayaran.getValue();

        if (installmentId.isEmpty() || salesId.isEmpty() || metodePembayaran == null) {
            showAlert("Form tidak lengkap", "Harap isi semua field!");
        } else {
            try {
                int salesIdValue = Integer.parseInt(salesId);
                System.out.println("Data Cicilan Disimpan: ");
                System.out.println("Installment ID: " + installmentId);
                System.out.println("Sales ID: " + salesIdValue);
                System.out.println("Jumlah Cicilan: " + String.format("%.2f", jumlahCicilan));
                System.out.println("Metode Pembayaran: " + metodePembayaran);

                showAlert("Berhasil", "Data cicilan berhasil disimpan!");
                resetForm();
            } catch (NumberFormatException e) {
                showAlert("Error", "Sales ID harus berupa angka.");
            }
        }
    }

    private void keluarAplikasi() {
        Stage stage = (Stage) btnkeluar.getScene().getWindow();
        stage.close();
    }

    private void resetForm() {
        txtinstallmentid.clear();
        txtsalesid.clear();
        txtjumlahcicilan.setValue(0);
        txtmetodepembayaran.getSelectionModel().clearSelection();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
