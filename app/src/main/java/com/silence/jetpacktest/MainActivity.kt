package com.silence.jetpacktest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }

    override fun onSupportNavigateUp() = Navigation.findNavController(this, R.id.fragment_Navigation).navigateUp()

    override fun onClick(v: View?) {
        if (null == v) return
    }
}
