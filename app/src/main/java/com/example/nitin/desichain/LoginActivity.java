package com.example.nitin.desichain;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nitin.desichain.Contents.LoginData;
import com.example.nitin.desichain.Internet.FetchingFromUrl;
import com.example.nitin.desichain.ParsingJson.LoginParse;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class LoginActivity extends AppCompatActivity {

    private Button forgotPwdBtn,registerAccBtn;
    private ForgotPassword forgotPassword = new ForgotPassword();
    private RegisterFragment registerFragment;
    private FrameLayout frameLayout;
    private ImageView logoImage;
    private ImageButton mSignInImg;
    private ArrayList<LoginData> LOGIN_CONTENT_LIST;
    private String JSON_RESPONSE, email, password;
    private EditText editEmail,editPassword;
    private TextView mSkipLogin;

    private FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editEmail=(EditText)findViewById(R.id.editTextEmail);
        editPassword=(EditText)findViewById(R.id.editTextPassword);
        mSignInImg=(ImageButton)findViewById(R.id.img_sign_in_button);
        frameLayout=(FrameLayout)findViewById(R.id.frameLayout2);
        logoImage=(ImageView)findViewById(R.id.desichainLogo);
        mSkipLogin = (TextView)findViewById(R.id.skipLogin);
        forgotPwdBtn=(Button)findViewById(R.id.btn_reset_password_main);
        forgotPwdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fm=getSupportFragmentManager();
                fm.beginTransaction().add(R.id.framePassword,forgotPassword).commit();
             //   logoImage.setVisibility(View.GONE);
                frameLayout.setVisibility(View.GONE);
            }
        });

        mSignInImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editEmail.getText().toString().equals("")){
                    editEmail.setError("please enter email");
                }
                else if (editPassword.getText().toString().equals("")){
                    editPassword.setError("please enter password");

                }
                else if (!editEmail.getText().toString().equals("") && !editPassword.getText().toString().equals("")){
//                    Toast.makeText(getApplicationContext(),"sign in logic",Toast.LENGTH_SHORT).show();
                    email = editEmail.getText().toString();
                    password = editPassword.getText().toString();
                    JSON_RESPONSE = load("http://dc.desichain.in/DesiChainWeService.asmx/login?loginid="
                            +email+"&password="+password);
                    if (JSON_RESPONSE != null && ! JSON_RESPONSE.contains("invalid argument")) {
//                        LOGIN_CONTENT_LIST = new LoginParse(JSON_RESPONSE, LoginActivity.this).parsingLogin();
                        Toast.makeText(LoginActivity.this, "Successfull login", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.putExtra("emailId",email);
                        intent.putExtra("password",password);
                        SharedPreferences sharedPreferences = getSharedPreferences("myPref",MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("emailId",email);
                        editor.putString("password",password);
                        editor.apply();
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(LoginActivity.this, "Invalid username and password", Toast.LENGTH_SHORT).show();
                    }
                }
           }
        });

        registerAccBtn=(Button)findViewById(R.id.sign_up_button);
        registerAccBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerFragment = new RegisterFragment(LoginActivity.this);
                fm = getSupportFragmentManager();
                fm.beginTransaction().replace(R.id.framePassword,registerFragment).commit();
               // logoImage.setVisibility(View.GONE);
                frameLayout.setVisibility(View.GONE);

            }
        });

        mSkipLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
            }
        });
    }
    public String load(String url) {
        try {
            JSON_RESPONSE = new FetchingFromUrl().execute(url).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return JSON_RESPONSE;

    }
}
