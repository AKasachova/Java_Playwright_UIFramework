package com.qa.framework.utils.dataGenerator;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomDataGenerator {
    private static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final Random random = new Random();

    public static String generateRandomString(int length) {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(LETTERS.length());
            text.append(LETTERS.charAt(index));
        }
        return text.toString();
    }

    public static String generatePassword(String email) {
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String cyrillic = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя";

        SecureRandom random = new SecureRandom();
        List<Character> password = new ArrayList<>();
        password.add(upperCase.charAt(random.nextInt(upperCase.length())));
        password.add(digits.charAt(random.nextInt(digits.length())));
        password.add(cyrillic.charAt(random.nextInt(cyrillic.length())));

         if (email != null && !email.isEmpty()) {
            String emailLetters = email.replaceAll("[^a-zA-Z]", "");
            if (!emailLetters.isEmpty()) {
                password.add(emailLetters.charAt(random.nextInt(emailLetters.length())));
            }
        }

        String allChars = upperCase + lowerCase + digits + cyrillic;
        while (password.size() < 10) {
            password.add(allChars.charAt(random.nextInt(allChars.length())));
        }
        Collections.shuffle(password);
        StringBuilder result = new StringBuilder();
        for (char c : password) {
            result.append(c);
        }
        return result.toString();
    }
}
