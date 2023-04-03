package com.example.playlistmaker

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton



class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val backButton = findViewById<ImageButton>(R.id.back_button)
        val shareAppButton = findViewById<ImageButton>(R.id.shareAppButton)
        val contactSupportButton = findViewById<ImageButton>(R.id.contactSupportButton)
        val userAgreementButton = findViewById<ImageButton>(R.id.UserAgreementButton)


        backButton.setOnClickListener {
            finish()
        }

        shareAppButton.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.setType("text/plain")
            shareIntent.putExtra(Intent.EXTRA_TEXT, this.getString(R.string.android_course_url))
            startActivity(Intent.createChooser(shareIntent, "Share"))
        }

        contactSupportButton.setOnClickListener {
            val supportIntent = Intent(Intent.ACTION_SENDTO)
            supportIntent.data = Uri.parse("mailto:")
            supportIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("nikshg@outlook.com"))
            supportIntent.putExtra(
                Intent.EXTRA_SUBJECT,
                this.getString(R.string.contact_support_email_topic)
            )
            supportIntent.putExtra(
                Intent.EXTRA_TEXT,
                this.getString(R.string.contact_support_email_body)
            )
            startActivity(supportIntent)
        }
        userAgreementButton.setOnClickListener {
            val agreementUrl = "https://yandex.ru/legal/practicum_offer/"
            val agreementIntent =
                Intent(Intent.ACTION_VIEW, Uri.parse(this.getString(R.string.agreement_url)))
            startActivity(agreementIntent)
        }
    }
}