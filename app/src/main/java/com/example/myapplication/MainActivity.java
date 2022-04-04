package com.example.myapplication;


import static android.service.controls.ControlsProviderService.TAG;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.mlkit.common.model.DownloadConditions;
import com.google.mlkit.nl.translate.TranslateLanguage;
import com.google.mlkit.nl.translate.Translation;
import com.google.mlkit.nl.translate.Translator;
import com.google.mlkit.nl.translate.TranslatorOptions;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;


public class MainActivity extends AppCompatActivity {


    public static TextView tv_text2;
    Button button;
    Button button2;
    Button button3;
    TextView tv_text;
    TextView nameTranslate;

    static java.util.ArrayList<String> arrlist = new java.util.ArrayList<String>();
    static java.util.ArrayList<String> arrlist2 = new java.util.ArrayList<String>();
    static java.util.ArrayList<String> arrlist3 = new java.util.ArrayList<String>();

    String originalText = "";
    Translator englishChineseTranslator;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        tv_text = findViewById(R.id.nameView);
        tv_text2 = findViewById(R.id.nameView2);
        nameTranslate = findViewById(R.id.nameTranslate);





        if (getSupportActionBar() != null)
            getSupportActionBar().hide();

        BottomAppBar bottomAppBar = findViewById(R.id.bottomAppBar);
        bottomAppBar.setNavigationOnClickListener(view -> {


            NavigationDrawerFragment bottomNavFragment = new NavigationDrawerFragment();
            bottomNavFragment.show(getSupportFragmentManager(), "TAG");
        });

        button2.setOnClickListener(new View.OnClickListener() {

            int count = 0;

            @Override
            public void onClick(View view) {

                if (button2.isPressed()) {
                    count++;
                }

                if (count == (1 % 3)) {
                    button2.setText("Male");
                } else if (count == 2 % 3) {
                    button2.setText("Female");
                } else {
                    button2.setText("Gender-Neutral");
                    count = 0;
                }
            }


        });


        button.setOnClickListener(view -> {

            prepareModel();


            String text = "";
            String[] tokens;
            InputStream is;
            String line = "";


            try {

                is = getAssets().open(NavigationDrawerFragment.stateName + ".TXT");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                text = new String(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }

            int i = 1;
            //continuously add 4
            tokens = text.split(",");
            for (int j = 3; j < tokens.length; j += 4) {
                String name = tokens[j];
                if (tokens[i].equals("F")) {
                    arrlist.add(name);
                    arrlist3.add(name);
                } else {
                    arrlist2.add(name);
                    arrlist3.add(name);
                }

                i += 4;

            }

            int randomitem;
            String randomElement = "";

            Random r = new Random();

            String button2Name = button2.getText().toString();

            if (button2Name.equals("Male")) {
                arrlist.clear();
                arrlist3.clear();
                randomitem = r.nextInt(arrlist2.size());
                randomElement = arrlist2.get(randomitem);
            } else if (button2Name.equals("Female")) {
                arrlist2.clear();
                arrlist3.clear();
                randomitem = r.nextInt(arrlist.size());
                randomElement = arrlist.get(randomitem);
            } else {
                arrlist.clear();
                arrlist2.clear();
                randomitem = r.nextInt(arrlist3.size());
                randomElement = arrlist3.get(randomitem);
            }

            tv_text.setText(randomElement);
            originalText = randomElement.toString();
        });

        button3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.names.org/n/" + tv_text.getText().toString() + "/about"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });




    }

    private void prepareModel() {
        TranslatorOptions options = new TranslatorOptions.Builder()
                .setSourceLanguage(TranslateLanguage.ENGLISH)
                .setTargetLanguage(TranslateLanguage.CHINESE)
                .build();
        englishChineseTranslator = Translation.getClient(options);

        englishChineseTranslator.downloadModelIfNeeded().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                translateLanguage();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
    }

    private void translateLanguage() {
        englishChineseTranslator.translate(originalText).addOnSuccessListener(new OnSuccessListener<String>() {
            @Override
            public void onSuccess(String s) {

               isAlpha(s);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                nameTranslate.setText("error");
            }
        });
    }
    public void isAlpha(String name) {
        if(name.matches("[a-zA-Z]+")) {
            nameTranslate.setText(" ");
        } else {
            nameTranslate.setText(name);
        }
    }
}
