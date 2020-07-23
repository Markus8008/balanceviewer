package com.balance.balanceviewer.persistance.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = Client.TABLE_NAME)
public class Client {

    static final String TABLE_NAME = "CLIENTS";

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String country;

    @OneToMany(
            mappedBy = "client",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnoreProperties("client")
    private List<Account> accounts = new ArrayList<>();
}
