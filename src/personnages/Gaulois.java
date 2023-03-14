package personnages;

public class Gaulois {
	private String nom;
	private int force, nb_trophees;
	private int effetPotion=1;
	private Equipement trophees[] = new Equipement[100];
	
	public Gaulois(String nom, int force) {
		super();
		this.nom = nom;
		this.force = force;
	}
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + " >>");
	}
	
//	private String prendreParole() {
//		return "Le gaulois" + nom + " : ";
//	}
	
	private String prendreParole() {
		String texte = "Le gaulois " + nom + " : ";
		return texte;
		}

	
//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de "
//		+ romain.getNom());
//		romain.recevoirCoup(force / 3 * effetPotion);
//		}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement trophees[] = romain.recevoirCoup((force / 3) *
		effetPotion);
		for (int i = 0; trophees != null && i < trophees.length; i++,
		nb_trophees++) {
		this.trophees[nb_trophees] = trophees[i];
		}
		return;
		}
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	public void boirePotion(Druide druide) {
		
	}
	
	public void faireUneDonnation(Musee musee) {
		Gaulois gaulois = new Gaulois(nom ,force );
		if (trophees!=null) {
			System.out.println("<< Je Donne au musée tous mes trophees : ");
			musee.donnerTrophee(gaulois, trophees[0]);
			Trophee c= new Trophee(gaulois , trophees[0]);
			int a=1;
			System.out.println("- " + c.getEquipement().name());
			while (c!=null) {
				musee.donnerTrophee(gaulois, trophees[a]);
				c= new Trophee(gaulois, trophees[a]);
				System.out.println("- " + c.getEquipement().name());
				a++;
			}
			System.out.println(">>");
		}
	}
	
	public static void main(String[] args) {
		final Gaulois asterix=new Gaulois("Astérix",8);
		System.out.println(asterix);
		
	}
}




	





