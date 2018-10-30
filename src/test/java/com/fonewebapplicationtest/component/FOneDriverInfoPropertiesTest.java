package com.fonewebapplicationtest.component;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * This class test the class that retrieves the F1 drivers records
 */
@RunWith(SpringRunner.class)
@TestPropertySource(properties = {"fonedriverinfo.driversRecord=Lewis Hamilton;226;71;35;26;132;81;40;2956"})
public class FOneDriverInfoPropertiesTest {

    @Autowired
    private FOneDriverInfoProperties fOneDriverInfoProperties;

    @EnableAutoConfiguration
    @Configuration
    static class FOneDriverInfoPropertiesTestConfig {

        @Bean
        public FOneDriverInfoProperties createFOneDriverInfoProperties() {
            return new FOneDriverInfoProperties();
        }
    }

    /**
     * Method should receive one driver record
     */
    @Test
    public void testGetDriversRecord() {
        Assert.assertEquals(1, fOneDriverInfoProperties.getDriversRecord().size());
    }

}
