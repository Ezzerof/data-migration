package com.dataMigration.employeePackage;

import java.time.LocalDate;

public class EmployeeDTO {

    private int empId;
    private String prefixName;
    private String firstName;
    private String middleName;
    private String lastName;
    private Gender gender;
    private String emailAddress;
    private LocalDate birthDate;
    private LocalDate joinDate;
    private int salary;

    public EmployeeDTO(int empId, String prefixName, String firstName, String middleName, String lastName, Gender gender, String emailAddress, LocalDate birthDate, LocalDate joinDate, int salary) {
        this.empId = empId;
        this.prefixName = prefixName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.gender = gender;
        this.emailAddress = emailAddress;
        this.birthDate = birthDate;
        this.joinDate = joinDate;
        this.salary = salary;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getPrefixName() {
        return prefixName;
    }

    public void setPrefixName(String prefixName) {
        this.prefixName = prefixName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "\nempId = " + empId +
                ", prefixName = '" + prefixName + '\'' +
                ", firstName = '" + firstName + '\'' +
                ", middleName = '" + middleName + '\'' +
                ", lastName = '" + lastName + '\'' +
                ", gender = " + gender +
                ", emailAddress = '" + emailAddress + '\'' +
                ", birthDate = " + birthDate +
                ", joinDate = " + joinDate +
                ", salary = " + salary;
    }
}
