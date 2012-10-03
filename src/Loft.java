import java.util.*;

public class Loft   {
	public  int taille;
	public  Vector<food> nourriture;
	public Vector<beta> lofteur;
	
	
	public Loft(int t){
		
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
				if((Math.random())<p){
					//mettre de la nourriture non humaine dans la case
					int r=1;
					if((Math.random())>0.8){r=2;
						if((Math.random())>0.8){r=0;}
					}
					if(r>0){
					food n=new food(i,j,r);nourriture.add(n);e=0;}
					else{alcool n=new alcool(i,j);nourriture.add(n);e=0;}
					
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
	
	public void AfficherLofteur(){
		for(int i=0;i<this.lofteur.size();i++){
			System.out.println(this.lofteur.get(i).genre+" en  ("+this.lofteur.get(i).h+","+this.lofteur.get(i).w+")");
		}
	}
	
	public int  go(){
		int r=1;
		//on compte le nombre de joueur
		if(this.lofteur.size()>1){
			//retirer le premier joueur
			
				beta b = this.lofteur.get(0);
				//System.out.println("tour de "+b.genre);
				this.lofteur.remove(0);
				if(b.energie>0){b.deplacer();}else{	System.out.println("KIA");}
				if(b.energie>0){b.action();this.lofteur.add(b);}else{	System.out.println("KIA");}
				//System.out.println("mvt en ("+b.h+","+b.w+") il reste "+b.energie+" energie");
				//System.out.println("nombre de particitant: "+this.lofteur.size());
				//this.go();
			}
			else{
			//mettre une fin
			System.out.println("fin de la partie");r=0;
			}
		return r;
	}
	
	public int occupe(int a,int b){
		int r=1;
		if(lofteur.size()!=0){
		for(int i=0;i<lofteur.size();i++){
			if((lofteur.get(i).h==a)&&(lofteur.get(i).w==b)){r=0;}
		}
	}
		return r;
	}
	
	public void mettreLofteur(int a){
		int n=a;int i,j;
		while(n>0){
		i=(int)(Math.random()*taille);
		j=(int)(Math.random()*taille);
		if(this.occupe(i, j)==1){n=n-1;
			double f=Math.random();
			if(f<0.25){this.add(new erratique(this,i,j,30));}
			else{if(f<0.5){this.add(new vorace(this,i,j,30));}
			else{if(f<0.75){this.add(new cannibale(this,i,j,30));}
			else{this.add(new lapin(this,i,j,30));}
			}
			}
		}
	}
	}
}
