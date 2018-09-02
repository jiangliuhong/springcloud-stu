package pers.jarome.scs.student.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.jarome.scs.student.core.dao.StudentDao;
import pers.jarome.scs.student.core.model.Student;
import pers.jarome.scs.student.core.service.StudentService;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    @Transactional
    public void addStudent(Student student) {
        studentDao.insert(student);
    }
}
