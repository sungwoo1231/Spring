package com.dw.jdbcapp.model;

import java.time.LocalDate;

public class Employee {
    private String employeeNumber;
    private String name;
    private String englishName;
    private String position;
    private String gender;
    private LocalDate birthday;
    private LocalDate dateOfEmployment;
    private String address;
    private String city;
    private String area;
    private String homePhoneNumber;
    private String supervisorDepartmentNumber;
    private String departmentNumber;

    public Employee(String employeeNumber, String name, String englishName, String position, String gender, LocalDate birthday,
                    LocalDate dateOfEmployment, String address, String city, String area, String homePhoneNumber,
                    String supervisorDepartmentNumber, String departmentNumber) {
        this.employeeNumber = employeeNumber;
        this.name = name;
        this.englishName = englishName;
        this.position = position;
        this.gender = gender;
        this.birthday = birthday;
        this.dateOfEmployment = dateOfEmployment;
        this.address = address;
        this.city = city;
        this.area = area;
        this.homePhoneNumber = homePhoneNumber;
        this.supervisorDepartmentNumber = supervisorDepartmentNumber;
        this.departmentNumber = departmentNumber;
    }

    public Employee() {
    }

    public String getEmployeeNumber()  {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }


    public void setDateOfEmployment(LocalDate dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getHomePhoneNumber() {
        return homePhoneNumber;
    }

    public void setHomePhoneNumber(String homePhoneNumber) {
        this.homePhoneNumber = homePhoneNumber;
    }

    public String getSupervisorDepartmentNumber() {
        return supervisorDepartmentNumber;
    }

    public void setSupervisorDepartmentNumber(String supervisorDepartmentNumber) {
        this.supervisorDepartmentNumber = supervisorDepartmentNumber;
    }

    public String getDepartmentNumber() {
        return departmentNumber;
    }

    public void setDepartmentNumber(String departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    @Override
    public String
    toString() {
        return "Employee{" +
                "employeeNumber='" + employeeNumber + '\'' +
                ", name='" + name + '\'' +
                ", englishName='" + englishName + '\'' +
                ", position='" + position + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", dateOfEmployment=" + dateOfEmployment +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", homePhoneNumber='" + homePhoneNumber + '\'' +
                ", supervisorDepartmentNumber='" + supervisorDepartmentNumber + '\'' +
                ", departmentNumber='" + departmentNumber + '\'' +
                '}';
    }
}
