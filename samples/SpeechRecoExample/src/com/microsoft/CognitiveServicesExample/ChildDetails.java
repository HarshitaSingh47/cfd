package com.microsoft.CognitiveServicesExample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;




public class ChildDetails extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailschild);


        TextView tv1=(TextView)findViewById(R.id.cname);
        TextView tv2=(TextView)findViewById(R.id.age);
        TextView tv3=(TextView)findViewById(R.id.bgroup);
        TextView tv4=(TextView)findViewById(R.id.cchild);
        TextView tv5=(TextView)findViewById(R.id.p1);
        TextView tv6=(TextView)findViewById(R.id.m1);
        TextView tv7=(TextView)findViewById(R.id.p2);
        TextView tv8=(TextView)findViewById(R.id.m2);



        Bundle b=new Bundle();
        b=getIntent().getExtras();
        String s1=b.getString("name");
        String s2=b.getString("age");
        String s3=b.getString("blood");
        String s4=b.getString("addr");
        String s5=b.getString("mname");
        String s6=b.getString("mcon");
        String s7=b.getString("fname");
        String s8=b.getString("fcon");

        tv1.setText(s1);
        tv2.setText(s2);
        tv3.setText(s3);
        tv4.setText(s4);
        tv5.setText(s5);
        tv6.setText(s6);
        tv7.setText(s7);
        tv8.setText(s8);




    }
}
