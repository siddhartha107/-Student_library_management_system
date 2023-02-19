package com.example.Student_Library_Management_System.Repositories;

import com.example.Student_Library_Management_System.Models.Transactions;
import org.hibernate.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transactions,Integer> {


}
