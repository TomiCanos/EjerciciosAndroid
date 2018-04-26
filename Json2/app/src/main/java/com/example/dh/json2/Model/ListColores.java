package com.example.dh.json2.Model;

import java.util.List;

/**
 * Created by DH on 25/4/2018.
 */

public class ListColores {
    private List<Color> colors;

    public ListColores(List<Color> colors) {
        this.colors = colors;
    }

    public List<Color> getColors() {
        return colors;
    }

    public void setColors(List<Color> colors) {
        this.colors = colors;
    }
}
