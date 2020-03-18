/**
 * 
 */
package core;

/**
 * @author ro6k4
 *
 */
public enum XmlNodes {

	CONFIG("configuration"),
	DOMFOLDER("dossier"),
	DOMAINS("domaines"),
	DOMAIN("domaine"),
	CATS("categories"),
	CAT("categorie"),
	SUBCATS("sous_categories"),
	SUBCAT("sous_categorie"),
	FIELDS("champs"),
	FIELD("champ"),
	NAME("nom"),
	TYPE("type"),
	RANK("ordre");
	
	private String name = "";
	
	private XmlNodes(String name) {
		this.name = name;
	}
	
	public String toString(){
		return this.name;
	}
}
