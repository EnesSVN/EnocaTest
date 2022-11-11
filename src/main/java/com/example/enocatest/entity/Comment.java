package com.example.enocatest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "comment")
public class Comment extends BaseEntity{

    private String content;

    @ManyToOne
    @JoinColumn(name = "tutorial_id")
    @JsonIgnore
    private Tutorial tutorial;

}
