package com.dataMigration.employeePackage;

import java.util.regex.Pattern;

public class ValidationsUtil {

    static boolean isEmailValid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    public static int isIntCorrupted(String text) {
        String regex = ".*[a-zA-Z!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*";
        int salary = 0;
        if (!text.matches(regex)) {
            salary = Integer.parseInt(text);
        } else
            return 0;
        if (salary <= 0)
            return 0;

        return 0;
    }

    public static boolean isStringCorrupted(String input) {
        if (input.equalsIgnoreCase("null"))
            return true;

        if (input == null || input.equalsIgnoreCase("FALSE"))
            return true;

        return input.matches(".*[0-9!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*");
    }

    static boolean isPrefixCorrupted(String prefix) {
        String regex = ".*[0-9!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,<>\\/?].*";
        if (prefix.equalsIgnoreCase("null"))
            return true;
        if (prefix == null || prefix.equalsIgnoreCase("false"))
            return true;
        return prefix.matches(regex);
    }

    static boolean isCorrupted(EmployeeDTO employee) {

        if (employee.getEmpId() == 0 || employee.getPrefixName() == null
                || employee.getFirstName() == null || employee.getMiddleName() == null
                || employee.getLastName() == null || employee.getGender() == null
                || employee.getEmailAddress() == null || employee.getSalary() == 0) {
            return true;
        }

        return false;
    }

}
