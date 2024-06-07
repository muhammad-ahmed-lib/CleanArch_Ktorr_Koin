package com.example.insta.ktorcompose.di.module

import android.app.Application
import androidx.room.Room
import com.example.insta.ktorcompose.data.database.MyDatabase
import com.example.insta.ktorcompose.data.respository.RemoteRepository
import com.example.insta.ktorcompose.domain.repositoryimp.RemoteRepositoryImpl
import com.example.insta.ktorcompose.data.network.ApiService
import com.example.insta.ktorcompose.data.network.httpClientAndroid
import com.example.insta.ktorcompose.data.respository.RoomRepository
import com.example.insta.ktorcompose.domain.repositoryimp.RoomRepositoryImp
import com.example.insta.ktorcompose.domain.usecase.RemoteUseCase
import com.example.insta.ktorcompose.ui.viewmodels.MainViewModel
import com.example.insta.ktorcompose.ui.viewmodels.RoomViewModel
import org.koin.dsl.module
import io.ktor.client.HttpClient
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel

val appModule = module {
    single { provideHttpClient() }
    single { provideApiService(get()) }
    single<RemoteRepository> { RemoteRepositoryImpl(get()) }
    single { RemoteUseCase(get()) }
    single { provideMyDataBase(androidApplication()) } // Provide Application instance
    single<RoomRepository> { provideMyRepository(get()) }
    viewModel { MainViewModel(get()) }
    viewModel { RoomViewModel(get()) }

}

fun provideMyDataBase(app: Application): MyDatabase {
    return Room.databaseBuilder(
        app,
        MyDatabase::class.java,
        "MyDataBase"
    ).build()
}

fun provideMyRepository(mydb: MyDatabase): RoomRepository {
    return RoomRepositoryImp(mydb.dao)
}

fun provideHttpClient(): HttpClient {
    return httpClientAndroid
}

fun provideApiService(httpClient: HttpClient): ApiService {
    return ApiService(httpClient)
}

fun provideRemoteRepository(apiService: ApiService): RemoteRepositoryImpl {
    return RemoteRepositoryImpl(apiService)
}