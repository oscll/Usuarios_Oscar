package modules.user.Model.classes;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import classes.fecha;
import classes.Lang.Language;
import modules.user.Model.utils.funciones_fecha_user;
import utils.Format;

public class client extends user {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8405176907751882372L;
	// Attributes
	// int puntos;
	@XStreamAlias("descuentos")
	int descuentos;
	@XStreamAlias("n_visitas")
	int n_visitas;
	@XStreamAlias("fecha_alta")
	fecha fecha_alta;
	@XStreamAlias("antiguitat_alta")
	int antiguitat_alta;
	@XStreamAlias("pasta_que_ha_soltado")
	float pasta_que_ha_soltado;

	// Constructor
	public client(String dni, String nom, String address, fecha fecha_nacimiento, fecha fecha_alta, String email,
			String avatar, String tipo, String username, String password, float pasta_que_ha_soltado, int n_visitas) {
		super(dni, nom, address, fecha_nacimiento, email, avatar, tipo, username, password);

		this.n_visitas = n_visitas;
		this.fecha_alta = fecha_alta;
		this.antiguitat_alta = funciones_fecha_user.Edad_Anti(fecha_alta);
		this.pasta_que_ha_soltado = pasta_que_ha_soltado;
		this.descuentos = this.calcula_descuento(this.pasta_que_ha_soltado);
	}

	public client(String dni) {
		super(dni);
	}

	// Getters

	public Float getPasta_que_ha_soltado() {
		return pasta_que_ha_soltado;
	}

	public int getDescuentos() {
		return this.descuentos;
	}

	public int getN_visitas() {
		return this.n_visitas;
	}

	public fecha getFecha_Alta() {
		return this.fecha_alta;
	}

	public int getAntiguitat_alta() {
		return this.antiguitat_alta;
	}

	// Setters

	public void setPasta_que_ha_soltado(float pasta_que_ha_soltado) {
		this.pasta_que_ha_soltado = pasta_que_ha_soltado;
		this.descuentos = this.calcula_descuento(this.pasta_que_ha_soltado);
	}

	/*
	 * public void setPuntos(int puntos) { this.puntos = puntos; }
	 */

	public void setN_visitas(int n_visitas) {
		this.n_visitas = n_visitas;
	}

	public void setFecha_Alta(fecha fecha_alta) {
		this.fecha_alta = fecha_alta;
		this.antiguitat_alta = funciones_fecha_user.Edad_Anti(fecha_alta);
	}

	// toString

	public String toString() {
		String cad = "";
		cad += Language.getInstance().getProperty("tu_dni") + "\t\t-> " + this.getDni() + " \n";
		cad += Language.getInstance().getProperty("tu_name") + "\t\t-> " + this.getNom() + " \n";
		cad += Language.getInstance().getProperty("tu_addres") + "\t\t-> " + this.getAddress() + " \n";
		cad += Language.getInstance().getProperty("tu_birthday") + "\t-> " + this.getFecha_nacimiento().toString()
				+ "\n";
		cad += Language.getInstance().getProperty("tu_date_alta") + "\t-> " + this.getFecha_Alta().toString() + "\n";
		cad += Language.getInstance().getProperty("tu_age") + "\t\t-> " + this.getEdad() + " \n";
		cad += Language.getInstance().getProperty("tu_email") + "\t\t-> " + this.getEmail() + " \n";
		cad += Language.getInstance().getProperty("tu_avatar") + "\t\t-> " + this.getAvatar() + " \n";
		cad += Language.getInstance().getProperty("tu_tipo") + "\t\t-> " + this.getTipo() + " \n";
		cad += Language.getInstance().getProperty("tu_user") + "\t\t-> " + this.getUsername() + " \n";
		cad += Language.getInstance().getProperty("tu_pass") + "\t\t-> " + this.getPassword() + " \n";
		cad += Language.getInstance().getProperty("tu_antiquity") + "\t\t-> " + this.getAntiguitat_alta() + "\n";
		cad += Language.getInstance().getProperty("tu_money_with_we") + "\t-> "
				+ Format.moneda(this.getPasta_que_ha_soltado()) + "\n";
		cad += Language.getInstance().getProperty("tu_discount") + "\t\t-> " + this.getDescuentos() + "%\n";
		cad += Language.getInstance().getProperty("tu_num_visitas") + "\t-> " + this.getN_visitas() + "\n";
		System.out.println(cad);
		return cad;
	}

	public int calcula_descuento(float pasta_que_ha_soltado) {
		int descuento = 0;

		if (pasta_que_ha_soltado <= 1500) {
			descuento = 15;
		} else if (pasta_que_ha_soltado <= 3500) {
			descuento = 25;
		} else if (pasta_que_ha_soltado <= 5000) {
			descuento = 35;
		} else {
			descuento = 50;
		}
		return descuento;
	}

}
