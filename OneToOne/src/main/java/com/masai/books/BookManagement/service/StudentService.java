package com.masai.books.BookManagement.service;

import com.masai.books.BookManagement.entity.Passport;
import com.masai.books.BookManagement.entity.Student;
//import com.masai.books.BookManagement.repository.BookRepository;
import com.masai.books.BookManagement.repository.PassportRepository;
import com.masai.books.BookManagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    PassportRepository passportRepository;



    public List<Student> getAllStudents(){
        List<Student> students = studentRepository.findAll();
        return students;
    }


    public Student allocatePassport(String studentId, Passport passport) {

        // Getting th student Obj
        Student student = studentRepository.findById(studentId).get();

        // Check wheather passport Exist
        String id = passport.getPassportId();
        Optional<Passport> passport1 = passportRepository.findById(id);

        if(passport1.isPresent()){
            student.setPassport(passport);
            studentRepository.save(student);
        }
        else{

            //Save Passport info to passport database
            passportRepository.save(passport);
            student.setPassport(passport);
            studentRepository.save(student);
        }

        return student;
    }

    public Student addStudent(Student student) {

        return studentRepository.save(student);
    }
}
