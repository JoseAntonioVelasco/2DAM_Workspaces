package com.example.practica1b;

public class Encapsulador {
    private Integer row_num;
    private String desc;
    private Double value;

    public Encapsulador(Integer row_num, String desc, Double value) {
        this.row_num = row_num;
        this.desc = desc;
        this.value = value;
    }

    public Integer getRow_num() {
        return row_num;
    }

    public String getDesc() {
        return desc;
    }

    public Double getValue() {
        return value;
    }
}