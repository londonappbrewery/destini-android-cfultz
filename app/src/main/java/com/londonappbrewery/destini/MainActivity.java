package com.londonappbrewery.destini;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView mStoryTextView;
    Button mButtonTop;
    Button mButtonBottom;
    int mQuesWithAns;
    int mAns1;
    int mAns2;
    int mStoryIndex;
    int mNewQuesIndex;
    int[][] mTransition = new int[][]{
            {0, 0}, {3, 2}, {3, 4}, {6, 5}
    };


    private QuestionWithAnswers[] mQuestionWithAnswersBank = new QuestionWithAnswers[]{

            new QuestionWithAnswers(0, 0, 0),
            new QuestionWithAnswers(R.string.T1_Story, R.string.T1_Ans1, R.string.T1_Ans2),
            new QuestionWithAnswers(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2),
            new QuestionWithAnswers(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2),
            new QuestionWithAnswers(R.string.T4_End, 0, 0),
            new QuestionWithAnswers(R.string.T5_End, 0, 0),
            new QuestionWithAnswers(R.string.T6_End, 0, 0),

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState!=null) {

            mStoryIndex = savedInstanceState.getInt("StoryIndex");
        }

        else {

            mStoryIndex = 1;
        }

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = (TextView) findViewById(R.id.storyTextView);
        mButtonTop = (Button) findViewById(R.id.buttonTop);
        mButtonBottom = (Button) findViewById(R.id.buttonBottom);
        mQuesWithAns = mQuestionWithAnswersBank[mStoryIndex].getQuestionId();
        mStoryTextView.setText(mQuesWithAns);
        mAns1 = mQuestionWithAnswersBank[mStoryIndex].getAns1Id();
        mAns2 = mQuestionWithAnswersBank[mStoryIndex].getAns2Id();
        mButtonTop.setText(mAns1);
        mButtonBottom.setText(mAns2);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                updateQuestionAndAnswers(0);
            }
        });

        //TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                updateQuestionAndAnswers(1);
            }
        });
    }

    private void updateQuestionAndAnswers(int option) {

        mNewQuesIndex = mTransition[mStoryIndex][option];

        if(mNewQuesIndex == 4 || mNewQuesIndex == 5 || mNewQuesIndex == 6) {

            mQuesWithAns = mQuestionWithAnswersBank[mNewQuesIndex].getQuestionId();
            mStoryTextView.setText(mQuesWithAns);
            mButtonTop.setVisibility(View.GONE);
            mButtonBottom.setVisibility(View.GONE);
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Game Over!");
            alert.setCancelable(false); //If user clicks other than alert then it will not work
            alert.setPositiveButton("Close application", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {

                    finish();
                }
            });

            alert.show();
        }

        else {

            mQuesWithAns = mQuestionWithAnswersBank[mNewQuesIndex].getQuestionId();
            mStoryTextView.setText(mQuesWithAns);
            mStoryIndex = mNewQuesIndex;
            mAns1 = mQuestionWithAnswersBank[mStoryIndex].getAns1Id();
            mAns2 = mQuestionWithAnswersBank[mStoryIndex].getAns2Id();
            mButtonTop.setText(mAns1);
            mButtonBottom.setText(mAns2);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("StoryIndex",mStoryIndex);
    }
}

