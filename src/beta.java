import java.util.*;

public abstract class beta extends food {
	public int h;
	public int w;
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
	public void deplacer(){
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
}
