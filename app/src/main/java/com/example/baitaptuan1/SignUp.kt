package com.example.baitaptuan1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer
import com.example.baitaptuan1.R
import android.widget.Toast

import com.example.baitaptuan1.databinding.ActivitySignUpBinding
import kotlinx.android.synthetic.main.activity_sign_up.*
import com.example.baitaptuan1.LoginViewModel

class SignUp : AppCompatActivity() {
    private lateinit var bindingSignUp : ActivitySignUpBinding
    lateinit var loginViewModel: LoginViewModel
    lateinit var context: Context
    lateinit var email: String
    lateinit var password: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        bindingSignUp = DataBindingUtil.setContentView(this,R.layout.activity_sign_up)


        context = this@SignUp

        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
                   bindingSignUp.btLogin.setOnClickListener{
                       email = bindingSignUp.etEmailSignUp.text.toString().trim()
                       password = bindingSignUp.etPasswordSignup.text.toString().trim()
               if (password.isEmpty()) {
                   bindingSignUp.etPasswordSignup.error = "Please enter the username"
               }
               else if (email.isEmpty()) {
                   bindingSignUp.etEmailSignUp.error = "Please enter the username"
               }
               else {
                   loginViewModel.insertData(context, email, password)
                   Toast.makeText(this, "Login complete", Toast.LENGTH_LONG).show()
//                   val intent = Intent(this,Login::class.java)
//                   startActivity(intent)
               }

           }



        bindingSignUp.tvSignInSignUp.setOnClickListener{
            val intent= Intent(this,Login::class.java)
            startActivity(intent)
        }

    }
}