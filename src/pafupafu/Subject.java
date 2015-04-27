/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pafupafu;

/**
 *
 * @author Atia
 */
public interface Subject {
    public void registerObserver(Observer obsever);
    public void removeObserver(Observer obsever);
    public void notifyObservers();
}
