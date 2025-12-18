package com.shift;

public final class TypeClassifier {

    private TypeClassifier() {
    }

    public static boolean isInteger(String s) {
        try {
            Long.parseLong(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isFloat(String s) {
        if (isInteger(s)) {
            return false;
        }
        try {
            Double.parseDouble(s);
            return true; // получилось распарсить как double → float
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
