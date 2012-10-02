import java.util.*;

public class erratique extends beta {

	public erratique(Loft l1,int h1,int w1,int e){
		super(l1, h1, w1, e);
		regime.add(0);
		regime.add(1);
		regime.add(2);
		genre="erratique";
	}
	public int accessible(int a,int b){//a faire
		int r=1;
		if(a<0){r=0;}
		if(a>l.taille-1){r=0;}
		if(b<0){r=0;}
		if(b>l.taille-1){r=0;}
		return r;
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
		
		if(a1!=0){a1=this.accessible(h-1,w-1);}
		if(a2!=0){a2=this.accessible(h-1,w);}
		if(a3!=0){a3=this.accessible(h-1,w+1);}
		if(a4!=0){a4=this.accessible(h,w-1);}
		if(a5!=0){a5=this.accessible(h,w+1);}
		if(a6!=0){a6=this.accessible(h+1,w-1);}
		if(a7!=0){a7=this.accessible(h+1,w);}
		if(a8!=0){a8=this.accessible(h+1,w+1);}
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
}
