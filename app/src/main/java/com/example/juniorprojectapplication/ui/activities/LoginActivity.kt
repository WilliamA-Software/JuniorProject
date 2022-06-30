package com.example.juniorprojectapplication.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.juniorprojectapplication.UserProvider
import com.example.juniorprojectapplication.databinding.ActivityLoginBinding
import com.example.juniorprojectapplication.ui.viewmodels.LoginViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityLoginBinding
    private val loginViewModel : LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.btnLogin.setOnClickListener {
            val intent = Intent(this, PrincipalActivity::class.java)
            intent.putExtra("username", mBinding.etUsername.text.toString().trim())
            startActivity(intent)
        }
    }

}