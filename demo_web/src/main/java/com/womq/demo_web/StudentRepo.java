package com.womq.demo_web;

import org.springframework.data.jpa.repository.JpaRepository;

import java.beans.JavaBean;
import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Integer> {
    List<Student> findByAge(int age);
}
