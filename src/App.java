import java.util.EmptyStackException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public static void cli(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input;
        boolean exit = false;

        while (true) {

            System.out.println("Select cipher: ");
            System.out.println(" 1: Mono Alphabetic Substitution Cipher");
            System.out.println(" 2: Mono Alphabetic Substitution Decipher");
            System.out.println(" 3: Polyalphabetic Substitution Cipher");
            System.out.println(" 4: Polyalphabetic Substitution Decipher");
            System.out.println(" 5: Vigenere Cipher");
            System.out.println(" 6: Vigenere Decipher");
            System.out.println(" 0: Exit");
            System.out.print("\n >>> ");

            input = sc.nextLine();

            try {
                String plaintext;
                int keyInt;
                String keyStr;
                String ciphertext;

                switch (input) {

                    case "0":
                        exit = true;
                        break;

                    case "1":
                        // Mono Alphabetic Substitution Cipher

                        System.out.print("Enter plaintext: ");
                        plaintext = sc.nextLine();
                        System.out.print("Enter key (number): ");
                        keyInt = Integer.parseInt(sc.nextLine());

                        if (plaintext.length() == 0)
                            throw new EmptyStackException();

                        Cipher.monoAlphaSubCipher(plaintext, keyInt);

                        break;

                    case "2":
                        // Mono Alphabetic Substitution Decipher

                        System.out.print("Enter cipher text: ");
                        ciphertext = sc.nextLine();
                        System.out.print("Enter key (number): ");
                        keyInt = Integer.parseInt(sc.nextLine());

                        if (ciphertext.length() == 0)
                            throw new EmptyStackException();

                        Cipher.monoAlphaSubDecipher(ciphertext, keyInt);

                        break;

                    case "3":
                        // Polyalphabetic Substitution Cipher

                        System.out.print("Enter plaintext: ");
                        plaintext = sc.nextLine();
                        System.out.print("Enter key (number): ");
                        keyInt = Integer.parseInt(sc.nextLine());

                        if (plaintext.length() == 0)
                            throw new EmptyStackException();

                        Cipher.polyAlphaSubCipher(plaintext, keyInt);

                        break;

                    case "4":
                        // Polyalphabetic Substitution Decipher

                        System.out.print("Enter ciphertext: ");
                        ciphertext = sc.nextLine();
                        System.out.print("Enter key (number): ");
                        keyInt = Integer.parseInt(sc.nextLine());

                        if (ciphertext.length() == 0)
                            throw new EmptyStackException();

                        Cipher.polyAlphaSubDecipher(ciphertext, keyInt);

                        break;

                    case "5":
                        // Vigenere Cipher

                        System.out.print("Enter plaintext: ");
                        plaintext = sc.nextLine();
                        System.out.print("Enter key (number): ");
                        keyStr = sc.nextLine();

                        if (plaintext.length() == 0 || keyStr.length() == 0)
                            throw new EmptyStackException();

                        Cipher.vigenereCipher(plaintext, keyStr);

                        break;

                    case "6":
                        // Vigenere Decipher

                        System.out.print("Enter cipher text: ");
                        ciphertext = sc.nextLine();
                        System.out.print("Enter key (number): ");
                        keyStr = sc.nextLine();

                        if (ciphertext.length() == 0 || keyStr.length() == 0)
                            throw new EmptyStackException();

                        Cipher.vigenereDecipher(ciphertext, keyStr);

                        break;

                    default:
                        System.out.println("Invalid selection.");
                        break;
                }
            } catch (EmptyStackException e) {
                System.out.println("Plaintext or key string must not be empty.");
            } catch (NumberFormatException e) {
                System.out.println("Key must be an integer.");
            }

            System.out.print("Press ENTER to continue.");
            sc.nextLine();
            System.out.print("\033[H\033[2J");
            System.out.flush();

            if (exit)
                break;
        }

        sc.close();

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ui.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        scene.setRoot(root);

        primaryStage.setTitle("BinaryConverterFX");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.maxHeightProperty().bind(primaryStage.heightProperty());
        primaryStage.minHeightProperty().bind(primaryStage.heightProperty());
        primaryStage.minWidthProperty().bind(primaryStage.widthProperty());
        primaryStage.maxWidthProperty().bind(primaryStage.widthProperty());
    }

}
