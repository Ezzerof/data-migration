package com.dataMigration.validators;

public interface PrefixValidator {

    static boolean isPrefixCorrupted(String prefix) {
        String regex = ".*[0-9!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,<>\\/?].*";
        if (prefix == null || prefix.equalsIgnoreCase("false"))
            return true;
        return prefix.matches(regex);
    }

}
