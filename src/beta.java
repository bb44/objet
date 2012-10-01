import java.util.*;

public abstract class beta extends food {
	public int h;
	public int w;
	public int energie;
	public Vector<Integer> regime=new Vector();
	public Loft l;
	
	public beta(Loft l1,int h1,int w1,int e){
		l=l1;
		h=h1;
		w=w1;
		energie=e;
	}
	public void action(){
		
	}
	
	public void reproduire(beta p){
		this.energie=this.energie-5;
		p.energie=p.energie-5;
		int m=(int)(Math.random()*3);
		if(m==0){erratique b=new erratique(l,
							(int)(Math.random()*l.taille),
							(int)(Math.random()*l.taille),
							4);}
		if(m==1){vorace b=new vorace(l,
				(int)(Math.random()*l.taille),
				(int)(Math.random()*l.taille),
				3);}
		if(m==2){cannibale b=new cannibale(l,
				(int)(Math.random()*l.taille),
				(int)(Math.random()*l.taille),
				5);}
		if(m==3){lapin b=new lapin(l,
				(int)(Math.random()*l.taille),
				(int)(Math.random()*l.taille),
				4);}
		l.add(b);
	}
}
