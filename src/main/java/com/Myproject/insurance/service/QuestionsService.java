package com.Myproject.insurance.service;

import com.Myproject.insurance.dto.QuestionsDto;
import com.Myproject.insurance.entity.Questions;
import com.Myproject.insurance.repository.QuestionsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuestionsService {

    private final QuestionsRepository questionsRepository;
    private final CommentService commentService;

    public QuestionsService(QuestionsRepository questionsRepository, CommentService commentService) {
        this.questionsRepository = questionsRepository;
        this.commentService = commentService;
    }

    // 게시글 저장 메서드
    public void save(QuestionsDto questionsDto) {
        Questions questions = new Questions();
        questions.setWriter(questionsDto.getWriter());
        questions.setTitle(questionsDto.getTitle());
        questions.setContent(questionsDto.getContent());
        questionsRepository.save(questions);
    }

    // 모든 게시글 조회 메서드
    public List<Questions> getAllQuestions() {
        return questionsRepository.findAll();
    }

    // 특정 게시글 조회 메서드
    public Questions getQuestionById(Long id) {
        return questionsRepository.findById(id).orElse(null);
    }

    public List<Questions> userQuestionMember(String name){
        return  questionsRepository.findByWriter(name);
    }
    @Transactional
    public void deleteQuestionById(Long id) {
        commentService.deleteCommentsByQuestionId(id);
        questionsRepository.deleteById(id);
    }
}