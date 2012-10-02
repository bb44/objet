import java.util.Vector;


public class vorace extends erratique{

	public vorace(Loft l1,int h1,int w1,int e){
		super(l1, h1, w1, e);
		genre="vorace";
	}
	
	
	
	public void deplacer(){
		System.out.println("deplacement depuis ("+h+","+w+")");
		int n=0;
		//on parcours la nourriture pour trouver le site le plus proche
		int e=this.ProximiterFood();
		
		if(e>-1){
			System.out.println("recherche");
			int x=h-l.nourriture.get(e).h;
			int y=w-l.nourriture.get(e).w;
			System.out.println("vecteur: "+x+","+y);
			int x1=h,y1=w;
			if(x<0){x1=h+1;}
			if(x==0){x1=h;}
			if(x>0){x1=h-1;}
			if(y<0){y1=w+1;}
			if(y==0){y1=w;}
			if(y>0){y1=w-1;}
			System.out.println("position souhaitée: "+x1+","+y1);
			if(this.accessible(x1,y1)==1){
				h=x1;w=y1;n=1;
			}
		}
		if(n==0){
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
		System.out.println("a1="+a1+" a2="+a2+" a3="+a3+" a4="+a4+" a5="+a5+" a6="+a6+" a7="+a7+" a8="+a8);
		int somme=a1+a2+a3+a4+a5+a6+a7+a8;
		
		if(somme==0){this.energie=this.energie-1;}
			else
			{
				Vector<Integer> a= new Vector();
				a.add(a1);a.add(a2);a.add(a3);a.add(a4);a.add(a5);a.add(a6);a.add(a7);a.add(a8);
				int r=(int)(Math.random()*somme);
				System.out.println(r+","+somme);
				int p=0,i=0;
				while(p==0){
					if((r==0) && (a.get(i)!=0)){
						p=1;
						System.out.println("case:"+i);
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
	public int ProximiterFood(){//si renvoi -1 alors il n'y a plus de nourriture
	int i,r=-1,d2,a,dist2=(l.taille)*(l.taille);
	
		for(i=0;i<l.nourriture.size();i++){
			a=l.nourriture.get(i).w-this.w;
		
		d2=((l.nourriture.get(i).h-this.h)*(l.nourriture.get(i).h-this.h)+(l.nourriture.get(i).w-this.w)*(l.nourriture.get(i).w-this.w));
		
		if((d2<dist2)&&(d2!=0)){
			dist2=d2;
			r=i;
		}
		}

return r;
	}
}
