package com.dw.driverapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="과목")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="title")
    private String title;
    @Column(name="explanation")
    private String explanation;

    @ManyToMany
    @JoinTable(name="subject_type", joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "type_id"))
    private List<Type> typeList = new ArrayList<>();

    @Column(name="price")
    private double price;

    @OneToMany
    @JoinColumn(name="image_urls")
    private List<Image>imageList = new ArrayList<>();

   @OneToMany
   @JoinColumn(name="video_urls")
   private List<Video>videoList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="user_name")
    private User user_fk;

}
