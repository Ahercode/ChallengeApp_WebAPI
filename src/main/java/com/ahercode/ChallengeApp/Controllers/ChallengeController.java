package com.ahercode.ChallengeApp.Controllers;

import com.ahercode.ChallengeApp.Models.Challenge;
import com.ahercode.ChallengeApp.Services.ChallengeService;
import org.springframework.web.bind.annotation.*;

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
            return "Challenge added successfully";
        else
            return "Failed to add a new challenge";

    }

    @GetMapping("/challenges/{id}")
    public Challenge getChallenge(@PathVariable Long id) {
        Challenge challenge = _challengeService.getChallenge(id);

        if(challenge == null) {
            throw new RuntimeException("Challenge not found");
        }
        else
            return challenge;
    }

}
