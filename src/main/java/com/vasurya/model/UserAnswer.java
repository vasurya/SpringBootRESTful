package com.vasurya.model;



public class UserAnswer {
    private int answer;

    public int getAnswer() {
        return answer;
    }


    public void setAnswer(int answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "UserAnswer{" +
                "answer=" + answer +
                '}';
    }
}
