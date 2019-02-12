package cn.ctyun.multi_datasource.service;

import cn.ctyun.multi_datasource.dao.StudentMapper;
import cn.ctyun.multi_datasource.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public List<Student> getStudentList(){
        return studentMapper.selectByExample(null);
    }
}
