package com.example.playlistmaker

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val backButton = findViewById<ImageButton>(R.id.back_button)
        val shareAppLayout = findViewById<FrameLayout>(R.id.shareAppLayout)
        val contactSupportLayout = findViewById<FrameLayout>(R.id.contactSupportLayout)
        val userAgreementLayout = findViewById<FrameLayout>(R.id.userAgreementLayout)

        backButton.setOnClickListener {
            finish()
        }

        shareAppLayout.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.setType("text/plain")
            shareIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.android_course_url))
            startActivity(Intent.createChooser(shareIntent, "Share"))
        }

        contactSupportLayout.setOnClickListener {
            val supportIntent = Intent(Intent.ACTION_SENDTO)
            supportIntent.data = Uri.parse("mailto:")
            supportIntent.putExtra(
                Intent.EXTRA_EMAIL,
                arrayOf(getString(R.string.contact_support_email))
            )
            supportIntent.putExtra(
                Intent.EXTRA_SUBJECT, getString(R.string.contact_support_email_topic)
            )
            supportIntent.putExtra(
                Intent.EXTRA_TEXT, getString(R.string.contact_support_email_body)
            )
            startActivity(supportIntent)
        }
        userAgreementLayout.setOnClickListener {
            val agreementIntent =
                Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.agreement_url)))
            startActivity(agreementIntent)
        }
    }
}