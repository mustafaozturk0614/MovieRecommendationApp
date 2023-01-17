package com.bilgeadam.service;

import com.bilgeadam.dto.request.NewMovieRequestDto;
import com.bilgeadam.dto.response.NewMovieResponseDto;
import com.bilgeadam.exception.ErrorType;
import com.bilgeadam.exception.MovieManagerException;
import com.bilgeadam.mapper.IMovieMapper;
import com.bilgeadam.repository.IMovieRepository;
import com.bilgeadam.repository.entity.Movie;
import com.bilgeadam.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class MovieService extends ServiceManager<Movie,String> {

private final IMovieRepository movieRepository;


    public MovieService(IMovieRepository movieRepository) {
        super(movieRepository);
        this.movieRepository = movieRepository;
    }

    public NewMovieResponseDto createMovie(NewMovieRequestDto dto) {
        Movie movie= IMovieMapper.INSTANCE.toMovie(dto);
        System.out.println(movie);
        try {
            movie=save(movie);
        }catch (Exception e){

            throw  new MovieManagerException(ErrorType.MOVIE_NOT_CREATED);
        }
        try {
            return IMovieMapper.INSTANCE.toNewMovieResponseDto(movie);
        }catch (Exception e){

            throw new MovieManagerException(ErrorType.INTERNAL_ERROR,"Garip bir hata");
        }


    }
}
