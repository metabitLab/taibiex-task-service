package com.taibiex.taskservice.controller;

import com.taibiex.taskservice.common.bean.ResponseResult;
import com.taibiex.taskservice.dto.SwapTaskRequestDTO;
import com.taibiex.taskservice.service.MintService;
import com.taibiex.taskservice.service.SwapService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("task")
public class TaskController {

    private final SwapService swapService;

    private final MintService mintService;

    public TaskController(SwapService swapService, MintService mintService) {
        this.swapService = swapService;
        this.mintService = mintService;
    }

    @PostMapping("checkSwapTask")
    public ResponseResult swapTask(@RequestBody @Validated SwapTaskRequestDTO request) {
        long swap = swapService.countBySender(request.getUserAddress());

        long mint = mintService.countBySender(request.getUserAddress());

        return ResponseResult.success(swap >= 3 || mint >= 1);
    }
}
