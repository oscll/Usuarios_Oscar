package modules.user.Model.BLL.BLL_User.Save_Open.generic;

import classes.Settings;
import modules.user.Model.BLL.BLL_User.Save_Open.funciones_save_open.open_auto;
import modules.user.Model.BLL.BLL_User.Save_Open.funciones_save_open.open_ondemand;
import utils.auto_settings;

public class open {
	public static void auto() {
		open_auto.abrirxml_admin();
		open_auto.abrirxml_client();
		open_auto.abrirxml_normal();
		open_auto.obri_txt_admin();
		open_auto.obri_txt_client();
		open_auto.obri_txt_normal();
		auto_settings.open_settings_xml();

	}

	public static void ondemand(int i) {
		switch (i) {
		case 0://Normal
			switch (Settings.getInstance().getFormato()) {
			case 0:
				open_ondemand.abrirxml_normal();//Open XML
				break;
			case 1:
				open_ondemand.obri_txt_normal();//Open TXT
				break;
			}
			break;
		case 1://Client
			switch (Settings.getInstance().getFormato()) {
			case 0:
				open_ondemand.abrirxml_client();//Open XML
				break;
			case 1:
				open_ondemand.obri_txt_client();//Open TXT
				break;
			}
			break;
		case 2://Admin
			switch (Settings.getInstance().getFormato()) {
			case 0:
				open_ondemand.abrirxml_admin();//Open XML
				break;
			case 1:
				open_ondemand.obri_txt_admin();//Open TXT
				break;
			}
			break;
		}

	}

}
