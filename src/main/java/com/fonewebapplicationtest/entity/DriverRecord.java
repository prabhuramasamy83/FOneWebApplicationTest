package com.fonewebapplicationtest.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * Class represents the diver record
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
public class DriverRecord extends Record {
    @JsonProperty("name")
    private String driverName;

}
