package com.dataMigration.validators;

public interface IntegerValidator {

    static int isIntCorrupted(String text) {
        String regex = ".*[a-zA-A!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*";
        if (!text.matches(regex)) {
            return Integer.parseInt(text);
        }

        return 0;
    }

}
