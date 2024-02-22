package com.ahercode.ChallengeApp.Controllers;

import com.ahercode.ChallengeApp.Models.Challenge;
import com.ahercode.ChallengeApp.Services.ChallengeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class ChallengeController {

    private final ChallengeService _challengeService;

    public ChallengeController( ChallengeService challengeService) {
        _challengeService = challengeService;

    }

    @GetMapping("/challenges")
    public ResponseEntity<List<Challenge>> getChallenges() {
//        return _challengeService.getChallenges();
        return ResponseEntity.ok(_challengeService.getChallenges());
    }

    @PostMapping("/challenges")
    public ResponseEntity<String> addChallenge(@RequestBody  Challenge challenge) {

        boolean isAdded = _challengeService.addChallenge(challenge);
        if (isAdded)
            return ResponseEntity.ok("Challenge added successfully");
        else
            return ResponseEntity.badRequest().body("Failed to add a new challenge");
    }

    @GetMapping("/challenges/{id}")
    public ResponseEntity<Challenge> getChallenge(@PathVariable Long id) {
        Challenge challenge = _challengeService.getChallenge(id);

        if(challenge == null) {
            return ResponseEntity.notFound().build();
        }
        else
            return ResponseEntity.ok(challenge);
    }


    @PutMapping("/challenges/{id}")
    public ResponseEntity<String> updateChallenge(@PathVariable Long id, @RequestBody Challenge updatedChallenge) {

        boolean isUpdated = _challengeService.updateChallenge(id, updatedChallenge);

        if (isUpdated)
            return ResponseEntity.ok("Challenge updated successfully");
        else
            return ResponseEntity.badRequest().body("Failed to update challenge");
    }

    @DeleteMapping("/challenges/{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable Long id) {
        boolean isDeleted = _challengeService.deleteChallenge(id);

        if (isDeleted)
            return ResponseEntity.ok("Challenge deleted successfully");
        else
            return ResponseEntity.badRequest().body("Failed to delete challenge");
    }

}
