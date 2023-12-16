package com.sangvaleap.foodiepal_culinarycompanion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.gson.Gson
import com.sangvaleap.foodiepal_culinarycompanion.databinding.ActivityRegisterBinding
import com.sangvaleap.foodiepal_culinarycompanion.model.User
import com.sangvaleap.foodiepal_culinarycompanion.utils.AppConstants

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener { onCreateAccount() }
    }

    private fun onCreateAccount(){
        if(!validateForm()){
            return
        }
        if(!validateForm()){
            Toast.makeText(this, "Please fill all required fields", Toast.LENGTH_LONG).show()
        }else{
            val fName = binding.etEmail.text.trim().toString()
            val lName =  binding.etPassword.text.trim().toString()
            val email = binding.etEmail.text.trim().toString()
            val password =  binding.etPassword.text.trim().toString()
            val user = User(fName, lName, email, password)

            onSaveUserPreference(user)
            Toast.makeText(this, "New account is created successfully", Toast.LENGTH_SHORT).show()
            goToLogin()
        }
    }

    private fun goToLogin(){
        var intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    private fun onSaveUserPreference(user: User){
        val prefs = getSharedPreferences(AppConstants.USER_PREFERENCE, MODE_PRIVATE)
        val userJson = Gson().toJson(user);
        prefs.edit().putString("user", userJson).apply()
    }

    private fun validateForm(): Boolean{
        val fName = binding.etEmail.text.trim().toString()
        val lName =  binding.etPassword.text.trim().toString()
        val email = binding.etEmail.text.trim().toString()
        val password =  binding.etPassword.text.trim().toString()
        if(fName.isEmpty()){
            Toast.makeText(this, "Please enter your first name", Toast.LENGTH_SHORT).show()
            return false
        }else if(lName.isEmpty()){
            Toast.makeText(this, "Please enter last name", Toast.LENGTH_SHORT).show()
            return false
        }else if(email.isEmpty()){
            Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show()
            return false
        }else if(password.isEmpty()){
            Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }


}