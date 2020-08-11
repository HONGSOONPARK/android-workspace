package com.stepup.mvvmstd01

import android.app.Application
import com.stepup.mvvmstd01.di.myDiModule
import org.koin.android.ext.android.startKoin

/**
 * 클래스 설명
 *
 * @author 최초작성자:
 * @date 최초작성일: 2020-08-11 오후 1:26
 *
 */
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(applicationContext, myDiModule)
    }
}