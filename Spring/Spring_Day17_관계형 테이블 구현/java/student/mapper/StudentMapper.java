package student.mapper;

import java.util.List;

import student.vo.Grade;
import student.vo.Student;

public interface StudentMapper {
    List<Student> getAllStudents();
    List<Grade> getGradesByStudentId(int studentId);
}