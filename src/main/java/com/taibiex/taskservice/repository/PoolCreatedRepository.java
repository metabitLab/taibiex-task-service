package com.taibiex.taskservice.repository;

import com.taibiex.taskservice.entity.PoolCreated;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoolCreatedRepository extends JpaRepository<PoolCreated, Long> {

    PoolCreated findByTxHash(String txHash);

}
