package com.example.microstuff

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tilEmail = findViewById<TextInputLayout>(R.id.tilEmail)
        val tilPass = findViewById<TextInputLayout>(R.id.tilPass)
        val inEmail = tilEmail.findViewById<TextInputEditText>(R.id.inEmail)
        val inPass = tilPass.findViewById<TextInputEditText>(R.id.inPass)

        findViewById<MaterialButton>(R.id.btnLogin).setOnClickListener {
            val email = inEmail.text.toString().trim()
            val password = inPass.text.toString()

            tilEmail.error = if(email.isEmpty()) "Email atau username wajib diisi" else null
            tilPass.error = if(password.isEmpty()) "Password wajib diisi" else null

            if (email.isNotEmpty() && password.isNotEmpty()){
                Toast.makeText(this, "Login berhasil xxx", Toast.LENGTH_SHORT).show()
            }
        }

        findViewById<MaterialButton>(R.id.btnGoogle).setOnClickListener {
            Toast.makeText(this, "Login Google", Toast.LENGTH_SHORT).show()
        }
        findViewById<android.view.View>(R.id.passForgot).setOnClickListener {
            Toast.makeText(this, "Lupa kata sandi", Toast.LENGTH_SHORT).show()
        }
        findViewById<android.view.View>(R.id.register).setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}