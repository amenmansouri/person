package maa.back.person.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import maa.back.person.entities.RequestTemplate;
import maa.back.person.entities.Role;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RelationTypeDto {
    private Long id;
    private String label;
    private Timestamp creationDate;
    private Timestamp updateDate;
    private Role role;
    private RequestTemplate requestTemplate;
  //  private Long offerId;
}
