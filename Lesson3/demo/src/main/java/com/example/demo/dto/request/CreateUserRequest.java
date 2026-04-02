package com.example.demo.dto.request;

import jakarta.validation.constraints.*;

public class CreateUserRequest {

    @NotBlank(message = "Ten khong duoc de trong")
    @Size(min = 2, max = 50, message = "Ten phai tu 2 den 50 ki tu")
    private String name;

    @NotBlank(message = "Email khong duoc de trong")
    @Email(message = "Email khong dung dinh dang")
    private String email;

    @NotNull(message = "Tuoi khong duoc de trong")
    @Min(value = 1, message = "Tuoi phai lon hon 0")
    @Max(value = 150, message = "Tuoi phai nhp hon 150")
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
