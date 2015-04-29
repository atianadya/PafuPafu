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
public class WingPafu extends PafuDefault {
    private int type = 1;
    private static WingPafu wpafu;
    
    public void fly() {
        // ??
    }
    
    public static WingPafu getShared() {
        if (wpafu == null)
            wpafu = new WingPafu();
        return wpafu;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setGender(int gender) {
        this.gender = gender;
    }
    
    public String getName() {
        return name;
    }
    
    public int getGender() {
        return gender;
    }
    
    public int getState() {
        return state;
    }
    
    public int getType() {
        return type;
    }
}
