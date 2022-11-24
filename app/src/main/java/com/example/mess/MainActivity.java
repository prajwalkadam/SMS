package com.example.mess;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText phonenumber;
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send=findViewById(R.id.button);
        phonenumber=findViewById(R.id.editText);
        //message=findViewById(R.id.editText2);
        send.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                String number="+91"+phonenumber.getText().toString();
                String msg="Help! I am in emergency. My Location : https://goo.gl/maps/yQdTrapGnQduBR4W7";
                try {
                    SmsManager smsManager=SmsManager.getDefault();
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    PendingIntent pi= PendingIntent.getActivity(getApplicationContext(), 0, intent,0);
                    smsManager.sendTextMessage(number,null,msg,pi,null);
                    Toast.makeText(getApplicationContext(),"Message Sent",Toast.LENGTH_LONG).show();
                }catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(),"Some fields is Empty",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}