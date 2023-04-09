package com.dataMigration.employeePackage;

import com.dataMigration.App;
import com.dataMigration.validators.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public interface EmployeeConverter{
    Logger LOGGER = LogManager.getLogger(App.class);
    /*
        Uses data from the CSV service to create an employee object and return it to caller

     */
    static EmployeeDTO createEmployeeFromData(String employeeData) {
        EmployeeDTO employee = null;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
            String[] dataList = employeeData.split(",");
            int empNo = IntegerValidator.isIntCorrupted(dataList[0]);
            String prefixName = (PrefixValidator.isPrefixCorrupted(dataList[1])) ? null : dataList[1];
            String firstName = NameValidator.isStringCorrupted(dataList[2]) ? null : dataList[2];
            String middleName = NameValidator.isStringCorrupted(dataList[3]) ? null : dataList[3];
            String lastName = NameValidator.isStringCorrupted(dataList[4]) ? null : dataList[4];
            Gender gender = Gender.valueOf(dataList[5].charAt(0));
            String emailAddress = dataList[6];
            LocalDate birthDate = LocalDate.parse(dataList[7], formatter);
            LocalDate joinDate = LocalDate.parse(dataList[8], formatter);
            int salary = IntegerValidator.isIntCorrupted(dataList[9]);

            // Identifying duplicates Object by KEYs and Corrupted data
            employee = new EmployeeDTO(empNo, prefixName, firstName, middleName, lastName, gender, emailAddress, birthDate, joinDate, salary);


        }catch (NullPointerException e){
            LOGGER.error(e.getMessage(), e);
        }

        return employee;
    }
}
