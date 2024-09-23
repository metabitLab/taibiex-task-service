package com.taibiex.taskservice.service;

import com.taibiex.taskservice.common.constant.PoolMapSingleton;
import com.taibiex.taskservice.entity.PoolCreated;
import com.taibiex.taskservice.repository.PoolCreatedRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PoolCreatedService {

    private final PoolCreatedRepository poolCreatedRepository;

    public PoolCreatedService(PoolCreatedRepository poolCreatedRepository) {
        this.poolCreatedRepository = poolCreatedRepository;
    }

    public List<PoolCreated> findAll() {
        return poolCreatedRepository.findAll();
    }

    @Transactional
    public void save(PoolCreated poolCreated) {
        PoolCreated p = poolCreatedRepository.findByTxHash(poolCreated.getTxHash());
        if (p != null) {
            return;
        }
        PoolMapSingleton.put(poolCreated.getPool(), poolCreated);
        poolCreatedRepository.save(poolCreated);
    }
}
