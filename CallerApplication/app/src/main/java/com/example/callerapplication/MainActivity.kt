package com.example.callerapplication

import android.Manifest
import android.app.SearchManager
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private lateinit var phoneNumberEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        phoneNumberEditText = findViewById(R.id.phoneNumberEditText)
        val callButton: Button = findViewById(R.id.callButton)

        callButton.setOnClickListener {
            makePhoneCall()
        }
        val searchButton: Button = findViewById(R.id.searchButton)
        searchButton.setOnClickListener {
            performWebSearch()
        }
    }

    private fun makePhoneCall() {
        val number = phoneNumberEditText.text.toString()
        if (number.trim().isNotEmpty()) {
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE),
                    REQUEST_CALL_PERMISSION)
            } else {
                val dial = "tel:$number"
                startActivity(Intent(Intent.ACTION_CALL, Uri.parse(dial)))
            }
        }
    }
    private fun performWebSearch() {
        val query = phoneNumberEditText.text.toString()
        if (query.isNotEmpty()) {
            val intent = Intent(Intent.ACTION_WEB_SEARCH).apply {
                putExtra(SearchManager.QUERY, query)
            }
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CALL_PERMISSION) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCall()
            }
        }
    }

    companion object {
        private const val REQUEST_CALL_PERMISSION = 1
    }
}
