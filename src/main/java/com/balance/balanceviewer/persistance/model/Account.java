package com.balance.balanceviewer.persistance.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = Account.TABLE_NAME)
public class Account {

    static final String TABLE_NAME = "ACCOUNTS";

    @Id
    private Integer id;
    @Column
    private String nrb;

    @OneToMany(
            mappedBy = "account",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnoreProperties("account")
    private List<Balance> balances = new ArrayList<>();

    @OneToMany(
            mappedBy = "account",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnoreProperties("account")
    private List<Transaction> transactions = new ArrayList<>();


    @JoinColumn(name = "id_client")
    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;
}
