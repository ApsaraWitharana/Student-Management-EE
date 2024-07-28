package lk.ijse.gdse68.aad.studentmanagement.dao;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.gdse68.aad.studentmanagement.controller.Student;
import lk.ijse.gdse68.aad.studentmanagement.dto.StudentDTO;

import java.sql.Connection;
import java.sql.SQLException;

public final class StudentDAOImpl implements StudentDAO {
    public static String SAVE_STUDENT = "INSERT INTO student (id,name,email,city,level) VALUES(?,?,?,?,?)";
    public static String UPDATE_STUDENT = "UPDATE student SET name=?,email=?,city=?,level=? WHERE id= ?";
    public static String GET_STUDENT = "SELECT * FROM student WHERE id=?";

    @Override
    public String saveStudent(StudentDTO student, Connection connection) throws Exception {
        try {
            var ps = connection.prepareStatement(SAVE_STUDENT);
            ps.setString(1, student.getId());
            ps.setString(2, student.getName());
            ps.setString(3, student.getEmail());
            ps.setString(4, student.getCity());
            ps.setString(5, student.getLevel());

            if (ps.executeUpdate() != 0) {
                return "save succesfully!!";

            } else {
                return "save unsucessfully!";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }




    @Override
    public boolean deleteStudent(String id, Connection connection) throws Exception {
        return false;
    }

    @Override
    public boolean updateStudent(String id, StudentDTO student, Connection connection) throws Exception {
        try {

            var ps = connection.prepareStatement(UPDATE_STUDENT);
            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getCity());
            ps.setString(4, student.getLevel());
            ps.setString(5, id);
            if (ps.executeUpdate() != 0) {
                //0 t wada wadi ganak iffect wennwad kiyl
            }
        }catch (SQLException e){

        }
    }

    @Override
    public StudentDTO getStudent(String id, Connection connection) throws Exception {
        try {
            StudentDTO studentDTO = new StudentDTO();
            var ps = connection.prepareStatement(GET_STUDENT);
            ps.setString(1, id);
            var rst = ps.executeQuery();
            while (rst.next()){
                studentDTO.setId(rst.getString("id"));
                studentDTO.setName(rst.getString("name"));
                studentDTO.setEmail(rst.getString("email"));
                studentDTO.setCity(rst.getString("city"));
                studentDTO.setLevel(rst.getString("level"));
            }
            return studentDTO;
        }catch (Exception e){
            throw new SQLException(e.getMessage());
        }
    }
}