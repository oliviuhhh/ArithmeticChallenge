package com.example.oa00179.arithmeticchallenge;

/************************************************************************
 * Made by Olivia Armstrong
 * 10/3/18
 ************************************************************************/

// import statements here

public abstract class ArithmeticChallenge {
    private String mQuestionText;
    private long mStartTime;
    private String[] mChoiceText = new String[3];
    private int mScore;
    private int mProgress;
    private int mTURNS_PER_LEVEL;
    private int mAnswer;
    private int mHighScore;
    private boolean ccorrect;
    // fields initialized here

    public ArithmeticChallenge(int TOTAL_LEVELS, int TURNS_PER_LEVEL){
        mTURNS_PER_LEVEL = TURNS_PER_LEVEL;
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

    public int getScore()  {
        return mScore;
    }

    public void setScore(boolean isCorrect) {
        if (isCorrect)  {
            long duration =  System.currentTimeMillis() - mStartTime;
            if (duration > 5000)  {
                mScore += 100 - duration / 100;
            }
        }
    }

    public int getProgress()  {
        return mProgress;
    }

    public void setProgress()  {
        if(ccorrect)
        mProgress += 100 / mTURNS_PER_LEVEL;
        else
            mProgress -= 100 / mTURNS_PER_LEVEL;

    }

    public int getHighScore()  {
        return mHighScore;
    }

    public void setHighScore(int highScore)  {
        mHighScore = highScore;
    }

    // other getters and setters declared and implemented here

    /******************************************************
     * Concrete Classes
     ******************************************************/

    protected boolean isCorrect(int choice) {
        boolean correct = (Integer.parseInt(mChoiceText[choice]) == mAnswer) ? true : false;
        ccorrect=correct;
        return correct;
    }



    private void shuffleChoices(int[] choices) {
        mAnswer = choices[0];
        int choice = (int) (3 * Math.random() + 1);
        {
            switch (choice)  {
                case 1:
                    mChoiceText[0] = Integer.toString(choices[0]);
                    mChoiceText[1] = Integer.toString(choices[1]);
                    mChoiceText[2] = Integer.toString(choices[2]);
                    break;

                case 2:
                    mChoiceText[0] = Integer.toString(choices[1]);
                    mChoiceText[1] = Integer.toString(choices[2]);
                    mChoiceText[2] = Integer.toString(choices[0]);
                    break;

                case 3:
                    mChoiceText[0] = Integer.toString(choices[2]);
                    mChoiceText[1] = Integer.toString(choices[0]);
                    mChoiceText[2] = Integer.toString(choices[1]);
                    break;
            }
        }
    }
}
