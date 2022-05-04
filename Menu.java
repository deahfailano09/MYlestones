package com.thesis.mylestones;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;


public class Menu extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_menu);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final ImageButton academicBtn = findViewById(R.id.academicBtn);
        final ImageButton careBtn = findViewById(R.id.careBtn);
        final ImageButton lifeBtn = findViewById(R.id.lifeBtn);

        final ImageButton img =  findViewById(R.id.selectedchar);
        if(CharacterSelection.character == 1){
            img.setImageResource(R.drawable.mchar);
            img.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    mediaPlayer= MediaPlayer.create(Menu.this,R.raw.mainmenum);
                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            mediaPlayer.start();
                        }
                    });
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            mediaPlayer.release();
                        }
                    });
                }
            });
        }
        else {
            img.setImageResource(R.drawable.fchar);
            img.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    mediaPlayer=MediaPlayer.create(Menu.this,R.raw.mainmenuf);
                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            mediaPlayer.start();
                        }
                    });
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            mediaPlayer.release();
                        }
                    });
                }
            });
        }

        final ImageButton settingsBtn = findViewById(R.id.settingsBtn);
        settingsBtn.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View v){
                Intent intent = new Intent(Menu.this, Settings.class);
                startActivity(intent);
            }
        });


        academicBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openAcademicSkills();
            }
        });

        careBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openCareSkills();

            }
        });

        lifeBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openLifeSkills();
            }
        });
    }


    public void openAcademicSkills(){
        Intent intent = new Intent (this, AcademicSkillsMenu.class);
        startActivity(intent);

    }
    public void openCareSkills(){
        Intent intent = new Intent (this, CareSkillsMenu.class);
        startActivity(intent);

    }
    public void openLifeSkills(){
        Intent intent = new Intent (this, LifeSkillsMenu.class);
        startActivity(intent);

    }

    }
