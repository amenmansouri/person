/**
 * this class represents Relation name between two persons
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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "relation_types")
public class RelationType {
    /**
     * Id represents the identifier: unique, primary key
     * @see Long
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * this column  represents the relation name between two person
     * @see String
     */
    private String label;

    /**
     * this column  represents the creation Date
     *
     * @see Timestamp
     */
    @CreationTimestamp
    private Timestamp creationDate;
    /**
     * this column  represents the update Date
     *
     * @see Timestamp
     */
    @UpdateTimestamp
    private Timestamp updateDate;
    @OneToOne(cascade = {CascadeType.ALL},orphanRemoval = true)
    private Role role;
    @OneToOne(cascade = {CascadeType.ALL})
    private RequestTemplate requestTemplate;

    /**
     * this field represents the offer id
     * we should refer to instance from offer ms and delete this filed
     * i should think more about this field
     * i should refactor offer !!
     */

    // private Long offerId;
}
