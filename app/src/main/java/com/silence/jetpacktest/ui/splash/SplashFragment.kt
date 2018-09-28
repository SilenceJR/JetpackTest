package com.silence.jetpacktest.ui.splash

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.silence.core.kotlin.ui.fragment.BaseFragment
import com.silence.jetpacktest.R
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.splash_fragment.*
import org.reactivestreams.Subscriber
import java.util.concurrent.TimeUnit

class SplashFragment : BaseFragment() {

    override fun getContentLayout() = R.layout.splash_fragment

    companion object {
        fun newInstance() = SplashFragment()
    }

    private lateinit var viewModel: SplashViewModel


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SplashViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        Glide.with(this)
                .load("https://ws1.sinaimg.cn/large/0065oQSqly1fvexaq313uj30qo0wldr4.jpg")
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(iv_splash)

        Observable.intervalRange(1, 5, 0, 1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<Long>{
                    override fun onComplete() {
                    }

                    override fun onSubscribe(d: Disposable) {
                    }

                    override fun onNext(t: Long) {
                        val currentCount = 4 - t
                        if (currentCount == 0L) {
                            Navigation.findNavController(view).navigate(R.id.mainFragment, null, mNavOptions)
                        } else tv_time.text = currentCount.toString()

                    }

                    override fun onError(e: Throwable) {
                    }

                })

    }

}
