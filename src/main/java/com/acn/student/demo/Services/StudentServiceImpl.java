package com.acn.student.demo.Services;

import com.acn.student.demo.Models.Student;
import com.acn.student.demo.StudentRepository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Integer studID) throws Exception {
        Optional<Student> optionalStudent = studentRepository.findById(studID);
        if(optionalStudent.isEmpty())
            throw new Exception("Student with given ID not found");
        Student student = optionalStudent.get();
        return student;

    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students;
    }

    @Override
    public Student deleteStudentById(Integer studId) throws Exception {
        Optional<Student> optionalStudent = studentRepository.findById(studId);
        if(optionalStudent.isEmpty())
            throw new Exception("Student with given ID doesn't exists");
        Student student = optionalStudent.get();
        studentRepository.delete(student);
        return student;
    }
}
