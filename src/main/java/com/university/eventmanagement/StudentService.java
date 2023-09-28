package com.university.eventmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudentDepartment(Long studentId, Department newDepartment) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student != null) {
            student.setDepartment(newDepartment);
            return studentRepository.save(student);
        }
        return null;
    }

    public boolean deleteStudent(Long studentId) {
        if (studentRepository.existsById(studentId)) {
            studentRepository.deleteById(studentId);
            return true;
        }
        return false;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }
}
