package lk.ijse.gdse68.aad.studentmanagement.controller;


import jakarta.json.Json;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.gdse68.aad.studentmanagement.bo.StudentBOImpl;
import lk.ijse.gdse68.aad.studentmanagement.dao.StudentDAOImpl;
import lk.ijse.gdse68.aad.studentmanagement.dto.StudentDTO;
import lk.ijse.gdse68.aad.studentmanagement.util.Util;
import org.eclipse.yasson.internal.JsonBinding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/student",loadOnStartup = 3)
public class Student extends HttpServlet {
//    =======logs====
    //in belt
    //pass string
    //limitation hinda login library use krgnnawa dependence widiyst dagnne
    //1.Adding needed libraries
    //2. Configuration
    //3. Placing log statements

    //    framework. -library
//application eke state ekt document ekk hadagnn use we = erros coll method time ekt ekk blagnn
//    1.Log4j 2 -fetchers wadi
//    2.Log4j
//    3.logback
//
    static Logger logger = LoggerFactory.getLogger(Student.class);
    Connection connection;



    @Override
    public void init() throws ServletException {
        logger.info("Hello method invoked");
//     var initparameter = getServletContext().getInitParameter("myparam");
//        System.out.println(initparameter);
        //db ek coll wenne ek parayi ek wenne

        try {
//            var dbClass = getServletContext().getInitParameter("db-class");
//            var dbUrl  = getServletContext().getInitParameter("dburl");
//            var dbUserName = getServletContext().getInitParameter("db-username");
//            var dbPassword = getServletContext().getInitParameter("db-password");
//            Class.forName(dbClass);

            var ctx = new InitialContext(); // connection pool eken connection ekk arahnn ekt
            DataSource pool = (DataSource) ctx.lookup("java:comp/env/jdbc/student_management"); // cast krl ek datasource ekk hdgnnwa // lookup => apit eken puluwn eke nm dila mokkhri gnna apit ona de lokup krl gann ek cast krgnn jenaric nida
            this.connection = pool.getConnection(); //namk dunnam eken hoyagnnw datasource ek== DataSource (connection pool ekkt)=> walin getconnection ekk
            logger.info("connection initialized", this.connection);
        } catch (SQLException | NamingException e) {
            e.printStackTrace();

        }


//        out-put
//        Hello Param
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        //paylord eke body ekt mokuth danne body ekk enne ek enne parameter ekk widiyat -resfull krnkot stand ekk widiyt gnnwa
//        todo:Get student.
        //db oparatio ekk dto hriynne natte -> db oparation ekk pawichchi kranne entity
        try (var writer = resp.getWriter()) {
            var studentBOImpl = new StudentBOImpl();
            Jsonb jsonb = JsonbBuilder.create();


            //id ek argent past kranwa postman t patameter ekk widiyt
            var studentId = req.getParameter("studentId");

            //json format eken ywnne data tika - java object ek json ob ekk krgnn ona
            //inform client to this is  server is send to json
            //headers =
            resp.setContentType("application/json");

            //json ywnn ona client ta ek to json server ek wisin ywn hinda eken parameter balaporottu wenwa api lg inn ob ek writer ek req ek reder resp eke writer ekyi //utility 2k
//          jsonb.toJson(studentDTO,writer);
            //json resp ek write krl ywnwa
            //req ek -> client post req eken en req ek reade krnn tiyen utility ek reader ek
            //fromjson-ftd eken en req ek gnn ek

            jsonb.toJson(studentBOImpl.getStudent(studentId, connection), writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        if (req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }

        //save student
        try (var writer = resp.getWriter()) {
            Jsonb jsonb = JsonbBuilder.create();
            var StudentBOImpl = new StudentBOImpl();
            StudentDTO student = jsonb.fromJson(req.getReader(), StudentDTO.class);
            logger.info("Invoke idGenerate()");
            student.setId(Util.IdGenerate());
            writer.write(StudentBOImpl.saveStudent(student, connection));
            logger.info("Student saved successfully");
            resp.setStatus(HttpServletResponse.SC_CREATED);
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }


        // 08. object binding of the json

     //   Jsonb jsonb = JsonbBuilder.create();  //json b type eke reference ekk hadagen jbilder eken
//        var writer = resp.getWriter();
   //     StudentDTO student = jsonb.fromJson(req.getReader(), StudentDTO.class); //eliyen en json student json t dagannwa fromjson gent pata 2 -reder and bined krn ob eke class type ek return krnne supplie krn class eke type ekk //map krgnnwa dto wl ek ek felde bined krnawa
  //      student.setId(Util.IdGenerate()); //id ek genngnn on hind nattm null enne
  //      System.out.println(student);
//        writer.write(jsonb.toJson(student.toString()));
//        output console -StudentDTO(id=65225d23-c4cf-45da-95bf-e1e2bd368647, name=Sachini, email=sachini@gmail.com, city=Matara, level=L02)


        //create response
 //       resp.setContentType("application/json");  //oyat dn json type eke ekk enwa
  //      jsonb.toJson(student, resp.getWriter());  //postman respoce body eke json type eke id ekk widiyt dgnn ona hinda 2json ekt pass krgnnwa writer eken paramere widiyt pass krgnnawa

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
//        super.doPut(req, resp);
//        todo:Update student


        try (var writer = resp.getWriter()) {
            var studentId = req.getParameter("studentId");
            var studentBOImpl = new StudentBOImpl();
            Jsonb jsonb = JsonbBuilder.create();
            StudentDTO student = jsonb.fromJson(req.getReader(), StudentDTO.class);
            if ( studentBOImpl.updateStudent(studentId, student, connection)) {
                resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
            } else {
                writer.write("Update failed");
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //writer ek dal tiyeddi thaw ekk


    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doDelete(req, resp);
//        todo:Delete student

        try (var writer = resp.getWriter()) {
            var studentId = req.getParameter("studentId");

            var studentBOImpl = new StudentBOImpl();
            if (studentBOImpl.deleteStudent(studentId, connection)) {
                resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
            } else {
                writer.write("Delete failed");
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }

        } catch (SQLException e) {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}