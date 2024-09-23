package com.taibiex.taskservice.common.constant;


import lombok.Getter;

@Getter
public enum AppTaskCode {

    INTER_WORLD_NFT_TASK("InterWorldNFTTask"),
    PROFILE_TASK("ProfileTask"),
    RUNES_TASK("RunesTask"),
    SWAP_TASK("SwapTask"),
    XRACER_GAME_TASK("XRacerGameTask"),
    XRACER_UPGRADE_CAR_MODEL_TASK("XRacerUpgradeCarModelTask"),
    XRACER_UPGRADE_TASK("XRacerUpgradeTask");

    public String taskCode;

    AppTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }
}
