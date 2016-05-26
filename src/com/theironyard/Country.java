package com.theironyard;

/**
 * Created by illladell on 5/26/16.
 */
public class Country {
    String abbre;
    String name;

    public Country(String abbre, String name) {
        this.abbre = abbre;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "abbre='" + abbre + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
