package search;

import search.controller.Controller;
import search.view.View;

public class MainClass {
 
    public static void main(String[] args) throws Exception {
  
    	//ProcessBuilder pb = new ProcessBuilder("C:\\Program Files (x86)\\VideoLAN\\VLC\\vlc.exe",
    			  //    "http://www.youtube.com/watch?v=b-3PQf10myk&feature=youtube_gdata_player");
    	//Process start = pb.start();
    	System.out.print("ASDasd");
    	
    	View view = new View();
    	Controller ctr=new Controller(view);
    	//Result result = new Result("Knorkator - Ich hasse Musik");
    	//Result result2 = new Result("Rammstein - Les Arènes de Nîmes");
       // view.showResult(result);
        //view.showResult(result2);
        
    }
    
    

}
