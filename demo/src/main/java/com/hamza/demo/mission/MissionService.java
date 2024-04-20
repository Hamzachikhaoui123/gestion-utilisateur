package com.hamza.demo.mission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissionService implements IMission {
    @Autowired
    MissionRepository missionRepository;
    @Override
    public List<Mission> getAllMission(){
        return missionRepository.findAll();
    }

    @Override
    public Mission addMission(Mission mission) {
        return missionRepository.save(mission);
    }


    @Override
    public Mission getMissionById(String id) {
        return missionRepository.findById(id).orElseThrow();
    }

    @Override
    public ResponseEntity<String> DeleteMission(String id) {
         missionRepository.deleteById(id);
        return ResponseEntity.ok("Mission est Deleted");
    }

}
