package com.taibiex.taskservice.service;

import com.taibiex.taskservice.entity.Mint;
import com.taibiex.taskservice.repository.MintRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MintService {

    private final MintRepository mintRepository;

    public MintService(MintRepository mintRepository) {
        this.mintRepository = mintRepository;
    }

    @Transactional
    public void save(Mint mint) {
        Mint m = mintRepository.findByTxHash(mint.getTxHash());
        if (m != null) {
            return;
        }
        mintRepository.save(mint);
    }

    public long countBySender(String sender) {
        return mintRepository.countAllBySender(sender);
    }
}
