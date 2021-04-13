package com.example.baitaptuan1


import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.widget.*
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.baitaptuan1.databinding.ActivityProfileBinding
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.customdialog.view.*


class Profile : Login() {
private  lateinit var  binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_profile)

        val bundle=intent.extras
        bundle?.let {
            val emailOrgi=bundle.getString("email","unknow")
            val fullNameOrgi=bundle.getString("fullName","unknow")
            val passwordOrgi=bundle.getString("passWord","unknow")



            loginViewModel.getLoginDetails(context,emailOrgi,passwordOrgi)!!.observe(this, Observer {

                binding.account= Account(it.Email,it.FullName,it.Password)


            })
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
//------------------------------
                    loginViewModel.getLoginDetails(context,emailOrgi,passwordOrgi)!!.observe(this, Observer {
                       it.Email=email
                       it.FullName=name

                    })



                    //--------------------------
                    //set the input text in TextView
                    //   mainInfoTv.setText("Name:"+ name +"\nEmail: "+ email +"\nPassword: "+ password)
                    txtName.setText(name)
                    tvcontentfullname.setText(name)
                    tvcontentemail.setText(email)
                    tvContentPhoneNumber.setText(password)
                //    binding.invalidateAll()

                }
                //cancel button click of custom layout
                mDialogView.dialogCancelBtn.setOnClickListener {
                    //dismiss dialog
                    mAlertDialog.dismiss()
                }
            }
        }








  //      if (it == null) {
//                    tvcontentfullname.text = "Data Not Found"
//                    tvcontentemail.text = "- - -"
//                    tvContentPhoneNumber.text = "- - -"
//                }
//                else {
//                    tvcontentfullname.text = it.FullName
//                    tvcontentemail.text = it.Email
//
//                    tvContentPhoneNumber.text = "Data Found Successfully"
//                }

        backProfile.setOnClickListener{

            val intent=Intent(this,Login::class.java)
            startActivity(intent)
        }


    }
}