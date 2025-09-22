package com.map;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.List;

import jakarta.persistence.CascadeType;  // ✅ important

@Entity
public class Question {

    @Id
    @Column(name = "question_id")
    private int questionId;
    private String question;

    // @OneToOne(cascade = CascadeType.ALL)
    // private Answer answer;
    @OneToMany(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    private List<Answer> answers;

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    // public Answer getAnswer() {
    //     return answer;
    // }

    // public void setAnswer(Answer answer) {
    //     this.answer = answer;
    // }

    


    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
    
    // ✅ Default constructor (required by JPA)
    public Question() {
    }

    // ✅ Parameterized constructor
    public Question(int questionId, String question, List<Answer> answers)  {
        this.questionId = questionId;
        this.question = question;
        this.answers = answers;
    }




    
    

    
}
