package com.example.baitaptuan1


import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.widget.*
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.customdialog.view.*


class Profile : Login() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

//        val tveditprofile = findViewById<TextView>(R.id.tveditprofile)
//        val txtName = findViewById<TextView>(R.id.txtName)
//        val tvcontentfullname = findViewById<TextView>(R.id.tvcontentfullname)
//        val tvcontentemail = findViewById<TextView>(R.id.tvcontentemail)
//        val tvContentPhoneNumber = findViewById<TextView>(R.id.tvContentPhoneNumber)
//        val dialogLoginBtn=findViewById<Button>(R.id.dialogLoginBtn)

        //button click to show dialog
        tveditprofile.setOnClickListener {
            //Inflate the dialog with custom view
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.customdialog, null)
            //AlertDialogBuilder
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("Edit Profile")
            //show dialog
            val  mAlertDialog = mBuilder.show()
            //login button click of custom layout
            mDialogView.dialogLoginBtn.setOnClickListener {
                //dismiss dialog
                mAlertDialog.dismiss()
                //get text from EditTexts of custom layout
                val name = mDialogView.dialogNameEt.text.toString()
                val email = mDialogView.dialogEmailEt.text.toString()
                val password = mDialogView.dialogPasswEt.text.toString()
                //set the input text in TextView
             //   mainInfoTv.setText("Name:"+ name +"\nEmail: "+ email +"\nPassword: "+ password)
                txtName.setText(name)
                tvcontentfullname.setText(name)
                tvcontentemail.setText(email)
                tvContentPhoneNumber.setText(password)

            }
            //cancel button click of custom layout
            mDialogView.dialogCancelBtn.setOnClickListener {
                //dismiss dialog
                mAlertDialog.dismiss()
            }
        }
        backProfile.setOnClickListener{

            val intent=Intent(this,Login::class.java)
            startActivity(intent)
        }


    }
}