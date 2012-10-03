import java.util.Vector;


public class lapin extends beta{
	public lapin(Loft l1,int h1,int w1,int e){
		super(l1, h1, w1, e);
		regime.add(0);
		regime.add(1);
		regime.add(2);
		genre="lapin";
	}
	public void deplacer(){
		//System.out.println("deplacement depuis ("+h+","+w+")");
		int n=0;
		//on parcours la nourriture pour trouver le site le plus proche
		int e=this.ProximiterBeta();
		
		if(e>-1){
			//System.out.println("recherche "+l.lofteur.get(e).genre);
			int x=h-l.lofteur.get(e).h;
			int y=w-l.lofteur.get(e).w;
			//System.out.println("vecteur: "+x+","+y);
			int x1=h,y1=w;
			if(x<0){x1=h+1;}
			if(x==0){x1=h;}
			if(x>0){x1=h-1;}
			if(y<0){y1=w+1;}
			if(y==0){y1=w;}
			if(y>0){y1=w-1;}
			//System.out.println("position souhaitée: "+x1+","+y1);
			if(this.accessible(x1,y1)==1){
				h=x1;w=y1;n=1;this.energie=this.energie-1;
			}
		}
		if(n==0){
		int a1=1,a2=1,a3=1,a4=1,a5=1,a6=1,a7=1,a8=1;
		if(w==0){a1=0;a4=0;a6=0;}
		if(h==0){a6=0;a7=0;a8=0;}
		if(w==l.taille-1){a8=0;a5=0;a3=0;}
		if(h==l.taille-1){a1=0;a2=0;a3=0;}
		if(a1!=0){a1=this.accessible(h+1,w-1);//System.out.println("a1="+a1);
		}
		if(a2!=0){a2=this.accessible(h+1,w);//System.out.println("a2="+a2);
		}
		if(a3!=0){a3=this.accessible(h+1,w+1);//System.out.println("a3="+a3);
		}
		if(a4!=0){a4=this.accessible(h,w-1);//System.out.println("a4="+a4);
		}
		if(a5!=0){a5=this.accessible(h,w+1);//System.out.println("a5="+a5);
		}
		
		if(a6!=0){a6=this.accessible(h-1,w-1);//System.out.println("a6="+a6);
		}
		if(a7!=0){a7=this.accessible(h-1,w);//System.out.println("a7="+a7);
		}
		if(a8!=0){a8=this.accessible(h-1,w+1);//System.out.println("a8="+a8);
		}
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
	}
	public int ProximiterBeta(){//si renvoi -1 alors il n'y a plus de nourriture
	int i,r=-1,d2,a,dist2=(l.taille)*(l.taille);
	
		for(i=0;i<l.lofteur.size();i++){
			a=l.lofteur.get(i).w-this.w;
		
		d2=((l.lofteur.get(i).h-this.h)*(l.lofteur.get(i).h-this.h)+(l.lofteur.get(i).w-this.w)*(l.lofteur.get(i).w-this.w));
		
		if((d2<dist2)&&(d2!=0)){
			dist2=d2;
			r=i;
		}
		}

return r;
	}

	public void action(){
		//si il y a de la bouffe en prendre une quantite aleatoire
		for(int i=0;i<l.nourriture.size();i++){
			if((l.nourriture.get(i).h==h)&&(l.nourriture.get(i).w==w)){
				int a=(int)(Math.random()*(l.nourriture.get(i).quantite)+1);
				//System.out.println("quantite consommer: "+a+"/"+l.nourriture.get(i).quantite);
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
			System.out.println("nouveau neuneu");
			l.add(new lapin(l,this.h,this.w,10));
		}
	}
}
