package com.codeup.blog.blog.models;

import com.mysql.cj.protocol.ColumnDefinition;
import jdk.jfr.Unsigned;

import javax.persistence.*;

@Entity
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition =  "Int(11) Unsigned", nullable = false)
    private int id;

    @Column(columnDefinition = "tinyInt(3) Unsigned", nullable = false, unique = true)
    private int age;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(columnDefinition = "char(2) default 'XX'")
    private String resideState;




}
