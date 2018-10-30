package com.fonewebapplicationtest.component;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * This class retrieves the F1 teams records
 */
@Component
@ConfigurationProperties("foneteaminfo")
public class FOneTeamInfoProperties {

    private List<String> teamsRecord = new ArrayList<>();

    /**
     * If the teams records property is not found this will return the empty list
     *
     * @return
     */
    public List<String> getTeamsRecord() {
        return Optional.of(teamsRecord).orElseGet(ArrayList::new);
    }

    public void setTeamsRecord(List<String> teamsRecord) {
        this.teamsRecord = teamsRecord;
    }

}
