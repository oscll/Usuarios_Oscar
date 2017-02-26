package modules.user.Model.classes;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import classes.fecha;
import classes.Lang.Language;
import modules.user.Model.utils.funciones_fecha_user;
import utils.Format;

@SuppressWarnings("serial")
@XStreamAlias("admin")
public class admin extends user implements java.io.Serializable {
	// Attributes
	@XStreamAlias("sueldo")
	float sueldo;
	@XStreamAlias("antiguitat")
	int antiguitat;
	@XStreamAlias("fecha_contratacion")
	fecha fecha_contratacion;

	// Constructos
	public admin(String dni, String nom, String address, fecha fecha_nacimiento, fecha fecha_contratacion, String email,
			String avatar, String tipo, String username, String password) {
		super(dni, nom, address, fecha_nacimiento, email, avatar, tipo, username, password);
		this.fecha_contratacion = fecha_contratacion;
		this.antiguitat = funciones_fecha_user.Edad_Anti(fecha_contratacion);
		this.sueldo = calcula_sueldo(this.antiguitat);
	}

	public admin(String dni) {
		super(dni);
	}

	// Getters

	public float getSueldo() {
		return this.sueldo;
	}

	public int getAntiguitat() {
		return this.antiguitat;
	}

	public fecha getFecha_contratacion() {
		return this.fecha_contratacion;
	}

	// Setters
	public void setFecha_contratacion(fecha fecha_contratacion) {
		this.fecha_contratacion = fecha_contratacion;
		this.antiguitat = funciones_fecha_user.Edad_Anti(fecha_contratacion);
		this.sueldo = calcula_sueldo(this.antiguitat);
	}

	// toString
	public String toString() {
		String cad = "";

		cad += Language.getInstance().getProperty("tu_dni") + "\t\t\t-> " + this.getDni() + " \n";
		cad += Language.getInstance().getProperty("tu_name") + "\t\t\t-> " + this.getNom() + " \n";
		cad += Language.getInstance().getProperty("tu_addres") + "\t\t\t-> " + this.getAddress() + " \n";
		cad += Language.getInstance().getProperty("tu_hiring_date") + "\t\t-> "
				+ this.getFecha_contratacion().toString() + "\n";
		cad += Language.getInstance().getProperty("tu_birthday") + "\t\t-> " + this.getFecha_nacimiento().toString()
				+ "\n";
		cad += Language.getInstance().getProperty("tu_age") + "\t\t\t-> " + this.getEdad() + " \n";
		cad += Language.getInstance().getProperty("tu_email") + "\t\t\t-> " + this.getEmail() + " \n";
		cad += Language.getInstance().getProperty("tu_avatar") + "\t\t\t-> " + this.getAvatar() + " \n";
		cad += Language.getInstance().getProperty("tu_tipo") + "\t\t\t-> " + this.getTipo() + " \n";
		cad += Language.getInstance().getProperty("tu_user") + "\t\t\t-> " + this.getUsername() + " \n";
		cad += Language.getInstance().getProperty("tu_pass") + "\t\t\t-> " + this.getPassword() + " \n";
		cad += Language.getInstance().getProperty("tu_salary") + "\t\t\t-> " + Format.moneda(this.sueldo) + " \n";
		cad += Language.getInstance().getProperty("tu_antiquity") + "\t\t\t-> " + this.antiguitat + "\n";

		System.out.println(cad);
		return cad;
	}

	public float calcula_sueldo(int antiguitat) {
		if (antiguitat >= 10)
			antiguitat = 10;

		float sueldo = 1500.00f;
		float plus_anti = 250.50f;
		plus_anti *= antiguitat;
		sueldo += plus_anti;
		return sueldo;
	}

}
