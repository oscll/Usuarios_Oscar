package utils;

import java.awt.HeadlessException;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import com.thoughtworks.xstream.XStream;

import classes.Settings;

public class auto_settings {
	public static void save_settings_xml() {
		String PATH = null;

		try {
			PATH = new java.io.File(".").getCanonicalPath() + "/src/file_settings/settings.xml";
		} catch (IOException e) {
			e.printStackTrace();
		}
		String ENCODING = "UTF-8";

		try {
			OutputStream os = new ByteArrayOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			XStream xstream = new XStream();

			String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
			xstream.toXML(Settings.getInstance(), osw);

			StringBuffer xml = new StringBuffer();
			xml.append(header);
			xml.append(os.toString());

			FileWriter fileXml = new FileWriter(PATH);
			fileXml.write(xml.toString());
			fileXml.close();
			osw.close();
			os.close();

		} catch (HeadlessException | IOException e) {
			System.out.println("Error guardar XML");

		}

	}

	public static void open_settings_xml() {
		String PATH = null;
		Settings instance = null;

		try {
			PATH = new java.io.File(".").getCanonicalPath() + "/src/file_settings/settings.xml";
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			XStream xstream = new XStream();
			// Annotations.configureAliases(xstream, Usuarios.class);
			instance = (Settings) xstream.fromXML(new FileReader(PATH));
			Settings.getInstance().setCurrency_config(instance.getCurrency_config());
			Settings.getInstance().setTheme(instance.getTheme());
			Settings.getInstance().setDate_config(instance.getDate_config());
			Settings.getInstance().setDecimals_config(instance.getDecimals_config());
			Settings.getInstance().setDummies(instance.getDummies());
			Settings.getInstance().setFormato(instance.getFormato());
			Settings.getInstance().setLanguage(instance.getLanguage());

		} catch (HeadlessException | FileNotFoundException e) {
			System.out.println("Error al leer XML");

		}
	}
}
