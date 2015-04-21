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
    
    Timer(String name) {
        threadName = name;
    }
    
    public void run() {
        try {
            while (!timerFlag) {
                // counter
                // player's time++;
                Thread.sleep(1000);
            }
//            endTime = System.nanoTime();
//            long elapsedTime = (endTime-startTime)/1000000000; // in seconds
//            System.out.println("elapsed time: "+elapsedTime+"s");
            timerFlag = false;
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
