import java.util.*;

public class erratique extends beta {

	public erratique(Loft l1,int h1,int w1,int e){
		super(l1, h1, w1, e);
		regime.add(0);
		regime.add(1);
		regime.add(2);
		genre="erratique";
	}
	
	
	public void deplacer(){
		//System.out.println("deplacement depuis ("+h+","+w+")");
		//8 cases 
		//0 si la case est hors du loft
		//sinon verifier l'acces avec la fonction accessibilite
		//1 si accessible et 0 sinon
		//si somme==0 alors impossible de bouger: on perd un d'energie
		//sinon un nombre aleatoire permet le mouvement: mouvement on perd de l'energie+action a effectuer(manger,reproduire)
		int a1=1,a2=1,a3=1,a4=1,a5=1,a6=1,a7=1,a8=1;
		if(w==0){a1=0;a4=0;a6=0;}
		if(h==0){a6=0;a7=0;a8=0;}
		if(w==l.taille-1){a8=0;a5=0;a3=0;}
		if(h==l.taille-1){a1=0;a2=0;a3=0;}
		
		if(a1!=0){a1=this.accessible(h+1,w-1);}
		if(a2!=0){a2=this.accessible(h+1,w);}
		if(a3!=0){a3=this.accessible(h+1,w+1);}
		if(a4!=0){a4=this.accessible(h,w-1);}
		if(a5!=0){a5=this.accessible(h,w+1);}
		if(a6!=0){a6=this.accessible(h-1,w-1);}
		if(a7!=0){a7=this.accessible(h-1,w);}
		if(a8!=0){a8=this.accessible(h-1,w+1);}
		//System.out.println("a1="+a1+" a2="+a2+" a3="+a3+" a4="+a4+" a5="+a5+" a6="+a6+" a7="+a7+" a8="+a8);
		int somme=a1+a2+a3+a4+a5+a6+a7+a8;
		
		if(somme==0){this.energie=this.energie-1;}
			else
			{
				Vector<Integer> a= new Vector();
				a.add(a1);a.add(a2);a.add(a3);a.add(a4);a.add(a5);a.add(a6);a.add(a7);a.add(a8);
				int r=(int)(Math.random()*somme);
				//System.out.println(r+","+somme);
				int p=0,i=0;
				while(p==0){
					if((r==0) && (a.get(i)!=0)){
						p=1;
						//System.out.println("case:"+i);
						this.cases(i);
					}
					else{
						if(a.get(i)!=0){r=r-1;}
					}
					i++;
				}
				this.energie=this.energie-1;
			}
	}
	
	public void action(){
		//si il y a de la bouffe en prendre une quantite aleatoire
		for(int i=0;i<l.nourriture.size();i++){
			if((l.nourriture.get(i).h==h)&&(l.nourriture.get(i).w==w)){
				int a=(int)(Math.random()*(l.nourriture.get(i).quantite)+1);
				//System.out.println("quantite consommer: "+a+" energie: "+l.nourriture.get(i).energie);
				this.energie=this.energie+l.nourriture.get(i).consommer(a);
				if(l.nourriture.get(i).quantite==0){l.nourriture.remove(i);//System.out.println("quantite consommer: totalite");
				}
				else{//System.out.println("nourriture restante: "+l.nourriture.get(i).quantite);
				}
			}
		}
		//reproduction
		int p=0;
		if(this.energie>10){
		for(int j=0;j<l.lofteur.size();j++){
			if((l.lofteur.get(j).h==h)&&(l.lofteur.get(j).w==w)&&(p==0)){
				this.energie=this.energie-10;
				l.lofteur.get(j).energie=l.lofteur.get(j).energie-10;
				p=1;
			}
		}	
		}
		//creer un nouveau neuneu si p=1
		if(p==1){
			//System.out.println("nouveau neuneu");
			l.add(new vorace(l,this.h,this.w,10));
		}
	}
}
