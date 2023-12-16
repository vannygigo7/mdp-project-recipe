package com.sangvaleap.foodiepal_culinarycompanion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.gson.Gson
import com.sangvaleap.foodiepal_culinarycompanion.databinding.ActivityLoginBinding
import com.sangvaleap.foodiepal_culinarycompanion.model.User
import com.sangvaleap.foodiepal_culinarycompanion.utils.AppConstants

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private var userList = arrayListOf(
        User("John", "Doe", "john.doe@test.com", "123"),
        User("Jane", "Doe", "jane.doe@test.com", "123"),
        User("Bob", "Smith", "bob.smith@test.com", "123"),
        User("Test", "User", "test@test.com", "123"),
        User("Nani", "Luis", "nani.lius@test.com", "123"),
        User("Kaka", "Ricardo", "kaka.r@test.com", "123")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener { onLogin() }
        binding.btnRegister.setOnClickListener { onRegister() }
    }

    private fun onRegister(){
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    private fun onLogin(){
        val email = binding.etEmail.text.toString()
        val password =  binding.etPassword.text.toString()
        if(!validateForm(email, password)){
            return
        }

        val user = findUser()
        if(user == null){
            Toast.makeText(this, "User doesn't exist", Toast.LENGTH_LONG).show()
        }else if( validateUser(user, email, password)){
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("user", user)
            startActivity(intent)
        }else{
            Toast.makeText(this, "Email or password is incorrect", Toast.LENGTH_LONG).show()
        }
    }

    private fun validateForm(email: String, password: String): Boolean{
        if(email.isEmpty()){
            Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show()
            return false
        }else if(password.isEmpty()){
            Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    private fun readUserPreference() : String?{
        val prefs = getSharedPreferences(AppConstants.USER_PREFERENCE, MODE_PRIVATE)
        return prefs.getString(AppConstants.USER, null)
    }

    private fun findUser(): User?{
        val userJson = readUserPreference()
        return if(userJson != null) Gson().fromJson(userJson, User::class.java) else null;
    }

    private fun validateUser(user: User, email: String, password: String): Boolean{
        return user.username == email && user.password == password
    }
}