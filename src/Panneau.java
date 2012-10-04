import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
 
public class Panneau extends JPanel { 
	
	public int n=-1;
	public int p=1;
	
   public void paintComponent(Graphics g){
 
      int x = this.getWidth();
      int y = this.getHeight();
      g.setColor(Color.GRAY);
     if(n==0) {g.setColor(Color.blue);}
     if(n==1) {g.setColor(Color.red);}
     if(n==2) {g.setColor(Color.green);}
      
      g.fillRect(0, 0, this.getWidth(), this.getHeight()); 
     if(p>0){
      g.setColor(Color.yellow);  
      g.fillOval(x/2-x/16, y/8, x/8, x/8);
      g.fillRect(x/2-x/8, x/8+y/8, x/4,3*y/8 );
      g.fillRect(x/2-x/8,x/8+y/8+3*y/8, x/12, y/4); 
      g.fillRect(13*x/24,x/8+y/8+3*y/8, x/12, y/4);
      g.setColor(Color.blue);
      if(p==1){g.drawString("E", x/2-x/16, y/2+y/8);}
      if(p==2){g.drawString("V", x/2-x/16, y/2+y/8);}
      if(p==3){g.drawString("C", x/2-x/16, y/2+y/8);}
      if(p==4){g.drawString("L", x/2-x/16, y/2+y/8);}
   }               
   }
}