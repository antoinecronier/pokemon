package pokemon;

public class Attaques {
	private int id_attaques;
	private String nom;
	private int puissance;
	private int precision;
	private Types type;
	
	public Attaques(String nom, int puissance, int precision,
			Types type) {
		super();
		this.nom = nom;
		this.puissance = puissance;
		this.precision = precision;
		this.type = type;
	}
	
	public int getId_attaques() {
		return id_attaques;
	}
	public void setId_attaques(int id_attaques) {
		this.id_attaques = id_attaques;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getPuissance() {
		return puissance;
	}
	public void setPuissance(int puissance) {
		this.puissance = puissance;
	}
	public int getPrecision() {
		return precision;
	}
	public void setPrecision(int precision) {
		this.precision = precision;
	}
	public Types getType() {
		return type;
	}
	public void setType(Types type) {
		this.type = type;
	}
}
