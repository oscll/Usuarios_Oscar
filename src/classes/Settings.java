package classes;

import java.io.Serializable;
import java.util.ArrayList;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import classes.Lang.Language;
import modules.user.Model.BLL.BLL_Dummies.funciones_dummies;
import modules.user.Model.BLL.BLL_User.Save_Open.generic.open;
import modules.user.Model.classes.admin;
import modules.user.Model.classes.client;
import modules.user.Model.classes.normal;
import modules.user.Model.classes.singleton;
import utils.funciones_menus;
import utils.funciones_theme;

@SuppressWarnings("serial")
@XStreamAlias("Settings")
public class Settings implements Serializable {
	@XStreamAlias("formato")
	private int formato;
	@XStreamAlias("currency_config")
	private char currency_config;
	@XStreamAlias("decimals_config")
	private int decimals_config;
	@XStreamAlias("date_config")
	private String date_config;
	@XStreamAlias("dummies")
	private boolean dummies;
	@XStreamAlias("language")
	private String language;
	@XStreamAlias("theme")
	private String theme;
	@XStreamAlias("instance")
	private static Settings instance;

	public Settings(String date_config, char currency_config, int decimals_config, boolean dummies, int formato,
			String language, String theme) {
		super();
		this.date_config = date_config;
		this.currency_config = currency_config;
		this.decimals_config = decimals_config;
		this.dummies = dummies;
		this.formato = formato;
		this.language = language;
		this.theme = theme;
	}

	public Settings() {
		super();
		this.date_config = "dd/mm/yyyy";
		this.currency_config = '€';
		this.decimals_config = 2;
		this.dummies = true;
		this.formato = 0;
		this.language = "English";
		this.theme = "METAL";
		;

		//0 = XML
		//1 = TXT
		//2 = JSON
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
		Language.getInstance().setIdioma();
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
		funciones_theme.theme();
	}

	public static void setInstance(Settings instance) {
		Settings.instance = instance;
	}

	public static Settings getInstance() {
		if (instance == null) {
			instance = new Settings();

			funciones_theme.theme();
			Language.getInstance();

			singleton.useradmin = new ArrayList<admin>();
			singleton.userclient = new ArrayList<client>();
			singleton.usernormal = new ArrayList<normal>();

			open.auto();
			String[] dumm = { Language.getInstance().getProperty("yes"), Language.getInstance().getProperty("no") };
			int dummies = funciones_menus.menu_buttons(dumm, Language.getInstance().getProperty("dummies1"),
					Language.getInstance().getProperty("dummies"));
			if (dummies == 0) {
				Settings.getInstance().setDummies(true);
				singleton.useradmin.clear();
				singleton.userclient.clear();
				singleton.usernormal.clear();
				funciones_dummies.makedummies_admin();
				funciones_dummies.makedummies_client();
				funciones_dummies.makedummies_normal();
			} else
				Settings.getInstance().setDummies(false);

		}
		return instance;
	}

	public String getDate_config() {
		return date_config;
	}

	public int getFormato() {
		return formato;
	}

	public void setFormato(int formato) {
		this.formato = formato;
	}

	public boolean getDummies() {
		return dummies;
	}

	public void setDummies(boolean dummies) {
		this.dummies = dummies;
	}

	public void setDate_config(String date_config) {
		this.date_config = date_config;
	}

	public char getCurrency_config() {
		return currency_config;
	}

	public void setCurrency_config(char currency_config) {
		this.currency_config = currency_config;
	}

	public int getDecimals_config() {
		return decimals_config;
	}

	public void setDecimals_config(int decimals_config) {
		this.decimals_config = decimals_config;
	}

	@Override
	public String toString() {
		return "Config [date_config=" + date_config + ", currency_config=" + currency_config + ", decimals_config="
				+ decimals_config + ", dummies_config=" + dummies + ", fomarmato" + formato + "]";
	}
}
