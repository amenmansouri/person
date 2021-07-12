package maa.back.person.dtos;
/**
 * @author amen allah mansouri
 */
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = NaturalPersonDto.class, name = "NP"),
        @JsonSubTypes.Type(value = LegalPersonDto.class, name = "LP")
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public  class PersonDto {
    private Long id;
    private Timestamp creationDate ;
    private Timestamp updateDate ;
    private String country ;
    private String city ;
    private Integer zipCode ;
}

