package com.crud.library.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "ledger")
@Setter
@Getter
public class Ledger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "borrower_id")
    private Long borrowerId;

    @Column(name = "book_id")
    private Long bookId;

    @Column(name= "received_date")
    private Date recievedDate;

    @Column(name= "returned_date")
    private Date returnedDate;
}
