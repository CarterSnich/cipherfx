import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Controller {

    String selection;
    String plaintext;
    String strKey;
    int intKey;
    String ciphertext;

    @FXML
    private ComboBox<String> cipher_selection;

    @FXML
    private TextField plaintext_input;

    @FXML
    private TextField key_input;

    @FXML
    private TextField ciphertext_input;

    @FXML
    private Button encrypt_btn;

    @FXML
    private Button dencrypt_btn;

    @FXML
    private Button reset_btn;

    @FXML
    public void initialize() {
        cipher_selection.setItems(FXCollections.observableArrayList(
                "Mono Alphabetic",
                "Polyalphabetic",
                "Vigenère"));

        encrypt_btn.setOnAction(event -> {
            selection = cipher_selection.getValue();

            try {
                switch (selection) {
                    case "Mono Alphabetic":
                        plaintext = plaintext_input.getText();
                        intKey = Integer.parseInt(key_input.getText());
                        ciphertext = Cipher.monoAlphaSubCipher(plaintext, intKey);
                        ciphertext_input.setText(ciphertext);
                        break;

                    case "Polyalphabetic":
                        plaintext = plaintext_input.getText();
                        intKey = Integer.parseInt(key_input.getText());
                        ciphertext = Cipher.polyAlphaSubCipher(plaintext, intKey);
                        ciphertext_input.setText(ciphertext);
                        break;

                    case "Vigenère":
                        plaintext = plaintext_input.getText();
                        strKey = key_input.getText();
                        ciphertext = Cipher.vigenereCipher(plaintext, strKey);
                        ciphertext_input.setText(ciphertext);
                        break;

                    default:
                        alert(AlertType.WARNING, "Unknown cipher", "Unknown cipher", "Unknown cipher");
                        break;
                }
            } catch (NullPointerException e) {
                alert(AlertType.WARNING,
                        "No cipher selected.",
                        "No cipher selected.",
                        "Please select a cipher method before encrypting/decrypting.");
            } catch (NumberFormatException e) {
                alert(AlertType.WARNING,
                        "Invalid input",
                        "Invalid input.",
                        "Please enter proper inputs on each field.");
            }
        });

        dencrypt_btn.setOnAction(event -> {
            selection = cipher_selection.getValue();

            try {
                switch (selection) {
                    case "Mono Alphabetic":
                        ciphertext = ciphertext_input.getText();
                        intKey = Integer.parseInt(key_input.getText());
                        plaintext = Cipher.monoAlphaSubDecipher(ciphertext, intKey);
                        plaintext_input.setText(plaintext);
                        break;

                    case "Polyalphabetic":
                        ciphertext = ciphertext_input.getText();
                        intKey = Integer.parseInt(key_input.getText());
                        plaintext = Cipher.polyAlphaSubDecipher(ciphertext, intKey);
                        plaintext_input.setText(plaintext);
                        break;

                    case "Vigenère":
                        ciphertext = ciphertext_input.getText();
                        strKey = key_input.getText();
                        plaintext = Cipher.vigenereDecipher(ciphertext, strKey);
                        plaintext_input.setText(plaintext);
                        break;

                    default:
                        alert(AlertType.WARNING, "Unknown cipher", "Unknown cipher", "Unknown cipher");
                        break;
                }
            } catch (NullPointerException e) {
                alert(AlertType.WARNING,
                        "No cipher selected.",
                        "No cipher selected.",
                        "Please select a cipher method before encrypting/decrypting.");
            } catch (NumberFormatException e) {
                alert(AlertType.WARNING,
                        "Invalid input",
                        "Invalid input.",
                        "Please enter proper inputs on each field.");
            }
        });

        reset_btn.setOnAction(event -> {
            cipher_selection.setValue(null);
            plaintext_input.setText("");
            key_input.setText("");
            ciphertext_input.setText("");
        });

    }

    public void alert(AlertType type, String title, String header, String context) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(context);
        alert.show();
    }

}
