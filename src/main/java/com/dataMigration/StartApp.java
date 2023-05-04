package com.dataMigration;

import com.dataMigration.database.EmployeeDAO;
import com.dataMigration.employeePackage.*;
import com.dataMigration.userInterface.UserInterfacesStarter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class StartApp {
    private static final Logger LOGGER = LogManager.getLogger(App.class);

    public static void start() {

        Scanner scanner = new Scanner(System.in);
        List<String> listOfEmps;
        EmployeeRepository employeeRepository = new EmploymentRepositoryImplementation();
        EmployeeService employeeService = new EmployeeService(employeeRepository);
        EmployeeDAO employeeDAO = new EmployeeDAO();

        while (true) {

            try {
                System.out.println("Welcome to MigrationApp\n");
                System.out.print("Please enter number of employee to migrate or Q to quit: ");
                String userInput = scanner.next();

                int numberOfEmployees = ValidationsUtil.isIntCorrupted(userInput);

                if (userInput.equalsIgnoreCase("q")) {
                    break;
                } else if (numberOfEmployees == 0 || numberOfEmployees > 10000) {
                    System.out.println("Invalid input\n");
                } else {
                    listOfEmps = EmployeeReader.getEmployees(numberOfEmployees);

                    // Adding Employees to Maps
                    for (String emp : listOfEmps) {
                        employeeService.addEmployee(emp);
                    }

                    System.out.println("Employees List\n" + employeeService.getAllEmployees().values());
                    System.out.println();
                    System.out.println("============================================================");
                    System.out.println("List of Corrupted Employees\n" + employeeService.getAllCorruptedEmployees().values());
                    System.out.println();

                    employeeDAO.dropTableIfExists();
                    employeeDAO.createTable();

                    System.out.println("Inserting employees to the Database ...");

                    // Adding employees to the MySQL
                    for (EmployeeDTO employeeDTO : employeeService.getAllEmployees().values()) {
                        employeeDAO.insert(employeeDTO);
                    }
                    System.out.println();

                    UserInterfacesStarter.runInterface(employeeService);


                }
            } catch (IOException e) {
                LOGGER.error(e);
            }

        }

    }

}
