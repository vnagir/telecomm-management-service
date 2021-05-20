package com.telecomm.traffic.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TowerRepository extends JpaRepository<Tower, Long> {
    public Tower findByUniqueId(String uniqueId);
    public List<Tower> findAllByIsActive(boolean isActive);

}
