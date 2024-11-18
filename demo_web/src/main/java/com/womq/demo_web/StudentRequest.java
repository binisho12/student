package com.womq.demo_web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    private String name;
    private int age;
    private String gender;

}
