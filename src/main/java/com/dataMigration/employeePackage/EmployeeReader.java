package com.dataMigration.employeePackage;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;


public class EmployeeReader {

    public static List<String> getEmployees(int numEmployees) throws IOException {
        if (numEmployees < 1 || numEmployees > 10000)
            throw new IllegalArgumentException("Argument Employees number must be between 1 and 10000");

        List<String> result = Files.lines(Paths.get("src/main/resources/EmployeeRecords.csv"))
                .skip(1) // skip the header line
                .collect(Collectors.toList()); // collect all lines into a list

        return result.stream()
                .limit(numEmployees) // limit to the first numEmployees values
                .toList();
    }


}
