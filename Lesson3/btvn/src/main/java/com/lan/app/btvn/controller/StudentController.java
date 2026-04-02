package com.lan.app.btvn.controller;

import com.lan.app.btvn.dto.request.CreateStudentRequest;
import com.lan.app.btvn.dto.request.UpdateStudentRequest;
import com.lan.app.btvn.dto.response.ApiResponse;
import com.lan.app.btvn.model.Student;
import com.lan.app.btvn.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService = new StudentService();


    @GetMapping("/api/students")
    public ResponseEntity<ApiResponse<List<Student>>> getAllStudents() {
        return ResponseEntity.ok(ApiResponse.success(studentService.getAllStudents()));
    }

    @GetMapping("/api/students/{id}")
    public ResponseEntity<ApiResponse<Student>> getStudent(@Valid @PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success(studentService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Student>> createStudent(@Valid @RequestBody CreateStudentRequest request) {
        Student st = studentService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(st));
    }

    @PutMapping("/api/students/{id}")
    public ResponseEntity<ApiResponse<Student>> updateStudent(@PathVariable Long id,@Valid @RequestBody UpdateStudentRequest request) {
        Student updatedStudent = studentService.update(id, request);
        return ResponseEntity.ok(ApiResponse.success(updatedStudent));
    }

    @DeleteMapping("/api/students/{id}")
    public ResponseEntity<ApiResponse<String>> deleteStudent(@PathVariable Long id) {
        studentService.delete(id);
        return ResponseEntity.ok(ApiResponse.success("Xoa thanh cong"));
    }

    @GetMapping("/api/students/major/{major}")
    public ResponseEntity<ApiResponse<List<Student>>> getStudentsByMajor(@PathVariable String major) {
        return ResponseEntity.ok(ApiResponse.success(studentService.majorFilter(major)));
    }

    @GetMapping("/api/students/honors")
    public ResponseEntity<ApiResponse<List<Student>>> getStudentsByHonor() {
        return ResponseEntity.ok(ApiResponse.success(studentService.excellentGpa()));
    }


}
