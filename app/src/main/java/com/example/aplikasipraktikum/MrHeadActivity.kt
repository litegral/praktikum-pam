package com.example.aplikasipraktikum

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MrHeadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mr_head)

        // Apply insets properly
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mr_head)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize views
        val face: ImageView = findViewById(R.id.face)
        val hair: ImageView = findViewById(R.id.hair)
        val eyebrows: ImageView = findViewById(R.id.eyebrows)
        val eyes: ImageView = findViewById(R.id.eyes)
        val mustache: ImageView = findViewById(R.id.mustache)
        val mouth: ImageView = findViewById(R.id.mouth)

        val checkFace: CheckBox = findViewById(R.id.check_face)
        val checkHair: CheckBox = findViewById(R.id.check_hair)
        val checkEyebrows: CheckBox = findViewById(R.id.check_eyebrows)
        val checkEyes: CheckBox = findViewById(R.id.check_eyes)
        val checkMustache: CheckBox = findViewById(R.id.check_mustache)
        val checkMouth: CheckBox = findViewById(R.id.check_mouth)

        // Set listeners
        checkFace.setOnCheckedChangeListener { _, isChecked ->
            face.visibility = if (isChecked) View.VISIBLE else View.INVISIBLE
        }
        checkHair.setOnCheckedChangeListener { _, isChecked ->
            hair.visibility = if (isChecked) View.VISIBLE else View.INVISIBLE
        }
        checkEyebrows.setOnCheckedChangeListener { _, isChecked ->
            eyebrows.visibility = if (isChecked) View.VISIBLE else View.INVISIBLE
        }
        checkEyes.setOnCheckedChangeListener { _, isChecked ->
            eyes.visibility = if (isChecked) View.VISIBLE else View.INVISIBLE
        }
        checkMustache.setOnCheckedChangeListener { _, isChecked ->
            mustache.visibility = if (isChecked) View.VISIBLE else View.INVISIBLE
        }
        checkMouth.setOnCheckedChangeListener { _, isChecked ->
            mouth.visibility = if (isChecked) View.VISIBLE else View.INVISIBLE
        }

        // Get intent extras
        val email = intent.getStringExtra("EMAIL")
        val password = intent.getStringExtra("PASSWORD")

        // Find TextView
        val emailTextView = findViewById<TextView>(R.id.text_username)
        val passwordTextView = findViewById<TextView>(R.id.text_password)

        // Display received data
        emailTextView.text = "Email: $email"
        passwordTextView.text = "Password: $password"

        // Contact Us Button Intent
        val contactUsButton: Button = findViewById(R.id.button_contact_us)
        contactUsButton.setOnClickListener {
            val intent = Intent(this, ContactUsActivity::class.java)
            startActivity(intent)
        }
    }
}
