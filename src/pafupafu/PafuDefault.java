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
public class PafuDefault implements Pet {
    
    private final int type=0;
    private String name;
    private int gender;
    
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
    
    public int getType() {
        return type;
    }
}