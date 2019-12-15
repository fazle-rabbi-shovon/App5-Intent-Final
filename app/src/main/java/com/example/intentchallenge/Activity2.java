package com.example.intentchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity implements View.OnClickListener {

    EditText edTxt2, edTxt3, edTxt4, edTxt5;
    ImageView img2, img3, img4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        edTxt2 = findViewById(R.id.edTxt2);
        edTxt3 = findViewById(R.id.edTxt3);
        edTxt4 = findViewById(R.id.edTxt4);
        edTxt5 = findViewById(R.id.edTxt5);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);


        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        img4.setOnClickListener(this);






    }


    @Override
    public void onClick(View v) {

        if(edTxt2.getText().toString().isEmpty()|| edTxt3.getText().toString().isEmpty()||
                edTxt4.getText().toString().isEmpty()|| edTxt5.getText().toString().isEmpty()){
            Toast.makeText(this, "Please enter all the values!!", Toast.LENGTH_SHORT).show();
        }
        else{

            Intent intent = new Intent();
            intent.putExtra("name",edTxt2.getText().toString().trim());
            intent.putExtra("call",edTxt3.getText().toString().trim());
            intent.putExtra("web",edTxt4.getText().toString().trim());
            intent.putExtra("address",edTxt5.getText().toString().trim());

            if(v.getId()==R.id.img2){
                intent.putExtra("mood","happy");
            }
            else if (v.getId()==R.id.img3){
                intent.putExtra("mood","ok");

            }
            else{
                intent.putExtra("mood","sad");

            }

            setResult(RESULT_OK,intent);
            Activity2.this.finish();



        }



    }
}
