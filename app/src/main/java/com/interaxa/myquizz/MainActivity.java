package com.interaxa.myquizz;

import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.interaxa.myquizz.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    quiz myquizz = new quiz();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setMyquiz(myquizz);
    }

    public void toastMyQuizz(View view) {
        resolveQuestionOne();
        resolveQuestionTwo();
        resolveQuestionThree();
        resolveQuestionFour();
        Toast.makeText(this,formatToast() , Toast.LENGTH_SHORT).show();
        myquizz = new quiz();
        binding.setMyquiz(myquizz);
    }
    private String formatToast() {
        String ret;
        int count = myquizz.getResult();
        if(count>0) {
            Resources res = getResources();
            ret = res.getQuantityString(R.plurals.question, count, count);
        }else{
            ret = getString(R.string.sorry);
        }
        return ret;
    }

    private void resolveQuestionFour() {
        if (myquizz.isCheckBoxOne()&& myquizz.isCheckBoxTwo() &&!myquizz.isCheckBoxThree()&&!myquizz.isCheckBoxFour() ){
            myquizz.setQuestionThree(true);
            binding.setMyquiz(myquizz);
        }
    }

    private void resolveQuestionThree() {
        if(myquizz.getAnswerFour()!= null&& myquizz.getAnswerFour().toLowerCase().contains(getString(R.string.answerQuestionFour))){
            myquizz.setQuestionFour(true);
            binding.setMyquiz(myquizz);

        }
    }

    private void resolveQuestionTwo() {
        if(myquizz.getAnswerTwo()!= null&& myquizz.getAnswerTwo().toLowerCase().equals(getString(R.string.answerQuestionTwo))){
            myquizz.setQuestionTwo(true);
            binding.setMyquiz(myquizz);

        }
    }
    private void resolveQuestionOne() {
        if (myquizz.isRadioFour()) {
            myquizz.setQuestionOne(true);
            binding.setMyquiz(myquizz);
        }
    }

}
