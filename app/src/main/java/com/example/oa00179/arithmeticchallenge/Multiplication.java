package com.example.oa00179.arithmeticchallenge;

public class Multiplication extends ArithmeticChallenge {
    int num1, num2;
    int option1, option2, option3;

    public Multiplication(int TOTAL_LEVELS, int TURNS_PER_LEVEL) {
        //super(TOTAL_LEVELS, TURNS_PER_LEVEL);
    }

    protected String createQuestion() {
        num1 = (int) (11 * Math.random() + 1);
        num2 = (int) (11 * Math.random() + 1);
        String question = num1 + " x " + num2;
        return question;
    }


    protected int[] createchoices() {
        option1 = num1 * num2;
        do {
            if(num1 > 3)
                option2 = num1 * (int)  (Math.random() * ((num2 + 4) - (num1- 8)) + (num1 -2));
            else
                option2 = num1 *(int) (3 * Math.random() + num2);

        } while (option2 == option1);
        do {
            if(num1 > 3)
                option3 = num2 * (int)  (Math.random() * ((num1 + 5) - (num2 - 3)) + (num2 -2));
            else
                option3 = num2 * (int) (3 * Math.random() + num1);

        } while (option3 == option2 || option3 == option1);
        int[] options = {option1, option2, option3};
        return options;
    }
}
