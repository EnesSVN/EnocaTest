package com.example.enocatest.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tutorial")
public class Tutorial extends BaseEntity {



    private String title;

    private String description;

    private boolean published;

    @OneToMany(mappedBy="tutorial")
    private List<Comment> comment;





}
