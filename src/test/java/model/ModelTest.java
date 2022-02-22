package model;

import org.junit.jupiter.api.*;
import model.Car;

import static org.junit.jupiter.api.Assertions.*;

public class ModelTest {


    static Car mustang;
    static Car ferarri;
    static Car lambo;
    static Car blueCar;
    //
    static Human h1;
    static Human h2;
    static Human h3;
    static Human h4;
    static Human h5;
    static Human h6;
    //
    static Highway hw1 = null;
    static Highway hw2 = null;
    static Highway hw3 = null;


    @BeforeEach
    void init() throws Exception {
        mustang = new Car(2,900);
        ferarri = new Car(2,700);
        lambo = new Car(2,1100);
        blueCar = new Car(4,600);

        h1 = new Human("Vasya","lol",9000);
        h2 = new Human("Petya","sssss",0);
        h3 = new Human("kkkk","kek",677);
        h4 = new Human("Artur","Da",234);
        h5 = new Human("Vika","Net",11);
        h6 = new Human("Vala","mozhetBit",76765);

        hw1 = new Highway("roadToHell",1,100);
        hw2 = new Highway("roadToHeaven",200,1);
        hw3 = new Highway("roadToHome",0,33);

    }

    @Nested
    class CarTest {


        @Test
        @DisplayName("CreateCar")
        void createCar() {
            Exception capacityE = assertThrows(Exception.class, () -> new Car(-1, 100));
            assertEquals("Capacity must be more than 0", capacityE.getMessage());
            Exception speedE = assertThrows(Exception.class, () -> new Car(1, -111));
            assertEquals("Max speed must be more than 0", speedE.getMessage());
        }

        @Test
        @DisplayName("Speed test")
        void testSpeed() throws Exception {
            Exception speedE = assertThrows(Exception.class, ()->mustang.setSpeed(-111));
            assertEquals("Negative speed",speedE.getMessage());
            speedE = assertThrows(Exception.class, ()->lambo.setSpeed(10000000));
            assertEquals("Speed must be lower than max speed",speedE.getMessage());
            lambo.setSpeed(100);
            assertEquals(100,lambo.getSpeed());
        }

        @Test
        @DisplayName("Add human")
        void testAddHuman() throws Exception {
            lambo.addHuman(h1);
            lambo.addHuman(h2);
            Exception e = assertThrows(Exception.class, ()->lambo.addHuman(h3));
            assertEquals("Car is full",e.getMessage(),"if car is full");

            mustang.setSpeed(1);
            e = assertThrows(Exception.class,()->mustang.addHuman(h4));
            assertEquals("Car is moving cant add new human",e.getMessage());
        }

        @Test
        @DisplayName("Car set Highway")
        void testSetCurrentHighway() throws Exception {
            Exception e = assertThrows(Exception.class,()->lambo.setCurrentHighway(hw1));
            assertEquals("cant move without human",e.getMessage());
            lambo.addHuman(h2);
            e = assertThrows(Exception.class,()->lambo.setCurrentHighway(hw1));
            assertEquals("give me more money to go to this highway",e.getMessage());

        }
    }

    @Nested
    class HumanTest{
        @Test
        @DisplayName("constructor human test")
        void creteHuman() throws Exception {
            Exception e = assertThrows(Exception.class, ()-> new Human("jojo","anime",-100));
            assertEquals("Money must be positive",e.getMessage());
        }

        @Test
        @DisplayName("money Test")
        void testSetMoney(){
            Exception e = assertThrows(Exception.class,()->h1.setMoneyInRubbles(-100));
            assertEquals("Money must be positive",e.getMessage());
        }

    }

    @Nested
    class HighwayTest{

        @Test
        @DisplayName("Highway cinstructor")
        void testCHighwayConstr() throws Exception {
            Exception e = assertThrows(Exception.class, ()->new Highway("da",-1,100));
            assertEquals("Fare must be positive",e.getMessage());
            e = assertThrows(Exception.class,()->new Highway("da",111,0));
            assertEquals("Max quantity must be more than 0",e.getMessage());
        }

        @Test
        @DisplayName("Set max number of cars ")
        void testSetFareInRubbles(){
            Exception e = assertThrows(Exception.class,()->hw1.setFareInRubbles(-100));
            assertEquals("Fare must be positive",e.getMessage());
        }

    }



}

