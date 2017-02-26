package modules.user.Model.BLL.BLL_User.Save_Open.funciones_save_open;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;

import modules.user.Model.classes.admin;
import modules.user.Model.classes.client;
import modules.user.Model.classes.normal;
import modules.user.Model.classes.singleton;

public class open_auto {
	/*
	 .----------------.  .----------------.  .----------------. 
	| .--------------. || .--------------. || .--------------. |
	| |  ____  ____  | || | ____    ____ | || |   _____      | |
	| | |_  _||_  _| | || ||_   \  /   _|| || |  |_   _|     | |
	| |   \ \  / /   | || |  |   \/   |  | || |    | |       | |
	| |    > `' <    | || |  | |\  /| |  | || |    | |   _   | |
	| |  _/ /'`\ \_  | || | _| |_\/_| |_ | || |   _| |__/ |  | |
	| | |____||____| | || ||_____||_____|| || |  |________|  | |
	| |              | || |              | || |              | |
	| '--------------' || '--------------' || '--------------' |
	 '----------------'  '----------------'  '----------------' 
	 */
	@SuppressWarnings("unchecked")
	public static void abrirxml_admin() {
		String PATH = null;

		try {
			PATH = new java.io.File(".").getCanonicalPath()
					+ "/src/modules/user/Model/files_users/Admin/files/admin.xml";
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			XStream xstream = new XStream();
			// Annotations.configureAliases(xstream, Usuarios.class);

			singleton.useradmin = (ArrayList<admin>) xstream.fromXML(new FileReader(PATH));

		} catch (HeadlessException | FileNotFoundException e) {
			System.out.println("Error al leer XML Admin");

		}
	}

	@SuppressWarnings("unchecked")
	public static void abrirxml_client() {
		String PATH = null;

		try {
			PATH = new java.io.File(".").getCanonicalPath()
					+ "/src/modules/user/Model/files_users/Client/files/client.xml";
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			XStream xstream = new XStream();
			// Annotations.configureAliases(xstream, Usuarios.class);

			singleton.userclient = (ArrayList<client>) xstream.fromXML(new FileReader(PATH));

		} catch (HeadlessException | FileNotFoundException e) {
			System.out.println("Error al leer XML Client");
		}
	}

	@SuppressWarnings("unchecked")
	public static void abrirxml_normal() {
		String PATH = null;

		try {
			PATH = new java.io.File(".").getCanonicalPath()
					+ "/src/modules/user/Model/files_users/Normal/files/normal.xml";
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			XStream xstream = new XStream();
			// Annotations.configureAliases(xstream, Usuarios.class);

			singleton.usernormal = (ArrayList<normal>) xstream.fromXML(new FileReader(PATH));

		} catch (HeadlessException | FileNotFoundException e) {
			System.out.println("Error al leer XML Normal");
		}
	}

	/* 
	 .----------------.  .----------------.  .----------------. 
	| .--------------. || .--------------. || .--------------. |
	| |  _________   | || |  ____  ____  | || |  _________   | |
	| | |  _   _  |  | || | |_  _||_  _| | || | |  _   _  |  | |
	| | |_/ | | \_|  | || |   \ \  / /   | || | |_/ | | \_|  | |
	| |     | |      | || |    > `' <    | || |     | |      | |
	| |    _| |_     | || |  _/ /'`\ \_  | || |    _| |_     | |
	| |   |_____|    | || | |____||____| | || |   |_____|    | |
	| |              | || |              | || |              | |
	| '--------------' || '--------------' || '--------------' |
	 '----------------'  '----------------'  '----------------' 
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<admin> obri_txt_admin() {
		String PATH = null;

		try {
			PATH = new java.io.File(".").getCanonicalPath()
					+ "/src/modules/user/Model/files_users/Admin/files/admin.txt";
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			File f;

			f = new File(PATH);

			FileInputStream fi = new FileInputStream(f);
			ObjectInputStream oi = new ObjectInputStream(fi);
			singleton.useradmin = (ArrayList<admin>) oi.readObject();
			oi.close();

		} catch (Exception e) {
			System.out.println("Error al leer TXT Admin");
		}
		return singleton.useradmin;
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<admin> obri_txt_client() {
		String PATH = null;

		try {
			PATH = new java.io.File(".").getCanonicalPath()
					+ "/src/modules/user/Model/files_users/Client/files/client.txt";
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			File f;

			f = new File(PATH);

			FileInputStream fi = new FileInputStream(f);
			ObjectInputStream oi = new ObjectInputStream(fi);
			singleton.userclient = (ArrayList<client>) oi.readObject();
			oi.close();

		} catch (Exception e) {
			System.out.println("Error al leer TXT Client");
		}
		return singleton.useradmin;
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<admin> obri_txt_normal() {
		String PATH = null;

		try {
			PATH = new java.io.File(".").getCanonicalPath()
					+ "/src/modules/user/Model/files_users/Normal/files/normal.txt";
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			File f;

			f = new File(PATH);

			FileInputStream fi = new FileInputStream(f);
			ObjectInputStream oi = new ObjectInputStream(fi);
			singleton.usernormal = (ArrayList<normal>) oi.readObject();
			oi.close();

		} catch (Exception e) {
			System.out.println("Error al leer TXT Normal");
		}
		return singleton.useradmin;
	}

}
