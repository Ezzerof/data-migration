package com.dataMigration.userInterface;

import com.dataMigration.database.EmployeeDAO;
import com.dataMigration.employeePackage.EmployeeDTO;
import com.dataMigration.employeePackage.EmployeeService;
import com.dataMigration.employeePackage.ValidationsUtil;

import java.util.Scanner;

public class UserInterfacesStarter {

    public static void runInterface(EmployeeService employeeService) {

        Scanner scanner = new Scanner(System.in);
        EmployeeDAO employeeDAO = new EmployeeDAO();
        EmployeeDTO emp = null;
        int parsedId;
        boolean isOn = true;

        while (isOn) {
            System.out.println("1. Get employee by ID\n" +
                    "2. Remove employee by ID\n" +
                    "3. Get all employee from database\n" +
                    "4. Get all corrupted/duplicates employees\n" +
                    "5. Quit");

            System.out.print("\nEnter an option from above: ");
            String userChoice = scanner.next();
            int number = ValidationsUtil.isIntCorrupted(userChoice);

            if (number == 5) {
                return;
            } else if (number == 0) {
                System.out.println("Invalid input");
            } else {

                switch (number) {
                    case 1:
                        parsedId = EmployeeIdInterface.getEmployeeId();
                        if (parsedId == 0) {
                            emp = null;
                            break;
                        } else {
                            emp = employeeDAO.findById(parsedId);
                            if (emp == null)
                                break;
                            System.out.println("You have selected: " + emp.getEmpId() + " " + emp.getFirstName() + " " + emp.getLastName());
                        }
                        break;
                    case 2:
                        if (emp != null) {
                            System.out.println("Do you want to remove selected employee?(Y/N): ");
                            String input = scanner.next();

                            if (ValidationsUtil.isStringCorrupted(input)) {
                                System.out.println("Invalid input");
                            } else {
                                if (input.equalsIgnoreCase("y")) {
                                    employeeDAO.deleteById(emp.getEmpId());
                                    System.out.printf("Employee: %d %s %s was successfully deleted\n", emp.getEmpId(), emp.getFirstName(), emp.getLastName());
                                    emp = null;
                                    break;
                                } else if (input.equalsIgnoreCase("n")) {
                                    parsedId = EmployeeIdInterface.getEmployeeId();
                                    if (parsedId == 0) {
                                        break;
                                    } else {
                                        employeeDAO.deleteById(emp.getEmpId());
                                        System.out.println("Employee was successfully deleted\n");
                                        break;
                                    }
                                }
                            }
                        } else {
                            parsedId = EmployeeIdInterface.getEmployeeId();
                            if (parsedId == 0) {
                                break;
                            } else {
                                employeeDAO.deleteById(parsedId);
                                System.out.println("Employee successfully deleted");
                            }
                        }
                        break;
                    case 3:
                        if (employeeDAO.findAll().isEmpty())
                            System.out.println("Database is empty");
                        else {
                            for (EmployeeDTO employeeDTO : employeeDAO.findAll().values())
                                System.out.println(employeeDTO);
                        }
                        break;
                    case 4:
                        if (employeeService.getAllCorruptedEmployees().isEmpty())
                            System.out.println("The list is empty");
                        else {
                            System.out.println(employeeService.getAllCorruptedEmployees().values());
                            System.out.println();
                        }
                        break;
                    case 5:
                        isOn = false;
                        break;
                }

            }

        }
    }

}
