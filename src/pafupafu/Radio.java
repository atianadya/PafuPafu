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
public class Radio implements Items {
    private int itemID = 3;
    private final int lifeAttr = 0;
    private final int loveAttr = 2;
    
    public void updateMeter() {
        LifeMeter.increaseLifeBy(lifeAttr);
        LoveMeter.increaseLoveBy(loveAttr);
    }
    
    public int getItemID() {
        return itemID;
    }
}
