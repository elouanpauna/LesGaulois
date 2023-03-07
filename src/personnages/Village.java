package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private int nbVillagoies=0;
	private Gaulois[] villagoies;
	
	
	public Village(String nom, int nbVillagoiesMaximum) {
		this.nom = nom;
		this.villagoies= new Gaulois[nbVillagoiesMaximum];
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		villagoies[nbVillagoies]=gaulois;
		nbVillagoies=nbVillagoies+1;
	}
	public Chef getChef() {
		return chef ; 
	}
	public String getNom() {
		return nom;
	}
	
	public int getNbVillagoies() {
		return nbVillagoies;
	}
	
	public Gaulois trouverHabitant(int numéroVillagoie) {
		return villagoies[numéroVillagoie-1];
	}
	 public void afficherVillagoies(Village village) {
		System.out.println("Dans le village du chef "+ village.getChef() + " vivent les légendaires gaulois :");
		for (int i=1; i<= village.getNbVillagoies();i+=1) {
		System.out.println("- " + village.trouverHabitant(i).getNom());
		}
	 }
	
	public static void main(String[] args) {
		final Village village= new Village("Village des irréductibles",30);
		//Gaulois gaulois = village.trouverHabitant(30);
		//il y a une exception car il ne peut y avoir que jusqu'à un villagoie 29
		final Gaulois asterix= new Gaulois("Asterix",8);
		final Chef abraracourcix = new Chef("Abraracourcix",6,village);
		village.ajouterHabitant(asterix);
		village.setChef(abraracourcix);
		//Gaulois gaulois = village.trouverHabitant(1);
		//System.out.println(gaulois);
		//ces instruction renvoie la variable gaulois qui posséde le gaulois asterix;
		final Gaulois obelix= new Gaulois("Obelix",25);
		village.ajouterHabitant(obelix);
		village.afficherVillagoies(village);
	}
}


