package com.lan.app.btvn.dto.request;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class CreateStudentRequest {
    @Pattern(regexp = "^SV\\d{3}$, message = Mã sinh viên phải đúng định dạng SVxxx")
    @NotBlank(message = "Mã sinh viên không được để trống")
    private String studentCode;

    @NotNull(message = "Tên sinh viên không được để trống")
    @Size(min = 2, max = 50)
    private String studentName;

    @Email(message = "Email phải đúng định dạng")
    private String email;

    @Pattern(regexp = "^0\\d{9}", message = "Số điện thoại phải đúng định dạng 0xxxxxxxxx")
    private String phone;

    @Past(message = "Ngày sinh phải là quá khứ")
    private LocalDate dateOfBirth;

    @Min(value = 0, message = "GPA phải >= 0")
    @Max(value = 4, message = "GPA phải <= 4")
    private Double gpa;

    @NotNull(message = "Ngành không được để trống")
    private String major;

    @Max(value = 6, message = "Số năm phải <= 6")
    @Min(value = 1, message = "Số năm phải >= 1")
    private Integer year;

    public @Pattern(regexp = "^SV\\d{3}$, message = Mã sinh viên phải đúng định dạng SVxxx") @NotBlank(message = "Mã sinh viên không được để trống") String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(@Pattern(regexp = "^SV\\d{3}$, message = Mã sinh viên phải đúng định dạng SVxxx") @NotBlank(message = "Mã sinh viên không được để trống") String studentCode) {
        this.studentCode = studentCode;
    }

    public @NotNull(message = "Tên sinh viên không được để trống") @Size(min = 2, max = 50) String getStudentName() {
        return studentName;
    }

    public void setStudentName(@NotNull(message = "Tên sinh viên không được để trống") @Size(min = 2, max = 50) String studentName) {
        this.studentName = studentName;
    }

    public @Email(message = "Email phải đúng định dạng") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "Email phải đúng định dạng") String email) {
        this.email = email;
    }

    public @Pattern(regexp = "^0\\d{9}", message = "Số điện thoại phải đúng định dạng 0xxxxxxxxx") String getPhone() {
        return phone;
    }

    public void setPhone(@Pattern(regexp = "^0\\d{9}", message = "Số điện thoại phải đúng định dạng 0xxxxxxxxx") String phone) {
        this.phone = phone;
    }

    public @Past(message = "Ngày sinh phải là quá khứ") LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(@Past(message = "Ngày sinh phải là quá khứ") LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public @Min(value = 0, message = "GPA phải >= 0") @Max(value = 4, message = "GPA phải <= 4") Double getGpa() {
        return gpa;
    }

    public void setGpa(@Min(value = 0, message = "GPA phải >= 0") @Max(value = 4, message = "GPA phải <= 4") Double gpa) {
        this.gpa = gpa;
    }

    public @NotNull(message = "Ngành không được để trống") String getMajor() {
        return major;
    }

    public void setMajor(@NotNull(message = "Ngành không được để trống") String major) {
        this.major = major;
    }

    public @Max(value = 6, message = "Số năm phải <= 6") @Min(value = 1, message = "Số năm phải >= 1") Integer getYear() {
        return year;
    }

    public void setYear(@Max(value = 6, message = "Số năm phải <= 6") @Min(value = 1, message = "Số năm phải >= 1") Integer year) {
        this.year = year;
    }
}
