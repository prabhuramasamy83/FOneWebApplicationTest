package com.fonewebapplicationtest.controller;

import com.fonewebapplicationtest.entity.DriverRecord;
import com.fonewebapplicationtest.entity.FOneSearchResult;
import com.fonewebapplicationtest.entity.TeamRecord;
import com.fonewebapplicationtest.service.IFOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller renders the ajax get request
 */
@RestController
public class FOneSearchController {

    @Autowired
    private IFOneService service;

    /**
     * Method serves the get request for retrieving the top drivers records
     *
     * @return
     */
    @GetMapping(path = "/getTopDrivers")
    public ResponseEntity<Object> getTopDrivers() {
        List<DriverRecord> listOfTopDrivers = service.listOfTopDriversRecord();
        FOneSearchResult<List<DriverRecord>> response = new FOneSearchResult<>(null != listOfTopDrivers && 0 != listOfTopDrivers.size() ? "success" : "failed", listOfTopDrivers);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Method serves the get request for retrieving the top teams records
     *
     * @return
     */
    @GetMapping("/getTopTeams")
    public ResponseEntity<Object> getTopTeams() {
        List<TeamRecord> listOfTopTeams = service.listOfTopTeamsRecord();
        FOneSearchResult<List<TeamRecord>> response = new FOneSearchResult<>(null != listOfTopTeams && 0 != listOfTopTeams.size() ? "success" : "failed", listOfTopTeams);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
