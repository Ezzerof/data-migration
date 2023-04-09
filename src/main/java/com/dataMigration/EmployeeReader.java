package com.dataMigration;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class EmployeeReader {

    public static List<String> getEmployees(int numEmployees) throws IOException {
        if (numEmployees < 1 || numEmployees > 1000)
            throw new IllegalArgumentException("Argument Employees number must be between 1 and 1000");

        List<String> result = Files.lines(Paths.get("src/main/resources/EmployeeRecords.csv"))
                .skip(1) // skip the header line
                .collect(Collectors.toList()); // collect all lines into a list

        Collections.shuffle(result); // randomize the list

        return result.stream()
                .limit(numEmployees) // limit to the first numEmployees values
                .toList();
    }


}
