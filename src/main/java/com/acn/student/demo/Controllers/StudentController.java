package com.acn.student.demo.Controllers;

import com.acn.student.demo.Models.Student;
import com.acn.student.demo.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    // Create
    @RequestMapping(value = "stu/insertStu",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> insertStudent(@RequestBody Student student){
        Student stud = studentService.addStudent(student);
        return new ResponseEntity<String>("Student added successfully with name : "+stud.getName(), HttpStatus.CREATED);
    }

    // GetBy ID
    @RequestMapping(value = "stu/getById/{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> getStudentByID(@PathVariable("id") Integer studId){
        Student student = new Student();
        try {
            student = studentService.getStudentById(studId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<Student>(student,HttpStatus.FOUND);
    }

    // Get All students
    @RequestMapping(value = "stu/getAllStudents",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> studentList = new ArrayList<>();
        studentList = studentService.getAllStudents();
        return new ResponseEntity<List<Student>>(studentList,HttpStatus.FOUND);
    }

    // Delete By Id
    @RequestMapping(value = "stu/deleteByID/{id}",method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteStudentByID(@PathVariable("id") Integer studID){
        Student s = new Student();
        try {
            s = studentService.deleteStudentById(studID);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<String>("Student with name "+s.getName()+ " deleted successfully",HttpStatus.FOUND);
    }

}
