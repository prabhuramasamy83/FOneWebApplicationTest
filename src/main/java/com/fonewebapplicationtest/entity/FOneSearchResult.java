package com.fonewebapplicationtest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


/**
 * Class represents the Restful service response object
 *
 * @param <T> T could be any subclass of Record class
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FOneSearchResult<T> {

    private String status;
    private T object;

}
