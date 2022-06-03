package com.vladzbuker.sampleproject.di.component

import android.app.Application
import com.vladzbuker.sampleproject.core.AppController
import com.vladzbuker.sampleproject.di.module.AndroidFrameworkInjectors
import com.vladzbuker.sampleproject.di.module.AppModule
import com.vladzbuker.sampleproject.di.module.RepositoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication
import com.vladzbuker.sampleproject.di.module.ServiceModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AndroidFrameworkInjectors::class,
        RepositoryModule::class,
        AppModule::class,
        ServiceModule::class
    ]
)
interface CoreComponent : AndroidInjector<DaggerApplication> {

    abstract fun inject(app: AppController)

    abstract override fun inject(instance: DaggerApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): CoreComponent
    }
}