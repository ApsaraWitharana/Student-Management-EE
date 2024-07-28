package lk.ijse.gdse68.aad.studentmanagement.bo;

import lk.ijse.gdse68.aad.studentmanagement.dao.StudentDAOImpl;
import lk.ijse.gdse68.aad.studentmanagement.dto.StudentDTO;

import java.sql.Connection;

public class StudentBOImpl implements StudentBO{
    @Override
    public  String saveStudent(StudentDTO student, Connection connection) throws Exception {
        var studentDAOImpl = new StudentDAOImpl();
        return studentDAOImpl.saveStudent(student,connection);

    }

    @Override
    public boolean deleteStudent(String id, Connection connection) throws Exception {
        var studentDAOImpl = new   StudentDAOImpl();
        return studentDAOImpl.deleteStudent(id,connection);
    }

    @Override
    public boolean updateStudent(String id, StudentDTO student, Connection connection) throws Exception {
        var studentDAOImpl = new   StudentDAOImpl();
        return studentDAOImpl.updateStudent(id,student,connection);
    }

    @Override
    public StudentDTO getStudent(String id, Connection connection) throws Exception {
        var studentDAOImpl = new   StudentDAOImpl();
        return studentDAOImpl.getStudent(id,connection);
    }
}
