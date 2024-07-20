package com.example.Quizzz.dao;

import com.example.Quizzz.Question;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {

    List<Question> findByCategory(String category);
//    Question getQuestionByIdAndCategory(int id,String category);

    @Modifying
    @Transactional
    @Query(value = "UPDATE question SET category = ?2 WHERE id = ?1", nativeQuery = true)
    void editCategoryById(int id, String category);


}
