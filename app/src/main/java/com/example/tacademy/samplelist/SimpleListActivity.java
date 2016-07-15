package com.example.tacademy.samplelist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class SimpleListActivity extends AppCompatActivity {
    EditText keywordView;
    ListView listView;
    ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list);
        keywordView = (EditText)findViewById(R.id.edit_keyword);
        listView = (ListView)findViewById(R.id.listView);

        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(mAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String text = (String)listView.getItemAtPosition(i);
                Toast.makeText(SimpleListActivity.this, "item : " + text, Toast.LENGTH_SHORT).show();
            }
        });

        Button btn = (Button)findViewById(R.id.bth_add);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = keywordView.getText().toString();
                if(text != null && !text.equals("")){
                    mAdapter.add(text);
                    keywordView.setText("");
                    listView.smoothScrollToPosition(mAdapter.getCount()-1);
                }
            }
        });

        initData();



    }

    private void initData() {
        String[] items = getResources().getStringArray(R.array.items);
        mAdapter.addAll(items);
    }
}
