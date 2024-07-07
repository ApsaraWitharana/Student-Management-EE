package lk.ijse.gdse68.aad.studentmanagement.util;

import java.util.UUID;


public class Util {
   //id ek generete krgnnwa uuid type eke id eke return krnwa static hinda
    public static String IdGenerate(){
        return UUID.randomUUID().toString();
    }
}
