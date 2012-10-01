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
}
