package com.example.demo.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL) //Nếu trường nào có giá trị là null, thì hãy loại bỏ nó khỏi chuỗi JSON trả về, đừng hiển thị ra.
public class ApiResponse<T> {
    private int code;
    private String message;
    private T data;
    private LocalDateTime time;

    public ApiResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ApiResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(200, "Thanh cong", data);
    }

    public static <T> ApiResponse<T> created(T data){
        return new ApiResponse<>(201, "Tao thanh cong", data);
    }

    public static <T> ApiResponse<T> error(int code, String message){
        return new ApiResponse<>(code, message);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
