package com.example.mudrakpatel_comp304_001_hands_on_test1;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class SendMessageActivity extends AppCompatActivity {
    //send button
    Button sendButtonSendMessageActivity;
    //Reference to the ImageView on
    //which we need to draw diagonals
    ImageView imageViewYellowSendMessageActivity;
    //Variables required for drawing
    //diagonals on the yellow ImageView
    Bitmap bitmap;
    Canvas canvas;
    Paint paint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);
        //Set Action bar title to the selected contact name
        getSupportActionBar().setTitle(MainActivity.contactName);
        sendButtonSendMessageActivity = (Button) findViewById(R.id.sendButtonSendMessageActivity);
        sendButtonSendMessageActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText messageEditTextSendMessageActivity = (EditText) findViewById(R.id.messageEditTextSendMessageActivity);
                String editTextMessage = messageEditTextSendMessageActivity.getText().toString();
                if(editTextMessage.isEmpty()){
                    Toast.makeText(SendMessageActivity.this, "PLEASE PUT A VALID MESSAGE.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SendMessageActivity.this, "Message: " + editTextMessage, Toast.LENGTH_SHORT).show();
                }
            }
        });
        /*
        * Following set of code lines
        * is to draw diagonal lines on
        * the yellow colored ImageView
        * */
        imageViewYellowSendMessageActivity = (ImageView) findViewById(R.id.imageViewYellowSendMessageActivity);
        bitmap = Bitmap.createBitmap((int) getWindowManager().getDefaultDisplay().getWidth(),
                (int) getWindowManager().getDefaultDisplay().getHeight(), Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        imageViewYellowSendMessageActivity.setImageBitmap(bitmap);
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(25);
        canvas.drawLine(100,imageViewYellowSendMessageActivity.getY(),200,imageViewYellowSendMessageActivity.getHeight(),paint);
    }

}
