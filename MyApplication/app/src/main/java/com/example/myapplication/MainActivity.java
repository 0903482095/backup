package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.model.UserDTO;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText username,password;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallRest();
            }
        });

    }

    public void CallRest() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://192.168.6.106:8080/login";

        JsonObjectRequest objectRequest = null;
        UserDTO user=new UserDTO(username.getText().toString().trim(),password.getText().toString().trim());

        try {
            objectRequest = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(new Gson().toJson(user)),
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            UserDTO userDTO = (UserDTO) new Gson().fromJson(response.toString(), UserDTO.class);
                            Intent intent=new Intent(MainActivity.this,ScheduleActivity.class);

                            Bundle bundle=new Bundle();
                            bundle.putString("user",response.toString());
                            intent.putExtra("bundle",bundle);

                            startActivity(intent);
                            Log.i("aaaaaa",response.toString());
                            Toast.makeText(MainActivity.this,"Đăng nhập thành công",LENGTH_SHORT).show();
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(MainActivity.this,"Đăng nhập thất bại",LENGTH_SHORT).show();
                }
            }
            );
        } catch (JSONException e) {
            e.printStackTrace();
        }
        queue.add(objectRequest);
    }
    public void anhXa(){
        username=(EditText) findViewById(R.id.editText);
        password=(EditText) findViewById(R.id.editText2);
        btn=(Button) findViewById(R.id.button);
        textView=(TextView) findViewById(R.id.textView);
    }
}
