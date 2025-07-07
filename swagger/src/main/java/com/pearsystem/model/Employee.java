package com.pearsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@ApiObject
public class Employee {
    @Id
    @GeneratedValue
    @ApiObjectField(name = "employee id",description = "Auto generated id")
    private int id;
    @ApiObjectField(name = "employee name",description = "name same as voterId")
    private String name;
    @ApiObjectField(name = "department",description = "dept section")
    private  String dept;
    @ApiObjectField(name = "salary",description = "annual income")
    private double salary;
}
