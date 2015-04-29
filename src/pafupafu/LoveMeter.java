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
public class LoveMeter implements Subject {
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
    
    public static void setLoveValue(int value) {
        LoveMeter.value = value;
    }
    
    public static int getLoveVal() {
        return value;
    }
    
    public static void increaseLoveBy(int value) {
        if (LoveMeter.value + value >= 5) {
            LoveMeter.value = MAX_VALUE;
        }
        else {
            LoveMeter.value += value;
        }
    }
    
    public static void decreaseLoveBy(int value) {
        if (LoveMeter.value - value >= 0) {
            LoveMeter.value -= value;
            if (LoveMeter.value == 0)
                new LoveMeter().notifyObservers();
        }
        else {
            LoveMeter.value = MIN_VALUE;
        }
    }
    
    public boolean isEmpty() {
        return value == 0;
    }
    
    
}
