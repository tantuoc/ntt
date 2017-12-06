package me.tnkid.smsserver.model;

import java.io.Serializable;

/**
 * Created by tom on 12/5/2017.
 */

public class Score implements Serializable {
    int MHS;
    String name;
    int dToan;
    int dLy;
    int dHoa;

    public Score(int MHS, String name, int dToan, int dLy, int dHoa) {
        this.MHS = MHS;
        this.name = name;
        this.dToan = dToan;
        this.dLy = dLy;
        this.dHoa = dHoa;
    }

    public int getMHS() {
        return MHS;
    }

    public void setMHS(int MSSV) {
        this.MHS = MHS;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getdToan() {
        return dToan;
    }

    public void setdToan(int dToan) {
        this.dToan = dToan;
    }

    public int getdLy() {
        return dLy;
    }

    public void setdLy(int dLy) {
        this.dLy = dLy;
    }

    public int getdHoa() {
        return dHoa;
    }

    public void setdHoa(int dHoa) {
        this.dHoa = dHoa;
    }

}
