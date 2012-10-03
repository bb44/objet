import java.util.*;

public abstract class beta extends food {
	public Vector<Integer> regime=new Vector();
	public Loft l;
	public String genre="";
	
	public beta(Loft l1,int h1,int w1,int e){
		super(h1,w1,3);
		quantite=1;
		l=l1;
		h=h1;
		w=w1;
		energie=e;
		
	}
	
	public int accessible(int a,int b){//a faire
		int r=1,p=0,j=0;
		//s'assurer que la case est dans le loft
		if(a<0){r=0;}
		if(a>l.taille-1){r=0;}
		if(b<0){r=0;}
		if(b>l.taille-1){r=0;}
		//si la case est occupee verifier qu'on peut y aller
		//on compte le nombre de personne sur la case
		//au dessus de 2 acces impossible
		//0 acces autorise 
		// 1 verifier l'energie 
		for(int i=0; i<l.lofteur.size();i++){
			if((l.lofteur.get(i).h==a)&&(l.lofteur.get(i).w==b)){p=p+1;j=i;System.out.println("neuneu en ("+a+","+b+")");}
		}
		if(p>1){r=0;}
		if(p==1){
			if((energie<11)||(l.lofteur.get(j).energie<11)){r=0;}
		}
		return r;
	}
	
	public void cases(int i){
		if(i==0){h=h+1;w=w-1;}
		if(i==1){h=h+1;}
		if(i==2){h=h+1;w=w+1;}
		if(i==3){w=w-1;}
		if(i==4){w=w+1;}
		if(i==5){h=h-1;w=w-1;}
		if(i==6){h=h-1;}
		if(i==7){h=h-1;w=w+1;}
	}
	
	public int Typage(){
		return 1;
	}
	
	public void deplacer(){
		System.out.println("indefini");
	}
	public void action(){
		System.out.println("indefini");
	}
	
	public void reproduire(beta p){
		this.energie=this.energie-5;
		p.energie=p.energie-5;
		int m=(int)(Math.random()*3);
		if(m==0){erratique b=new erratique(l,
							(int)(Math.random()*l.taille),
							(int)(Math.random()*l.taille),
							4);l.add(b);}
		if(m==1){vorace b=new vorace(l,
				(int)(Math.random()*l.taille),
				(int)(Math.random()*l.taille),
				3);l.add(b);}
		if(m==2){cannibale b=new cannibale(l,
				(int)(Math.random()*l.taille),
				(int)(Math.random()*l.taille),
				5);l.add(b);}
		if(m==3){lapin b=new lapin(l,
				(int)(Math.random()*l.taille),
				(int)(Math.random()*l.taille),
				4);l.add(b);}
		
	}
	public int consommer(int q){
		int r=0;
		if((q>0)&&(q<quantite+1)){
			r=q*energie;quantite=0;
			this.energie=-1;
		}
		
		return r;
	}
}
