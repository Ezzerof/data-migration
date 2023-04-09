package com.dataMigration.validators;

public interface NameValidator {

    static boolean isStringCorrupted(String input) {
        if (input == null || input.equalsIgnoreCase("FALSE"))
            return true;

        return input.matches(".*[0-9!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*");
    }

}
