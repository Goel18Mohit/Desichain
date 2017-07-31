package com.example.nitin.desichain;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nitin.desichain.Internet.FetchingFromUrl;
import com.example.nitin.desichain.ParsingJson.GetSnoOfNewCustome;

import java.util.concurrent.ExecutionException;


public class RegisterFragment extends Fragment {

    private EditText editName, editEmail, editPassword, editNumber;
    private Button mRegister;
    private String  JSON_RESPONSE;
    private Context mContext;
    private String SNO;
    public RegisterFragment(Context mContext) {
        this.mContext = mContext;
    }

    private TextWatcher mTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            checkForEmptyValues();
        }
    };

    private void checkForEmptyValues() {
        final String name = editName.getText().toString();
        final String email = editEmail.getText().toString();
        String pwd = editPassword.getText().toString();
        final String number = editNumber.getText().toString();

        if (name.equals("") ||email.equals("")|| pwd.equals("")|| number.equals("")){
            mRegister.setEnabled(false);
        }
        else {
            mRegister.setEnabled(true);
            mRegister.setBackgroundColor(getResources().getColor(R.color.green));
            mRegister.setTextColor(Color.WHITE);
            mRegister.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    JSON_RESPONSE=load("http://dc.desichain.in/DesiChainWeService.asmx/Register?"+"Name="+name+"&"+"Emailid="+email+"&"+"Password="+number);
                    if(JSON_RESPONSE.contains("Mail Id Already exist."))
                    {
                        Toast.makeText(mContext,"Mail Id Already exist.",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        if(JSON_RESPONSE!=null) {
                            SNO=new GetSnoOfNewCustome(JSON_RESPONSE,mContext).getSno();
                            Intent intent = new Intent(mContext, MainActivity.class);
                            intent.putExtra("CALLINGFROMREGISTERACTIVITY","CALLINGFROMREGISTERACTIVITY");
                            intent.putExtra("SNO",SNO);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(mContext,"Something Went Wrong",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });

        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_register, container, false);
        editName = (EditText) view.findViewById(R.id.editTextName);
        editEmail = (EditText) view.findViewById(R.id.editTextEmail);
        editPassword = (EditText) view.findViewById(R.id.editTextPassword);
        editNumber = (EditText) view.findViewById(R.id.editTextMobile);
        mRegister = (Button) view.findViewById(R.id.mRegisterBtn);



        editName.addTextChangedListener(mTextWatcher);
        editEmail.addTextChangedListener(mTextWatcher);
        editPassword.addTextChangedListener(mTextWatcher);
        editNumber.addTextChangedListener(mTextWatcher);


//        editEmail.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//                if (s.toString().trim().length()>0 && !email.equals("") && !pwd.equals("") && !number.equals("")){
//                    mRegister.setEnabled(true);
//                }
//                else {
//                    mRegister.setEnabled(false);
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//            }
//        });
//
//        editName.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });


        return view;
    }
    public String load(String Url) {
        try {
            JSON_RESPONSE = new FetchingFromUrl().execute(Url).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return JSON_RESPONSE;

    }

}
