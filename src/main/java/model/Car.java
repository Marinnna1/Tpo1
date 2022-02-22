package model;

import java.util.ArrayList;
import java.util.List;

public class Car {

    public Car(int capacity, float maxSpeed) throws Exception {
        if(capacity<=0){
            throw new Exception("Capacity must be more than 0");
        }
        if(maxSpeed<=0){
            throw new Exception("Max speed must be more than 0");
        }
        this.capacity = capacity;
        this.maxSpeed = maxSpeed;
    }

    private int capacity;

    private float maxSpeed;

    private float speed;

    private List<Human> humans;

    private Highway currentHighway;

    //getters
    public int getCapacity() {
        return capacity;
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }

    public float getSpeed() {
        return speed;
    }

    public List<Human> getHumans() {
        return humans;
    }

    public Highway getCurrentHighway() {
        return currentHighway;
    }

    //setters
    public void setSpeed(float speed) throws Exception {
        if(speed>=0){
            if(speed<=this.maxSpeed){
                this.speed=speed;
            }
            else{
                throw new Exception("Speed must be lower than max speed");
            }
        }
        else {
            throw new Exception("Negative speed");
        }
    }

    public void addHuman(Human human) throws Exception {
        List<Human> oldHumans = this.getHumans();
        if(oldHumans==null || oldHumans.size()<this.capacity){
            if(this.speed>0){
                throw new Exception("Car is moving cant add new human");
            }
            if(oldHumans==null){
                oldHumans=new ArrayList<>();
            }
            oldHumans.add(human);
            this.humans = oldHumans;
        }
        else {
            throw new Exception("Car is full");
        }
    }

    public void setCurrentHighway(Highway currentHighway) throws Exception {
        currentHighway.addCar(this);
        if(this.humans==null || this.humans.isEmpty()){
            throw new Exception("cant move without human");
        }
        int sumOfMoney = 0;
        for(Human h:this.humans){
            sumOfMoney+=h.getMoneyInRubbles();
        }
        if(currentHighway.getFareInRubbles()>sumOfMoney){
            throw new Exception("give me more money to go to this highway");
        }
        this.currentHighway = currentHighway;
    }
}

