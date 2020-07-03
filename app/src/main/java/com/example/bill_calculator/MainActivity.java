package com.example.bill_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText et1;
    private EditText et2;
    private EditText et3;
    private EditText et4;
    private TextView tv;
    private TextView tv2;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.textView);
        tv2=findViewById(R.id.textView2);
        et1=findViewById(R.id.editText);
        et2=findViewById(R.id.editText2);
        et3=findViewById(R.id.editText3);
        et4=findViewById(R.id.editText4);
        button=findViewById(R.id.button);

       button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(et1.getText().toString().length()==0){
                    et1.setText("0");
                }
                if(et2.getText().toString().length()==0){
                    et2.setText("0");
                }
                if(et3.getText().toString().length()==0){
                    et3.setText("0");
                }
                if(et4.getText().toString().length()==0){
                    et4.setText("0");
                }
                final int val1 = Integer.parseInt(et1.getText().toString());
                final int val2 = Integer.parseInt(et2.getText().toString());
                final int val3 = Integer.parseInt(et3.getText().toString());
                final int val4 = Integer.parseInt(et4.getText().toString());
                CalculateFun(val1,val2,val3,val4);

            }
        });
    }

    public void CalculateFun(int u, int v, int w, int x) {
        int submeter,temp;
        float a,b,c,d,our_amount,neighbours_amount;
        String s1,s2;
        submeter=x-w;
        temp=v-submeter;
        a=condition(submeter);
        b=condition(temp);
        c=a+b;
        d=u-c;
        neighbours_amount=a+(d/2);
        s1=String.valueOf(neighbours_amount);
        our_amount=b+(d/2);
        s2=String.valueOf(our_amount);
        Log.i("their amount", s1);
        Log.i("our amount",s2);
        tv.setText(s1);
        tv2.setText(s2);
    }

    public float condition(int sub){
        float a,b,c,ans;
        if(sub>70){
            a=sub-70;
            b= (float) (70*5.20);
            c= (float) (a*6.75);
            ans=b+c;
        }
        else if((sub<=70)&&(sub>30)){
            a=sub-30;
            b= (float) (30*3.20);
            c= (float) (a*5.20);
            ans=b+c;
        }
        else{
            ans= (float) (sub*3.20);
        }
        return (float) ans;
    }

}
