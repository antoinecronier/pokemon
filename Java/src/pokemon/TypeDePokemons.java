package pokemon;

public class TypeDePokemons {
	private int id_type_pokemons;
	private String nom;
	private int attaque;
	private int attaque_spe;
	private int defence;
	private int defence_spe;
	private int vitesse;
	private int pv;
	
	public TypeDePokemons(String nom, int attaque, int attaque_spe,
			int defence, int defence_spe, int vitesse, int pv) {
		super();
		this.nom = nom;
		this.attaque = attaque;
		this.attaque_spe = attaque_spe;
		this.defence = defence;
		this.defence_spe = defence_spe;
		this.vitesse = vitesse;
		this.pv = pv;
	}
	
	public int getId_type_pokemons() {
		return id_type_pokemons;
	}
	public void setId_type_pokemons(int id_type_pokemons) {
		this.id_type_pokemons = id_type_pokemons;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getAttaque() {
		return attaque;
	}
	public void setAttaque(int attaque) {
		this.attaque = attaque;
	}
	public int getAttaque_spe() {
		return attaque_spe;
	}
	public void setAttaque_spe(int attaque_spe) {
		this.attaque_spe = attaque_spe;
	}
	public int getDefence() {
		return defence;
	}
	public void setDefence(int defence) {
		this.defence = defence;
	}
	public int getDefence_spe() {
		return defence_spe;
	}
	public void setDefence_spe(int defence_spe) {
		this.defence_spe = defence_spe;
	}
	public int getVitesse() {
		return vitesse;
	}
	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}
	public int getPv() {
		return pv;
	}
	public void setPv(int pv) {
		this.pv = pv;
	}
}
