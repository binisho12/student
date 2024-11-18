package com.womq.demo_web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class StudentMapper {
    private final StudentRepo studentRepo;
    public StudentResponse mapToResponse(Student student) {
        StudentResponse response = new StudentResponse();
        response.setId(student.getId());
        response.setName(student.getName());
        response.setAge(student.getAge());
        response.setGender(student.getGender());
        return response;
    }
    public Student mapToStudent(StudentRequest studentRequest) {
        Student student = new Student();
        student.setAge(studentRequest.getAge());
        student.setName(studentRequest.getName());
        student.setGender(studentRequest.getGender());
        return student;
    }

    public void updateStudent(Student student ,StudentRequest studentRequest) {
        student.setAge(studentRequest.getAge());
        student.setName(studentRequest.getName());
        student.setGender(studentRequest.getGender());



    }
}
