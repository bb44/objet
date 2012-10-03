

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
public class ZoneGraphique extends JFrame{

	public Loft l;
	
   public ZoneGraphique(Loft v){
	   l=v;
     	this.dessiner();	
   }

   public void set(Loft loft){
	   l=loft;
   }
   public void dessiner(){
	   this.setTitle("Loft par Brice Le Dain");
	      this.setSize(1400, 900);
	      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      this.setLocationRelativeTo(null);
	      
	     
	      
	      
			
	      //Le conteneur principal
	      JPanel content = new JPanel();
	      content.setPreferredSize(new Dimension(1400, 900));
	      content.setBackground(Color.WHITE);
	      //On définit le layout manager
	      content.setLayout(new GridBagLayout());
	      //L'objet servant à positionner les composants
	      GridBagConstraints gbc = new GridBagConstraints();
			
	      //matrice food
	  	int[][] matrice=new int[l.taille][l.taille];
		
	//initialisation
		for(int i=0;i<l.taille;i++){
			for(int j=0;j<l.taille;j++){
				matrice[i][j]=-1;
			}	
		}
		//intergration des donnee
	for(int i=0;i<l.nourriture.size();i++){
			matrice[l.nourriture.get(i).h][l.nourriture.get(i).w]=l.nourriture.get(i).type;
			
		}
	      //matrice lofteur
		int[][] matrice2=new int[l.taille][l.taille];
		System.out.println("part: "+l.lofteur.size());
	//initialisation
	for(int i=0;i<l.taille;i++){
		for(int j=0;j<l.taille;j++){
			matrice2[i][j]=0;
		}	
	}
	//intergration des donnee
	for(int i=0;i<l.lofteur.size();i++){
		if(l.lofteur.get(i).genre=="erratique"){matrice2[l.lofteur.get(i).h][l.lofteur.get(i).w]=1;}
		if(l.lofteur.get(i).genre=="vorace"){matrice2[l.lofteur.get(i).h][l.lofteur.get(i).w]=2;}
		if(l.lofteur.get(i).genre=="cannibale"){matrice2[l.lofteur.get(i).h][l.lofteur.get(i).w]=3;}
		if(l.lofteur.get(i).genre=="lapin"){matrice2[l.lofteur.get(i).h][l.lofteur.get(i).w]=4;}
	}
	      //La taille en hauteur et en largeur
	      gbc.gridheight = 1;
	      gbc.gridwidth = 1;
	      
	    for(int i=0;i<30;i++){
	    	for(int j=0;j<30;j++){
	    		   //On positionne la case du composant
	    		gbc.gridx = i;
	    	    gbc.gridy = j;
	    	    //on ajoute la cellule au conteneur
	    	    Panneau cell=new Panneau();
	    	    cell.n=matrice[j][i];
	    	    cell.p=matrice2[j][i];
	    	    cell.setPreferredSize(new Dimension(40, 25));	
	    	    content.add(cell, gbc);
	        }
	    }
	      //On ajoute le conteneur
	      this.setContentPane(content);
	      this.setVisible(true);
   }
}