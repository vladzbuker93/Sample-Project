package com.vladzbuker.sampleproject.di.module

import com.vladzbuker.sampleproject.ui.activity.MainActivity
import com.vladzbuker.sampleproject.di.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AndroidFrameworkInjectors {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindTestActivity(): MainActivity
}