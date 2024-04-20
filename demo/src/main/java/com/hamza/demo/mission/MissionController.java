package com.hamza.demo.mission;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mission")
@CrossOrigin(origins = "*")

@RequiredArgsConstructor
public class MissionController {

    @Autowired
    private  final MissionService missionService;
    @PostMapping(path = "/add")
    Mission addDepartment(@RequestBody Mission mission){
        return missionService.addMission(mission);
    }

    @GetMapping(path = "/all")
    List<Mission> departmentList (){
        return missionService.getAllMission();
    }
}
