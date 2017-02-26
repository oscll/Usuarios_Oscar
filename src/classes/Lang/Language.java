package classes.Lang;

import java.io.IOException;
import java.util.Properties;

import classes.Settings;

public class Language extends Properties {
	private static final long serialVersionUID = 1L;
	private static Language instance;

	public void getProperties(String idioma) {
		try {
			this.load(getClass().getResourceAsStream(idioma));
		} catch (IOException ex) {
		}
	}

	public Language() {
		switch (Settings.getInstance().getLanguage()) {
		case "English":
			this.getProperties("English.properties");
			break;
		case "Spanish":
			this.getProperties("Spanish.properties");
			break;
		case "Valencia":
			this.getProperties("Valencia.properties");
			break;
		default:
			getProperties("English.properties");
		}
	}

	public static Language getInstance() {
		if (instance == null) {
			instance = new Language();
		}
		return instance;
	}

	public void setIdioma() {
		switch (Settings.getInstance().getLanguage()) {
		case "English":
			this.getProperties("English.properties");
			break;
		case "Spanish":
			this.getProperties("Spanish.properties");
			break;
		case "Valencia":
			this.getProperties("Valencia.properties");
			break;
		default:
			this.getProperties("English.properties");
		}
	}

}
