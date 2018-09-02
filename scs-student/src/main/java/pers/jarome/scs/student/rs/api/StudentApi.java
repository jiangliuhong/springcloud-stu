package pers.jarome.scs.student.rs.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.jarome.scs.core.model.Student;
import pers.jarome.scs.student.core.service.StudentService;

import java.util.UUID;

@RestController
public class StudentApi {

    @Autowired
    @Qualifier("studentService")
    private StudentService studentService;

    @GetMapping(value = "addStu")
    public Student addStu(@RequestParam(value = "name")String name, @RequestParam(value = "num")String num){
        Student student = new Student();
        student.setId(UUID.randomUUID().toString().replace("-",""));
        student.setName(name);
        student.setNum(num);
        studentService.addStudent(student);
        return student;
    }

}
