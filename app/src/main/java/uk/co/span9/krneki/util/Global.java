package uk.co.span9.krneki.util;


import android.app.Application;

import java.util.ArrayList;

import uk.co.span9.krneki.models.Dogodek;

public class Global extends Application {

    private ArrayList<Dogodek> ponedeljek, torek, sreda;

    public ArrayList<Dogodek> getPonedeljek() {
        return ponedeljek;
    }

    public void setPonedeljek(ArrayList<Dogodek> ponedeljek) {
        this.ponedeljek = ponedeljek;
    }

    public ArrayList<Dogodek> getTorek() {
        return torek;
    }

    public void setTorek(ArrayList<Dogodek> torek) {
        this.torek = torek;
    }

    public ArrayList<Dogodek> getSreda() {
        return sreda;
    }

    public void setSreda(ArrayList<Dogodek> sreda) {
        this.sreda = sreda;
    }
}
