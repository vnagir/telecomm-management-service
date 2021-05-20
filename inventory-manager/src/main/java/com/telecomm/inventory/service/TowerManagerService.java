package com.telecomm.inventory.service;

import com.telecomm.inventory.domain.Response;
import com.telecomm.inventory.domain.Tower;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface TowerManagerService {
    public Response saveTowers(List<Tower> towers) throws Exception;
    public Response getTowerById(String id);
    public Response getOnlineOfflineTowers(boolean online);
    public Response getAllTowers();

}
