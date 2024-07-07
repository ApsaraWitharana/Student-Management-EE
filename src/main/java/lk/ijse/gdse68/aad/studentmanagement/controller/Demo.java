package lk.ijse.gdse68.aad.studentmanagement.controller;

import jakarta.json.Json;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.gdse68.aad.studentmanagement.dto.StudentDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/demo")
public class Demo  extends HttpServlet{

    @Override
    public void init() throws ServletException {
        var initparameter = getServletContext().getInitParameter("myparam");
        System.out.println(initparameter);
    }

    @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//            super.doPost(req, resp);
            Jsonb jsonb = JsonbBuilder.create();
         List<StudentDTO> studentList = jsonb.fromJson(req.getReader(),new ArrayList<StudentDTO>(){ //array list ekk pass wenne <> galawunam genaric wenawa .diaman sintag complie unat passe byte codeekt ynne ita passe ek mon type d kiyl dnne annonimas inner class ekk danwa<>() widiyt ehem dmmam <StudentDTO> galawenne nattam hoyagnn bari wenawa gnne mokkda kiyl etkot yt method coll krnn bari wenwa
         }.getClass().getGenericSuperclass());
         studentList.forEach(System.out::println);

//         input
//                 [
//                 {
//                         "id":"S003",
//                "name":"Dakuni",
//                "email":"dakuni@gmail.com",
//                "city":"Galle",
//                "level":"L03"
//
//},

//
//        {
//            "id":"S004",
//                "name":"Tachini",
//                "email":"tachini@gmail.com",
//                "city":"Matara",
//                "level":"L04"
//
//        }
 //       ]

//        out-Put
//StudentDTO(id=S003, name=Dakuni, email=dakuni@gmail.com, city=Galle, level=L03)
//StudentDTO(id=S004, name=Tachini, email=tachini@gmail.com, city=Matara, level=L04)
    }
}
