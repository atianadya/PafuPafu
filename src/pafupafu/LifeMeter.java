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
    private int value;
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    public void notifyObservers() {
        for (Observer ob : observers) {
            ob.update(isEmpty());
        }
    }
    
    public void increaseLifeBy(int value) {
        this.value += value;
    }
    
    public void decreaseLifeBy(int value) {
        this.value -= value;
    }
    
    public boolean isEmpty() {
        return value == 0;
    }
}
