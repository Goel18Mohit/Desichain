package com.example.nitin.desichain;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private Button forgotPwdBtn,registerAccBtn;
    private ForgotPassword forgotPassword = new ForgotPassword();
    private RegisterFragment registerFragment = new RegisterFragment();
    private FrameLayout frameLayout;
    private ImageView logoImage;
    private ImageButton mSignInImg;
    private EditText editEmail,editPassword;

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
                    Toast.makeText(getApplicationContext(),"sign in logic",Toast.LENGTH_SHORT).show();
                }
            }
        });

        registerAccBtn=(Button)findViewById(R.id.sign_up_button);
        registerAccBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm = getSupportFragmentManager();
                fm.beginTransaction().replace(R.id.framePassword,registerFragment).commit();
               // logoImage.setVisibility(View.GONE);
                frameLayout.setVisibility(View.GONE);

            }
        });



    }
}
