package com.fonewebapplicationtest.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * Class represents the team record
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
public class TeamRecord extends Record {
    @JsonProperty("name")
    private String teamName;

}
