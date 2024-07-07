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
import lk.ijse.gdse68.aad.studentmanagement.util.Util;
import org.eclipse.yasson.internal.JsonBinding;

import java.io.IOException;

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

//     01  var id= req.getParameter("id");
//        var name= req.getParameter("name");
//        var email= req.getParameter("email");
//        var level= req.getParameter("level");
//        System.out.println(id);
//        System.out.println(name);
//        System.out.println(email);
//        System.out.println(level);

        //02.JSON
        //1.get the header to content type header check null d nattam chek krnwa ! nattam kiyl blnwa kohomad wenne kiyl
        //if true unam hadpu client ge kiyl ne ewnnw mokkd kiyl
       //client gent en data eke validate ek
        if (req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }

       // 08. object binding of the json

        Jsonb jsonb = JsonbBuilder.create();
        var writer = resp.getWriter();
        StudentDTO student = jsonb.fromJson(req.getReader(), StudentDTO.class); //eliyen en json student json t dagannwa fromjson gent pata 2 -reder and bined krn ob eke class type ek return krnne supplie krn class eke type ekk
        student.setId(Util.IdGenerate());
        writer.write(jsonb.toJson(student.toString()));

        //create response
        resp.setContentType("application/json");
        jsonb.toJson(student,resp.getWriter());

//        input-postman
//        {
//
//            "name":"Sachini",
//                "email":"sachini@gmail.com",
//                "city":"Matara",
//                "level":"L02"
//
//        }
//           out-Put
//        "StudentDTO(id=4ac43041-6279-4399-9279-918522fc806c, name=Sachini, email=sachini@gmail.com, city=Matara, level=L02)"{
//            "city": "Matara",
//                    "email": "sachini@gmail.com",
//                    "id": "4ac43041-6279-4399-9279-918522fc806c",
//                    "level": "L02",
//                    "name": "Sachini"
//        }



//    03.    BufferedReader reader = req.getReader(); //reade req
//        StringBuilder sb = new StringBuilder(); // sting bilder eken puluwn string eke swabaway krnn puluwan apit ona widiyt bild krnn append krnn glawann
//        reader.lines().forEach(line -> sb.append(line).append("\n")); //append krnwa new line ekt ynn kiyl
//        System.out.println(sb);
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


//        process-json
//entri point eken json reader ekk hadagen ek arrayd mokkd kiyl bll manipulation ek krnne
//        JsonReader reader =  Json.createReader(req.getReader());
//   04.     JsonObject jsonObject = reader.readObject();// json ob ekk hadgnnwa jawa ee eje kiynw wage ekk
//        String email = jsonObject.getString("email"); //json ob ekt adal krna manupulation krnn puluwn ekk json ob ekt pass krn ewa
//        System.out.println(email);  //reader() method eken req data reade krnnn

//        out put -sachini@gmail.com


        // 06 - optional - json array processing
//       JsonArray jsonArray =  reader.readArray();
//       for(int i =0; i< jsonArray.size(); i++){
//           var jsonObject = jsonArray.getJsonObject(i);
//           System.out.println(jsonObject.getString("name"));
//           System.out.println(jsonObject.getString("email"));

//           postman ge arry ek hadnn ona
//                   [
//           {
//               "id":"S001",
//                   "name":"Sakuni",
//                   "email":"sakuni@gmail.com",
//                   "city":"Galle",
//                   "level":"L01"
//
//           }
//],

//           out-put
//           Sakuni
//           sakuni@gmail.com
     //  }

        //json p type eke
        // 05.send data to client
//        var write =resp.getWriter();
//        write.write(email); // writer() method eken req data write kranna

        //optional - json array processing
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