/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pafupafu;
import java.util.ArrayList;
import java.util.TimeZone;
import java.util.Scanner; 
import java.util.Collections; 
import java.lang.String;
import java.lang.Exception;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
/*/
 * @author Aurelia
 */
public class Player {
    private String PlayerName; 
    private String PlayerID; 
    private String Time;
    public static int elapsedTime;
    ArrayList<Player> PlayerList= new ArrayList<Player>(); 
   
    public Player(){
        PlayerName= "Aurelia";
        PlayerID= "01A";
        Time = "00:00:00";
    }
    public Player(String PlayerName, String PlayerID, String Time){
        this.PlayerName = PlayerName;
        this.PlayerID = PlayerID;
        this.Time = Time;
    }
    public String getPlayerName(){
        return PlayerName; 
    }
    
    public void setPlayerName(String PlayerName){
        this.PlayerName = PlayerName;
    }
    
    public void setPlayerID(String PlayerID){
        this.PlayerID = PlayerID; 
    }
    public String getPlayerID(){
        return PlayerID;
    } 
    
    public static void incrementElapsedTime() {
        elapsedTime++;
    }
    
    public void addPlayertoPlayerList(){
        PlayerList.add(this);
    }
    public void save(String fileName) throws FileNotFoundException{
      String tmp = getPlayerName();
      String tmp1 = getPlayerID();
      PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));
      pw.write(tmp);
      pw.close();
    }
    public String getTime(){
       Calendar cal = Calendar.getInstance();
       cal.getTime();
       SimpleDateFormat sdf = new SimpleDateFormat("HH:MM:SS");
       String time = sdf.format(cal.getTime());
       Time = time; 
       return time; 
    }
    
    public int getElapsedTime() {
        return elapsedTime;
    }
    
    public void setElapsedTime(int time) {
        elapsedTime = time;
    }
    
    public void showPlayerList(){
        for(int i = 0; i<PlayerList.size();i++){
            System.out.println(getPlayerName());
            System.out.println(getPlayerID());
            System.out.println(getTime());
        }
    }
}
