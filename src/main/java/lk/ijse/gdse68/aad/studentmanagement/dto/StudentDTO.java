package lk.ijse.gdse68.aad.studentmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDTO implements Serializable {
    // DTO -> dto pawichchi krnne achitecher ekk gttm eke layers athar data geniynna
    //db connect krnne DAO - entitiy thmayi db ekk wada krnne
    //BEAN spack ek => ym ym standet tikk dto class anugmny krnn ona @anotation use krl fully encapsulation wenn ona privet wenn ona marker interface ek implement krnn ona Serializable//funshion-ek interface ekk //normal/defolte- interface 2k ho it wada wadi//marker-interface body eke method ne
    //tostring ek override wenn ona ne
    private String id;
    private String name;
    private String email;
    private String city;
    private String level;

}
