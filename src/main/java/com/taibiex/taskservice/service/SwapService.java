package com.taibiex.taskservice.service;

import com.taibiex.taskservice.entity.Swap;
import com.taibiex.taskservice.repository.SwapRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SwapService {

    private final SwapRepository swapRepository;

    public SwapService(SwapRepository swapRepository) {
        this.swapRepository = swapRepository;
    }

    @Transactional
    public void save(Swap swap) {
        Swap s = swapRepository.findByTxHash(swap.getTxHash());
        if (s != null) {
            return;
        }
        swapRepository.save(swap);
    }

    public long countBySender(String sender){
        return swapRepository.countAllBySender(sender);
    }
}
