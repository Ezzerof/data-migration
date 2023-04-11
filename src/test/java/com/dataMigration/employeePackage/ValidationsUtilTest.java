package com.dataMigration.employeePackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class ValidationsUtilTest {

    EmployeeDTO invalidEmp = new EmployeeDTO(19525, null, null, null, "Dan", Gender.MALE, "aa@gmail.c", LocalDate.now(), LocalDate.now(), 898596);
    EmployeeDTO validEmp = new EmployeeDTO(19525, "Mr.", "Dan", "M", "Flower", Gender.MALE, "aa@gmail.c", LocalDate.now(), LocalDate.now(), 898596);

    @Test
    @DisplayName("Testing isCorrupted method by adding an Employee with invalid details should get true")
    void testingIsInvalidMethodByAddingAnEmployeeWithInvalidDetailsShouldGetTrue() {

        Assertions.assertTrue(ValidationsUtil.isCorrupted(invalidEmp));
    }

    @Test
    @DisplayName("Testing isCorrupted method by adding a Employee with valid details should get false")
    void testingIsInvalidMethodByAddingAEmployeeWithValidDetailsShouldGetFalse() {
        Assertions.assertFalse(ValidationsUtil.isCorrupted(validEmp));
    }

    @Test
    @DisplayName("Testing isEmailValid method by adding a valid email address should get true")
    void testingIsEmailValidMethodByAddingAValidEmailAddressShouldGetTrue() {

        Assertions.assertTrue(ValidationsUtil.isEmailValid("hello@gmail.com"));
    }

    @Test
    @DisplayName("Testing isEmailValid method by adding an invalid email address should get false")
    void testingIsEmailValidMethodByAddingAnInvalidEmailAddressShouldGetFalse() {
        Assertions.assertFalse(ValidationsUtil.isEmailValid("hello.com"));
    }

    @Test
    @DisplayName("Testing isPrefixCorrupted method by adding a corrupt prefix should get true")
    void testingIsPrefixCorruptedMethodByAddingACorruptPrefixShouldGetTrue() {
        Assertions.assertTrue(ValidationsUtil.isPrefixCorrupted(null));
    }

}
