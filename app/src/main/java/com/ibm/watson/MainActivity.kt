package com.ibm.watson

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {  // <-- Change from ComponentActivity to AppCompatActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Load WebViewFragment into the container
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                replace(R.id.fragment_help, HelpFragment())
            }
        }
    }
}