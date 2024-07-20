package com.example.Quizzz.dao;


import com.example.Quizzz.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Quizdao extends JpaRepository<Quiz,Integer> {
}
