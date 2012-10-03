

public class Saison1 {

	public static int nombreLofteurs = 4;
	public static int tailleLoft = 30;
	public static float proportionErratique = .75f;
	public static float proportionVorace = .25f;
	public static float proportionCannibale = 0f;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Saison1().primeTime2();
	}
	
	public void primeTime() {
		ZoneGraphique zone = new ZoneGraphique("Mon premier loft");
		Loft loft = new Loft(tailleLoft,zone);
		//remplissageAleatoire(a) a est la probabilite que de la nourriture soit sur une case au debut
		//de la partie
		loft.remplissageAleatoire(0.1f);
		//zone.ajouterObjet(loft);
		/*
		for (int i=0 ; i<nombreLofteurs ; i++) {
			double x = Math.random();
			if (x<proportionVorace) {
				loft.add(new vorace(loft,(int)(Math.random()*29),(int)(Math.random()*29),3));
			}
			else {
				x -= proportionVorace;
				if (x<proportionErratique) {
					loft.add(new erratique(loft,
							(int)(Math.random()*29),
							(int)(Math.random()*29),4));
				}
				else {
					x -= proportionErratique;
					if (x<proportionCannibale) {
						loft.add(new cannibale(loft,
						(int)(Math.random()*29),
						(int)(Math.random()*29),
						5));
					}
				}
			}
		}
		*/
		loft.go();
	}
	public void primeTime2() {
		ZoneGraphique zone = new ZoneGraphique("Mon premier loft");
		Loft loft = new Loft(tailleLoft,zone);
		loft.remplissageAleatoire(0.1f);
		System.out.println(loft.nourriture.size()+","+loft.nourriture.get(0).h+","+loft.nourriture.get(0).w);
		loft.AfficherFood();
		
		//2 erratique en place
		//loft.add(new erratique(loft,0,0,30));
		//loft.add(new erratique(loft,tailleLoft-1,tailleLoft-1,10));
		loft.add(new lapin(loft,0,tailleLoft-1,30));
		loft.add(new lapin(loft,0,0,30));
		loft.go();
	}
	
	
}
