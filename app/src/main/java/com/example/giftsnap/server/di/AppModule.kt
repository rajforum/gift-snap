package com.example.giftsnap.server.di

import android.content.Context
import com.example.giftsnap.server.db.AppDatabase
import com.example.giftsnap.server.repository.CashEntryRepository
import com.example.giftsnap.server.repository.GiftRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getDatabase(context)
    }

    @Provides
    @Singleton
    fun provideGiftRepository(database: AppDatabase): GiftRepository {
        return GiftRepository(database.giftDao())
    }

    @Provides
    @Singleton
    fun provideCashEntryRepository(database: AppDatabase): CashEntryRepository {
        return CashEntryRepository(database.cashEntryDao())
    }
}