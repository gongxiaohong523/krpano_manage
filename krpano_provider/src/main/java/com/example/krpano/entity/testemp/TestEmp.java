package com.example.krpano.entity.testemp;


import lombok.Data;

import java.io.Serializable;

@Data
public class TestEmp implements Serializable {
    private Long id;

    private String name;

    private Long age;

    private static final long serialVersionUID = 1L;

}