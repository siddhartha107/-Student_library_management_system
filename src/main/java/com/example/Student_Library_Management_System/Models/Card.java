package com.example.Student_Library_Management_System.Models;


import com.example.Student_Library_Management_System.Enums.CardStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "card")
public class Card {


    //Plan is to save this card in Db.
    //Before saving I have to set its attributes : Rule 1

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //Its auto generated


    @CreationTimestamp //Auto timestamp the time when an entry is created
    private Date createdOn;  //Its auto generated


    @UpdateTimestamp //Sets time when an entity is updated
    private Date updatedOn;    //Its auto generated


    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;   //Set this attribute


    @OneToOne
    @JoinColumn
    private Student studentVariableName;    //This variable is used in the parent class,].
    //while doing the bidirectional mapping


    //Card is parent wrt Book
    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    List<Book> booksIssued;



    @OneToMany(mappedBy = "card",cascade=CascadeType.ALL)
    private List<Transactions> listOfTransactions = new ArrayList<>();

    public List<Transactions> getListOfTransactions() {
        return listOfTransactions;
    }

    public void setListOfTransactions(List<Transactions> listOfTransactions) {
        this.listOfTransactions = listOfTransactions;
    }

    public Card() {
        booksIssued = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }


    public Student getStudentVariableName() {
        return studentVariableName;
    }

    public void setStudentVariableName(Student studentVariableName) {
        this.studentVariableName = studentVariableName;
    }

    public List<Book> getBooksIssued() {
        return booksIssued;
    }

    public void setBooksIssued(List<Book> booksIssued) {
        this.booksIssued = booksIssued;
    }
}
