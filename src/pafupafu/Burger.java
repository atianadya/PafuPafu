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
public class Burger implements Items {
    private int itemID = 2;
    private final int lifeAttr = 1;
    private final int loveAttr = 1;
    
    public void updateMeter() {
        LifeMeter.increaseLifeBy(lifeAttr);
        LoveMeter.increaseLoveBy(loveAttr);
    }
    
    public int getItemID() {
        return itemID;
    }
}
