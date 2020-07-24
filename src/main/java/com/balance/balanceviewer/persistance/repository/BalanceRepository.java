package com.balance.balanceviewer.persistance.repository;

import com.balance.balanceviewer.persistance.model.BalanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceRepository extends JpaRepository<BalanceEntity, Integer> {
}
