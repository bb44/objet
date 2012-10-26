

public class Saison1 {
//
	public static int nombreLofteurs = 4;
	public static int tailleLoft = 30;
	public static float proportionErratique = .75f;
	public static float proportionVorace = .25f;
	public static float proportionCannibale = 0f;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Saison1().primeTime();
	}
	
	
	public void primeTime() {
		
		Loft loft = new Loft(tailleLoft);
	
		loft.remplissageAleatoire(0.1f);
		loft.mettreLofteur(nombreLofteurs);
		loft.AfficherFood();
		loft.AfficherLofteur();
		ZoneGraphique zone = new ZoneGraphique(loft);
		
		int r=1;
		while(r==1){
		 r=loft.go();
		 zone.set(loft);
		 zone.dessiner();
		}
		loft.AfficherFood();
		loft.AfficherLofteur();
	}
	
	
}
