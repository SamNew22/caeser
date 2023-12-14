package caesar;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Что хотите сделать? Зашифровать или Расшифровать?");
        String operation = scanner.nextLine();

        if (operation.equalsIgnoreCase("зашифровать")) {
            System.out.println("Введите текст: ");
            String text = scanner.nextLine();
            System.out.println("Введите сдвиг: ");
            int shift = scanner.nextInt();

            String encryptedText = encrypt(text, shift);
            System.out.println("Зашифрованный текст: " + encryptedText);
        } else if (operation.equalsIgnoreCase("расшифровать")) {
            System.out.println("Введите текст: ");
            String text = scanner.nextLine();
            System.out.println("У вас есть ключ? Д/Н");
            String hasKey = scanner.next();

            if (hasKey.equalsIgnoreCase("Д")) {
                System.out.println("Введите сдвиг: ");
                int shift = scanner.nextInt();

                String decryptedText = decrypt(text, shift);
                System.out.println("Расшифрованный текст: " + decryptedText);
            } else if (hasKey.equalsIgnoreCase("Н")) {
                for (int i = 1; i <= 30; i++) {
                    String decryptedText = decrypt(text, i);
                    System.out.println("Вариант " + i + ": " + decryptedText);
                }
            }
        }
    }

    public static String encrypt(String text, int shift) {
        StringBuilder encryptedText = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                encryptedText.append((char) ('А' + (ch - 'А' + shift) % 32));
            } else if (Character.isLowerCase(ch)) {
                encryptedText.append((char) ('а' + (ch - 'а' + shift) % 32));
            } else {
                encryptedText.append(ch);
            }
        }
        return encryptedText.toString();
    }

    public static String decrypt(String text, int shift) {
        StringBuilder decryptedText = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                decryptedText.append((char) ('А' + (ch - 'А' - shift + 32) % 32));
            } else if (Character.isLowerCase(ch)) {
                decryptedText.append((char) ('а' + (ch - 'а' - shift + 32) % 32));
            } else {
                decryptedText.append(ch);
            }
        }
        return decryptedText.toString();
    }
}
