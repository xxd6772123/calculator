package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity{
    private Button btn_1,btn_2,btn_3;
    private TextView textView,textView_1;
    public boolean flag=true;
    String front="";
    String center="";
    String after="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.text);
        textView_1=findViewById(R.id.text_1);
    }

    public void sbumit(View v) {
        String str=front+center+after;
        int i;
        btn_2=findViewById(v.getId());

        if (v.getId()==R.id.btn_zf){
            if (flag &&!(front.equals(""))){
                i=Integer.valueOf(front)*(-1);
                front=i+"";
            }else if (!after.equals("")){
                i=Integer.valueOf(after)*(-1);
                after=i+"";
            }
            textView.setText(front+center+after);
        }else {
            if (flag){
                if (v.getId()==R.id.btn_d&&front.equals("")){
                    return;
                }else {
                    front+=btn_2.getText().toString();
                }
            }else {
                if (v.getId()==R.id.btn_d&&after.equals("")){
                    return;
                }else{
                    after+=btn_2.getText().toString();
                }
            }
            textView.setText(str+btn_2.getText().toString());
        }
    }

    public void dy(View v){
        System.out.println("00000000000000000");
        String str=front+center+after;
        float i;
        float j;
        btn_2=findViewById(v.getId());
        if (v.getId()==R.id.btn_AC){
            flag=true;
            front="";
            center="";
            after="";
            textView.setText("");
            textView_1.setText("");
            return;
        }
        System.out.println(str+"///"+center+"?????"+front+","+after);

            if (v.getId()==R.id.btn_dy){
            if(!(front.equals("")||center.equals("")||after.equals(""))) {
                System.out.println("ddddddddddddddddddddddddddd");
                System.out.println(center+"9999999999999999");
                i = Float.valueOf(front);
                j = Float.valueOf(after);
                if (center.equals("+")) {
                    textView_1.setText(i + j + "");
                } else if (center.equals("-")) {
                    textView_1.setText(i - j + "");
                } else if (center.equals("*")) {
                    textView_1.setText(i * j + "");
                } else if (center.equals("÷")) {
                    textView_1.setText(i / j + "");
                } else if(center.equals("%")){
                    int n= (int) i;
                    int a= (int) j;
                    textView_1.setText(n % a+"");
                }
            }
            return;
        }

        if (flag&&(!front.equals(""))){
            center=btn_2.getText().toString();
            switch (v.getId()){
                case R.id.btn_jia :
                case R.id.btn_jian :
                case R.id.btn_c :
                case R.id.btn_cf :
                case R.id.remainder:
                    textView.setText(str+btn_2.getText().toString()); break;
            }
            flag=false;
        }
    }
}