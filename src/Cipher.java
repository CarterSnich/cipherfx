public class Cipher {

    final public static int asciiIndexA = 65;
    final public static int alphabetLength = 26;

    // TODO: Mono Alphabetic Substitution Cipher
    public static String monoAlphaSubCipher(String mPlaintext, int mKey) {
        String plaintext = mPlaintext.toUpperCase();
        int key = mKey;
        String ciphertext = "";

        for (int i = 0; i < plaintext.length(); i++) {
            int p = charToIndex(plaintext.charAt(i));
            int index = p + key;

            while (index >= alphabetLength)
                index -= alphabetLength;

            Character c = indexToChar(index);
            ciphertext += c.toString();
        }

        System.out.println("========== Mono Alphabetic Substitution Cipher ==========");
        System.out.println("Plaintext   : " + mPlaintext);
        System.out.println("Key         : " + mKey);
        System.out.println("Cipher text : " + ciphertext + "\n");

        return ciphertext;
    }

    // TODO: Mono Alphabetic Substitution Decipher
    public static String monoAlphaSubDecipher(String mCiphertext, int mKey) {

        String ciphertext = mCiphertext.toUpperCase();
        int key = mKey;
        String plaintext = "";

        for (int i = 0; i < ciphertext.length(); i++) {
            int p = charToIndex(ciphertext.charAt(i));
            int index = p - key;

            while (index < 0)
                index += alphabetLength;

            Character c = indexToChar(index);
            plaintext += c.toString();
        }

        System.out.println("========== Mono Alphabetic Substitution Decipher ==========");
        System.out.println("Cipher text : " + mCiphertext);
        System.out.println("Key         : " + mKey);
        System.out.println("Plaintext   : " + plaintext + "\n");

        return plaintext;
    }

    // TODO: Polyalphabetic Substitution Cipher
    public static String polyAlphaSubCipher(String mPlaintext, int mKey) {

        String plaintext = mPlaintext.toUpperCase();
        int key = mKey;
        String ciphertext = "";

        int last = key;
        for (int i = 0; i < plaintext.length(); i++) {
            int current = charToIndex(plaintext.charAt(i));
            int index = current + last;

            while (index >= 26)
                index -= alphabetLength;

            last = current;

            Character c = indexToChar(index);
            ciphertext += c.toString();

        }

        System.out.println("========== Polyalphabetic Substitution Cipher ==========");
        System.out.println("Plaintext   : " + mPlaintext);
        System.out.println("Key         : " + mKey);
        System.out.println("Cipher text : " + ciphertext + "\n");

        return ciphertext;
    }

    // TODO: Polyalphabetic Substitution Decipher
    public static String polyAlphaSubDecipher(String mCiphertext, int mKey) {

        String ciphertext = mCiphertext.toUpperCase();
        int key = mKey;
        String plaintext = "";
        int last = key;

        for (int i = 0; i < ciphertext.length(); i++) {
            int current = ciphertext.charAt(i) - 65;
            int index = current - last;

            while (index < 0)
                index += alphabetLength;

            last = index;

            Character c = indexToChar(index);
            plaintext += c.toString();

        }

        System.out.println("========== Polyalphabetic Substitution Decipher ==========");
        System.out.println("Cipher text : " + mCiphertext.toUpperCase());
        System.out.println("Key         : " + mKey);
        System.out.println("Plaintext   : " + plaintext + "\n");

        return plaintext;
    }

    // TODO: Vigenere Cipher
    public static String vigenereCipher(String mPlaintext, String mKey) {

        String plaintext = mPlaintext.toUpperCase();
        String key = mKey.toUpperCase();
        String ciphertext = "";

        while (key.length() < plaintext.length()) {
            key += key;
        }
        key = key.substring(0, plaintext.length());

        for (int i = 0; i < plaintext.length(); i++) {
            int p = charToIndex(plaintext.charAt(i));
            int k = charToIndex(key.charAt(i));
            int index = p + k;
            Character c = indexToChar(index >= alphabetLength ? index - alphabetLength : index);
            ciphertext += c.toString();
        }

        System.out.println("========== Vigenere Cipher ==========");
        System.out.println("Plaintext   : " + mPlaintext);
        System.out.println("Key         : " + mKey);
        System.out.println("Cipher text : " + ciphertext + "\n");

        return ciphertext;
    }

    // TODO: Vigenere Decipher
    public static String vigenereDecipher(String mCiphertext, String mKey) {

        String ciphertext = mCiphertext.toUpperCase();
        String key = mKey.toUpperCase();
        String plaintext = "";

        while (key.length() < ciphertext.length()) {
            key += key;
        }
        key = key.substring(0, ciphertext.length());

        for (int i = 0; i < ciphertext.length(); i++) {
            int p = charToIndex(ciphertext.charAt(i));
            int k = charToIndex(key.charAt(i));
            int index = p - k;
            Character c = indexToChar(index < 0 ? index + 26 : index);
            plaintext += c.toString();
        }

        System.out.println("========== Vigenere Cipher ==========");
        System.out.println("Cipher text : " + mCiphertext.toUpperCase());
        System.out.println("Key         : " + mKey.toUpperCase());
        System.out.println("Plaintext   : " + plaintext + "\n");

        return plaintext;
    }

    public static int charToIndex(char ch) {
        return ch - asciiIndexA;
    }

    public static char indexToChar(int index) {
        return (char) (index + asciiIndexA);
    }
}
