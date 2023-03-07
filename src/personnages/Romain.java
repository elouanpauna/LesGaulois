package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipement= new Equipement[2];
	private int nbEquipement=0;
	
	public Romain(String nom, int force) {
			this.nom = nom;
			this.force = force;
			assert force>0;
		
	}
	public String getNom() {
			return nom;
	}
	public void parler(String texte) {
			System.out.println(prendreParole() + "« " + texte + "»");
	}
	private String prendreParole() {
			return "Le romain " + nom + " : ";
	}
	public void recevoirCoup(int forceCoup) {
			assert force>0;
			int postcond=force;
			force -= forceCoup;
			assert force<postcond;
			if (force > 0) {
				parler("Aïe");
			} else {
				parler("J'abandonne...");
}
	}
	
	public String sEquiper(Equipement equipementajouté) {
		if (equipement[1]== Equipement.CASQUE) {
			return "Le romain " + nom + "est déja bien protégé";
		}
	}
	public static void main(String[] args) {
		final Romain minus =new Romain("Minus",6);
		System.out.println(Equipement.CASQUE);
		System.out.println(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		
}
}
