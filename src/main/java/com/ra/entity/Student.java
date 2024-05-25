package com.ra.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer id;
    @Column(name = "student_name")
    private String name;
    private String address;
    @Column(columnDefinition = "date")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date birthday;
    @Column(name = "image_url")
    private String imageUrl;
    private Integer phoneNumber;
    private Boolean sex;


}
