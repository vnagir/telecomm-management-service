package com.telecomm.inventory.resources;

import com.telecomm.inventory.domain.Tower;
import com.telecomm.inventory.domain.TowerRepository;
import com.telecomm.inventory.service.TowerManagerServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager")
public class TowerManagerController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TowerManagerController.class);
    @Autowired
    private TowerRepository repository;
    @Autowired
    private TowerManagerServiceImpl towerManagerService;

    @PostMapping(value = "/update", produces ={"application/json"}, consumes = {"application/json"} )
    public ResponseEntity<?> saveTowers(@RequestBody List<Tower> towers) {
        return ResponseEntity.ok(towerManagerService.saveTowers(towers));
    }

    @GetMapping(value="/tower/{id}", consumes = {"application/json"}, produces ={"application/json"})
    public ResponseEntity<?> getTowers(@PathVariable ("id") String uniqueId) {
          return ResponseEntity.ok(towerManagerService.getTowerById(uniqueId));
    }

    @GetMapping(value = "/tower/get-all",  produces ={"application/json"})
    public ResponseEntity<?> getAllTowers() {
        return ResponseEntity.ok(towerManagerService.getAllTowers());
    }

    @GetMapping(value ="/tower/{status}",produces ={"application/json"})
    public ResponseEntity<?> getTowersByStatus(@PathVariable("status") boolean status) {
        return  ResponseEntity.ok(towerManagerService.getOnlineOfflineTowers(status));
    }



}

