package com.fonewebapplicationtest.component;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * This class retrieves the F1 drivers records
 */
@Component
@ConfigurationProperties("fonedriverinfo")
public class FOneDriverInfoProperties {

    private List<String> driversRecord = new ArrayList<>();

    /**
     * If the drivers records property is not found this will return the empty list
     *
     * @return
     */
    public List<String> getDriversRecord() {
        return Optional.of(driversRecord).orElseGet(ArrayList::new);
    }

    public void setDriversRecord(List<String> driversRecord) {
        this.driversRecord = driversRecord;
    }

}
