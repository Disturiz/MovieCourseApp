package com.example.movieappnew.repository

import com.example.movieappnew.data.model.MovieList

interface MovieRepository {
    suspend fun getUpcommingMovies(): MovieList
    suspend fun getTopRatedMovies(): MovieList
    suspend fun getPopularMovies(): MovieList
}