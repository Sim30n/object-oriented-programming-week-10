package com.example.week_10;

import java.util.ArrayList;

public class Websites {

    ArrayList<Site> sites = new ArrayList<Site>();

    private int indeksi = 0;

    public Websites(){
    }

    public void addSite(String s){
        sites.add(new Site(s));
        indeksi = sites.size()-1;
    }

    public void setIndex(int i){
        indeksi = i;
    }

    public int getIndex(){
        return indeksi;
    }
}
