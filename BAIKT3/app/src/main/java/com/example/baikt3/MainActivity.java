package com.example.baikt3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    ListView lv;
    ArrayList<String> arrayCourse;
    int vt = -1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText)findViewById(R.id.editText) ;
        lv = (ListView)  findViewById(R.id.lv);
        arrayCourse = new ArrayList<>();
        arrayCourse.add("Hiện tại đơn");
        arrayCourse.add("Hiện tại tiếp diễn");
        arrayCourse.add("Quá khứ đơn");
        arrayCourse.add("Quá khứ tiếp diễn");
        arrayCourse.add("Quá khứ hoàn thành");
        arrayCourse.add("Tương lai đơn");
        arrayCourse.add("Tương lai gần");
        ArrayAdapter adapter = new ArrayAdapter <String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                arrayCourse
        );
        lv.setAdapter(adapter) ;
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long  l) {
                Toast.makeText(MainActivity.this, arrayCourse.get(i), Toast.LENGTH_SHORT).show();editText.setText(arrayCourse.get(i));
                lv.setSelector(R.color.purple_200);
                vt = i;
            }

        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, arrayCourse.get(i), Toast.LENGTH_SHORT).show();String str=lv.getAdapter().getItem(i).toString();
                Intent intent=new Intent(getApplicationContext(),Detail.class);
                intent.putExtra("Name",str);
                startActivity(intent);
                lv.setSelector(R.color.purple_200);
                return false;
            }
        });
    }
}