package com.womq.demo_web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepo studentRepo;
    private final StudentMapper studentMapper;

    // Create a new student
    public StudentResponse addStudent(StudentRequest studentRequest) {
        Student student = studentMapper.mapToStudent(studentRequest); // Map request to entity
        Student savedStudent = studentRepo.save(student);            // Save to repository
        return studentMapper.mapToResponse(savedStudent);            // Map entity to response
    }

    // Get all students
    public List<StudentResponse> getAllStudents() {
        List<Student> students = studentRepo.findAll();
        return students.stream()
                .map(studentMapper::mapToResponse) // Use mapper to convert each student to a response
                .collect(Collectors.toList());
    }

    // Update a student
    public StudentResponse updateStudent(Integer id, StudentRequest studentRequest) {
        Student student = studentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student with ID " + id + " not found"));

        studentMapper.updateStudent(student, studentRequest); // Update student using mapper
        Student updatedStudent = studentRepo.save(student);  // Save updated student
        return studentMapper.mapToResponse(updatedStudent);  // Map entity to response
    }

    // Get a single student by ID
    public StudentResponse getStudentById(Integer id) {
        Student student = studentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student with ID " + id + " not found"));
        return studentMapper.mapToResponse(student); // Use mapper to convert entity to response
    }

    // Delete a student
    public void deleteStudent(Integer id) {
        studentRepo.findById(id).orElseThrow(() ->
                new StudentNotFoundException("Student with ID " + id + " not found")
        );
        studentRepo.deleteById(id);
    }

}
