package maa.back.person.dtos;

/**
 * @author amen allah mansouri
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import maa.back.person.entities.RelationType;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RelationDto {
    private Long id;
    private RelationType relationType;
    private PersonDto from;
    private PersonDto to;
    private Timestamp creationDate;
    private Timestamp updateDate;
    private Timestamp endDate;
}
