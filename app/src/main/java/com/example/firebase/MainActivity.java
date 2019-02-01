package com.example.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText mKey,mValue;
    private Button mSendData;
    private DatabaseReference mRootRef,mChild1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mKey = findViewById(R.id.keyEditText);
        mValue =  findViewById(R.id.valueEditText);


        mRootRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://fir-demo-2f1f7.firebaseio.com/Users");
        mSendData= findViewById(R.id.sendData);
        mChild1=mRootRef.child("ID:001");
        mSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String key=mKey.getText().toString();
                String value=mValue.getText().toString();

                if(key.trim().length() ==0 || value.trim().length() ==0)
                {
                   return;
                }else{
                    DatabaseReference mChild2=mChild1.child(key);
                    mChild2.setValue(value);
                    mKey.getText().clear();
                    mValue.getText().clear();
                }




            }
        });

    }
}
