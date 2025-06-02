package co.approbe.core.dto;

public class RequestHubspot {
	private String action;
	private String email; 
	private String firstname; 
	private String lastname; 
	private String id_titular; 
	private String mobilephone; 
	private String phone; 
	private String company; 
	private String city; 
	private String jobtitle; 
	private String id; 
	private String dealname; 
	private String idDeal; 
	private String name; 
	private String domain; 
	private String nit; 
	private String representante_legal; 
	private String cc_representante_legal; 
	
	// para crear los creditos
	
	private int plazo; 
	private double tasa_ea; 
	private double monto_desembolso; 
	private double amount;
	private String status_credit; 
	private int cuota_canceladas; 
	private double cuota_mensual;
	private double gmf; 
	private int dias_mora; 
	private String financier; 
	private String producto;
	private double valor_mes_actual; 
	private double deuda_total; 
	private String fecha_terminacion_credito; 
	private String cuenta_pago; 
	private String fecha_ultimo_pago; 
	private double valor_pago; 
	private String medio_pago; 
	private double gac; 
	private double n_cuotas_gac; 
	private String fecha_promesa; 
	private double valor_promesa; 
	private String gestion_llamada; 
	private String fecha_extracto; 
	private String fecha_notificacion; 
	private String envio_indicacion; 
	private String notificacion_gac; 
	
	
	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getRepresentante_legal() {
		return representante_legal;
	}

	public void setRepresentante_legal(String representante_legal) {
		this.representante_legal = representante_legal;
	}

	public String getCc_representante_legal() {
		return cc_representante_legal;
	}

	public void setCc_representante_legal(String cc_representante_legal) {
		this.cc_representante_legal = cc_representante_legal;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getId_titular() {
		return id_titular;
	}

	public void setId_titular(String id_titular) {
		this.id_titular = id_titular;
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getJobtitle() {
		return jobtitle;
	}

	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDealname() {
		return dealname;
	}

	public void setDealname(String dealname) {
		this.dealname = dealname;
	}

	public String getIdDeal() {
		return idDeal;
	}

	public void setIdDeal(String idDeal) {
		this.idDeal = idDeal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public int getPlazo() {
		return plazo;
	}

	public void setPlazo(int plazo) {
		this.plazo = plazo;
	}

	public double getTasa_ea() {
		return tasa_ea;
	}

	public void setTasa_ea(double tasa_ea) {
		this.tasa_ea = tasa_ea;
	}

	public double getMonto_desembolso() {
		return monto_desembolso;
	}

	public void setMonto_desembolso(double monto_desembolso) {
		this.monto_desembolso = monto_desembolso;
	}

	public double getCuota_mensual() {
		return cuota_mensual;
	}

	public void setCuota_mensual(double cuota_mensual) {
		this.cuota_mensual = cuota_mensual;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus_credit() {
		return status_credit;
	}

	public void setStatus_credit(String status_credit) {
		this.status_credit = status_credit;
	}

	public int getCuota_canceladas() {
		return cuota_canceladas;
	}

	public void setCuota_canceladas(int cuota_canceladas) {
		this.cuota_canceladas = cuota_canceladas;
	}

	public double getGmf() {
		return gmf;
	}

	public void setGmf(double gmf) {
		this.gmf = gmf;
	}

	public int getDias_mora() {
		return dias_mora;
	}

	public void setDias_mora(int dias_mora) {
		this.dias_mora = dias_mora;
	}

	public String getFinancier() {
		return financier;
	}

	public void setFinancier(String financier) {
		this.financier = financier;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public double getValor_mes_actual() {
		return valor_mes_actual;
	}

	public void setValor_mes_actual(double valor_mes_actual) {
		this.valor_mes_actual = valor_mes_actual;
	}

	public double getDeuda_total() {
		return deuda_total;
	}

	public void setDeuda_total(double deuda_total) {
		this.deuda_total = deuda_total;
	}

	public String getFecha_terminacion_credito() {
		return fecha_terminacion_credito;
	}

	public void setFecha_terminacion_credito(String fecha_terminacion_credito) {
		this.fecha_terminacion_credito = fecha_terminacion_credito;
	}

	public String getCuenta_pago() {
		return cuenta_pago;
	}

	public void setCuenta_pago(String cuenta_pago) {
		this.cuenta_pago = cuenta_pago;
	}

	public String getFecha_ultimo_pago() {
		return fecha_ultimo_pago;
	}

	public void setFecha_ultimo_pago(String fecha_ultimo_pago) {
		this.fecha_ultimo_pago = fecha_ultimo_pago;
	}

	public double getValor_pago() {
		return valor_pago;
	}

	public void setValor_pago(double valor_pago) {
		this.valor_pago = valor_pago;
	}

	public String getMedio_pago() {
		return medio_pago;
	}

	public void setMedio_pago(String medio_pago) {
		this.medio_pago = medio_pago;
	}

	public double getGac() {
		return gac;
	}

	public void setGac(double gac) {
		this.gac = gac;
	}

	public double getN_cuotas_gac() {
		return n_cuotas_gac;
	}

	public void setN_cuotas_gac(double n_cuotas_gac) {
		this.n_cuotas_gac = n_cuotas_gac;
	}

	public String getFecha_promesa() {
		return fecha_promesa;
	}

	public void setFecha_promesa(String fecha_promesa) {
		this.fecha_promesa = fecha_promesa;
	}

	public double getValor_promesa() {
		return valor_promesa;
	}

	public void setValor_promesa(double valor_promesa) {
		this.valor_promesa = valor_promesa;
	}

	public String getGestion_llamada() {
		return gestion_llamada;
	}

	public void setGestion_llamada(String gestion_llamada) {
		this.gestion_llamada = gestion_llamada;
	}

	public String getFecha_extracto() {
		return fecha_extracto;
	}

	public void setFecha_extracto(String fecha_extracto) {
		this.fecha_extracto = fecha_extracto;
	}

	public String getFecha_notificacion() {
		return fecha_notificacion;
	}

	public void setFecha_notificacion(String fecha_notificacion) {
		this.fecha_notificacion = fecha_notificacion;
	}

	public String getEnvio_indicacion() {
		return envio_indicacion;
	}

	public void setEnvio_indicacion(String envio_indicacion) {
		this.envio_indicacion = envio_indicacion;
	}

	public String getNotificacion_gac() {
		return notificacion_gac;
	}

	public void setNotificacion_gac(String notificacion_gac) {
		this.notificacion_gac = notificacion_gac;
	}

	@Override
	public String toString() {
		return "{\"action\":\"" + action + "\", \"email\":\"" + email + "\", \"firstname\":\"" + firstname
				+ "\", \"lastname\":\"" + lastname + "\", \"id_titular\":\"" + id_titular + "\", \"mobilephone\":\""
				+ mobilephone + "\", \"phone\":\"" + phone + "\", \"company\":\"" + company + "\", \"city\":\"" + city
				+ "\", \"jobtitle\":\"" + jobtitle + "\", \"id\":\"" + id + "\", \"dealname\":\"" + dealname
				+ "\", \"idDeal\":\"" + idDeal + "\", \"name\":\"" + name + "\", \"domain\":\"" + domain
				+ "\", \"nit\":\"" + nit + "\", \"representante_legal\":\"" + representante_legal
				+ "\", \"cc_representante_legal\":\"" + cc_representante_legal + "\", \"plazo\":\"" + plazo
				+ "\", \"tasa_ea\":\"" + tasa_ea + "\", \"monto_desembolso\":\"" + monto_desembolso
				+ "\", \"amount\":\"" + amount + "\", \"status_credit\":\"" + status_credit
				+ "\", \"cuota_canceladas\":\"" + cuota_canceladas + "\", \"cuota_mensual\":\"" + cuota_mensual
				+ "\", \"gmf\":\"" + gmf + "\", \"dias_mora\":\"" + dias_mora + "\", \"financier\":\"" + financier
				+ "\", \"producto\":\"" + producto + "\", \"valor_mes_actual\":\"" + valor_mes_actual
				+ "\", \"deuda_total\":\"" + deuda_total + "\", \"fecha_terminacion_credito\":\""
				+ fecha_terminacion_credito + "\", \"cuenta_pago\":\"" + cuenta_pago + "\", \"fecha_ultimo_pago\":\""
				+ fecha_ultimo_pago + "\", \"valor_pago\":\"" + valor_pago + "\", \"medio_pago\":\"" + medio_pago
				+ "\", \"gac\":\"" + gac + "\", \"n_cuotas_gac\":\"" + n_cuotas_gac + "\", \"fecha_promesa\":\""
				+ fecha_promesa + "\", \"valor_promesa\":\"" + valor_promesa + "\", \"gestion_llamada\":\""
				+ gestion_llamada + "\", \"fecha_extracto\":\"" + fecha_extracto + "\", \"fecha_notificacion\":\""
				+ fecha_notificacion + "\", \"envio_indicacion\":\"" + envio_indicacion + "\", \"notificacion_gac\":\""
				+ notificacion_gac + "\"}";
	}

	
}

