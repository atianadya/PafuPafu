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
public class Timer extends Thread {
    private Thread t;
    private String threadName;
    public static boolean timerFlag = false;
    public int localtime=0;
    
    Timer(String name) {
        threadName = name;
    }
    
    public void run() {
        try {
            while (!timerFlag) {
                // counter
                localtime++;
                Player.incrementElapsedTime();
                Thread.sleep(1000);
            }
            timerFlag = false;
            System.out.println("current session time: "+localtime+"s");
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void start() {
        if (t == null) {
            t = new Thread (this, threadName);
            t.start();
        }
    }
}
