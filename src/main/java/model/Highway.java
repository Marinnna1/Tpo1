package model;

import java.util.ArrayList;
import java.util.List;

public class Highway {

    public Highway(String name, int fareInRubbles, int maxNum) throws Exception {
        this.name = name;
        if(fareInRubbles<0){
            throw new Exception("Fare must be positive");
        }
        if(maxNum<1){
            throw new Exception("Max quantity must be more than 0");
        }

        this.fareInRubbles = fareInRubbles;
        this.maxNumberOfCars=maxNum;
    }


    private String name;

    private List<Car> cars;

    private int maxNumberOfCars;

    private int fareInRubbles;

    public List<Car> getCars() {
        return cars;
    }

    public void addCar(Car car) throws Exception {
        int size=0;
        if (cars!=null){
            size=cars.size();
        }
        else {
            this.cars = new ArrayList<>();
        }

        if(maxNumberOfCars > size) {
            this.cars.add(car);
        }
        else {
            throw new Exception("Can't add new car");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getMaxNumberOfCars() {
        return maxNumberOfCars;
    }

    public int getFareInRubbles() {
        return fareInRubbles;
    }

    public void setFareInRubbles(int fareInRubbles) throws Exception {
        if(fareInRubbles < 0) {
            throw new Exception("Fare must be positive");
        }
        else {
            this.fareInRubbles = fareInRubbles;
        }
    }
}
