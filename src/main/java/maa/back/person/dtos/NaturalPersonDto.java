package maa.back.person.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import maa.back.person.enums.Gender;
import java.sql.Timestamp;

@Data
public class NaturalPersonDto extends PersonDto{
    private String firstName;
    private String lastName ;
    private String email ;
    private String phone ;
    private Timestamp birthDay;
    private Gender gender ;
    private String photo ;
    private String biography ;
    private String schooling ;
    private String password;
}
