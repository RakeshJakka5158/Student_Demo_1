package com.acn.student.demo.Models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Student extends BaseModel{
    private String name;
    private int age;
    private String mailID;
    private String contactNumber;

}
