package com.example.project.user;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.project.MyDatabaseHelper;
import com.example.project.R;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {

    EditText ufirstname, ulastname, uemail, upassword, uconfpassword, ucontactno;
    Button btnRegister;
    TextInputLayout userFirstNameWrapper, userLastNameWrapper, userEmailWrapper, userPasswordWrapper,
            userConfPasswordWrapper, userContactNoWrapper;
    MyDatabaseHelper dbHelper = new MyDatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ragister);

        ufirstname = findViewById(R.id.userFirstName);
        ulastname = findViewById(R.id.userLastName);
        uemail = findViewById(R.id.userEmailAddress);
        upassword = findViewById(R.id.userPassword);
        uconfpassword = findViewById(R.id.userConfPassword);
        ucontactno = findViewById(R.id.userContactNumber);

        userFirstNameWrapper = findViewById(R.id.userFirstNameWrapper);
        userLastNameWrapper = findViewById(R.id.userlastNameWrapper);
        userEmailWrapper = findViewById(R.id.userEmailAddressWrapper);
        userPasswordWrapper = findViewById(R.id.userPasswordWrapper);
        userConfPasswordWrapper = findViewById(R.id.userConfPasswordWrapper);
        userContactNoWrapper = findViewById(R.id.userContactNoWrapper);

        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstname = ufirstname.getText().toString().trim();
                String lastname = ulastname.getText().toString().trim();
                String email = uemail.getText().toString().trim();
                String password = upassword.getText().toString().trim();
                String confpassword = uconfpassword.getText().toString().trim();
                String contactno = ucontactno.getText().toString().trim();

                if(firstname.isEmpty()){
                    userFirstNameWrapper.setError("Enter Firstname");
                    userFirstNameWrapper.requestFocus();
                    return;
                }

                if(lastname.isEmpty()){
                    userLastNameWrapper.setError("Enter Lastname");
                    userLastNameWrapper.requestFocus();
                    return;
                }

                if(email.isEmpty()){
                    userEmailWrapper.setError("Enter Email");
                    userEmailWrapper.requestFocus();
                    return;
                }

                if(password.isEmpty()){
                    userPasswordWrapper.setError("Enter Password");
                    userPasswordWrapper.requestFocus();
                    return;
                }

                if(confpassword.isEmpty()){
                    userConfPasswordWrapper.setError("Enter Confirm Password");
                    userConfPasswordWrapper.requestFocus();
                    return;
                }

                if(!password.equals(confpassword)){
                    userConfPasswordWrapper.setError("Password didn't match");
                    userConfPasswordWrapper.requestFocus();
                    return;
                }

                if(contactno.isEmpty()){
                    userContactNoWrapper.setError("Enter Lastname");
                    userContactNoWrapper.requestFocus();
                    return;
                }

                User user = new User(firstname, lastname, email, confpassword, contactno);
                long result = dbHelper.insertUser(user);

                if (result != -1){
                    //ghi thanh cong
                } else{
                    //trg hop that bai
                }
            }
        });

    }

}