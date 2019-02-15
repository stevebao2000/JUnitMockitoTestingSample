package com.steve.JUnitMockitoTest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ProcessLogin login;
    RemoteService service;
    EditText txtName, txtPassword;
    TextView txtMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtName = (EditText)findViewById(R.id.name);
        txtPassword = (EditText)findViewById(R.id.password);
        txtMessage = (TextView) findViewById(R.id.message);

        service = new RemoteService();
        login = new ProcessLogin(service);
    }

    public void onClickLogin(View view) {
        if (login.UserLogin(txtName.getText().toString(), txtPassword.getText().toString())) {
            txtMessage.setText("Login Successfully.");
        } else
            txtMessage.setText("Login Failed");

    }
}
