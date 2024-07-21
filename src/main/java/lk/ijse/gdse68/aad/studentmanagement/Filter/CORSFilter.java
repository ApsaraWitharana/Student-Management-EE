package lk.ijse.gdse68.aad.studentmanagement.Filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(urlPatterns = "/*") //ham sevlete ektm req ek metnin ynn ona hinda denne will card mapping ekk denne ona thankt req ekk awam ek hamdle krgnn on hind will card denne
public class CORSFilter extends HttpFilter {
    //HttpFilter EK EXTEND KRGNNWA
    //Servlet ekk = req resp handle krn ek wage meket filter eken wenne t ekmyi inheritence walin sub eke ewa extend wenwa

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
       var origin = getServletContext().getInitParameter("origin");  //web.xml eke connect krn origin ek methnin allagnnawa
        if (origin.contains(getServletContext().getInitParameter("origin"))){
            res.setHeader("Access-Control-Allow-Origin",origin);//allow kran kamaththa den kena thamyi methnt dann ona meke origin allwo krn kena kwd kiyl onannm url ek denn puluwn // mam wisin allow krnn ne me origin kiyl denne
            res.setHeader("Access-Control-Allow-Methods","GET,POST,PUT,PATCH,DELETE,OPTIONS"); //server ek patthen access krnn ona method monawad kyl denn ona crud wlt adal post method dl nattm enne
            // ADAL METHOD EKK WADA KRGNN MEKE METHOD TIK ALLOW KRN ONA
            res.setHeader("Access-Control-Allow-Headers","Content-Type"); //content server eke tiyen content ek client t aran denne methanin mek allow krl nattm wade wenne
            res.setHeader("Access-Control-Expose-Headers","Content-Type"); //adal browser eke webxml ek tamyi meken gnne // browser eke java script wal engin eke  mek export krnwa // heder and expose wal wensa ?? expose adal browser eke engin ekt content type kiyn ek accept krgnn

        }//if ekk dal chek krgnn wa meke tiyennet origin eke tyien servlet ekmd kiyl mek onem ne

        //FilterChain chain ->> tw filters tibbot ek mekt passs krgnn wenwa nttm ek ynne na filter chan eke anit ewat ehem unot servleet walt ynne e hinda chain.doFilter(req,res); ek danwa
        chain.doFilter(req,res); // chnage ekk krm ek issrh filter walat passs kragnnwa
    }
}
