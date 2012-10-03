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
		int e=1;
		for(int i=0;i<taille;i++){
			for(int j=0;j<taille;j++){
				if((Math.random())<p*e){
					//mettre de la nourriture non humaine dans la case
					int r=1;
					if((Math.random())>0.8){r=2;}
					food n=new food(i,j,r);
					nourriture.add(n);e=0;
				}
			}
		}
	}
	
	public void AfficherFood(){
		int[][] matrice=new int[taille][taille];
		int i,j;
	//initialisation
		for(i=0;i<taille;i++){
			for(j=0;j<taille;j++){
				matrice[i][j]=0;
			}	
		}
		//intergration des donnee
for(i=0;i<nourriture.size();i++){
			matrice[nourriture.get(i).h][nourriture.get(i).w]=nourriture.get(i).quantite;
			
		}
//affichage
String a;
	for(i=0;i<taille;i++){
		a="";
		for(j=0;j<taille;j++){
			a=a+matrice[i][j];
		}	
	System.out.println(a);
	}
}
	
	public void go(){
		//on compte le nombre de joueur
		if(this.lofteur.size()>0){
			//retirer le premier joueur
			
				beta b = this.lofteur.get(0);
				System.out.println("tour de "+b.genre);
				this.lofteur.remove(0);
				if(b.energie>0){b.deplacer();}else{	System.out.println("KIA");}
				if(b.energie>0){b.action();this.lofteur.add(b);}else{	System.out.println("KIA");}
				System.out.println("mvt en ("+b.h+","+b.w+") il reste "+b.energie+" energie");
				System.out.println("nombre de particitant: "+this.lofteur.size());
				this.go();
			}
			else{
			//mettre une fin
			System.out.println("fin de la partie");
			}
	}
}
