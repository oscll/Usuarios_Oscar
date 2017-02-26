package modules.user.Model.BLL.BLL_User.Save_Open.funciones_save_open;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.thoughtworks.xstream.XStream;

import modules.user.Model.classes.admin;
import modules.user.Model.classes.client;
import modules.user.Model.classes.normal;
import modules.user.Model.classes.singleton;

public class open_ondemand {

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
		String PATH;

		try {
			XStream xstream = new XStream();
			// Annotations.configureAliases(xstream, Usuarios.class);

			JFileChooser fileChooser = new JFileChooser();

			fileChooser.setAcceptAllFileFilterUsed(false);
			fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("XML (*.xml)", "xml"));

			int seleccion = fileChooser.showOpenDialog(null);

			if (seleccion == JFileChooser.APPROVE_OPTION) {
				File JFC = fileChooser.getSelectedFile();
				PATH = JFC.getAbsolutePath();
				singleton.useradmin = (ArrayList<admin>) xstream.fromXML(new FileReader(PATH));

				JOptionPane.showMessageDialog(null, "Archivo XML abierto con éxito", "Archivo XML",
						JOptionPane.INFORMATION_MESSAGE);
			}

		} catch (HeadlessException | FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Error al leer el XML", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	@SuppressWarnings("unchecked")
	public static void abrirxml_client() {
		String PATH;

		try {
			XStream xstream = new XStream();
			// Annotations.configureAliases(xstream, Usuarios.class);

			JFileChooser fileChooser = new JFileChooser();

			fileChooser.setAcceptAllFileFilterUsed(false);
			fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("XML (*.xml)", "xml"));

			int seleccion = fileChooser.showOpenDialog(null);

			if (seleccion == JFileChooser.APPROVE_OPTION) {
				File JFC = fileChooser.getSelectedFile();
				PATH = JFC.getAbsolutePath();
				singleton.userclient = (ArrayList<client>) xstream.fromXML(new FileReader(PATH));

				JOptionPane.showMessageDialog(null, "Archivo XML abierto con éxito", "Archivo XML",
						JOptionPane.INFORMATION_MESSAGE);
			}

		} catch (HeadlessException | FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Error al leer el XML", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	@SuppressWarnings("unchecked")
	public static void abrirxml_normal() {
		String PATH;

		try {
			XStream xstream = new XStream();
			// Annotations.configureAliases(xstream, Usuarios.class);

			JFileChooser fileChooser = new JFileChooser();

			fileChooser.setAcceptAllFileFilterUsed(false);
			fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("XML (*.xml)", "xml"));

			int seleccion = fileChooser.showOpenDialog(null);

			if (seleccion == JFileChooser.APPROVE_OPTION) {
				File JFC = fileChooser.getSelectedFile();
				PATH = JFC.getAbsolutePath();
				singleton.usernormal = (ArrayList<normal>) xstream.fromXML(new FileReader(PATH));

				JOptionPane.showMessageDialog(null, "Archivo XML abierto con éxito", "Archivo XML",
						JOptionPane.INFORMATION_MESSAGE);
			}

		} catch (HeadlessException | FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Error al leer el XML", "Error", JOptionPane.ERROR_MESSAGE);
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
	public static void obri_txt_admin() {
		String PATH = null;
		try {
			File f;
			JFileChooser fileChooser = new JFileChooser();
			int seleccion = fileChooser.showOpenDialog(null);
			if (seleccion == JFileChooser.APPROVE_OPTION) {
				File JFC = fileChooser.getSelectedFile();
				PATH = JFC.getAbsolutePath();
				f = new File(PATH);

				FileInputStream fi = new FileInputStream(f);
				ObjectInputStream oi = new ObjectInputStream(fi);
				singleton.useradmin = (ArrayList<admin>) oi.readObject();
				oi.close();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al leer el TXT", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	@SuppressWarnings("unchecked")
	public static void obri_txt_client() {
		String PATH = null;
		try {
			File f;
			JFileChooser fileChooser = new JFileChooser();
			int seleccion = fileChooser.showOpenDialog(null);
			if (seleccion == JFileChooser.APPROVE_OPTION) {
				File JFC = fileChooser.getSelectedFile();
				PATH = JFC.getAbsolutePath();
				f = new File(PATH);

				FileInputStream fi = new FileInputStream(f);
				ObjectInputStream oi = new ObjectInputStream(fi);
				singleton.userclient = (ArrayList<client>) oi.readObject();
				oi.close();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al leer el TXT", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	@SuppressWarnings("unchecked")
	public static void obri_txt_normal() {
		String PATH = null;
		try {
			File f;
			JFileChooser fileChooser = new JFileChooser();
			int seleccion = fileChooser.showOpenDialog(null);
			if (seleccion == JFileChooser.APPROVE_OPTION) {
				File JFC = fileChooser.getSelectedFile();
				PATH = JFC.getAbsolutePath();
				f = new File(PATH);

				FileInputStream fi = new FileInputStream(f);
				ObjectInputStream oi = new ObjectInputStream(fi);
				singleton.usernormal = (ArrayList<normal>) oi.readObject();
				oi.close();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al leer el TXT", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
