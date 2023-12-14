package com.example.manage.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String age;
    private String sex;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToOne
    @JoinColumn(name = "fullName_id")
    private FullName fullName;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    private boolean isDelete;

    public User (Long id, String age, String sex, Account account, FullName fullName, Address address) {
        this.id = id;
        this.age = age;
        this.sex = sex;
        this.account = account;
        this.fullName = fullName;
        this.address = address;
        isDelete = false;
    }
}