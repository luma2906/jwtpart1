package com.example.mapstruct.exception;


import com.example.mapstruct.error.ErrorCodeEnum;
import com.example.mapstruct.error.InternalServerErrorException;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends InternalServerErrorException
{
    public UserNotFoundException()
    {
        super( new ServerErrorResponseDto( "User not found", ErrorCodeEnum.USER_NOT_FOUND, HttpStatus.NOT_FOUND ),
                HttpStatus.NOT_FOUND );
    }
}

