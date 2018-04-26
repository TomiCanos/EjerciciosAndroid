package com.example.dh.json2.Model;

/**
 * Created by DH on 25/4/2018.
 */

public class Color {
    private String color;
    private String category;
    private String type;
    private Code code;

    @Override
    public String toString() {
        return "Color{" +
                "color='" + color + '\'' +
                ", category='" + category + '\'' +
                ", type='" + type + '\'' +
                ", code=" + code +
                '}';
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public Color(String color, String category, String type, Code code) {
        this.color = color;
        this.category = category;
        this.type = type;
        this.code = code;
    }
}
