package utils;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import classes.Settings;
import classes.Lang.Language;

public class funciones_theme {
	public static void theme() {

		//Obtener lista look&feel disponibles en el SO
		//http://www.codigofantasma.com/blog/java-look-feel-parte-1/
		try {
			switch (Settings.getInstance().getTheme()) {
			case "METAL":// Metal - Predeterminado JAVA
				UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
				break;

			case "GTK":// GTK
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				break;

			case "MOTIF":// Motif
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
				break;

			case "NINBUS"://Ninbus
				UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
				break;

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("errortheme"),
					Language.getInstance().getProperty("errortitle"), JOptionPane.ERROR_MESSAGE);
		}
	}
}
