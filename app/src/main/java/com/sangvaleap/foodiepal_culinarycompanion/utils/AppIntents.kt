package com.sangvaleap.foodiepal_culinarycompanion.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast

class AppIntents private constructor(private val context: Context) {
    companion object {
        private lateinit var instance: AppIntents

        fun getInstance(context: Context): AppIntents {
            if (!::instance.isInitialized) {
                instance = AppIntents(context)
            }
            return instance
        }
    }

    fun startDialPhone(phoneNumber: String){ // Replace this with the actual phone number you want to dial
        val dialIntent = Intent(Intent.ACTION_DIAL)
        val phoneUri = Uri.fromParts("tel", phoneNumber, null)
        dialIntent.data = phoneUri
        context.startActivity(dialIntent)
    }

    fun startEmail(email: String){ // Replace this with the actual email address
        val subject = "Subject of the email"
        val body = "Body of the email"

        val emailIntent = Intent(Intent.ACTION_SENDTO)
        emailIntent.data = Uri.parse("mailto:$email")
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
        emailIntent.putExtra(Intent.EXTRA_TEXT, body)

        if (emailIntent.resolveActivity(context.packageManager) != null) {
            context.startActivity(emailIntent)
        } else {
            Toast.makeText(context, "Cannot handle your request", Toast.LENGTH_SHORT).show()
        }
    }
}
