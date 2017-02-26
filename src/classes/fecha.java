package classes;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@SuppressWarnings("serial")
@XStreamAlias("fecha")
public class fecha implements Serializable {
	// Atributos
	@XStreamAlias("fecha1")
	private String fecha;
	@XStreamAlias("dia")
	private int dia;
	@XStreamAlias("mes")
	private int mes;
	@XStreamAlias("anyo")
	private int anyo;

	private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

	// Constructor
	public fecha(String introducefecha) {
		String[] SplitArray = null;

		switch (Settings.getInstance().getDate_config()) {
		case "dd/mm/yyyy":
			SplitArray = introducefecha.split("/");
			this.dia = Integer.parseInt(SplitArray[0]);
			this.mes = Integer.parseInt(SplitArray[1]);
			this.anyo = Integer.parseInt(SplitArray[2]);
			this.fecha = this.dia + "/" + this.mes + "/" + this.anyo;
			break;
		case "dd-mm-yyyy":
			SplitArray = introducefecha.split("-");
			this.dia = Integer.parseInt(SplitArray[0]);
			this.mes = Integer.parseInt(SplitArray[1]);
			this.anyo = Integer.parseInt(SplitArray[2]);
			this.fecha = this.dia + "/" + this.mes + "/" + this.anyo;
			break;
		case "yyyy/mm/dd":
			SplitArray = introducefecha.split("/");
			this.dia = Integer.parseInt(SplitArray[2]);
			this.mes = Integer.parseInt(SplitArray[1]);
			this.anyo = Integer.parseInt(SplitArray[0]);
			this.fecha = this.dia + "/" + this.mes + "/" + this.anyo;
			break;
		case "yyyy-mm-dd":
			SplitArray = introducefecha.split("-");
			this.dia = Integer.parseInt(SplitArray[2]);
			this.mes = Integer.parseInt(SplitArray[1]);
			this.anyo = Integer.parseInt(SplitArray[0]);
			this.fecha = this.dia + "/" + this.mes + "/" + this.anyo;
			break;

		}

	}

	public fecha(String dia, String mes, String anyo) {
		this.dia = Integer.parseInt(dia);
		this.mes = Integer.parseInt(mes);
		this.anyo = Integer.parseInt(anyo);
		this.fecha = this.dia + "/" + this.mes + "/" + this.anyo;
	}

	// toString
	public String toString() {
		String fecha = null;

		switch (Settings.getInstance().getDate_config()) {
		case "dd/mm/yyyy":
			fecha = this.dia + "/" + this.mes + "/" + this.anyo;
			break;
		case "dd-mm-yyyy":
			fecha = this.dia + "-" + this.mes + "-" + this.anyo;
			break;
		case "yyyy/mm/dd":
			fecha = this.anyo + "/" + this.mes + "/" + this.dia;
			break;
		case "yyyy-mm-dd":
			fecha = this.anyo + "-" + this.mes + "-" + this.dia;
			break;
		}
		return fecha;
	}

	// Validar fecha
	// si boolean hasta_el_dia_de_hoy es true dira que las fechas que sobrepasen
	// el dia actual son incorrectas
	public boolean ValidaFecha(boolean hasta_el_dia_de_hoy) {
		int anyosistema = this.anyoactual();
		int messistema = this.mesactual();
		int diasistema = this.diaactual();
		boolean resultado = true;
		GregorianCalendar fecha = new GregorianCalendar();
		int dias_mes[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		if ((this.mes < 1) || (this.mes > 12)) {
			resultado = false;
		}

		if (resultado) {
			fecha.set(this.anyo, this.mes, this.dia);

			if (fecha.isLeapYear(this.anyo)) {
				dias_mes[2] = 29;
			}

			if ((this.dia < 1) || (this.dia > dias_mes[this.mes])) {
				resultado = false;
			}

			if (hasta_el_dia_de_hoy == true) {
				if (this.anyo > anyosistema)
					resultado = false;
				if (this.anyo == (anyosistema)) {
					if (this.mes > messistema)
						resultado = false;
					else if (this.mes == messistema) {
						if (this.dia > diasistema)
							resultado = false;
					}
				}
			}

		}

		return resultado;
	}

	/**
	 * Compara la fecha Fecha de referencia con una segunda fecha Fecha. Si la
	 * fecha de refencia es anterior a la segunda fecha, devuelve -1. Si la
	 * fecha de refencia es posterior a la segunda fecha, devuelve 1. Si la
	 * fecha de refencia es igual a la segunda fecha, devuelve 0.
	 **/
	public int comparafecha(fecha fecha, int edad_minima) {
		int resultado;
		Calendar fecha1 = Calendar.getInstance();
		Calendar fecha2 = Calendar.getInstance();
		edad_minima -= 1;// temporal

		fecha1.clear();
		fecha2.clear();

		fecha1.set((this.anyo + edad_minima), this.mes - 1, this.dia);
		fecha2.set(fecha.getAnyo(), fecha.getMes() - 1, fecha.getDia());

		resultado = fecha1.compareTo(fecha2);
		return resultado;
	}

	// String to Calendar
	public Calendar deStringToCalendar(String fecha) {
		Date fechaDate = new Date();
		Calendar fechaCalendar = new GregorianCalendar();
		try {
			fechaDate = formato.parse(fecha);
			fechaCalendar.setTime(fechaDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return fechaCalendar;
	}

	// Resta fecha
	public int RestaFechas() {
		int diferencia, any1, anyosistema;
		Calendar cal1 = new GregorianCalendar();

		cal1 = (deStringToCalendar(fecha));

		any1 = cal1.get(Calendar.YEAR);
		anyosistema = this.anyoactual();

		diferencia = anyosistema - any1;

		return diferencia;
	}

	/***** No se si poner los aqui o en funciones_fecha_user ****/
	// Dia sistema
	public int diaactual() {
		Calendar fecha = new GregorianCalendar();
		int dia = fecha.get(Calendar.DAY_OF_MONTH);
		return dia;
	}

	// Any sistema
	public int anyoactual() {
		Calendar fecha = new GregorianCalendar();
		int anyo = fecha.get(Calendar.YEAR);
		return anyo;
	}

	// Mes sistema
	public int mesactual() {
		Calendar fecha = new GregorianCalendar();
		int mes = fecha.get(Calendar.MONTH);
		return mes + 1;
	}

	// Getters & Setters

	public int getDia() {
		return dia;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

}
