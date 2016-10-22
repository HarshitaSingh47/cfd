package com.microsoft.CognitiveServicesExample;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;


public class ChooseImage extends AppCompatActivity {


    Map<String, String> emergency = new HashMap<String, String>();
    Toolbar toolbar;


    CustomPagerAdapter mCustomPagerAdapter;
    ViewPager mViewPager;
    int[] mResources = {


            R.drawable.first,
            R.drawable.second,
            R.drawable.third,
            R.drawable.fourth,
            R.drawable.sleep,
            R.drawable.toilet,
            R.drawable.water,
            R.drawable.fifth

    };



    String[] nResources={"food","alone","help","play","sleep","toilet","water","alone"};



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_pager);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("Hear Me Out");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);


        mCustomPagerAdapter = new CustomPagerAdapter(this);

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mCustomPagerAdapter);


        emergency.put("food", "1");
        emergency.put("hungry", "1");
        emergency.put("hunger", "1");
        emergency.put("cake", "1");
        emergency.put("cand.", "1");
        emergency.put("eat", "1");
        emergency.put("bread","1");


        emergency.put("loo", "2");
        emergency.put("toilet", "2");
        emergency.put("pee", "2");
        emergency.put("potty", "2");
        emergency.put("washroom", "2");

        emergency.put("lonely", "3");
        emergency.put("alone", "3");
        emergency.put("mom", "3");
        emergency.put("dad", "3");
        emergency.put("friend", "3");

        emergency.put("help", "4");
        emergency.put("danger", "4");
        emergency.put("scared", "4");
        emergency.put("save", "4");
        emergency.put("rescue", "4");
        emergency.put("scary", "4");


        emergency.put("alone", "5");

        emergency.put("sleep", "6");


        emergency.put("water","7");

        emergency.put("play","8");









    }


    class CustomPagerAdapter extends PagerAdapter {

        Context mContext;
        LayoutInflater mLayoutInflater;

        public CustomPagerAdapter(Context context) {
            mContext = context;
            mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return (mResources.length)/4;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((FrameLayout) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View itemView = mLayoutInflater.inflate(R.layout.pager_item, container, false);
            if(position==1){
                position=4;
            }


            final int pos=position;
            ImageView imageView1 = (ImageView) itemView.findViewById(R.id.imageView2);
            imageView1.setImageResource(mResources[position]);


            imageView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String status=(Boolean.toString(inDictionary(emergency, nResources[pos])));
                    if(status!=null){
                        String code=emergency.get(nResources[pos]);
                        Toast.makeText(ChooseImage.this,""+code,Toast.LENGTH_SHORT).show();
                        //performTask(code);


                    }
                    else{
                        Toast.makeText(ChooseImage.this,"No match",Toast.LENGTH_SHORT).show();}


                }
            });







            ImageView imageView2 = (ImageView) itemView.findViewById(R.id.imageView3);
            imageView2.setImageResource(mResources[position+1]);

            imageView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String status=(Boolean.toString(inDictionary(emergency, nResources[pos+1])));
                    if(status!=null){
                        String code=emergency.get(nResources[pos+1]);
                        Toast.makeText(ChooseImage.this,""+code,Toast.LENGTH_SHORT).show();
                        //performTask(code);


                    }
                    else{
                        Toast.makeText(ChooseImage.this,"No match",Toast.LENGTH_SHORT).show();}


                }
            });


            ImageView imageView3 = (ImageView) itemView.findViewById(R.id.imageView4);
            imageView3.setImageResource(mResources[position+2]);

            imageView3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String status=(Boolean.toString(inDictionary(emergency, nResources[pos+2])));
                    if(status!=null){
                        String code=emergency.get(nResources[pos+2]);
                        Toast.makeText(ChooseImage.this,""+code,Toast.LENGTH_SHORT).show();
                        //performTask(code);


                    }
                    else{
                        Toast.makeText(ChooseImage.this,"No match",Toast.LENGTH_SHORT).show();}


                }
            });


            ImageView imageView4 = (ImageView) itemView.findViewById(R.id.imageView5);
            imageView4.setImageResource(mResources[position+3]);

            imageView4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String status=(Boolean.toString(inDictionary(emergency, nResources[pos+3])));
                    if(status!=null){
                        String code=emergency.get(nResources[pos+3]);
                        Toast.makeText(ChooseImage.this,""+code,Toast.LENGTH_SHORT).show();
                        //performTask(code);


                    }
                    else{
                        Toast.makeText(ChooseImage.this,"No match",Toast.LENGTH_SHORT).show();}


                }
            });

            container.addView(itemView);

            return itemView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((FrameLayout) object);
        }
    }

    public boolean inDictionary(Map<String, String> dict, String str) {


        if(dict.get(str) == null)
            return false;
        return true;

    }
}
