package modules.user.Model.classes;

import classes.fecha;
import classes.Lang.Language;

@SuppressWarnings("serial")
public class normal extends user {
	// Atributos
	int comentarios;
	int n_visitas;
	String karma;
	int puntos;

	// Constructor
	public normal(String dni, String nom, String address, fecha fecha_nacimiento, String email, String avatar,
			String tipo, String username, String password, int comentarios, int n_visitas) {
		super(dni, nom, address, fecha_nacimiento, email, avatar, tipo, username, password);
		this.karma = calcula_karma(comentarios);
		this.comentarios = comentarios;
		this.puntos = calcula_puntos(karma);
		this.n_visitas = n_visitas;
		System.out.println(comentarios);
	}

	public normal(String dni) {
		super(dni);
	}

	// Getters

	public int getComentarios() {
		return this.comentarios;
	}

	public String getKarma() {
		return this.karma;
	}

	public int getPuntos() {
		return this.puntos;
	}

	public int getN_visitas() {
		return this.n_visitas;
	}

	// Setters

	public void setN_visitas(int n_visitas) {
		this.n_visitas = n_visitas;
	}

	public void setComentarios(int comentarios) {
		this.comentarios = comentarios;
		this.karma = calcula_karma(this.comentarios);
		this.puntos = calcula_puntos(this.karma);
	}

	// toString

	public String toString() {
		String cad = "";
		cad += Language.getInstance().getProperty("tu_dni") + "\t\t-> " + this.getDni() + " \n";
		cad += Language.getInstance().getProperty("tu_name") + "\t\t-> " + this.getNom() + " \n";
		cad += Language.getInstance().getProperty("tu_addres") + "\t\t-> " + this.getAddress() + " \n";
		cad += Language.getInstance().getProperty("tu_birthday") + "\t-> " + this.getFecha_nacimiento().toString()
				+ "\n";
		cad += Language.getInstance().getProperty("tu_age") + "\t\t-> " + this.getEdad() + " \n";
		cad += Language.getInstance().getProperty("tu_email") + "\t\t-> " + this.getEmail() + " \n";
		cad += Language.getInstance().getProperty("tu_avatar") + "\t\t-> " + this.getAvatar() + " \n";
		cad += Language.getInstance().getProperty("tu_tipo") + "\t\t-> " + this.getTipo() + " \n";
		cad += Language.getInstance().getProperty("tu_user") + "\t\t-> " + this.getUsername() + " \n";
		cad += Language.getInstance().getProperty("tu_pass") + "\t\t-> " + this.getPassword() + " \n";
		cad += Language.getInstance().getProperty("tu_point") + "\t\t-> " + this.getPuntos() + "\n";
		cad += Language.getInstance().getProperty("tu_num_visitas") + "\t-> " + this.getN_visitas() + "\n";
		cad += Language.getInstance().getProperty("tu_karma") + " \t\t-> " + this.getKarma() + "\n";
		cad += Language.getInstance().getProperty("tu_comments") + "\t\t-> " + this.getComentarios() + "\n";
		System.out.println(cad);
		return cad;
	}

	public String calcula_karma(int comentarios) {
		String karma = "";

		if (comentarios < 51) {
			karma = "Low";
		} else if (comentarios <= 100) {
			karma = "Medium";
		} else if (comentarios > 100) {
			karma = "High";
		}
		return karma;
	}

	public int calcula_puntos(String karma) {
		int puntos = 0;

		switch (karma) {
		case "Low":
			puntos = 25;
			break;
		case "Medium":
			puntos = 50;
			break;
		case "High":
			puntos = 100;
			break;
		}
		return puntos;
	}

}
