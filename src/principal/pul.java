package principal;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;




public class pul  extends JFrame {
	
    /**
     * 
     */
    private static final long serialVersionUID = 1L;


    
    
    
    
    private void pantalla(){
        
	calcula cal = new calcula();
	
    	setSize(1200,1200);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setFocusable(true);
    	add(cal);
    	setVisible(true);
        
    }
    


    public static void main(String[] args)  {
	pul juego = new pul();
	juego.pantalla();

	}
    
    }
    

class calcula extends JPanel{
    
    
    
    public void paint(Graphics g){
	
	//int[] mapa = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36};
	
	int relativaX;
	int relativaY;
    	int totalTils = 100;
    	int[] mapa = new int [totalTils];
    	for(int n=0;n<totalTils;n++){
    	    mapa[n]=n+1;
    	    
    	}
    	
    	for(int m: mapa){
    	    
    	    System.out.print(" , "+m);
    	}
    	
    	int cuadrante = (int) Math.sqrt(totalTils);
    	int diago = (cuadrante+cuadrante)-6;
    	
    	int loopDiago = 0;
    	int muestraPosi = 0;
    	int regreLoop=1;
    	int sum=0;

    	
    	 g.drawString(" totalTils: "+totalTils+" | cuadrante: "+cuadrante+" | diago: "+diago,500, 15);
    	
    	 for (int f=0;f<diago;f++){
    	 System.out.println("---------------------------------- Diagonal: "+(f+1));
     	int[] alma = new int[f+1];
     	int[] almaX = new int[f+1];
     	int[] almaY = new int[f+1];
    	 
    	    for (int lp=loopDiago;lp>=0;lp--){
        	    relativaX = (f-lp)*(32/2)+320;
            	    relativaY = (f+lp)*(32/2)+120;
            	   
            	    
            	
            	if(f==0){
            	//muestraPosi=0;
            	alma[f]=0;
            	} else {
            	//muestraPosi = (muestraPosi*cuadrante);
            
            	
            	}
            	alma[lp]=(lp*cuadrante);
            	if(lp==0 && f>0){
            	alma[lp]=f;   
            	} else if(lp>0){
            	    
            	    alma[lp]=alma[lp]+((f)-lp);
            	   // alma[lp]=alma[lp];//+((f+1)-lp);
            	}
            	System.out.println(" cuadrante:"+cuadrante+" * "+lp+" = "+((lp*cuadrante))+"  valor["+lp+"]= "+alma[lp]);
            	almaX[lp]=relativaX;
            	almaY[lp]=relativaY;
    	    }
    	   



    	 if (loopDiago<cuadrante){
    	 loopDiago++;  
    	 } else {
    	 loopDiago=1; 
    	 }
    	    
    	 
 	    for(int nAlma=0;nAlma<alma.length;nAlma++){
    		
     	//System.out.println(" alma["+nAlma+"] = "+alma[nAlma]+"  => "+mapa[alma[nAlma]]+"   ||| lp:"+regreLoop+" * "+f);

     	g.drawString(""+mapa[alma[nAlma]],almaX[nAlma], almaY[nAlma]); 
 	    }
    	 
    	}
	
    }
    
}
    

