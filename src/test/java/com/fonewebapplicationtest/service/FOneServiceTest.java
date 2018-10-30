package com.fonewebapplicationtest.service;


import com.fonewebapplicationtest.component.FOneDriverInfoProperties;
import com.fonewebapplicationtest.component.FOneTeamInfoProperties;
import com.fonewebapplicationtest.entity.DriverRecord;
import com.fonewebapplicationtest.entity.TeamRecord;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * Class that test the service class
 */
@RunWith(SpringRunner.class)
@TestPropertySource(properties = {"fonedriverinfo.driversRecord=Lewis Hamilton;226;71;35;26;132;81;40;2956", "foneteaminfo.teamsRecord=Ferrari;968;236;272;251;562;218;246;8581.27"})
public class FOneServiceTest {

    @TestConfiguration
    static class FOneServiceTestContextConfiguration {

        @Bean
        public FOneService fOneService() {
            return new FOneService();
        }
    }

    @Value("${fonedriverinfo.driversRecord}")
    private String driversRecordDetails;

    @Value("${foneteaminfo.teamsRecord}")
    private String teamsRecordDetails;

    @Autowired
    private IFOneService fOneService;

    @MockBean
    private FOneDriverInfoProperties fOneDriverInfoProperties;
    @MockBean
    private FOneTeamInfoProperties fOneTeamInfoProperties;


    /**
     * Method that test get list of drivers record with single record
     */
    @Test
    public void testListOfTopDriversRecord() {
        List<String> driversRecord = Arrays.asList(driversRecordDetails);
        when(fOneDriverInfoProperties.getDriversRecord()).thenReturn(driversRecord);
        List<DriverRecord> listOfDriverRecord = fOneService.listOfTopDriversRecord();
        Assert.assertEquals(driversRecordDetails.split(";")[0], listOfDriverRecord.get(0).getDriverName());
    }

    /**
     * Method that test get list of team record with single record
     */
    @Test
    public void testListOfTopTeamsRecord() {
        List<String> teamsRecord = Arrays.asList(teamsRecordDetails);
        when(fOneTeamInfoProperties.getTeamsRecord()).thenReturn(teamsRecord);
        List<TeamRecord> listOfTeamRecord = fOneService.listOfTopTeamsRecord();
        Assert.assertEquals(teamsRecordDetails.split(";")[0], listOfTeamRecord.get(0).getTeamName());
    }

    /**
     * Method that test get list of drivers record with empty details
     */
    @Test
    public void testListOfTopDriversRecordWithNoDetails() {
        List<String> driversRecord = Arrays.asList("");
        when(fOneDriverInfoProperties.getDriversRecord()).thenReturn(driversRecord);
        List<DriverRecord> listOfDriverRecord = fOneService.listOfTopDriversRecord();
        Assert.assertNull(listOfDriverRecord);

    }

    /**
     * Method that test get list of team record  with empty details
     */
    @Test
    public void testListOfTopTeamsRecordWithNoDetails() {
        List<String> teamsRecord = Arrays.asList("");
        when(fOneTeamInfoProperties.getTeamsRecord()).thenReturn(teamsRecord);
        List<TeamRecord> listOfTeamRecord = fOneService.listOfTopTeamsRecord();
        Assert.assertNull(listOfTeamRecord);
    }

    /**
     * Method that test get list of drivers record without any record
     */
    @Test
    public void testListOfTopDriversRecordWithNoRecords() {
        List<String> driversRecord = new ArrayList<>();
        when(fOneDriverInfoProperties.getDriversRecord()).thenReturn(driversRecord);
        List<DriverRecord> listOfDriverRecord = fOneService.listOfTopDriversRecord();
        Assert.assertEquals(0, listOfDriverRecord.size());

    }

    /**
     * Method that test get list of team record without any record
     */
    @Test
    public void testListOfTopTeamsRecordWithNoRecords() {
        List<String> teamsRecord = new ArrayList<>();
        when(fOneTeamInfoProperties.getTeamsRecord()).thenReturn(teamsRecord);
        List<TeamRecord> listOfTeamRecord = fOneService.listOfTopTeamsRecord();
        Assert.assertEquals(0, listOfTeamRecord.size());
    }

}
