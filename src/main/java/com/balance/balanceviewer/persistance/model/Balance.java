package com.balance.balanceviewer.persistance.model;

import com.balance.balanceviewer.persistance.CurrencyType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = Balance.TABLE_NAME)
public class Balance {

    static final String TABLE_NAME = "BALANCES";

    @Id
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
    private Account account;
}
