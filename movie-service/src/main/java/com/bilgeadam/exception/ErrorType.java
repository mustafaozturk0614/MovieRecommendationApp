package com.bilgeadam.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ErrorType {


    INTERNAL_ERROR(5200,"Sunucu Hatas�", HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST(4200,"Parametre Hatas�",HttpStatus.BAD_REQUEST),
    MOVIE_NOT_CREATED(4210,"Film Olusturlamad�",HttpStatus.BAD_REQUEST),
    MOVIE_NOT_FOUND(4210,"Boyle Bir Film Bulunamad�",HttpStatus.BAD_REQUEST);
    private int code;
    private String message;
    HttpStatus httpStatus;
}
