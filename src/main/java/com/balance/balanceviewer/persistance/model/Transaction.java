package com.balance.balanceviewer.persistance.model;

import com.balance.balanceviewer.persistance.CurrencyType;
import com.balance.balanceviewer.persistance.TransactionType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = Transaction.TABLE_NAME)
public class Transaction {

    static final String TABLE_NAME = "TRANSACTIONS";

    @Id
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column
    private TransactionType type;

    @Enumerated(EnumType.STRING)
    @Column
    private CurrencyType currency;

    @Column
    private BigDecimal value;

    @Column
    private LocalDate date;

    @Column(name = "desc")
    private String description;

    @JoinColumn(name = "id_account")
    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;
}
