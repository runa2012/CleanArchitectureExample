package co.kr.cleanarchitectureexample

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ExApplication : Application()  {

    override fun onCreate() {
        super.onCreate()


    }

}


