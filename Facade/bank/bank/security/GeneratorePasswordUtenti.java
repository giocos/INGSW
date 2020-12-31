package bank.security;

import org.apache.commons.lang3.RandomStringUtils;

// USO LA LIBRERIA COMMONS LANG DI APACHE PER RICHIAMARE IL RANDOMSTRINGUTILS
@SuppressWarnings("deprecation")
public class GeneratorePasswordUtenti {
	private String characters;
	
	public GeneratorePasswordUtenti() {
		characters = "0123456789";
	};

	public String getCharacters() {
		return characters;
	}

	public void setCharacters(String characters) {
		this.characters = characters;
	}
	
	public String generaPassRandom() {
		return RandomStringUtils.random(6,characters);
	}
}
