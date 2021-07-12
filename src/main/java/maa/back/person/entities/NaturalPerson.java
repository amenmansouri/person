package maa.back.person.entities;
/**
 *
 * this class represents the natural person
 *
 * @author sofien trabelsi
 * @version 1.0
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import maa.back.person.enums.Gender;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "natural_persons")
public class NaturalPerson extends  Person {

    /**
     * this column represents the first Name of Natural Person
     * @see String
     */
    private String firstName;
    /**
     * this column represents the last Name of Natural Person
     * @see String
     */
    private String lastName ;

    /**
     * this column represents the E-mail of Natural Person
     * @see String
     */
    @Column(name="email" ,unique = true)
    private String email ;
    /**
     * this column represents the phone of Natural Person
     * @see String
     */
    private String phone ;

    /**
     * this column represents the birthDay of Natural Person
     * @see Timestamp
     */
    private Timestamp birthDay;

    /**
     * this column represents the birthDay of Natural Person
     * @see Gender
     */
    @Enumerated(EnumType.STRING)
    private Gender gender ;

    /**
     * this column represents the photo of Natural Person
     * @see String
     */
    private String photo ;

    /**
     * this column represents the biographique of Natural Person
     * @see String
     */
    @Lob
    private String biography ;

    /**
     * this column represents the schooling of Natural Person , this column is enum
     * @see String
     */
    private String schooling ;
    private String password;


    /**
     *the constructor for class  NaturalPerson
     */
    public NaturalPerson(Long id,String country,String city,Integer zipCode, Timestamp creationDate, Timestamp updateDate) {
        super(id, country, city, zipCode, creationDate, updateDate);
    }


}
