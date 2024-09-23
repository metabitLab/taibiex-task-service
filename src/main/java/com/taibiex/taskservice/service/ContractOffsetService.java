package com.taibiex.taskservice.service;

import com.taibiex.taskservice.entity.ContractOffset;
import com.taibiex.taskservice.repository.ContractOffsetRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class ContractOffsetService {

    private final ContractOffsetRepository contractOffsetRepository;

    public ContractOffsetService(ContractOffsetRepository contractOffsetRepository) {
        this.contractOffsetRepository = contractOffsetRepository;
    }

    public ContractOffset findByContractAddress(String contractAddress){
        return contractOffsetRepository.findByContractAddress(contractAddress);
    }

    @Transactional
    public void update(ContractOffset contractOffset){
        contractOffsetRepository.save(contractOffset);
    }

    public BigInteger findMinBlockOffset(){
        return contractOffsetRepository.findMinBlockOffset();
    }
}
