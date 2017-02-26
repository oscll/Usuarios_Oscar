package modules.user.Model.BLL.BLL_User.Save_Open.funciones_save_open;

import java.awt.HeadlessException;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import com.thoughtworks.xstream.XStream;

import modules.user.Model.classes.singleton;

public class save_auto {

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
	public static void guardarxml_admin() {
		String PATH = null;

		try {
			PATH = new java.io.File(".").getCanonicalPath()
					+ "/src/modules/user/Model/files_users/Admin/files/admin.xml";
		} catch (IOException e) {
			e.printStackTrace();
		}
		String ENCODING = "UTF-8";

		try {
			OutputStream os = new ByteArrayOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			XStream xstream = new XStream();

			String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
			xstream.toXML(singleton.useradmin, osw);

			StringBuffer xml = new StringBuffer();
			xml.append(header);
			xml.append(os.toString());

			FileWriter fileXml = new FileWriter(PATH);
			fileXml.write(xml.toString());
			fileXml.close();
			osw.close();
			os.close();

		} catch (HeadlessException | IOException e) {
			System.out.println("Error guardar XML Admin");

		}
	}

	public static void guardarxml_client() {
		String PATH = null;

		try {
			PATH = new java.io.File(".").getCanonicalPath()
					+ "/src/modules/user/Model/files_users/Client/files/client.xml";
		} catch (IOException e) {
			e.printStackTrace();
		}
		String ENCODING = "UTF-8";

		try {
			OutputStream os = new ByteArrayOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			XStream xstream = new XStream();

			String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
			xstream.toXML(singleton.userclient, osw);

			StringBuffer xml = new StringBuffer();
			xml.append(header);
			xml.append(os.toString());

			FileWriter fileXml = new FileWriter(PATH);
			fileXml.write(xml.toString());
			fileXml.close();
			osw.close();
			os.close();

		} catch (HeadlessException | IOException e) {
			System.out.println("Error guardar XML Client");
		}
	}

	public static void guardarxml_normal() {
		String PATH = null;

		try {
			PATH = new java.io.File(".").getCanonicalPath()
					+ "/src/modules/user/Model/files_users/Normal/files/normal.xml";
		} catch (IOException e) {
			e.printStackTrace();
		}
		String ENCODING = "UTF-8";

		try {
			OutputStream os = new ByteArrayOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			XStream xstream = new XStream();

			String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
			xstream.toXML(singleton.usernormal, osw);

			StringBuffer xml = new StringBuffer();
			xml.append(header);
			xml.append(os.toString());

			FileWriter fileXml = new FileWriter(PATH);
			fileXml.write(xml.toString());
			fileXml.close();
			osw.close();
			os.close();

		} catch (HeadlessException | IOException e) {
			System.out.println("Error guardar XML Normal");

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

	public static void generatxt_admin() {
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

			FileOutputStream fo = new FileOutputStream(f);
			ObjectOutputStream o = new ObjectOutputStream(fo);
			o.writeObject(singleton.useradmin);
			o.close();
		} catch (

		Exception e) {
			System.out.println("Error guardar TXT Admin");
		}
	}

	public static void generatxt_client() {
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

			FileOutputStream fo = new FileOutputStream(f);
			ObjectOutputStream o = new ObjectOutputStream(fo);
			o.writeObject(singleton.userclient);
			o.close();
		} catch (

		Exception e) {
			System.out.println("Error guardar TXT Client");
		}
	}

	public static void generatxt_normal() {
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

			FileOutputStream fo = new FileOutputStream(f);
			ObjectOutputStream o = new ObjectOutputStream(fo);
			o.writeObject(singleton.usernormal);
			o.close();
		} catch (

		Exception e) {
			System.out.println("Error guardar TXT Normal");
		}
	}
}
