package com.example.baikt3;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Detail extends AppCompatActivity {
    TextView t1,congthuc;
    EditText A;
    Button Luu,Refresh;
    ImageButton ql;
    ListView lvFile;
    private List<Tense> arrayFile = new ArrayList<>();
    private TenseAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        t1=findViewById(R.id.textview);
        congthuc=findViewById(R.id.CongThuc);
        A=findViewById(R.id.Cau);
        Luu=findViewById(R.id.Luu);
        Refresh=findViewById(R.id.LamMoi);
        ql=findViewById(R.id.quayve);
        t1.setText(getIntent().getExtras().getString("Name"));
        String uername =t1.getText().toString().trim();
        if (uername.equals("Hiện tại tiếp diễn")){
            congthuc.setText("S+am/is/are+V_ing");
        }
        if (uername.equals("Quá khứ đơn")){
            congthuc.setText("S+was/were+Ved");
        }
        if (uername.equals("Tương lai đơn")){
            congthuc.setText("S + will/shall + V-inf");
        }
        if (uername.equals("Tương lai gần")){
            congthuc.setText("S + is/ are/ am + going to + V");
        }
        if (uername.equals("Quá khứ tiếp diễn")){
            congthuc.setText("S + was/were + V-ing");
        }
        if (uername.equals("Quá khứ hoàn thành")){
            congthuc.setText("S + had + VpII");
        }
        AnhXa();
        adapter =new TenseAdapter(this,R.layout.item_file,arrayFile);
        lvFile.setAdapter(adapter);
        Luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFile();
                A.setText("");
            }
        });
        Refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                A.setText("");
            }
        });
        ql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
    private void AnhXa() {
        lvFile=(ListView) findViewById(R.id.lv);
        arrayFile=new ArrayList<>();
        arrayFile.add(new Tense("Tên Thì","Công Thức","Câu Ví Dụ"));
    }
    private void addFile() {
        String gtA = t1.getText().toString();
        String gtB = congthuc.getText().toString();
        String gtKQ = A.getText().toString();

        if(TextUtils.isEmpty(gtA) || TextUtils.isEmpty(gtB)||TextUtils.isEmpty(gtKQ)){
            Toast.makeText(this, "Hiện Không Câu Nào", Toast.LENGTH_SHORT).show();
            return;
        }
        Tense s = new Tense(gtA,gtB,gtKQ);
        s.setTen(gtA);
        s.setCongThuc(gtB);
        s.setCau(gtKQ);
        arrayFile.add(s);
        adapter.notifyDataSetChanged();
    }
}