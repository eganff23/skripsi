package com.example.easylearnenglish;

public class question {
        private String question;
        private String option1;
        private String option2;
        private String option3;
        private int correctAnswer;

        public question(String question, String option1, String option2, String option3, int correctAnswer) {
            this.question = question;
            this.option1 = option1;
            this.option2 = option2;
            this.option3 = option3;
            this.correctAnswer = correctAnswer;
        }

        public String getQuestion() {
            return question;
        }

        public String getOption1() {
            return option1;
        }

        public String getOption2() {
            return option2;
        }

        public String getOption3() {
            return option3;
        }

        public int getCorrectAnswer() {return correctAnswer;}

}


