package com.womq.demo_web.controller;

import com.womq.demo_web.StudentRequest;
import com.womq.demo_web.StudentResponse;
import com.womq.demo_web.StudentService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/students")
@Tag(name = "Student API", description = "Operations related to students")
public class StudentController {

    private final StudentService studentService;

    // Create a new student
    @PostMapping("/add")
    public ResponseEntity<StudentResponse> addStudent(@RequestBody StudentRequest studentRequest) {
        StudentResponse studentResponse = studentService.addStudent(studentRequest);
        return ResponseEntity.ok(studentResponse);
    }

    // Get all students
    @GetMapping("/get-all")
    public ResponseEntity<List<StudentResponse>> getAllStudents() {
        List<StudentResponse> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    // Update a student
    @PutMapping("/update/{id}")
    public ResponseEntity<StudentResponse> updateStudent(
            @PathVariable("id") Integer id,
            @RequestBody StudentRequest studentRequest) {
        StudentResponse updatedStudent = studentService.updateStudent(id, studentRequest);
        return ResponseEntity.ok(updatedStudent);
    }

    // Get a single student by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<StudentResponse> getStudentById(@PathVariable("id") Integer id) {
        StudentResponse studentResponse = studentService.getStudentById(id);
        return ResponseEntity.ok(studentResponse);
    }

    // Delete a student
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Deleted student");
    }
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        // You can get more details from the request here
        return "Error occurred: " + request.getAttribute(RequestDispatcher.ERROR_MESSAGE);
    }

}
