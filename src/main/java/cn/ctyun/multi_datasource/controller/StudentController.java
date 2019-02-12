package cn.ctyun.multi_datasource.controller;

import cn.ctyun.multi_datasource.entity.Student;
import cn.ctyun.multi_datasource.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/student/index")
    public List<Student> getStudentList(){
        return studentService.getStudentList();
    }

}
