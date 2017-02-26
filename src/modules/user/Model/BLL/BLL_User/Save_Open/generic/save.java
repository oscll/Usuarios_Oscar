package modules.user.Model.BLL.BLL_User.Save_Open.generic;

import classes.Settings;
import modules.user.Model.BLL.BLL_User.Save_Open.funciones_save_open.save_auto;
import modules.user.Model.BLL.BLL_User.Save_Open.funciones_save_open.save_ondemand;
import modules.user.Model.classes.singleton;
import utils.auto_settings;

public class save {
	public static void auto() {
		if (Settings.getInstance().getDummies() == false) {
			if (singleton.useradmin.size() != 0) {
				save_auto.generatxt_admin();
				save_auto.guardarxml_admin();
			}
			if (singleton.userclient.size() != 0) {
				save_auto.generatxt_client();
				save_auto.guardarxml_client();
			}

			if (singleton.usernormal.size() != 0) {
				save_auto.generatxt_normal();
				save_auto.guardarxml_normal();
			}
		}
		auto_settings.save_settings_xml();
	}

	public static void ondemand(int i) {
		switch (i) {
		case 0://Normal
			switch (Settings.getInstance().getFormato()) {
			case 0:
				save_ondemand.guardarxml_normal();//Save XML
				break;
			case 1:
				save_ondemand.generatxt_normal();//Save TXT
				break;
			}
			break;
		case 1://Client
			switch (Settings.getInstance().getFormato()) {
			case 0:
				save_ondemand.guardarxml_client();//Save XML
				break;
			case 1:
				save_ondemand.generatxt_client();//Save TXT
				break;
			}
			break;
		case 2://Admin
			switch (Settings.getInstance().getFormato()) {
			case 0:
				save_ondemand.guardarxml_admin();//Save XML
				break;
			case 1:
				save_ondemand.generatxt_admin();//Save TXT
				break;
			}
			break;
		}

	}
}
