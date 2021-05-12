package com.randomword.myproject.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "words")
public class Word extends BaseEntity{

    @Column(name = "word")
    @NotNull
    private String word;

    @Column(name = "type")
    @NotNull
    private String type;

}
