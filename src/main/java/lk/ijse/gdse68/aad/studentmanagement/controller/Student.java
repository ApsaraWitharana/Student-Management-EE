package lk.ijse.gdse68.aad.studentmanagement.controller;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(urlPatterns = "/student")
public class Student extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
//        todo:Get student

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
//        todo:Save student

//       var id= req.getParameter("id");
//        var name= req.getParameter("name");
//        var email= req.getParameter("email");
//        var level= req.getParameter("level");
//        System.out.println(id);
//        System.out.println(name);
//        System.out.println(email);
//        System.out.println(level);

        //JSON
        //1.get the header to content type header check null d nattam chek krnwa ! nattam kiyl blnwa kohomad wenne kiyl
        //if true unam hadpu client ge kiyl ne ewnnw mokkd kiyl

        if (req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }

        BufferedReader reader = req.getReader(); //reade req
        StringBuilder sb = new StringBuilder(); // sting bilder eken puluwn string eke swabaway krnn puluwan apit ona widiyt bild krnn append krnn glawann
        reader.lines().forEach(line -> sb.append(line).append("\n")); //
        System.out.println(sb);
        //client req ekk dunnam balnna ona resp ek it passe port ekk ewanawa //2,4,5
        //successfull unot -200 ok //201-create //204 -update/delete
        //client erro resp = clientget mokkhri waraddk unam --//400-490 // 400-bad req //401 Unauthorized//404 Not Found
        //server erro resp = server eke awlk unam enne // 500--//502-bad geteway

//        out -put
//        {
//            "id":"S001",
//                "name":"Sachini",
//                "email":"sachini@gmail.com",
//                "city":"Matara",
//                "level":"L01"
//
//        }

    }


    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
//        todo:Update student

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doDelete(req, resp);
//        todo:Delete student
    }
}