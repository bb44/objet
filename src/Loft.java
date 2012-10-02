import java.util.*;

public class Loft   {
	public  int taille;
	public  Vector<food> nourriture;
	public Vector<beta> lofteur;
	public ZoneGraphique Area;
	
	public Loft(int t, ZoneGraphique z){
		Area=z;
		taille=t;
		nourriture=new Vector();
		lofteur=new Vector();	
	}
	
	public void add(beta b){
		this.lofteur.add(b);
	}
	public void add(vorace b){
		this.lofteur.add(b);
	}
	public void add(erratique b){
		this.lofteur.add(b);
	}
	public void add(cannibale b){
		this.lofteur.add(b);
	}
	public void add(lapin b){
		this.lofteur.add(b);
	}
	
	public void remplissageAleatoire(float p){//0<p<1
		for(int i=0;i<taille;i++){
			for(int j=0;j<taille;j++){
				if(Math.random()<p){
					//mettre de la nourriture non humaine dans la case
					int r=1;
					if(Math.random()>0.8){r=2;}
					food n=new food(i,j,r);
					nourriture.add(n);
				}
			}
		}
	}
	
	public void go(){
		//on compte le nombre de joueur
		if(this.lofteur.size()>1){
			//retirer le premier joueur
			
				beta b = this.lofteur.get(0);
				this.lofteur.remove(0);
				b.deplacer();
				if(b.energie>0){this.lofteur.add(b);}
				System.out.println("mvt en ("+b.h+","+b.w+") il reste "+b.energie+" energie");
				this.go();
			}
			else{
			//mettre une fin
			System.out.println("fin de la partie");
			}
	}
}
