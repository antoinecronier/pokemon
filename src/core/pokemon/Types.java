package core.pokemon;

import java.util.ArrayList;

/**
 * Class Types use to define all types like electrik, water, ...
 * @author tactfactory
 *
 */
public class Types {
	/* Attribut id_types use to manage database types ids. */
	private int id_types;
	private String nom;
	
	/* ArrayList is a container use to store object here I store Types. */
	private ArrayList<Types> fortContre;
	private ArrayList<Types> faibleContre;
	
	/**
	 * This is the constructor of class Types that used the next different params.
	 * @param nom
	 * @param fortContre
	 * @param faibleContre
	 */
	public Types(String nom, ArrayList<Types> fortContre,
			ArrayList<Types> faibleContre) {
		super();
		this.nom = nom;
		this.fortContre = fortContre;
		this.faibleContre = faibleContre;
	}
	
	/**
	 * This is the constructor of class Types that do not used any parameters.
	 */
	public Types() {
	}

	/**
	 * This is the property used to access id_types attribut.
	 * @return
	 */
	public int getId_types() {
		return id_types;
	}
	
	/**
	 * This is the property used to edit id_types attribut.
	 * @param id_types
	 */
	public void setId_types(int id_types) {
		this.id_types = id_types;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public ArrayList<Types> getFortContre() {
		return fortContre;
	}
	public void setFortContre(ArrayList<Types> fortContre) {
		this.fortContre = fortContre;
	}
	public ArrayList<Types> getFaibleContre() {
		return faibleContre;
	}
	public void setFaibleContre(ArrayList<Types> faibleContre) {
		this.faibleContre = faibleContre;
	}
	
	/**
	 * This function say true if this class Types is effective against another Types.
	 * @param typeToTest
	 * @return
	 */
	public boolean DidItIsEffective(Types typeToTest){
		boolean result = false;
		
		for (Types types : typeToTest.faibleContre) {
			if (types.id_types == this.id_types) {
				result = true;
			}
		}
		
		return result;
	}
}
