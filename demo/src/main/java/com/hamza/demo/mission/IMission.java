package com.hamza.demo.mission;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IMission {
    List<Mission> getAllMission();
    Mission addMission(Mission mission);
    Mission getMissionById(String id);
    ResponseEntity DeleteMission(String id);

}
