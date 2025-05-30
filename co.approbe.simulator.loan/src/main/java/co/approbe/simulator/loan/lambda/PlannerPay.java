package co.approbe.simulator.loan.lambda;

import java.util.Arrays;

public class PlannerPay {
	private Double saldoDeuda[];
	private Double abonoCapital[];
	private Double interesMensual[];
	private String fechas[];
	
	public String[] getFechas() {
		return fechas;
	}
	public void setFechas(String[] fechas) {
		this.fechas = fechas;
	}
	public Double[] getSaldoDeuda() {
		return saldoDeuda;
	}
	public Double[] getAbonoCapital() {
		return abonoCapital;
	}
	public Double[] getInteresMensual() {
		return interesMensual;
	}
	public void setSaldoDeuda(Double[] saldoDeuda) {
		this.saldoDeuda = saldoDeuda;
	}
	public void setAbonoCapital(Double[] abonoCapital) {
		this.abonoCapital = abonoCapital;
	}
	public void setInteresMensual(Double[] interesMensual) {
		this.interesMensual = interesMensual;
	}
	
	public PlannerPay(Double[] saldoDeuda, Double[] abonoCapital, Double[] interesMensual, String[] fechas) {
		super();
		this.saldoDeuda = saldoDeuda;
		this.abonoCapital = abonoCapital;
		this.interesMensual = interesMensual;
		this.fechas = fechas;
	}
	public PlannerPay() {
		super();
	}
	
}
