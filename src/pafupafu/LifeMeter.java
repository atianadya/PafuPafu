/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pafupafu;

import java.util.ArrayList;

/**
 *
 * @author Atia
 */
public class LifeMeter implements Subject {
    public static final int MAX_VALUE = 5;
    public static final int MIN_VALUE = 0;
    public static int value;
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    public void notifyObservers() {
        for (Observer ob : observers) {
            ob.update();
        }
    }
    
    public static int getLifeVal() {
        return value;
    }
    
    public static void setLifeValue(int value) {
        LifeMeter.value = value;
    }
    
    public static void increaseLifeBy(int value) {
        if (LifeMeter.value + value >= 5)
            LifeMeter.value = MAX_VALUE;
        else
            LifeMeter.value += value;
    }
    
    public static void decreaseLifeBy(int value) {
        if (LifeMeter.value - value >= 0) {
            LifeMeter.value -= value;
            if (LifeMeter.value == 0)
                new LifeMeter().notifyObservers();
        }
        else {
            LifeMeter.value = MIN_VALUE;
        }
    }
    
    public boolean isEmpty() {
        return value == 0;
    }
}