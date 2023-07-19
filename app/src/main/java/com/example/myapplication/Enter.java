package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.google.android.gms.cast.framework.media.ImagePicker;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.ktx.Firebase;

public class Enter extends AppCompatActivity implements Enter2 {
    ImageView cover;

    Button btn;
    EditText mFullName, mEmail, mPhone, mDob;
    Button mEnterBtn;
    ProgressBar progressBar;
    private final int GALLERY_REQ_CODE=1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter2);
        cover=findViewById(R.id.imageView);
        btn=findViewById(R.id.button3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iga = new Intent(Intent.ACTION_PICK);
                iga.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(iga, GALLERY_REQ_CODE);
            }
        });
        }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            if(requestCode==GALLERY_REQ_CODE){
                ImageView cover = this.cover;
                cover.setImageURI(data.getData());
            }
        }
    }
            public void onClick(View view) {
        mFullName=findViewById(R.id.editTextTextPersonName);
        mEmail=findViewById(R.id.editTextTextEmailAddress);
        mPhone=findViewById(R.id.editTextPhone);
        mDob=findViewById(R.id.editTextDate2);
        progressBar=findViewById(R.id.progressBar);
        mEnterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mEmail.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    mEmail.setError("Email is required");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);


            }
        });
    }
}

