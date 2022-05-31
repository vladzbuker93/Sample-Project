package com.vladzbuker.sampleproject.core

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import com.vladzbuker.sampleproject.di.component.DaggerCoreComponent

class AppController: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val coreComponent = DaggerCoreComponent
            .builder()
            .application(this)
            .build()
        coreComponent.inject(this)
        return coreComponent
    }
}