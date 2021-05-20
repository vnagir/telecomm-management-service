package com.telecomm.inventory.service;

import com.telecomm.inventory.domain.Response;
import com.telecomm.inventory.domain.Tower;
import com.telecomm.inventory.domain.TowerRepository;
import com.telecomm.inventory.exception.TowerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TowerManagerServiceImpl implements TowerManagerService {

    @Autowired
    private TowerRepository repository;

    @Autowired
    private Response resposne;

    @Override
    public Response saveTowers(List<Tower> towers) throws TowerException {
        if(towers==null || towers.isEmpty()){
            throw new TowerException("Input is either empty or not valid. Please provide valid towers.");
        }
        resposne.setSavedTowers(repository.saveAll(towers).stream().collect(Collectors.toMap(Tower::getUniqueId, tower -> tower)));
       return resposne;

    }

    @Override
    public Response getTowerById(String id) throws TowerException {
        if(id==null || id.isEmpty()){
            throw new TowerException("Id value is not valid");
        }
        resposne.setTowerInfo(repository.findByUniqueId(id));
       return  resposne;
    }

    @Override
    public Response getOnlineOfflineTowers(boolean online) {
        resposne.setTowers(repository.findAllByIsActive(online));
        return resposne;
    }

    @Override
    public Response getAllTowers() {
        resposne.setTowers(repository.findAll());
        return resposne;
    }

}
