package lk.ijse.gdse68.aad.studentmanagement.dao;

import lk.ijse.gdse68.aad.studentmanagement.controller.Student;
import lk.ijse.gdse68.aad.studentmanagement.dto.StudentDTO;

import java.sql.Connection;

public sealed interface StudentDAO permits StudentDAOImpl {

//    sealed kral  permits - inherite krnn denne StudentDAOImpl witharayi
// sealed class inheriten controll awashya ayat witharayi inherite wenne 17 update ekk
    String saveStudent(StudentDTO student, Connection connection)throws Exception;
    boolean deleteStudent(String id,Connection connection)throws Exception;
    boolean updateStudent(String id,StudentDTO student,Connection connection)throws Exception;
    StudentDTO getStudent(String id,Connection connection)throws Exception;
}
