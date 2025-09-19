package com.util;

// Classe utilitaire pour validation et lecture
public class Utils {
    public static boolean isValidCode(String code) {
        return code.matches("CPT-\\d{5}");
    }

    public static float lireFloat(String s) {
        try {
            return Float.parseFloat(s);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
