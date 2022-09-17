package com.example.numbershapes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    class Numbers{
        int num;
        public boolean isTriangular(){
            int x=1;
            int triangularNum=1;

            while(triangularNum<num){
                x++;
                triangularNum+=x;
            }
            if(triangularNum == num){
                return true;
            }else{
                return false;
            }
        }

        public boolean isSquare() {
            double squareRoot = Math.sqrt(num);

            if(squareRoot == Math.floor(squareRoot)){
                return true;
            }else{
                return false;
            }
        }
    }

    public void TestNumber(View view){
        String message;
        EditText editText = (EditText) findViewById(R.id.editTextNumber);

        Numbers myNum = new Numbers();
        //myNum.num = 6;

        myNum.num = Integer.parseInt(editText.getText().toString());

        //System.out.println(myNum.isTriangular());
//        System.out.println(myNum.isSquare());
        if(editText.getText().toString().isEmpty()){
            message = "Please enter a number";
        }else{
            if(myNum.isSquare() && myNum.isTriangular()){
                message = editText.getText().toString() + " is square and triangular!";
            }else if(myNum.isSquare()){
                message = editText.getText().toString() + " is square number but not triangular.";
            }else if(myNum.isTriangular()){
                message = editText.getText().toString() + " is a triangular number but not square.";
            }else{
                message = editText.getText().toString() + " neither square nor triangular!";
            }
        }


        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        Log.i("info", "Button Pressed!");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}