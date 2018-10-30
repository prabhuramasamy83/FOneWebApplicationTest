package com.fonewebapplicationtest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


/**
 * Class represent the record details
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Record implements Comparable<Record> {
    private int noOfRaces;
    private int noOfFirstPos;
    private int noOfSecondPos;
    private int noOfThirdPos;
    private int noOfPodiums;
    private int noOfPoles;
    private int noOfTimesFastest;
    private float noOfPoints;

    @Override
    public int compareTo(Record param) {
        return this.noOfPoints - param.noOfPoints > 0 ? -1 : 1;
    }

}
