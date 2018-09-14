package com.example.oa00179.arithmeticchallenge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageButton;
import android.widget.Button;
import android.content.Intent;

/***********************************************************************
 * Description: This is the controller of the main activity to react
 *              user activities.
 *
 * @author Bruce Gustin
 * @version September 8, 2018 5:30 pm
 ***********************************************************************/

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listenForUserInput();
    }

    private void listenForUserInput(){
        // sets asset ids for use in setOnClickListener
        final ImageButton[] operation = {
                findViewById(R.id.imageButton_Addition),
                findViewById(R.id.imageButton_Subtraction),
                findViewById(R.id.imageButton_Multiplication),
                findViewById(R.id.imageButton_Division)};
        //final ImageView instructionExit = findViewById(R.id.imageView_Instructions);
        //final Button instructionButton = findViewById(R.id.button_Instructions);
       // final Button exitButton = findViewById(R.id.button_Exit);

        // sets operation strings for use in intent put
        final String operationName[] = {"addition", "subtraction", "multiplication", "division"};


        // listens for clicks to pass intent
        for(int i = 0; i < operation.length; i++) {
            final int operationNum = i; //declared final to pass into inner class
            operation[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), GameActivity.class);
                    intent.putExtra("Operation", operationName[operationNum]);
                    startActivity(intent);
                }
            });
        }

        // listens for button and instruction view clicks
       // instructionButton.setOnClickListener(new View.OnClickListener() {
           // @Override
           // public void onClick(View v) {
                //instructionExit.setVisibility(View.VISIBLE);
         //   }
      // });

        //exitButton.setOnClickListener(new View.OnClickListener() {
          //  @Override
           // public void onClick(View v) {
            //    finish();
             //   System.exit(0);
        //    }
      //  });

        //instructionExit.setOnClickListener(new View.OnClickListener() {
        //   @Override
            //public void onClick(View v) {
                //instructionExit.setVisibility(View.INVISIBLE);
          //  }
        //});
    }
}


