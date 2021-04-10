package com.example.baitaptuan1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.isEmpty
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.btLogin
import kotlinx.android.synthetic.main.activity_login.etPasswordSignUp
import kotlinx.android.synthetic.main.activity_login.tvSignInSignUp
import kotlinx.android.synthetic.main.activity_sign_up.*

open class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
//        val edEmailLogin = findViewById<EditText>(R.id.edEmailLogin)
//        val etPasswordLogin = findViewById<EditText>(R.id.etPasswordLogin)
//        val btLogin = findViewById<ImageButton>(R.id.btLogin)

        btLogin.setOnClickListener {
            var email: String = etEmailignUp.text.toString()
            var password: String = etPasswordSignUp.text.toString()



            if (isEmpty(email)) {
                etEmailignUp.setError("Enter your email, Please!!!");
            }
            if (isEmpty(password)) {
                etPasswordSignUp.setError("Enter your password, Please!!!");
            }

///
            if (!isEmpty(email) && !isEmpty(password)) {
                if (email.equals("ronaldo@gmail.com") && password.equals("123456")) {
                    Toast.makeText(this, "Login complete", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, Profile::class.java)
//                intent.putExtra( "Email", email)
                    startActivity(intent)
                } else {
                    val mAlertDialog = AlertDialog.Builder(this)
                    mAlertDialog.setIcon(R.drawable.iconnotifi) //set alertdialog icon
                    mAlertDialog.setTitle("Notification!") //set alertdialog title
                    mAlertDialog.setMessage("Your email or password are wronged\n Enter again, please!") //set alertdialog message
                    mAlertDialog.setPositiveButton("Try again") { dialog, id ->
                        //perform some tasks here
                        //   Toast.makeText(this@MainActivity, "Yes", Toast.LENGTH_SHORT).show()
                        etEmailignUp.setText("")
                        etPasswordSignUp.setText("")


                    }
                    mAlertDialog.setNegativeButton("Don’t have an account?") { dialog, id ->
                        //perform som tasks here
                        //     Toast.makeText(this@MainActivity, "No", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, SignUp::class.java)
                        intent.putExtra("Email", email)
                        intent.putExtra("password", password)

                        startActivity(intent)

                    }
                    mAlertDialog.show()
                }
                //   Toast.makeText(this, "dang nhap that bai", Toast.LENGTH_LONG).show()
            }
        }









        tvSignInSignUp.setOnClickListener {

            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
        backLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}