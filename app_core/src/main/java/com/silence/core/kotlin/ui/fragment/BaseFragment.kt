package com.silence.core.kotlin.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import com.silence.app.core.R

abstract class BaseFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = when (getContentLayout()) {
            is View -> getContentLayout() as View
            is Int -> inflater.inflate(getContentLayout() as Int, container, false)
            else -> throw IllegalArgumentException("View is null")
        }
        return view
    }

    abstract fun getContentLayout() : Any

    val mNavOptions: NavOptions = NavOptions.Builder()
            .setEnterAnim(R.anim.slide_in_right)
            .setExitAnim(R.anim.slide_out_left)
            .setPopEnterAnim(R.anim.slide_in_left)
            .setPopExitAnim(R.anim.slide_out_right)
            .build()

}