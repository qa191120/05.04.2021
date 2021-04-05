package com.example;

import lombok.ToString;

// POJO
@ToString
public class Employee {
    public int Id;
    public String Name;
    public int Age;
    public String Address;
    public double Salary;

    public Employee() {
    }

    public Employee(int id, String name, int age, String address, double salary) {
        Id = id;
        Name = name;
        Age = age;
        Address = address;
        Salary = salary;
    }
}
