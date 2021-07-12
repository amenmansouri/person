package maa.back.person.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Legal Person class represents a legal entity
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "legal_persons")
public class LegalPerson extends Person {

    /**
     * logo represents the logo of legal Person
     * @see String
     */
    private String logo;

    /**
     * code represents the code / registration number of legal Person unique
     * @see String
     */
    @Column(unique = true)
    private String code;

    /**
     * name represents the name
     * @see String
     */
    private String name;

    /**
     * this column represents the short Description
     * @see String
     */
    @Lob
    @Column(length = 1000)
    private String shortDescription;

    /**
     * this column represents the description
     * @see String
     */
    @Lob
    private String description;

    /**
     * this column represents the  theme  color
     * @see String
     */
    private String color;

    /**
     * this column represents the  central Logo
     * @see String
     */
    private String centralLogo;

    /**
     * this column represents the cover Photo
     * @see String
     */
    private String coverPhoto;

    /**
     * this column represents the status of legal Person : enabled or disabled
     * @see String
     */
    private String enabled;

    public LegalPerson(Long id,String country,String city,Integer zipCode, Timestamp creationDate, Timestamp updateDate) {
        super(id, country, city, zipCode, creationDate, updateDate);
    }
}