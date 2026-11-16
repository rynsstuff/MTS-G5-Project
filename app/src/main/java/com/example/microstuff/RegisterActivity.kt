package com.example.microstuff

import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tilName = findViewById<TextInputLayout>(R.id.tilName)
        val tilEmail = findViewById<TextInputLayout>(R.id.tilEmail)
        val tilPass = findViewById<TextInputLayout>(R.id.tilPass)
        val tilConfirm = findViewById<TextInputLayout>(R.id.tilConfirm)

        val inName = findViewById<TextInputEditText>(R.id.inName)
        val inEmail = findViewById<TextInputEditText>(R.id.inEmail)
        val inPass = findViewById<TextInputEditText>(R.id.inPass)
        val inConfirm = findViewById<TextInputEditText>(R.id.inConfirm)

        findViewById<MaterialButton>(R.id.btnRegister).setOnClickListener {
            val name = inName.text.toString().trim()
            val email = inEmail.text.toString().trim()
            val password = inPass.text.toString()
            val confirm = inConfirm.text.toString()

            tilName.error = if(name.isEmpty()) "Nama lengkap wajib diisi" else null

            tilEmail.error = when{
                email.isEmpty() -> "Email wajib diisi"
                !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> "Format email tidak valid" else -> null
            }

            tilPass.error = when{
                password.isEmpty() -> "Password wajib diisi"
                password.length < 6 -> "Password minimal 6 karakter" else -> null
            }

            tilConfirm.error = when{
                confirm.isEmpty() -> "Konfirmasi password wajib diisi"
                confirm != password -> "Konfirmasi password tidak sama" else -> null
            }

            val valid = listOf(tilName, tilEmail, tilPass, tilConfirm).all {it.error == null}
            if (valid){
                Toast.makeText(this, "Registrasi berhasil xxx", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
        findViewById<View>(R.id.login).setOnClickListener {finish()}
    }
}