package com.example.calculation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Templates;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText mEdtA;
    private EditText mEdtB;
    private TextView mTvResult;
    private Button mbt_plus;
    private Button mbt_sub;
    private Button mbt_mul;
    private Button mbt_div;
    private ListView lvResult;
    List<String> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEdtA = findViewById(R.id.edt_a);
        mEdtB = findViewById(R.id.edt_b);

        mbt_sub = findViewById(R.id.bt_sub);
        mbt_sub.setOnClickListener(this);

        mbt_mul = findViewById(R.id.bt_mul);
        mbt_mul.setOnClickListener(this);


        mbt_div = findViewById(R.id.bt_div);
        mbt_div.setOnClickListener(this);

        mTvResult = findViewById(R.id.tv_Result);
        lvResult = findViewById(R.id.listView);

        mbt_plus = findViewById(R.id.bt_plus);
        mbt_plus.setOnClickListener(this) ;

    }
    public void hienthi(){
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        lvResult.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        float a = Float.parseFloat(mEdtA.getText().toString());
        float b = Float.parseFloat(mEdtB.getText().toString());
        float ketqua = 0;
        String dau = "";
        switch(v.getId()){
            case R.id.bt_plus:
                ketqua = a+b;
                dau = "+";
                list.add(mEdtA.getText().toString()+" "+dau+" "+mEdtB.getText().toString()+" = "+ketqua);
                break;
            case R.id.bt_sub:
                ketqua = a-b;
                dau = "-";
                list.add(mEdtA.getText().toString()+" "+dau+" "+mEdtB.getText().toString()+" = "+ketqua);
                break;
            case R.id.bt_mul:
                ketqua = a*b;
                dau = "*";
                list.add(mEdtA.getText().toString()+" "+dau+" "+mEdtB.getText().toString()+" = "+ketqua);
                break;
            case R.id.bt_div:
                ketqua = a/b;
                dau = "/";
                list.add(mEdtA.getText().toString()+" "+dau+" "+mEdtB.getText().toString()+" = "+ketqua);
                break;
        }
        mTvResult.setText("Result: "+mEdtA.getText().toString()+" "+dau+" "+mEdtB.getText().toString()+" = "+ketqua);
        hienthi();
    }
}
