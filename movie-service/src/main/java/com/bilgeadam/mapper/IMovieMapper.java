package com.bilgeadam.mapper;

import com.bilgeadam.dto.request.NewMovieRequestDto;
import com.bilgeadam.dto.response.NewMovieResponseDto;
import com.bilgeadam.repository.entity.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IMovieMapper {

    IMovieMapper INSTANCE= Mappers.getMapper(IMovieMapper.class);

    Movie toMovie(final NewMovieRequestDto dto);
    NewMovieResponseDto toNewMovieResponseDto(final Movie movie);



}
