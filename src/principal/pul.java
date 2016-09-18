package principal;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;




public class pul  extends JFrame {
	
    /**
     * 
     */
    private static final long serialVersionUID = 1L;


    private void pantalla(){
        
	calcula cal = new calcula(36,60,51,500,200);
	cal.calcularIso();
	
	test test = new test(cal.getRes(), cal.getMapa());
	
    	setSize(1200,1200);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setFocusable(true);
    	add(test);
    	setVisible(true);
        
    }
    


    public static void main(String[] args)  {
	pul juego = new pul();
	juego.pantalla();

	}
    
    }
    


class test extends JPanel{
    
    /**
     * 
     */
    private static final long serialVersionUID = -167822327877707720L;
    private int[][] res;
    private int[] origen;
    
    
    public test(int[][] res, int[] origen){
	this.res = res;
	this.origen = origen;
    }
   
    
    public void paint(Graphics g){
	
 	for(int nAlma=0;nAlma<res.length;nAlma++){
 	   g.setColor(Color.BLACK);
 	   g.setFont(new Font("Arial", Font.PLAIN, 12));
 	    g.drawString(""+origen[res[nAlma][0]],res[nAlma][1], res[nAlma][2]); 
 	   g.setFont(new Font("Arial", Font.PLAIN, 8));
 	   g.drawString(""+res[nAlma][1]+"."+res[nAlma][2],res[nAlma][1]-10, res[nAlma][2]-10); 
 	  g.setFont(new Font("Arial", Font.PLAIN, 8));
 	  g.setColor(Color.red);
	   g.drawString(""+nAlma,res[nAlma][1]+20, res[nAlma][2]+20); 
 	    }
    }
    
}




class calcula{
    
    
    private int totalTils;
    private int relativaX;
    private int relativaY;
    private int altoTil;
    private int anchoTil;
    private int scrollX;
    private int scrollY;
    
    private int[] mapa;
    private int[][] res;
    

    public calcula(int totalTils,int anchoTil, int altoTil, int scrollX, int scrollY){
    	this.totalTils = totalTils;
    	this.anchoTil = anchoTil;
    	this.altoTil = altoTil;
    	this.scrollX = scrollX;
    	this.scrollY = scrollY;
    	
    	mapa = new int [totalTils];
    	
    	for(int n=0;n<totalTils;n++){
    	    mapa[n]=n+1;
    	    
    	}
    	
    	for(int m: mapa){
    	    
    	    System.out.print(" , "+m);
    	
    	}
    	System.out.println(" ");
    	System.out.println("***-----------------------------------");
	
    }
    
    public void calcularIso(){

    	int cuadrante = (int) Math.sqrt(totalTils);
    	int diago = cuadrante;
    	
    	res = new int[totalTils][3];
    	
    	int loopDiago = 0;
    	int n = 0;
    	int inicio_bu;
    	int fin_bu;
    	
    	
    	
    	    
    	for (int f=0;f<diago;f++){
    	 System.out.println("---------------------------------- Diagonal: "+(f+1));
    	 int[] alma ;
    	 int[] almaX;
    	 int[] almaY;
    	 alma = new int[f+1];
     	 almaX = new int[f+1];
     	 almaY = new int[f+1];
    	 
     	 
     	 
    	    for (int lp=loopDiago;lp>=0;lp--){

//          	relativaX = (f-lp)*(anchoTil/2)+scrollX;
//            	relativaY = (f+lp)*(altoTil/2)+scrollY; 
            	
            	if(f==0){
            	//muestraPosi=0;
            	alma[f]=0;
            	} else {
            	//muestraPosi = (muestraPosi*cuadrante);
            
            	
            	}
            	
            	relativaX = (f-lp)*(anchoTil/2)+(scrollX-(lp*anchoTil/2));
            	relativaY = (f)*(altoTil)+scrollY;
            	
            	alma[lp]=(lp*cuadrante);
            	if(lp==0 && f>0){
            	alma[lp]=f;   
            	} else if(lp>0){
            	    
            	    alma[lp]=alma[lp]+((f)-lp);
            	   // alma[lp]=alma[lp];//+((f+1)-lp);
            	}
            	
            	almaX[lp]=relativaX;
            	almaY[lp]=relativaY;
            	
            	
            	
            	res[n][0] = alma[lp];
            	res[n][1] = almaX[lp];
            	res[n][2] = almaY[lp];
            	
            	System.out.println("["+n+"]  valor["+lp+"]= "+alma[lp]);
            	n++;
    	    }
    	   

    	 

    	 if (loopDiago<cuadrante){
    	 loopDiago++;  
    	 } else {
    	 loopDiago=1; 
    	 }
    	    
    	 
    	 
    	}
    	
    	int inrever = diago;
    	int valn = diago;
    	int nn = n;
    	int fijdiagos=diago;
    	for(int f=0;f<diago;f++){
        	System.out.println("---------------------------------- Diagonal: "+((f+diago)+1));
       	 	int[] alma ;
       	 	int[] almaX;
       	 	int[] almaY;
       	 	alma = new int[inrever];
        	almaX = new int[inrever];
        	almaY = new int[inrever];    
        	 
        	
        	for (int x=0;x<inrever-1;x++){
        	    
            	    
            	    if (f==0){
            		alma[x] = res[n-(valn)][0]+1;
            	    	} else {
            		alma[x] = res[nn-(fijdiagos)][0]+1;
            	    	}
            	    	
            	    	
                    	relativaX = (f-x)*(anchoTil/2)+(scrollX-(x*anchoTil/4));
                    	relativaY = (f)*(altoTil)+scrollY+(diago*altoTil);
            	    	
            	    	almaX[x] = relativaX;
            	    	almaY[x] = relativaY;
                	
        
                	
                	System.out.println(nn+" - "+fijdiagos+" = "+(nn-(fijdiagos))+"  valor["+(nn-(fijdiagos))+"]= "+alma[x]);
            	
                    	res[nn][0] = alma[x];
                	res[nn][1] = almaX[x];
                	res[nn][2] = almaY[x];
                	
                	valn--;
                	nn++;
                	
                	
            	}
        	inrever--;
        	n++;
        	valn=2;
        	fijdiagos--;
    	

	
    	}
    	
            for(int r=0;r<res.length;r++){
                	    
        	
        	    System.out.println("Res["+r+"]: "+res[r][0]+" x:"+res[r][1]+" y:"+res[r][2]);
        	    
        	
        	
                	   
                	}

    }
    


    public int[][] getRes() {
        return res;
    }
    
    
    public int[] getMapa() {
        return mapa;
    }
    
}
    

