/**
 * 
 */
package config;

/**
 * @author ro6k4
 *
 */
public enum ConfigValues {

	RAW("brut"),
	PREPROC("precalcule");
	
	private String name = "";
	
	private ConfigValues(String name) {
		this.name = name;
	}
	
	public String toString(){
		return this.name;
	}
}
