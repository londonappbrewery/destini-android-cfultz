package com.londonappbrewery.destini;

/**
 * Created by Lenovo on 07-Jul-17.
 */

public class QuestionWithAnswers {

    int mQuestionId;
    int mAns1Id;
    int mAns2Id;

    public QuestionWithAnswers(int questionResourceId,int ans1ResourceId,int ans2resourceId) {

        mQuestionId = questionResourceId;
        mAns1Id = ans1ResourceId;
        mAns2Id = ans2resourceId;
    }

    public int getQuestionId() {
        return mQuestionId;
    }

    public void setQuestionId(int questionId) {
        mQuestionId = questionId;
    }

    public int getAns1Id() {
        return mAns1Id;
    }

    public void setAnswer1Id(int ans1Id) {
        mAns1Id = ans1Id;
    }

    public int getAns2Id() {
        return mAns2Id;
    }

    public void setAnswer2Id(int ans2Id) {
        mAns2Id = ans2Id;
    }
}