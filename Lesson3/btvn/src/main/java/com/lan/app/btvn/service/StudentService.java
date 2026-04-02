package com.lan.app.btvn.service;

import com.lan.app.btvn.dto.request.CreateStudentRequest;
import com.lan.app.btvn.dto.request.UpdateStudentRequest;
import com.lan.app.btvn.exception.DuplicateResourceException;
import com.lan.app.btvn.exception.ResourceNotFoundException;
import com.lan.app.btvn.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    Long studentId = 1L;

    private final List<Student> list = new ArrayList<>();

    public List<Student> getAllStudents() {
        return list;
    }

    public Student create(CreateStudentRequest request) {
        for (Student student : list) {
            if(request.getStudentCode().equals(student.getStudentCode())) {
                throw new DuplicateResourceException("User", "studentCode", request.getStudentCode());
            }
            if(request.getEmail().equals(student.getEmail())) {
                throw new DuplicateResourceException("Student", "email", request.getEmail());
            }
        }
        Student st = new Student();
        st.setId(this.studentId++);
        st.setStudentCode(request.getStudentCode());
        st.setName(request.getStudentName());
        st.setEmail(request.getEmail());
        st.setPhone(request.getPhone());
        st.setDateOfBirth(request.getDateOfBirth());
        st.setGpa(request.getGpa());
        st.setMajor(request.getMajor());
        st.setYear(request.getYear());
        list.add(st);
        return st;
    }

    public Student findById(Long id) {
        for (Student student : list) {
            if(student.getId().equals(id)) {
                return student;
            }
        }
        throw new ResourceNotFoundException("Student", "id", id);
    }

    public Student update(Long id, UpdateStudentRequest request) {
        Student st = findById(id);

        for (Student student : list) {
            if(request.getEmail().equals(student.getEmail())) {
                throw new DuplicateResourceException("Student", "email", request.getEmail());
            }
        }

        st.setName(request.getStudentName());
        st.setEmail(request.getEmail());
        st.setPhone(request.getPhone());
        st.setDateOfBirth(request.getDateOfBirth());
        st.setGpa(request.getGpa());
        st.setMajor(request.getMajor());
        st.setYear(request.getYear());
        return st;
    }

    public void delete(Long id) {
        Student st = findById(id);
        list.remove(st);
    }

    public List<Student> majorFilter(String major) {
        List<Student> majorList = new ArrayList<>();
        for (Student student : list) {
            if(student.getMajor().equalsIgnoreCase(major)){
                majorList.add(student);
            }
        }
        return majorList;
    }

    public List<Student> excellentGpa() {
        List<Student> excellentGpaList = new ArrayList<>();
        for (Student student : list) {
            if(student.getGpa() >= 3.6){
                excellentGpaList.add(student);
            }
        }
        return excellentGpaList;
    }
}
