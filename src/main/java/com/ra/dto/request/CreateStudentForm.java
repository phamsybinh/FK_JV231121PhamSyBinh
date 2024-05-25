package com.ra.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateStudentForm {
    private String name;
    private MultipartFile file;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date birthday;
    private Boolean sex;
    private Integer phoneNumber;
    private String address;

}
