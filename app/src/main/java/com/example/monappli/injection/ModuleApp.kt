package com.example.monappli.injection

import android.content.Context
import androidx.room.Room
import com.example.monappli.data.repository.UserRepository
import com.example.monappli.data.repository.local.models.AppDatabase
import com.example.monappli.data.repository.local.models.DatabaseDao
import com.example.monappli.domain.usecase.CreateUserUseCase
import com.example.monappli.domain.usecase.GetUserUseCase
import com.example.monappli.presentation.main.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import java.security.AccessControlContext

val presentationModule = module {
    factory { MainViewModel(get(), get()) }


    }
val domainModule = module {
    factory { CreateUserUseCase(get()) }
    factory { GetUserUseCase(get()) }
}

val dataModule = module {
   single { UserRepository(get()) }
    single { createDatabase(androidContext()) }
}

fun createDatabase(context: Context): DatabaseDao {
    val appDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "database-name"
    ).build()
   return appDatabase.databaseDao()
}
