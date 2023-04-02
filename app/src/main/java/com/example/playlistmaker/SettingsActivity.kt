package com.example.playlistmaker

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView


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

        shareAppButton.setOnClickListener{
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.setType("text/plain")
            shareIntent.putExtra(Intent.EXTRA_TEXT, "https://practicum.yandex.ru/android-developer/")
            startActivity(Intent.createChooser(shareIntent,"Share"))
        }

        contactSupportButton.setOnClickListener{
            val supportIntent = Intent(Intent.ACTION_SENDTO)
            supportIntent.data = Uri.parse("mailto:")
            supportIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("nikshg@outlook.com"))
            supportIntent.putExtra(Intent.EXTRA_SUBJECT,"Сообщение разработчикам и разработчицам приложения Playlist Maker")
            supportIntent.putExtra(Intent.EXTRA_TEXT, "Спасибо разработчикам и разработчицам за крутое приложение!")
            startActivity(supportIntent)
        }
        userAgreementButton.setOnClickListener{
            val agreementUrl = "https://yandex.ru/legal/practicum_offer/"
            val agreementIntent = Intent(Intent.ACTION_VIEW, Uri.parse(agreementUrl))
            startActivity(agreementIntent)
        }
    }
}