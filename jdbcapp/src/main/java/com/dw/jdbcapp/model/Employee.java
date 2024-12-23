package com.dw.jdbcapp.model;

import java.time.LocalDate;

public class Employee {
    private String employeeNum;
    private String name;
    private String englishName;
    private String position;
    private String gender;
    private LocalDate birthday;
    private LocalDate dateOfEmployment;
    private String address;
    private String city;
    private String area;
    private String homeNum;
    private String supervisorNum;
    private String departmentNum;

    public Employee() {
    }

    public Employee(String employeeNum, String name, String englishName, String position, String gender, LocalDate birthday, LocalDate dateOfEmployment, String address, String city, String area, String homeNum, String supervisorNum, String departmentNum) {
        this.employeeNum = employeeNum;
        this.name = name;
        this.englishName = englishName;
        this.position = position;
        this.gender = gender;
        this.birthday = birthday;
        this.dateOfEmployment = dateOfEmployment;
        this.address = address;
        this.city = city;
        this.area = area;
        this.homeNum = homeNum;
        this.supervisorNum = supervisorNum;
        this.departmentNum = departmentNum;
    }

    public String getEmployeeNum() {
        return employeeNum;
    }

    public void setEmployeeNum(String employeeNum) {
        this.employeeNum = employeeNum;
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

    public String getHomeNum() {
        return homeNum;
    }

    public void setHomeNum(String homeNum) {
        this.homeNum = homeNum;
    }

    public String getSupervisorNum() {
        return supervisorNum;
    }

    public void setSupervisorNum(String supervisorNum) {
        this.supervisorNum = supervisorNum;
    }

    public String getDepartmentNum() {
        return departmentNum;
    }

    public void setDepartmentNum(String departmentNum) {
        this.departmentNum = departmentNum;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeNum='" + employeeNum + '\'' +
                ", name='" + name + '\'' +
                ", englishName='" + englishName + '\'' +
                ", position='" + position + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", dateOfEmployment=" + dateOfEmployment +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", homeNum='" + homeNum + '\'' +
                ", supervisorNum='" + supervisorNum + '\'' +
                ", departmentNum='" + departmentNum + '\'' +
                '}';
    }
}