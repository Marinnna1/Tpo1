package model;

public class Human {

    private String name;
    private String surname;
    private int moneyInRubbles;
    private Car car;

    public Human(String name, String surname, int moneyInRubbles) throws Exception {
        if(moneyInRubbles < 0) {
            throw new Exception("Money must be positive");
        }
        this.name = name;
        this.surname = surname;
        this.moneyInRubbles = moneyInRubbles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getMoneyInRubbles() {
        return moneyInRubbles;
    }

    public void setMoneyInRubbles(int moneyInRubbles) throws Exception {
        if(moneyInRubbles > 0) {
            this.moneyInRubbles = moneyInRubbles;
        }
        else {
            throw new Exception("Money must be positive");
        }
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
