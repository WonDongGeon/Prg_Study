package student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import student.mapper.StudentMapper;
import student.vo.Grade;
import student.vo.Student;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public StudentService() {
	System.out.println("서비스 생성자 확인!!");
	}
    public List<Student> getStudentsWithGrades() {
        List<Student> students = studentMapper.getAllStudents();
        for (Student student : students) {
            List<Grade> grades = studentMapper.getGradesByStudentId(student.getStudentId());
            student.setGrades(grades);
        }
        return students;
    }
}