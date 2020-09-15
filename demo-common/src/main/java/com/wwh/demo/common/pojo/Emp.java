package com.wwh.demo.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Emp {
    private int id;

    private String name;
    /**
     * next默认为空
     */
    private Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
