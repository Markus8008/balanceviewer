package com.balance.balanceviewer.persistance.repository;
import com.balance.balanceviewer.persistance.model.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BalanceRepository extends JpaRepository<Balance, Integer> {
    @Override
    List<Balance> findAll();
}
