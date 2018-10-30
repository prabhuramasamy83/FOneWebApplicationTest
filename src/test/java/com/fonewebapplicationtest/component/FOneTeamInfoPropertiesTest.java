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
 * This class test the class that retrieves the F1 teams records
 */
@RunWith(SpringRunner.class)
@TestPropertySource(properties = {"foneteaminfo.teamsRecord=Ferrari;968;236;272;251;562;218;246;8581.27"})
public class FOneTeamInfoPropertiesTest {

    @Autowired
    private FOneTeamInfoProperties fOneTeamInfoProperties;

    @EnableAutoConfiguration
    @Configuration
    static class FOneTeamInfoPropertiesTestConfig {

        @Bean
        public FOneTeamInfoProperties createFOneTeamInfoProperties() {
            return new FOneTeamInfoProperties();
        }
    }

    /**
     * Method should retrieve the team record
     */
    @Test
    public void testGetTeamsRecord() {
        Assert.assertEquals(1, fOneTeamInfoProperties.getTeamsRecord().size());
    }

}
