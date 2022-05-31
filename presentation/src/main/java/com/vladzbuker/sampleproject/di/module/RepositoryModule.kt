package com.vladzbuker.sampleproject.di.module

import com.vladzbuker.domain.repository.TestRepo
import dagger.Module
import dagger.Provides
import repository.TestRepoImpl
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideTestRepo(): TestRepo {
        return TestRepoImpl()
    }
}