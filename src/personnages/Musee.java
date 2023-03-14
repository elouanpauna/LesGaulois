package personnages;

public class Musee {
	private Trophee[] tab= new Trophee[200];
	private int nbTrophee;
	
	public void donnerTrophee(Gaulois gaulois, Equipement equipement) {
		Trophee don= new Trophee(gaulois,equipement);
		tab[nbTrophee]=don;
		nbTrophee++;
	}
	
	public String extraireInstructionsCaml() {
		String c="let musee = [";
		for (int i=0;i<nbTrophee;i++) {
			c+=  tab[i].donnerNom() + ", " + tab[i].getEquipement().name() + ";" ;
		}
		c+="]";
		return c;
	}
}
