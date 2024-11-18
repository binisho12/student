package com.womq.demo_web;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Setter
@Getter
@Entity
public class Student {
    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private int age;
    private String gender;

    public Student() {

    }

}
