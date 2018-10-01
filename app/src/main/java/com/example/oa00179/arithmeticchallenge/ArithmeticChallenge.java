package com.example.oa00179.arithmeticchallenge;

// import statements here

public abstract class ArithmeticChallenge {
    private String mQuestionText;
    private long mStartTime;
    private String[] mChoiceText = new String[3];
    // fields initialized here

    public ArithmeticChallenge(int TOTAL_LEVELS, int TURNS_PER_LEVEL){
        //super(TOTAL_LEVELS, TURNS_PER_LEVEL);
    }

    /******************************************************
     * Abstract Classes
     ******************************************************/

    protected abstract String createQuestion();

    protected abstract int[] createChoices();


    // abstract methods declared here;

    /******************************************************
     * Getters and Setters
     ******************************************************/
    public String getQuestionText() {
        //get QuestionText into the abstract class
        return mQuestionText;
    }

    public void setQuestionText(String questionText) {
        mQuestionText = questionText;
    }

    public String getChoice(int index){
        return mChoiceText[index];
    }

    protected void setChoice(int[] choices) {
        shuffleChoices(choices);
        mStartTime = System.currentTimeMillis();
    }


    // other getters and setters declared and implemented here

    /******************************************************
     * Concrete Classes
     ******************************************************/

    protected boolean isCorrect(int choice){
        // to be implemented
        return true;
    }


    private void shuffleChoices(int[] choices) {
        int choice = (int) (3 * Math.random() + 1);
        {
            switch (choice)  {
                case 1:
                    mChoiceText[0] = " " + choices[0] + " ";
                    mChoiceText[1] = " " + choices[1] + " ";
                    mChoiceText[2] = " " + choices[2] + " ";
                    break;

                case 2:
                    mChoiceText[0] = " " + choices[2] + " ";
                    mChoiceText[1] = " " + choices[1] + " ";
                    mChoiceText[2] = " " + choices[0] + " ";
                    break;

                case 3:
                    mChoiceText[0] = " " + choices[1] + " ";
                    mChoiceText[1] = " " + choices[0] + " ";
                    mChoiceText[2] = " " + choices[2] + " ";
                    break;
            }
        }
    }
}
