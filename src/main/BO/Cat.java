package main.BO;

import java.util.Date;

public class Cat extends Animal {


    private String chipId;

    public Cat(){ super();}

    public Cat(String chipId){
        super();
        this.chipId = chipId;
    }

    public String getChipId() {
        return chipId;
    }

    public void setChipId(String chipId) {
        this.chipId = chipId;
    }


}
