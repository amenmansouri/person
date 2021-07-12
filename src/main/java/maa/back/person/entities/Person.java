/**
 * Person is an abstract class can not be instantiate
 * it groups common fields between legal and natural person
 * @author amen allah mansouri
 */
package maa.back.person.entities;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person {

    /**
     * Id represents the identifier: unique, primary key
     * @see Long
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * It represents the person country
     * @see String
     */
    private String country ;
    /**
     * it represents the person city
     * @see String
     */
    private String city ;
    /**
     * it represents the person zipCode
     * @see String
     */
    private Integer zipCode ;
    /**
     * this column represents creation Date
     * @see Timestamp
     */
    @CreationTimestamp
    private Timestamp creationDate ;
    /**
     * this column represents update Date
     * @see Timestamp
     */
    @UpdateTimestamp
    private Timestamp updateDate ;

}

