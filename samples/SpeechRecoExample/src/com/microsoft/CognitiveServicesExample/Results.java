

package com.microsoft.CognitiveServicesExample;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;


public class Results extends AppCompatActivity {

    Map<String, String> emergency = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);


        emergency.put("food.", "1");
        emergency.put("hungry.", "1");
        emergency.put("hunger.", "1");
        emergency.put("cake.", "1");
        emergency.put("candy.", "1");
        emergency.put("eat.", "1");
        emergency.put("bread","1");


        emergency.put("loo.", "2");
        emergency.put("toilet.", "2");
        emergency.put("pee.", "2");
        emergency.put("potty.", "2");
        emergency.put("washroom.", "2");

        emergency.put("lonely.", "3");
        emergency.put("alone.", "3");
        emergency.put("mom.", "3");
        emergency.put("dad.", "3");
        emergency.put("friend.", "3");

        emergency.put("help.", "4");
        emergency.put("danger.", "4");
        emergency.put("scared.", "4");
        emergency.put("save.", "4");
        emergency.put("rescue.", "4");
        emergency.put("scary.", "4");



        Bundle b = new Bundle();
        b = getIntent().getExtras();
        String receivedText = b.getString("result");
        TextView tv = (TextView) findViewById(R.id.textView);



        receivedText.toLowerCase();
        tv.setText(receivedText);






        String status=(Boolean.toString(inDictionary(emergency, receivedText)));
        if(status!=null){
        String code=emergency.get(receivedText);
        Toast.makeText(Results.this,""+code,Toast.LENGTH_SHORT).show();
        performTask(code);


        }
        else{
            Toast.makeText(Results.this,"No match",Toast.LENGTH_SHORT).show();}





        tv.setText(status);

        // OtherClass myObject = new OtherClass("Hello World!");
        // System.out.print(myObject);
    }


    public boolean inDictionary(Map<String, String> dict, String str) {


        if(dict.get(str) == null)
            return false;
        return true;

    }


    public void performTask(String code){

        if(code=="1"){
            sendFoodMessage();


        }
        else if(code=="2"){
            sendLooMessage();
        }
    }

    public void sendFoodMessage() {
        Log.i("Send SMS", "");
        String phoneNo = "9591353047";
        String message = "Hi nigga! I need food!";

        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, message, null, null);
            Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();
        }

        catch (Exception e) {
            Toast.makeText(getApplicationContext(), "SMS faild, please try again.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    public void sendLooMessage(){
        Log.i("Send SMS", "");
        String phoneNo = "9663600190";
        String message = "Hi mom! I wanna pee!";

        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, message, null, null);
            Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();
        }

        catch (Exception e) {
            Toast.makeText(getApplicationContext(), "SMS faild, please try again.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }



    }

}

















