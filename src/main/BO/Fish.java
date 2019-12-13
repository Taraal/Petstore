package main.BO;

public class Fish extends Animal {
    private FishLivEnv livingEnv;

    public Fish(){ super();}

    public Fish(FishLivEnv livingEnv){
        super();
        this.livingEnv = livingEnv;
    }

}
