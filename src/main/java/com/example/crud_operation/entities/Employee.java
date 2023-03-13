package com.example.crud_operation.entities;

import jakarta.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String salary;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Employee(Integer id, String name, String salary, Address address) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }


    public Employee(Integer id, String name, String salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;

    }

    public Employee() {
    }
}
