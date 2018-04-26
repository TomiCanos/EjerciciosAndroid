package com.example.dh.json2.Model;

import java.util.List;

/**
 * Created by DH on 25/4/2018.
 */

class Code {
    private List<String> rgba;
    private String hex;

    @Override
    public String toString() {
        return "Code{" +
                "rgba=" + rgba +
                ", hex='" + hex + '\'' +
                '}';
    }

    public List<String> getRgba() {
        return rgba;
    }

    public void setRgba(List<String> rgba) {
        this.rgba = rgba;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    public Code(List<String> rgba, String hex) {
        this.rgba = rgba;
        this.hex = hex;
    }
}
