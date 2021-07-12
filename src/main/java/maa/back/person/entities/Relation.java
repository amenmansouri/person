/**
 * this class represents relation between two persons
 * @author amen allah mansouri
 */
package maa.back.person.entities;


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
@Table(name="relations")
public class Relation {
    /**
     * Id represents the identifier: unique, primary key
     * @see Long
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    /**
     * this column  represents the relation Type
     * @see RelationType
     */
    @ManyToOne(optional = false)
    @JoinColumn(name="relation_type_id")
    private RelationType relationType;

    /**
     * this column  represents the first person
     * @see Person
     */
    @ManyToOne
    @JoinColumn(name = "from_person")
    private Person from;

    /**
     * this column  represents the second person
     * @see Person
     */
    @ManyToOne
    @JoinColumn(name = "to_person")
    private Person to;

    /**
     * this column  represents the creation Date
     * @see Timestamp
     */
    @CreationTimestamp
    private Timestamp creationDate;

    /**
     * this column  represents the update Date
     * @see Timestamp
     */
    @UpdateTimestamp
    private Timestamp updateDate;

    /**
     * endDate  represents the outdated relation
     * @see Timestamp
     */
    //should specify
    private Timestamp endDate;
}