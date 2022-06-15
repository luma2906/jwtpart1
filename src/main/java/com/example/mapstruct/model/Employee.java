package com.example.mapstruct.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("employee")
public class Employee {
    @Id
    private String id;
    private String name;
    private String position;
    private Integer years;
    private Integer salary;

    public Employee() {
    }

    public Employee(String id, String name, String position, Integer years, Integer salary) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.years = years;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
