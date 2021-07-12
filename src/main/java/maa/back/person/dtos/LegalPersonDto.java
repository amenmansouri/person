package maa.back.person.dtos;

import lombok.Data;

@Data
public class LegalPersonDto extends PersonDto{
    private String logo;
    private String code;
    private String name;
    private String shortDescription;
    private String description;
    private String color;
    private String centralLogo;
    private String coverPhoto;
}
