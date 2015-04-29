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
public class PafuDefault implements Pet,Observer {
    
    public static int state = 1;
    private int type = 0;
    protected String name;
    protected int gender;
    private static PafuDefault pafudef;
    
    public PafuDefault() {}
    
    public static PafuDefault getShared() {
        if (pafudef == null)
            pafudef = new PafuDefault();
        return pafudef;
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
    
    public void update() {
        state = 0;
    }
}
