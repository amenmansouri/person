package maa.back.person.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="templates")
public class RequestTemplate{
    /**
     * Id represents the identifier: unique, primary key
     * @see Long
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     *
     */
    private String Subject;
    private String cc;
    @Lob
    private String body;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "relation_type_id")
    private RelationType relationType;
}
