/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pafupafu;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
/**
 *
 * @author Thea
 */
public interface Pet {
        
      //  public TamagochiListener TamList = null;
      //  public HungryListener HungList  = null;
      //  public HealthListener HealthList = null;
      //  public HappinessListener HappyList = null;
        
        public String name = new String();
        public int gender = 1;
        public int lifespan = 999999;
        
        // koordinat pafupafu
        public static int[][] pafuStand = {
        
            };
        
        // posisi x
        public int x;
        // posisi y
        public int y;
        // kecepatan gerak pafupafu
        public int expression;
        // umur pafupafu
        public int age;
        
        public BufferedImage pafuImg; // gambar pafu
        
        // konstruktor dengan parameter - membuat pafu baru
        public Pet(int x, int y, int expression, int age )
        {
            this.x = x;
            this.y = y;
        
            this.expression = expression;
            this.age = age;
              this.pafuImg = pafuImg;
        
        };
        
        // mengubah ekspresi
        public void update()
        {
            x -= expression;
            if expression = 100 // satisfied
                    {
                         //HealthListener Health = new HealthListener;
                        //HungryListener Hungry = new HungryListener;
                        //HappinessListener Happy = new HappyListener;
                    }
            else if expression = 50 // badmood
                    {
                        //HealthListener Health = new HealthListener;
                        //HungryListener Hungry = new HungryListener;
                        //HappinessListener Happy = new HappyListener;
                    }
            else if expression = 10 // depressed
                    {
                        //HealthListener Health = new HealthListener;
                        //HungryListener Hungry = new HungryListener;
                        //HappinessListener Happy = new HappyListener;
                    }
            else if expression = 0 // die
                    {
                        IsDead == true;
                    }
        }
        
        
    public void setName(String name){
        
    };
    public void setGender(int gender)
    {
        gender = x;
    };
    public int getGender(){
        return gender;
    };
    public String getName(){
        return name;
    };
    public int getType(){
        return 1;
    };
    
    public int getState(){
        return 1;
    };
    public void setState(){
       
    };
    public void onClickPetReact(){
        
        
    
    };
    
    // tambahan
    public boolean IsDead(){
        if LifeMeter = 0{
               return true;
            } else
        {
            return false;
        }
    }
    
    public void Draw(Graphics2D g2d)
    {
        g2d.drawImage(pafuImg, x, y, null);
    }
    
}
