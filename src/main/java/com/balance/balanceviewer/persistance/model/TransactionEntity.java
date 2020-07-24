package com.balance.balanceviewer.persistance.model;

import com.balance.balanceviewer.model.CurrencyType;
import com.balance.balanceviewer.model.TransactionType;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
@Entity
@Table(name = TransactionEntity.TABLE_NAME)
public class TransactionEntity {

    static final String TABLE_NAME = "TRANSACTIONS";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private AccountEntity account;
}
