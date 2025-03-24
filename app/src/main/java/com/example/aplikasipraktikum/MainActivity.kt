package com.example.aplikasipraktikum

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Find views
        val emailInput = findViewById<EditText>(R.id.emailInput)
        val passwordInput = findViewById<EditText>(R.id.passwordInput)
        val loginButton = findViewById<Button>(R.id.loginButton)

        // Set click listener for login button
        loginButton.setOnClickListener {
            // Get input values
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            // Validation
            when {
                email.isEmpty() || password.isEmpty() -> {
                    Toast.makeText(this, "Email or password cannot be empty", Toast.LENGTH_SHORT).show()
                }
                email == "dimas@gmail.com" && password == "235150707111052" -> {
                    Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Toast.makeText(this, "Login failed: Invalid email or password", Toast.LENGTH_SHORT).show()
                }
            }
        }

        // Handle window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
