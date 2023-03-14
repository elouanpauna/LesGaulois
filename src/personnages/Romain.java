package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipement= new Equipement[2];
	private int nbEquipement=0;
	private String texte;
	
	public Romain(String nom, int force) {
			this.nom = nom;
			this.force = force;
			assert force>0;
		
	}
	public String getNom() {
			return nom;
	}
	
	public int getForce() {
		return force;
	}
	public void setForce(int force) {
		this.force = force;
	}
	public void parler(String texte) {
			System.out.println(prendreParole() + "« " + texte + "»");
	}
	private String prendreParole() {
			return "Le romain " + nom + " : ";
	}
//	public void recevoirCoup(int forceCoup) {
//			assert force>0;
//			int postcond=force;
//			force -= forceCoup;
//			assert force<postcond;
//			if (force > 0) {
//				parler("Aïe");
//			} else {
//				parler("J'abandonne...");
//}
//	}
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = CalculResistanceEquipement(forceCoup);
		force -= forceCoup;
		// if (force > 0) {
		// parler("Aïe");
		// } else {
		// equipementEjecte = ejecterEquipement();
		// parler("J'abandonne...");
		// }
		switch (force) {
		case 0:
		parler("Aïe");
		default:
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
			break;
			}
			// post condition la force a diminuée
			assert force < oldForce;
			return equipementEjecte;
			}

	private int CalculResistanceEquipement(int forceCoup) {
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (!(nbEquipement == 0)) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
		for (int i = 0; i < nbEquipement;) {
			if ((equipement[i] != null &&
		equipement[i].equals(Equipement.BOUCLIER)) == true) {
				resistanceEquipement += 8;
			} else {
				System.out.println("Equipement casque");
				resistanceEquipement += 5;
			}
			i++;
		}
		texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
		}
		
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom.toString() + "s'envole sous la force du coup.");
		//TODO
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipement[i] == null) {
				continue;
				} else {
				equipementEjecte[nbEquipementEjecte] =
				equipement[i];
				nbEquipementEjecte++;
				equipement[i] = null;
				}
				}
				return equipementEjecte;
				}

	
	public void sEquiper(Equipement equipementajouté) {
		if (equipement[1]== Equipement.CASQUE || equipement[1]== Equipement.BOUCLIER) {
			System.out.println( "Le romain " + nom + "est déja bien protégé");
		}
		else if (equipement[0]==equipementajouté) {
			System.out.println( "Le soldat " + nom + "posséde déja un"+ equipementajouté.name());
		}
		else System.out.println( "Le soldat " + nom + "s'équipe d'un" + equipementajouté.name());
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
