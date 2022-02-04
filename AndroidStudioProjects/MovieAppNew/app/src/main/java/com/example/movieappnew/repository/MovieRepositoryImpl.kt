
package com.example.movieappnew.repository

import com.example.movieappnew.core.InternetCheck
import com.example.movieappnew.data.model.MovieList
import com.example.movieappnew.data.remote.RemoteMovieDataSource
class MovieRepositoryImpl(private val dataSourceRemote: RemoteMovieDataSource) : MovieRepository {


    override suspend fun getUpcommingMovies(): MovieList {
        return if (InternetCheck.isNetworkAvailable()) {
            dataSourceRemote.getUpcomingMovies()
        } else {
            dataSourceRemote.getUpcomingMovies()
        }
    }

    override suspend fun getTopRatedMovies(): MovieList {
        return if (InternetCheck.isNetworkAvailable()) {
            dataSourceRemote.getTopRatedMovies()
        } else {
            dataSourceRemote.getTopRatedMovies()
        }
    }

    override suspend fun getPopularMovies(): MovieList {
        return if (InternetCheck.isNetworkAvailable()) {
            dataSourceRemote.getPopularMovies()
        } else {
            dataSourceRemote.getPopularMovies()
        }
    }
}
