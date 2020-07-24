package com.balance.balanceviewer.persistance.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
@Entity
@Table(name = AccountEntity.TABLE_NAME)
public class AccountEntity {

    static final String TABLE_NAME = "ACCOUNTS";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nrb;

    @OneToMany(
            mappedBy = "account",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnoreProperties("account")
    private List<BalanceEntity> balances = new ArrayList<>();

    @OneToMany(
            mappedBy = "account",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnoreProperties("account")
    private List<TransactionEntity> transactions = new ArrayList<>();


    @JoinColumn(name = "id_client")
    @ManyToOne(fetch = FetchType.LAZY)
    private ClientEntity client;
}
