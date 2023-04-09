package com.dataMigration;

import com.dataMigration.employeePackage.EmployeeReader;
import com.dataMigration.employeePackage.EmployeeRepository;
import com.dataMigration.employeePackage.EmployeeService;
import com.dataMigration.employeePackage.EmploymentRepositoryImplementation;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class StartApp {

    public static void start() {
        Scanner scanner = new Scanner(System.in);
        List<String> listOfEmps;
        EmployeeRepository employeeRepository = new EmploymentRepositoryImplementation();
        EmployeeService employeeService = new EmployeeService(employeeRepository);

        while (true) {

            try {
                System.out.println("Welcome to MigrationApp\n");
                System.out.print("Please enter number of employee to migrate or -1 to quit: ");
                int userInput = scanner.nextInt();

                if (userInput == -1) {
                    break;
                }  else if (userInput == 0 || userInput < -1 || userInput > 10000) {
                    System.out.println("Invalid input\n");
                } else {

                    listOfEmps = EmployeeReader.getEmployees(userInput);

                    for (String emp : listOfEmps) {
                        employeeService.addEmployee(emp);
                    }

                    System.out.println("Employees List\n" + employeeService.getAllEmployees().values());
                    System.out.println("============================================================");
                    System.out.println("Corrupted Employees List\n" + employeeService.getAllCorruptedEmployees().values());
                    System.out.println();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }

}
