package com.ahercode.ChallengeApp.Services;

import com.ahercode.ChallengeApp.Models.Challenge;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChallengeService {
    private List<Challenge> challenges = new ArrayList<>();

    public ChallengeService() {

    // Added a some dummy data to the challenges list

        challenges.add(new Challenge(1L, "January", "Do 100 pushups a day"));
        challenges.add(new Challenge(2L, "February", "Do 100 situps a day"));
        challenges.add(new Challenge(3L, "March", "Do 100 squats a day"));
        challenges.add(new Challenge(4L, "April", "Do 100 jumping jacks a day"));
        challenges.add(new Challenge(5L, "May", "Do 100 burpees a day"));
    }


    public List<Challenge> getChallenges() {
        return challenges;
    }

    public boolean addChallenge(Challenge challenge) {
        try {
            for (Challenge c : challenges) {
                if (c.getId().equals(challenge.getId())) {
                    return false;
                }
            }
            challenges.add(challenge);
            return true;
        } catch (NullPointerException e) {
            return false;
        }

    }
}
