package com.dataMigration.employeePackage;

public enum Gender {

    MALE('M'),
    FEMALE('F');

    private char value;

    Gender(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public static Gender valueOf(char value) {
        for (Gender gender: values()) {
            if (gender.getValue() == value) {
                return gender;
            }
        }
        return null;
    }
}
