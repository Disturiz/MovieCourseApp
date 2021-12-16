package com.example.movieappnew.data.remote

import com.example.movieappnew.application.AppConstants
import com.example.movieappnew.data.model.MovieList
import com.example.movieappnew.repository.RetrofitClient.webService
import com.example.movieappnew.repository.WebService

class RemoteMovieDataSource(private val webService: WebService) {

    suspend fun getUpcomingMovies(): MovieList = webService.getUpcommingMovies(AppConstants.API_KEY)


    suspend fun getTopRatedMovies(): MovieList = webService.getTopRatedMovies(AppConstants.API_KEY)


    suspend fun getPopularMovies(): MovieList = webService.getPopularMovies(AppConstants.API_KEY)

}