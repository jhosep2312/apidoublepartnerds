package com.example.apidoublepartnerds.aplication.entities;


import com.google.gson.Gson;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BaseResponseDto<T> {

    private ResponseCode code;
    private String message;
    private T data;

    public BaseResponseDto<T> ok(String message) {
        return ok(message, null);
    }

    public BaseResponseDto<T> ok(String message, T data) {
        setCode(ResponseCode.OK);
        setMessage(message);
        setData(data);
        return this;
    }

    public BaseResponseDto<T> error(String message) {
        setCode(ResponseCode.ERROR);
        setMessage(message);
        return this;
    }

    public BaseResponseDto<T> noContent(String message) {
        setCode(ResponseCode.NO_CONTENT);
        setMessage(message);
        return this;
    }

    public BaseResponseDto<T> badRequest(String message) {
        setCode(ResponseCode.BAD_REQUEST);
        setMessage(message);
        return this;
    }

    public BaseResponseDto<T> conflict(String message) {
        setCode(ResponseCode.CONFLICT);
        setMessage(message);
        return this;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
