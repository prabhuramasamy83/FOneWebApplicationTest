package com.fonewebapplicationtest.service;

import com.fonewebapplicationtest.entity.DriverRecord;
import com.fonewebapplicationtest.entity.TeamRecord;

import java.util.List;

public interface IFOneService {
    public List<DriverRecord> listOfTopDriversRecord();

    public List<TeamRecord> listOfTopTeamsRecord();

}
