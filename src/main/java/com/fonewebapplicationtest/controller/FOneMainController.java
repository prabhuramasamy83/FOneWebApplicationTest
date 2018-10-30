package com.fonewebapplicationtest.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Controller renders the main page
 */
@Controller
public class FOneMainController {

    private static String MESSAGE_KEY = "message";
    private static String DRIVER_RANKING_MSG_KEY = "driverRankingMsg";
    private static String TEAM_RANKING_MSG_KEY = "teamRankingMsg";
    private static String VIEW_PAGE = "display";

    /**
     * If the property is not found will default to empty string
     */
    @Value("${welcome.message:}")
    private String message;

    /**
     * If the property is not found will default to empty string
     */
    @Value("${drivers.ranking.message:}")
    private String driverRankingMsg;

    /**
     * If the property is not found will default to empty string
     */
    @Value("${teams.ranking.message:}")
    private String teamRankingMsg;

    @RequestMapping("/")
    public String appInitMethod(Map<String, Object> model) {
        model.put(MESSAGE_KEY, this.message);
        model.put(DRIVER_RANKING_MSG_KEY, this.driverRankingMsg);
        model.put(TEAM_RANKING_MSG_KEY, this.teamRankingMsg);
        return VIEW_PAGE;
    }


}
