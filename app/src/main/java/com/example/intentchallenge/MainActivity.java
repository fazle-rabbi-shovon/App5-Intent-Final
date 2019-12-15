package com.example.intentchallenge;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnMainId;
    final int RCD = 2;
    String name ="", call ="", address = "", web = "", mood = "";
    ImageView faceMain2, callImg3 , lcnImg3 , webImg3;
    TextView    txtV3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        txtV3 = findViewById(R.id.txtV3);
        callImg3 = findViewById(R.id.callImg3);
        lcnImg3 = findViewById(R.id.lcnImg3);
        webImg3 = findViewById(R.id.webImg3);
        btnMainId = findViewById(R.id.btnMainId);
        faceMain2 = findViewById(R.id.faceMain2);


        txtV3.setVisibility(View.GONE);
        callImg3.setVisibility(View.GONE);
        lcnImg3.setVisibility(View.GONE);
        webImg3.setVisibility(View.GONE);
        faceMain2.setVisibility(View.GONE);




        btnMainId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        com.example.intentchallenge.Activity2.class);
                startActivityForResult(intent,RCD);

            }
        });

        callImg3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+call));
                startActivity(intent1);
            }
        });

        lcnImg3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="+address));
                startActivity(intent2);
            }
        });

        webImg3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+web));
                startActivity(intent3);


            }
        });




    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RCD){
            if (resultCode==RESULT_OK){

                txtV3.setVisibility(View.VISIBLE);
                callImg3.setVisibility(View.VISIBLE);
                lcnImg3.setVisibility(View.VISIBLE);
                webImg3.setVisibility(View.VISIBLE);
                faceMain2.setVisibility(View.VISIBLE);



                name = data.getStringExtra("name");
                call = data.getStringExtra("call");
                web = data.getStringExtra("web");
                address = data.getStringExtra("address");
                mood = data.getStringExtra("mood");

                txtV3.setText(name);

                if (mood.equals("happy")){
                    faceMain2.setImageResource(R.drawable.happy);
                }
                else if (mood.equals("sad")){
                    faceMain2.setImageResource(R.drawable.sed);
                }
                else{
                    faceMain2.setImageResource(R.drawable.neutral);
                }








            }
            else {
                Toast.makeText(this, "No data passed", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
