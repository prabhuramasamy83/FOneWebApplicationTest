package com.fonewebapplicationtest.controller;

import com.fonewebapplicationtest.entity.DriverRecord;
import com.fonewebapplicationtest.entity.TeamRecord;
import com.fonewebapplicationtest.service.IFOneService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Class test the Search controller
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = FOneSearchController.class, secure = false)
public class FOneSearchControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IFOneService fOneService;

    /**
     * Method calling the get top drivers restful service
     *
     * @throws Exception
     */
    @Test
    public void shouldReturnTopDriversCallingGetTopDrivers() throws Exception {
        DriverRecord driverRecord = new DriverRecord();
        driverRecord.setDriverName("driverTest");
        List<DriverRecord> listOfDriversRecord = new ArrayList<>();
        listOfDriversRecord.add(driverRecord);
        when(fOneService.listOfTopDriversRecord()).thenReturn(listOfDriversRecord);
        this.mockMvc.perform(get("/getTopDrivers")).andExpect(status().isOk())
                .andExpect(content().json("{\"status\":\"success\",\"object\":[{\"noOfRaces\":0,\"noOfFirstPos\":0,\"noOfSecondPos\":0,\"noOfThirdPos\":0,\"noOfPodiums\":0,\"noOfPoles\":0," +
                        "\"noOfTimesFastest\":0,\"noOfPoints\":0.0,\"name\":\"driverTest\"}]}"));
    }

    /**
     * Method calling the get top teams restful service
     *
     * @throws Exception
     */
    @Test
    public void shouldReturnTopTeamsCallingGetTopDrivers() throws Exception {
        TeamRecord teamRecord = new TeamRecord();
        teamRecord.setTeamName("teamTest");
        List<TeamRecord> listOfTeamRecord = new ArrayList<>();
        listOfTeamRecord.add(teamRecord);
        when(fOneService.listOfTopTeamsRecord()).thenReturn(listOfTeamRecord);
        this.mockMvc.perform(get("/getTopTeams")).andExpect(status().isOk())
                .andExpect(content().json("{\"status\":\"success\",\"object\":[{\"noOfRaces\":0,\"noOfFirstPos\":0,\"noOfSecondPos\":0,\"noOfThirdPos\":0,\"noOfPodiums\":0,\"noOfPoles\":0," +
                        "\"noOfTimesFastest\":0,\"noOfPoints\":0.0,\"name\":\"teamTest\"}]}"));
    }

}
