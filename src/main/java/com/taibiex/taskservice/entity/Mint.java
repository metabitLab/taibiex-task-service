package com.taibiex.taskservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mint")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mint extends BaseEntity{

    @Column(name = "tx_hash")
    private String txHash;

    @Column(name = "sender")
    private String sender;

    @Column(name = "owner")
    private String owner;

    @Column(name = "tick_lower")
    private String tickLower;

    @Column(name = "tick_upper")
    private String tickUpper;

    @Column(name = "amount")
    private String amount;

    @Column(name = "amount0")
    private String amount0;

    @Column(name = "amount1")
    private String amount1;
}

