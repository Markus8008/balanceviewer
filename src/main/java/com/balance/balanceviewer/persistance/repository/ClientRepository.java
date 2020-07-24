package com.balance.balanceviewer.persistance.repository;

import com.balance.balanceviewer.persistance.model.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity, Integer> {
}
