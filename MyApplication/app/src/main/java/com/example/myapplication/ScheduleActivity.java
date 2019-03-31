package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication.model.ScheduleDTO;
import com.example.myapplication.model.UserDTO;
import com.google.gson.Gson;

import java.util.List;

public class ScheduleActivity extends AppCompatActivity {

    TextView name;
    ListView schedule;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        anhXa();

        Intent intent=getIntent();
        Bundle bundle=intent.getBundleExtra("bundle");
        UserDTO userDTO = (UserDTO) new Gson().fromJson(bundle.getString("user").toString(), UserDTO.class);

        name.setText("Xin chào "+userDTO.getName());

        List<ScheduleDTO> scheduleDTOS=userDTO.getScheduleDTOs();

//        Log.i("name",scheduleDTOS.get(0).getAddress());
        CustomAdapter customAdapter=new CustomAdapter(this,R.layout.item_schedule,scheduleDTOS);
        schedule.setAdapter(customAdapter);

    }
    public void anhXa(){
        name=(TextView) findViewById(R.id.textView2);
        schedule=(ListView) findViewById(R.id.listView);
    }
}
