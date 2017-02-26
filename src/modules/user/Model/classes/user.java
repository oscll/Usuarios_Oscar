package modules.user.Model.classes;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import classes.fecha;
import modules.user.Model.utils.funciones_fecha_user;

@SuppressWarnings("serial")
@XStreamAlias("user")
public abstract class user implements Comparable<user>, java.io.Serializable {
	// Attributes
	@XStreamAlias("dni")
	private String dni;
	@XStreamAlias("nom")
	private String nom;
	@XStreamAlias("address")
	private String address;
	@XStreamAlias("email")
	private String email;
	@XStreamAlias("avatar")
	private String avatar;
	@XStreamAlias("tipo")
	private String tipo;
	@XStreamAlias("username")
	private String username;
	@XStreamAlias("password")
	private String password;
	@XStreamAlias("fecha_nacimiento")
	private fecha fecha_nacimiento;
	@XStreamAlias("edad")
	private int edad;

	// constructor
	public user(String dni, String nom, String address, fecha fecha_nacimiento, String email, String avatar,
			String tipo, String username, String password) {
		this.dni = dni;
		this.nom = nom;
		this.address = address;
		this.fecha_nacimiento = fecha_nacimiento;
		this.edad = funciones_fecha_user.Edad_Anti(fecha_nacimiento);
		this.email = email;
		this.avatar = avatar;
		this.tipo = tipo;
		this.username = username;
		this.password = password;

	}

	public user(String dni) {
		this.dni = dni;

	}

	// getters
	public fecha getFecha_nacimiento() {
		return this.fecha_nacimiento;

	}

	public String getNom() {
		return this.nom;
	}

	public String getDni() {
		return this.dni;
	}

	public String getAddress() {
		return this.address;
	}

	public int getEdad() {
		return this.edad;
	}

	public String getEmail() {
		return this.email;
	}

	public String getAvatar() {
		return this.avatar;
	}

	public String getTipo() {
		return this.tipo;
	}

	public String getUsername() {
		return this.username;
	}

	public String getPassword() {
		return this.password;
	}

	// setters
	public void setFecha_nacimiento(fecha fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
		this.edad = funciones_fecha_user.Edad_Anti(fecha_nacimiento);
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int compareTo(user param) {// para ordenar los empleados por nombre
		if (this.getDni().compareTo(param.getDni()) > 0)
			return 1;
		if (this.getDni().compareTo(param.getDni()) < 0)
			return -1;
		return 0;
	}

	public boolean equals(Object param) {
		return getDni().equals(((user) param).getDni());
	}

	// toStrings
	public abstract String toString();

}