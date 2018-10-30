package com.fonewebapplicationtest.service;

import com.fonewebapplicationtest.component.FOneDriverInfoProperties;
import com.fonewebapplicationtest.component.FOneTeamInfoProperties;
import com.fonewebapplicationtest.entity.DriverRecord;
import com.fonewebapplicationtest.entity.Record;
import com.fonewebapplicationtest.entity.TeamRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service class reads the record, process the record and produce the list of records
 */
@Service
public class FOneService implements IFOneService {

    @Autowired
    private FOneDriverInfoProperties fOneDriverInfoProperties;
    @Autowired
    private FOneTeamInfoProperties fOneTeamInfoProperties;

    /**
     * If the property is not found will default to empty string
     */
    @Value("${record.delimiter:;}")
    private String delimiter;

    /**
     * If the property is not found will default to 9
     */
    @Value("${record.details.count:9}")
    private int recordDetailsCount;

    /**
     * If the property is not found will default to 10
     */
    @Value("${display.records.count:10}")
    private int displayRecordsCount;


    /**
     * Record details position definition
     */
    private int RECORD_TYPE_DPOSITION = 0;
    private int NO_OF_RACES_DPOSITION = 1;
    private int NO_OF_FIRSTPOS_DPOSITION = 2;
    private int NO_OF_SECONDPOS_DPOSITION = 3;
    private int NO_OF_THIRDPOS_DPOSITION = 4;
    private int NO_OF_PODIUMS_DPOSITION = 5;
    private int NO_OF_POLES_DPOSITION = 6;
    private int NO_OF_TIMES_FASTEST_DPOSITION = 7;
    private int NO_OF_POINTS_DPOSITION = 8;

    /**
     * Method process and returns the list of driver record
     *
     * @return
     */
    @Override
    public List<DriverRecord> listOfTopDriversRecord() {
        DriverRecord driverRecord;
        List<DriverRecord> listOfTopDriversRecord = new ArrayList<>();
        for (String record : fOneDriverInfoProperties.getDriversRecord()) {
            List<String> details = Arrays.asList(record.split(delimiter));
            if (recordDetailsCount != details.size())
                return null;
            driverRecord = new DriverRecord();
            populateRecord(details, driverRecord);
            driverRecord.setDriverName(getStringValue(details.get(RECORD_TYPE_DPOSITION)));
            listOfTopDriversRecord.add(driverRecord);
        }
        listOfTopDriversRecord = listOfTopDriversRecord.stream().sorted().limit(displayRecordsCount).collect(Collectors.toList());
        return listOfTopDriversRecord;
    }

    /**
     * Method process and returns the list of team record
     *
     * @return
     */
    @Override
    public List<TeamRecord> listOfTopTeamsRecord() {
        TeamRecord teamRecord;
        List<TeamRecord> listOfTopTeamsRecord = new ArrayList<>();
        for (String record : fOneTeamInfoProperties.getTeamsRecord()) {
            List<String> details = Arrays.asList(record.split(delimiter));
            if (recordDetailsCount != details.size())
                return null;
            teamRecord = new TeamRecord();
            populateRecord(details, teamRecord);
            teamRecord.setTeamName(getStringValue(details.get(RECORD_TYPE_DPOSITION)));
            listOfTopTeamsRecord.add(teamRecord);
        }
        listOfTopTeamsRecord = listOfTopTeamsRecord.stream().sorted().limit(displayRecordsCount).collect(Collectors.toList());
        return listOfTopTeamsRecord;
    }

    /**
     * method populates the record
     *
     * @param details
     * @param record
     */
    private void populateRecord(List<String> details, Record record) {
        record.setNoOfRaces(getIntValue(details.get(NO_OF_RACES_DPOSITION)));
        record.setNoOfFirstPos(getIntValue(details.get(NO_OF_FIRSTPOS_DPOSITION)));
        record.setNoOfSecondPos(getIntValue(details.get(NO_OF_SECONDPOS_DPOSITION)));
        record.setNoOfThirdPos(getIntValue(details.get(NO_OF_THIRDPOS_DPOSITION)));
        record.setNoOfPodiums(getIntValue(details.get(NO_OF_PODIUMS_DPOSITION)));
        record.setNoOfPoles(getIntValue(details.get(NO_OF_POLES_DPOSITION)));
        record.setNoOfTimesFastest(getIntValue(details.get(NO_OF_TIMES_FASTEST_DPOSITION)));
        record.setNoOfPoints(getFloatValue(details.get(NO_OF_POINTS_DPOSITION)));
    }

    /**
     * Method returns the empty string if the value is not found.
     * ElseGet method is called only when the value is null, so no empty string is created untill needed.
     *
     * @param param
     * @return
     */
    private String getStringValue(String param) {
        return Optional.of(param).orElseGet(String::new);
    }

    /**
     * Method returns the default value if the value is not found.
     * ElseGet method is called only when the value is null.
     *
     * @param param
     * @return
     */
    private int getIntValue(String param) {
        return Integer.parseInt(Optional.of(param).orElseGet(() -> "0"));
    }

    /**
     * Method returns default value if the value is not found.
     * ElseGet method is called only when the value is null
     *
     * @param param
     * @return
     */
    private float getFloatValue(String param) {
        return Float.parseFloat(Optional.of(param).orElseGet(() -> "0"));
    }

}
