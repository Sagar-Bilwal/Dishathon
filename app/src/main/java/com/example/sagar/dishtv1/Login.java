package com.example.sagar.dishtv1;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.example.sagar.dishtv.R;
import com.rengwuxian.materialedittext.MaterialEditText;

import dmax.dialog.SpotsDialog;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Login extends AppCompatActivity {

    Button btnRegister,btnSignIn;
    ConstraintLayout constraintLayout;
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder().setDefaultFontPath("fonts/Lobster_1.3.otf").setFontAttrId(R.attr.fontPath).build());
        setContentView(R.layout.activity_login);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        btnRegister=findViewById(R.id.btnRegister);
        btnSignIn=findViewById(R.id.btnSignIn);
        constraintLayout=findViewById(R.id.partnerLayout);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRegisterDialog();
            }
        });
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSignInDialog();
            }
        });
    }
    MaterialEditText signPhoneNo,signPassword;
    private void showSignInDialog()
    {
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setTitle("Sign In");
        dialog.setMessage("Please use Phone No. to Sign In");

        LayoutInflater layoutInflater=LayoutInflater.from(this);
        final View sign_in_layout=layoutInflater.inflate(R.layout.activity_sign_in,null);
        signPhoneNo=sign_in_layout.findViewById(R.id.signInEmail);
        signPassword=sign_in_layout.findViewById(R.id.signInPassword);
        dialog.setView(sign_in_layout);
        dialog.setPositiveButton("Sign In", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.dismiss();
                btnSignIn.setEnabled(false);
                if(TextUtils.isEmpty(signPhoneNo.getText().toString()))
                {
                    Snackbar.make(constraintLayout,"Please Enter Your Registered Phone No.",Snackbar.LENGTH_LONG).show();
                    return;
                }
                else if(TextUtils.isEmpty(signPassword.getText().toString()))
                {
                    Snackbar.make(constraintLayout,"Please Enter the Password",Snackbar.LENGTH_LONG).show();
                    return;
                }
                else if(signPassword.getText().toString().length()<8)
                {
                    Snackbar.make(constraintLayout,"The Password is too Short",Snackbar.LENGTH_LONG).show();
                    return;
                }
                else
                {
                    final SpotsDialog alertDialog=new SpotsDialog(Login.this);
                    alertDialog.show();
                    Snackbar.make(constraintLayout,"Successfully SignIn",Snackbar.LENGTH_LONG).show();
                    startActivity(new Intent(Login.this,MainActivity.class));
                    return;
                }
            }
        });
        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    MaterialEditText regPassword,regName,regPhoneNo;
    private void showRegisterDialog()
    {
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setTitle("Register");
        dialog.setMessage("Please use Phone No. to Register");

        LayoutInflater layoutInflater=LayoutInflater.from(this);
        final View register_layout=layoutInflater.inflate(R.layout.activity_register,null);
        regPassword=register_layout.findViewById(R.id.regPassword);
        regName=register_layout.findViewById(R.id.regName);
        regPhoneNo=register_layout.findViewById(R.id.regPhoneNo);
        dialog.setView(register_layout);
        dialog.setPositiveButton("Register", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.dismiss();
                if(TextUtils.isEmpty(regPassword.getText().toString()))
                {
                    Snackbar.make(constraintLayout,"Please Enter the Password",Snackbar.LENGTH_LONG).show();
                    return;
                }
                else if(TextUtils.isEmpty(regName.getText().toString()))
                {
                    Snackbar.make(constraintLayout,"Please Enter Your Name",Snackbar.LENGTH_LONG).show();
                    return;
                }
                else if(TextUtils.isEmpty(regPhoneNo.getText().toString()))
                {
                    Snackbar.make(constraintLayout,"Please Enter Your Phone No.",Snackbar.LENGTH_LONG).show();
                    return;
                }
                else if(regPassword.getText().toString().length()<8)
                {
                    Snackbar.make(constraintLayout,"The Password is too Short",Snackbar.LENGTH_LONG).show();
                    return;
                }
                else if(regPhoneNo.getText().toString().length()!=10)
                {
                    Snackbar.make(constraintLayout,"Please Enter Correct Phone No.",Snackbar.LENGTH_LONG).show();
                    return;
                }
                else
                {
                    return;
                }
            }
        });
        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}