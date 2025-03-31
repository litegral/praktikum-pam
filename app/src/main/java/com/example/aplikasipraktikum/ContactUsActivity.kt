package com.example.aplikasipraktikum

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ContactUsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contact_us)

        // Phone Call Intent
        findViewById<Button>(R.id.btn_call).setOnClickListener {
            val phoneNumber = "+6285754550557"
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$phoneNumber")
            startActivity(intent)
        }

        // Email Intent
        findViewById<Button>(R.id.btn_email).setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:dimasandrian@student.ub.ac.id")
                putExtra(Intent.EXTRA_SUBJECT, "Customer Inquiry")
            }
            startActivity(Intent.createChooser(emailIntent, "Send email using..."))
        }

        // WhatsApp Intent
        findViewById<Button>(R.id.btn_whatsapp).setOnClickListener {
            val phoneNumber = "+6285754550557"
            val message = "Hello, I need assistance with..."

            // Create the intent
            try {
                val whatsappIntent = Intent(Intent.ACTION_VIEW)
                val url = "https://api.whatsapp.com/send?phone=$phoneNumber&text=${Uri.encode(message)}"
                whatsappIntent.data = Uri.parse(url)
                startActivity(whatsappIntent)
            } catch (e: Exception) {
                // WhatsApp not installed, show error or fallback
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("https://play.google.com/store/apps/details?id=com.whatsapp")
                startActivity(intent)
            }
        }

        // Website Intent
        findViewById<Button>(R.id.btn_website).setOnClickListener {
            val webpage = Uri.parse("https://www.example.com")
            val intent = Intent(Intent.ACTION_VIEW, webpage)
            startActivity(intent)
        }
    }
}
