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

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

import classes.Lang.Language;
import modules.user.Model.classes.admin;
import modules.user.Model.classes.singleton;

public class save_ondemand {

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
		String PATH;
		String ENCODING = "UTF-8";

		try {
			OutputStream os = new ByteArrayOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			XStream xstream = new XStream();

			// Annotations.configureAliases(xstream, Usuarios.class);
			String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
			xstream.toXML(singleton.useradmin, osw);

			StringBuffer xml = new StringBuffer();
			xml.append(header);
			xml.append(os.toString());

			JFileChooser fileChooser = new JFileChooser();

			fileChooser.setAcceptAllFileFilterUsed(false);
			fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("XML (*.xml)", "xml"));

			int seleccion = fileChooser.showSaveDialog(null);

			if (seleccion == JFileChooser.APPROVE_OPTION) {
				File JFC = fileChooser.getSelectedFile();
				PATH = JFC.getAbsolutePath();

				if (!PATH.endsWith(".xml")) {
					PATH = PATH + ".xml";
				}

				FileWriter fileXml = new FileWriter(PATH);
				fileXml.write(xml.toString());
				fileXml.close();
				osw.close();
				os.close();

				JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("xmlsaved"),
						Language.getInstance().getProperty("xml"), JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (HeadlessException | IOException e) {
			JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("xmlerror"),
					Language.getInstance().getProperty("Error"), JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void guardarxml_client() {
		String PATH;
		String ENCODING = "UTF-8";

		try {
			OutputStream os = new ByteArrayOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			XStream xstream = new XStream();

			// Annotations.configureAliases(xstream, Usuarios.class);
			String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
			xstream.toXML(singleton.userclient, osw);

			StringBuffer xml = new StringBuffer();
			xml.append(header);
			xml.append(os.toString());

			JFileChooser fileChooser = new JFileChooser();

			fileChooser.setAcceptAllFileFilterUsed(false);
			fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("XML (*.xml)", "xml"));

			int seleccion = fileChooser.showSaveDialog(null);

			if (seleccion == JFileChooser.APPROVE_OPTION) {
				File JFC = fileChooser.getSelectedFile();
				PATH = JFC.getAbsolutePath();

				if (!PATH.endsWith(".xml")) {
					PATH = PATH + ".xml";
				}

				FileWriter fileXml = new FileWriter(PATH);
				fileXml.write(xml.toString());
				fileXml.close();
				osw.close();
				os.close();

				JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("xmlsaved"),
						Language.getInstance().getProperty("xml"), JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (HeadlessException | IOException e) {
			JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("xmlerror"),
					Language.getInstance().getProperty("Error"), JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void guardarxml_normal() {
		String PATH;
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

			JFileChooser fileChooser = new JFileChooser();

			fileChooser.setAcceptAllFileFilterUsed(false);
			fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("XML (*.xml)", "xml"));

			int seleccion = fileChooser.showSaveDialog(null);

			if (seleccion == JFileChooser.APPROVE_OPTION) {
				File JFC = fileChooser.getSelectedFile();
				PATH = JFC.getAbsolutePath();

				if (!PATH.endsWith(".xml")) {
					PATH = PATH + ".xml";
				}

				FileWriter fileXml = new FileWriter(PATH);
				fileXml.write(xml.toString());
				fileXml.close();
				osw.close();
				os.close();
				JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("xmlsaved"),
						Language.getInstance().getProperty("xml"), JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (HeadlessException | IOException e) {
			JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("xmlerror"),
					Language.getInstance().getProperty("Error"), JOptionPane.ERROR_MESSAGE);
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
			File f;
			JFileChooser fileChooser = new JFileChooser();
			int seleccion = fileChooser.showSaveDialog(null);
			if (seleccion == JFileChooser.APPROVE_OPTION) {
				File JFC = fileChooser.getSelectedFile();
				PATH = JFC.getAbsolutePath();
				if (!PATH.endsWith(".txt")) {
					PATH = PATH + ".txt";
				}
				f = new File(PATH);

				FileOutputStream fo = new FileOutputStream(f);
				ObjectOutputStream o = new ObjectOutputStream(fo);
				o.writeObject(singleton.useradmin);
				o.close();
				JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("txtsaved"),
						Language.getInstance().getProperty("txt"), JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("txterror"),
					Language.getInstance().getProperty("Error"), JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void generatxt_client() {
		String PATH = null;
		try {
			File f;
			JFileChooser fileChooser = new JFileChooser();
			int seleccion = fileChooser.showSaveDialog(null);
			if (seleccion == JFileChooser.APPROVE_OPTION) {
				File JFC = fileChooser.getSelectedFile();
				PATH = JFC.getAbsolutePath();
				if (!PATH.endsWith(".txt")) {
					PATH = PATH + ".txt";
				}
				f = new File(PATH);

				FileOutputStream fo = new FileOutputStream(f);
				ObjectOutputStream o = new ObjectOutputStream(fo);
				o.writeObject(singleton.userclient);
				o.close();
				JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("txtsaved"),
						Language.getInstance().getProperty("txt"), JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("txterror"),
					Language.getInstance().getProperty("Error"), JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void generatxt_normal() {
		String PATH = null;
		try {
			File f;
			JFileChooser fileChooser = new JFileChooser();
			int seleccion = fileChooser.showSaveDialog(null);
			if (seleccion == JFileChooser.APPROVE_OPTION) {
				File JFC = fileChooser.getSelectedFile();
				PATH = JFC.getAbsolutePath();
				if (!PATH.endsWith(".txt")) {
					PATH = PATH + ".txt";
				}
				f = new File(PATH);

				FileOutputStream fo = new FileOutputStream(f);
				ObjectOutputStream o = new ObjectOutputStream(fo);
				o.writeObject(singleton.usernormal);
				o.close();
				JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("txtsaved"),
						Language.getInstance().getProperty("txt"), JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("txterror"),
					Language.getInstance().getProperty("Error"), JOptionPane.ERROR_MESSAGE);
		}
	}

	/*
	 .----------------.  .----------------.  .----------------.  .-----------------.
	| .--------------. || .--------------. || .--------------. || .--------------. |
	| |     _____    | || |    _______   | || |     ____     | || | ____  _____  | |
	| |    |_   _|   | || |   /  ___  |  | || |   .'    `.   | || ||_   \|_   _| | |
	| |      | |     | || |  |  (__ \_|  | || |  /  .--.  \  | || |  |   \ | |   | |
	| |   _  | |     | || |   '.___`-.   | || |  | |    | |  | || |  | |\ \| |   | |
	| |  | |_' |     | || |  |`\____) |  | || |  \  `--'  /  | || | _| |_\   |_  | |
	| |  `.___.'     | || |  |_______.'  | || |   `.____.'   | || ||_____|\____| | |
	| |              | || |              | || |              | || |              | |
	| '--------------' || '--------------' || '--------------' || '--------------' |
	 '----------------'  '----------------'  '----------------'  '----------------' 
	
	 */

	public static void generajson() {
		String PATH = null;
		try {
			XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
			xstreamjson.setMode(XStream.NO_REFERENCES);
			xstreamjson.alias("admin", admin.class);

			JFileChooser fileChooser = new JFileChooser();
			int seleccion = fileChooser.showSaveDialog(null);
			if (seleccion == JFileChooser.APPROVE_OPTION) {
				File JFC = fileChooser.getSelectedFile();
				PATH = JFC.getAbsolutePath();
				PATH = PATH + ".json";

				Gson gson = new Gson();
				System.out.println("Peta");
				System.out.println(singleton.useradmin.toString());
				String json = gson.toJson(singleton.useradmin);
				FileWriter fileXml = new FileWriter(PATH);
				fileXml.write(json.toString());
				fileXml.close();

				JOptionPane.showMessageDialog(null, "Archivo JSON guardado con exito", "Archivo JSON",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al grabar el JSON", Language.getInstance().getProperty("Error"),
					JOptionPane.ERROR_MESSAGE);
		}
	}

}
