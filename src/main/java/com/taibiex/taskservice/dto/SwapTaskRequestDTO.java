package com.taibiex.taskservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SwapTaskRequestDTO {

    @NonNull
    private String userAddress;

}
