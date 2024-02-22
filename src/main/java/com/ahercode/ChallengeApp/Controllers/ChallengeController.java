package com.ahercode.ChallengeApp.Controllers;

import com.ahercode.ChallengeApp.Models.Challenge;
import com.ahercode.ChallengeApp.Services.ChallengeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ChallengeController {

    private final ChallengeService _challengeService;

    public ChallengeController( ChallengeService challengeService) {
        _challengeService = challengeService;

    }


    @GetMapping("/challenges")
    public List<Challenge> getChallenges() {
        return _challengeService.getChallenges();
    }

    @PostMapping("/challenges")
    public String addChallenge(@RequestBody  Challenge challenge) {
        if (_challengeService.addChallenge(challenge))
            return "Challenge added";
        else
            return "Challenge not added";

    }

}
