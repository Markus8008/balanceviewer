package com.balance.balanceviewer.persistance.model;

import com.balance.balanceviewer.model.CurrencyType;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
@Entity
@Table(name = BalanceEntity.TABLE_NAME)
public class BalanceEntity {

    static final String TABLE_NAME = "BALANCES";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private BigDecimal total;

    @Enumerated(EnumType.STRING)
    @Column
    private CurrencyType currency;

    @Column
    private LocalDate date;

    @JoinColumn(name = "id_account")
    @ManyToOne(fetch = FetchType.LAZY)
    private AccountEntity account;
}
