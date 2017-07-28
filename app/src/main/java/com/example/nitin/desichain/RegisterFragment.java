package com.example.nitin.desichain;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class RegisterFragment extends Fragment {

    private EditText editName, editEmail, editPassword, editNumber;
    private Button mRegister;


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
        String name = editName.getText().toString();
        String email = editEmail.getText().toString();
        String pwd = editPassword.getText().toString();
        String number = editNumber.getText().toString();

        if (name.equals("") ||email.equals("")|| pwd.equals("")|| number.equals("")){
            mRegister.setEnabled(false);
        }
        else {
            mRegister.setEnabled(true);
            mRegister.setBackgroundColor(getResources().getColor(R.color.green));
            mRegister.setTextColor(Color.WHITE);
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

}
