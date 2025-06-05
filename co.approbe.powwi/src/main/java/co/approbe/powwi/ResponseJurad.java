package co.approbe.powwi;

import java.util.Arrays;

public class ResponseJurad {
	
		private StatusId estadoCedula;
		private SarlaftVID sarlaftVID;
		private String mensaje;
		
		public StatusId getEstadoCedula() {
			return estadoCedula;
		}
		public void setEstadoCedula(StatusId estadoCedula) {
			this.estadoCedula = estadoCedula;
		}
		public String getMensaje() {
			return mensaje;
		}
		public void setMensaje(String mensaje) {
			this.mensaje = mensaje;
		}

		public SarlaftVID getSarlaftVID() {
			return sarlaftVID;
		}

		public void setSarlaftVID(SarlaftVID sarlaftVID) {
			this.sarlaftVID = sarlaftVID;
		}

		public ResponseJurad() {
			super();
			// TODO Auto-generated constructor stub
		}

		public ResponseJurad(StatusId estadoCedula, SarlaftVID sarlaftVID, String mensaje) {
			super();
			this.estadoCedula = estadoCedula;
			this.sarlaftVID = sarlaftVID;
			this.mensaje = mensaje;
		}

		@Override
		public String toString() {
			return "{\"estadoCedula\":\"" + estadoCedula + "\", \"sarlaftVID\":\"" + sarlaftVID + "\", \"mensaje\":\""
					+ mensaje + "\"}";
		}

		public class SarlaftVID{
			private int status;
			private String codigoError;
			private String mensajeError;
			private int estadoFuente;
			private String estadoFuenteLeyenda;
			private String fechaUltimaActualizacion;
			private ListasResponse[] listasResponse;
			private PepsResponse[] pepsResponse;
			private String noticiasResponse;
			private String validacionIdentidad;
			private String denominacion;
			private NovedadesMonitoreoResponse[] novedadesMonitoreoResponse;
			private NovedadesListasResponse [] novedadesListasResponse;
			
			public SarlaftVID() {
			}

			public SarlaftVID(int status, String codigoError, String mensajeError, int estadoFuente,
					String estadoFuenteLeyenda, String fechaUltimaActualizacion, ListasResponse[] listasResponse,
					PepsResponse[] pepsResponse, String noticiasResponse, String validacionIdentidad,
					String denominacion, NovedadesMonitoreoResponse[] novedadesMonitoreoResponse,
					NovedadesListasResponse[] novedadesListasResponse) {
				super();
				this.status = status;
				this.codigoError = codigoError;
				this.mensajeError = mensajeError;
				this.estadoFuente = estadoFuente;
				this.estadoFuenteLeyenda = estadoFuenteLeyenda;
				this.fechaUltimaActualizacion = fechaUltimaActualizacion;
				this.listasResponse = listasResponse;
				this.pepsResponse = pepsResponse;
				this.noticiasResponse = noticiasResponse;
				this.validacionIdentidad = validacionIdentidad;
				this.denominacion = denominacion;
				this.novedadesMonitoreoResponse = novedadesMonitoreoResponse;
				this.novedadesListasResponse = novedadesListasResponse;
			}



			public int getStatus() {
				return status;
			}
			public void setStatus(int status) {
				this.status = status;
			}
			public String getCodigoError() {
				return codigoError;
			}
			public void setCodigoError(String codigoError) {
				this.codigoError = codigoError;
			}
			public String getMensajeError() {
				return mensajeError;
			}
			public void setMensajeError(String mensajeError) {
				this.mensajeError = mensajeError;
			}
			public int getEstadoFuente() {
				return estadoFuente;
			}
			public void setEstadoFuente(int estadoFuente) {
				this.estadoFuente = estadoFuente;
			}
			public String getEstadoFuenteLeyenda() {
				return estadoFuenteLeyenda;
			}
			public void setEstadoFuenteLeyenda(String estadoFuenteLeyenda) {
				this.estadoFuenteLeyenda = estadoFuenteLeyenda;
			}
			public String getFechaUltimaActualizacion() {
				return fechaUltimaActualizacion;
			}
			public void setFechaUltimaActualizacion(String fechaUltimaActualizacion) {
				this.fechaUltimaActualizacion = fechaUltimaActualizacion;
			}
			
			public ListasResponse[] getListasResponse() {
				return listasResponse;
			}
			public void setListasResponse(ListasResponse[] listasResponse) {
				this.listasResponse = listasResponse;
			}
			public PepsResponse[] getPepsResponse() {
				return pepsResponse;
			}
			public void setPepsResponse(PepsResponse[] pepsResponse) {
				this.pepsResponse = pepsResponse;
			}
			public String getNoticiasResponse() {
				return noticiasResponse;
			}
			public void setNoticiasResponse(String noticiasResponse) {
				this.noticiasResponse = noticiasResponse;
			}
			public String getValidacionIdentidad() {
				return validacionIdentidad;
			}
			public void setValidacionIdentidad(String validacionIdentidad) {
				this.validacionIdentidad = validacionIdentidad;
			}
			public String getDenominacion() {
				return denominacion;
			}
			public void setDenominacion(String denominacion) {
				this.denominacion = denominacion;
			}
			public NovedadesMonitoreoResponse[] getNovedadesMonitoreoResponse() {
				return novedadesMonitoreoResponse;
			}

			public void setNovedadesMonitoreoResponse(NovedadesMonitoreoResponse[] novedadesMonitoreoResponse) {
				this.novedadesMonitoreoResponse = novedadesMonitoreoResponse;
			}

			public NovedadesListasResponse[] getNovedadesListasResponse() {
				return novedadesListasResponse;
			}

			public void setNovedadesListasResponse(NovedadesListasResponse[] novedadesListasResponse) {
				this.novedadesListasResponse = novedadesListasResponse;
			}

			@Override
			public String toString() {
				return "{\"status\":\"" + status + "\", \"codigoError\":\"" + codigoError + "\", \"mensajeError\":\""
						+ mensajeError + "\", \"estadoFuente\":\"" + estadoFuente + "\", \"estadoFuenteLeyenda\":\""
						+ estadoFuenteLeyenda + "\", \"fechaUltimaActualizacion\":\"" + fechaUltimaActualizacion
						+ "\", \"listasResponse\":\"" + listasResponse  + "\", \"pepsResponse\":\""
						+ pepsResponse + "\", \"noticiasResponse\":\"" + noticiasResponse
						+ "\", \"validacionIdentidad\":\"" + validacionIdentidad + "\", \"denominacion\":\""
						+ denominacion + "\", \"novedadesMonitoreoResponse\":\"" + novedadesMonitoreoResponse
						+ "\", \"novedadesListasResponse\":\"" + novedadesListasResponse + "\"}";
			}

			
		}

		public class StatusId{
			private String status;
			private String codigoError;
			private String mensajeError;
			private String estadoFuente;
			private String estadoFuenteLeyenda;
			private String fechaUltimaActualizacion;
			private String denominacion;
			private String estadoCedula;
			public String getStatus() {
				return status;
			}
			public void setStatus(String status) {
				this.status = status;
			}
			public String getCodigoError() {
				return codigoError;
			}
			public void setCodigoError(String codigoError) {
				this.codigoError = codigoError;
			}
			public String getMensajeError() {
				return mensajeError;
			}
			public void setMensajeError(String mensajeError) {
				this.mensajeError = mensajeError;
			}
			public String getEstadoFuente() {
				return estadoFuente;
			}
			public void setEstadoFuente(String estadoFuente) {
				this.estadoFuente = estadoFuente;
			}
			public String getEstadoFuenteLeyenda() {
				return estadoFuenteLeyenda;
			}
			public void setEstadoFuenteLeyenda(String estadoFuenteLeyenda) {
				this.estadoFuenteLeyenda = estadoFuenteLeyenda;
			}
			public String getFechaUltimaActualizacion() {
				return fechaUltimaActualizacion;
			}
			public void setFechaUltimaActualizacion(String fechaUltimaActualizacion) {
				this.fechaUltimaActualizacion = fechaUltimaActualizacion;
			}
			public String getDenominacion() {
				return denominacion;
			}
			public void setDenominacion(String denominacion) {
				this.denominacion = denominacion;
			}
			public String getEstadoCedula() {
				return estadoCedula;
			}
			public void setEstadoCedula(String estadoCedula) {
				this.estadoCedula = estadoCedula;
			}
			@Override
			public String toString() {
				return "{\"status\":\"" + status + "\", \"codigoError\":\"" + codigoError + "\", \"mensajeError\":\""
						+ mensajeError + "\", \"estadoFuente\":\"" + estadoFuente + "\", \"estadoFuenteLeyenda\":\""
						+ estadoFuenteLeyenda + "\", \"fechaUltimaActualizacion\":\"" + fechaUltimaActualizacion
						+ "\", \"denominacion\":\"" + denominacion + "\", \"estadoCedula\":\"" + estadoCedula + "\"}";
			}
			
		}
		public class PepsResponse{
			private String coincidencia;
			private String porcentajeCoincidencia;
			private String listasTipoIdentificacion;
			private String listasNroIdentificacion;
			private String listasNombre;
			private String nombreLista;
            private String cargo;
			private String dependencia;
            private String publicacion;
			public String getCoincidencia() {
				return coincidencia;
			}
			public void setCoincidencia(String coincidencia) {
				this.coincidencia = coincidencia;
			}
			public String getPorcentajeCoincidencia() {
				return porcentajeCoincidencia;
			}
			public void setPorcentajeCoincidencia(String porcentajeCoincidencia) {
				this.porcentajeCoincidencia = porcentajeCoincidencia;
			}
			public String getListasTipoIdentificacion() {
				return listasTipoIdentificacion;
			}
			public void setListasTipoIdentificacion(String listasTipoIdentificacion) {
				this.listasTipoIdentificacion = listasTipoIdentificacion;
			}
			public String getListasNroIdentificacion() {
				return listasNroIdentificacion;
			}
			public void setListasNroIdentificacion(String listasNroIdentificacion) {
				this.listasNroIdentificacion = listasNroIdentificacion;
			}
			public String getListasNombre() {
				return listasNombre;
			}
			public void setListasNombre(String listasNombre) {
				this.listasNombre = listasNombre;
			}
			public String getNombreLista() {
				return nombreLista;
			}
			public void setNombreLista(String nombreLista) {
				this.nombreLista = nombreLista;
			}
			public String getCargo() {
				return cargo;
			}
			public void setCargo(String cargo) {
				this.cargo = cargo;
			}
			public String getDependencia() {
				return dependencia;
			}
			public void setDependencia(String dependencia) {
				this.dependencia = dependencia;
			}
			public String getPublicacion() {
				return publicacion;
			}
			public void setPublicacion(String publicacion) {
				this.publicacion = publicacion;
			}
			public PepsResponse(String coincidencia, String porcentajeCoincidencia, String listasTipoIdentificacion,
					String listasNroIdentificacion, String listasNombre, String nombreLista, String cargo,
					String dependencia, String publicacion) {
				super();
				this.coincidencia = coincidencia;
				this.porcentajeCoincidencia = porcentajeCoincidencia;
				this.listasTipoIdentificacion = listasTipoIdentificacion;
				this.listasNroIdentificacion = listasNroIdentificacion;
				this.listasNombre = listasNombre;
				this.nombreLista = nombreLista;
				this.cargo = cargo;
				this.dependencia = dependencia;
				this.publicacion = publicacion;
			}
			@Override
			public String toString() {
				return "{\"coincidencia\":\"" + coincidencia + "\", \"porcentajeCoincidencia\":\""
						+ porcentajeCoincidencia + "\", \"listasTipoIdentificacion\":\"" + listasTipoIdentificacion
						+ "\", \"listasNroIdentificacion\":\"" + listasNroIdentificacion + "\", \"listasNombre\":\""
						+ listasNombre + "\", \"nombreLista\":\"" + nombreLista + "\", \"cargo\":\"" + cargo
						+ "\", \"dependencia\":\"" + dependencia + "\", \"publicacion\":\"" + publicacion + "\"}";
			}
            
		}
		
		public class ListasResponse{
			
			private String coincidencia;
			private String porcentajeCoincidencia;
			private String listasTipoIdentificacion;
			private String listasNroIdentificacion;
			private String listasNombre;
			private String nombreLista;
			public ListasResponse() {
				
			}
			public ListasResponse(String coincidencia, String porcentajeCoincidencia, String listasTipoIdentificacion,
					String listasNroIdentificacion, String listasNombre, String nombreLista) {
				super();
				this.coincidencia = coincidencia;
				this.porcentajeCoincidencia = porcentajeCoincidencia;
				this.listasTipoIdentificacion = listasTipoIdentificacion;
				this.listasNroIdentificacion = listasNroIdentificacion;
				this.listasNombre = listasNombre;
				this.nombreLista = nombreLista;
			}
			public String getCoincidencia() {
				return coincidencia;
			}
			public String getPorcentajeCoincidencia() {
				return porcentajeCoincidencia;
			}
			public String getListasTipoIdentificacion() {
				return listasTipoIdentificacion;
			}
			public String getListasNroIdentificacion() {
				return listasNroIdentificacion;
			}
			public String getListasNombre() {
				return listasNombre;
			}
			public String getNombreLista() {
				return nombreLista;
			}
			public void setCoincidencia(String coincidencia) {
				this.coincidencia = coincidencia;
			}
			public void setPorcentajeCoincidencia(String porcentajeCoincidencia) {
				this.porcentajeCoincidencia = porcentajeCoincidencia;
			}
			public void setListasTipoIdentificacion(String listasTipoIdentificacion) {
				this.listasTipoIdentificacion = listasTipoIdentificacion;
			}
			public void setListasNroIdentificacion(String listasNroIdentificacion) {
				this.listasNroIdentificacion = listasNroIdentificacion;
			}
			public void setListasNombre(String listasNombre) {
				this.listasNombre = listasNombre;
			}
			public void setNombreLista(String nombreLista) {
				this.nombreLista = nombreLista;
			}
			@Override
			public String toString() {
				return "{\"coincidencia\":\"" + coincidencia + "\", \"porcentajeCoincidencia\":\""
						+ porcentajeCoincidencia + "\", \"listasTipoIdentificacion\":\"" + listasTipoIdentificacion
						+ "\", \"listasNroIdentificacion\":\"" + listasNroIdentificacion + "\", \"listasNombre\":\""
						+ listasNombre + "\", \"nombreLista\":\"" + nombreLista +"\"}";
			}
		}
		
		public class NovedadesMonitoreoResponse{
			private String denominacionMonitoreada;
			private String denominacionEncontrada;
			private String porcentajeCoincidenciaDenominacion;
			public NovedadesMonitoreoResponse() {
			}
			public NovedadesMonitoreoResponse(String denominacionMonitoreada, String denominacionEncontrada,
					String porcentajeCoincidenciaDenominacion) {
				super();
				this.denominacionMonitoreada = denominacionMonitoreada;
				this.denominacionEncontrada = denominacionEncontrada;
				this.porcentajeCoincidenciaDenominacion = porcentajeCoincidenciaDenominacion;
			}
			public String getDenominacionMonitoreada() {
				return denominacionMonitoreada;
			}
			public String getDenominacionEncontrada() {
				return denominacionEncontrada;
			}
			public String getPorcentajeCoincidenciaDenominacion() {
				return porcentajeCoincidenciaDenominacion;
			}
			public void setDenominacionMonitoreada(String denominacionMonitoreada) {
				this.denominacionMonitoreada = denominacionMonitoreada;
			}
			public void setDenominacionEncontrada(String denominacionEncontrada) {
				this.denominacionEncontrada = denominacionEncontrada;
			}
			public void setPorcentajeCoincidenciaDenominacion(String porcentajeCoincidenciaDenominacion) {
				this.porcentajeCoincidenciaDenominacion = porcentajeCoincidenciaDenominacion;
			}
			@Override
			public String toString() {
				return "{\"denominacionMonitoreada\":\"" + denominacionMonitoreada + "\", \"denominacionEncontrada\":\""
						+ denominacionEncontrada + "\", \"porcentajeCoincidenciaDenominacion\":\""
						+ porcentajeCoincidenciaDenominacion + "\"}";
			} 
			
		}
		
		public class NovedadesListasResponse{
			private String denominacionMonitoreada;
			private String denominacionEncontrada;
			private String porcentajeCoincidenciaDenominacion;
			public NovedadesListasResponse() {
			}
			public NovedadesListasResponse(String denominacionMonitoreada, String denominacionEncontrada,
					String porcentajeCoincidenciaDenominacion) {
				super();
				this.denominacionMonitoreada = denominacionMonitoreada;
				this.denominacionEncontrada = denominacionEncontrada;
				this.porcentajeCoincidenciaDenominacion = porcentajeCoincidenciaDenominacion;
			}

			public String getDenominacionMonitoreada() {
				return denominacionMonitoreada;
			}
			public String getDenominacionEncontrada() {
				return denominacionEncontrada;
			}
			public String getPorcentajeCoincidenciaDenominacion() {
				return porcentajeCoincidenciaDenominacion;
			}
			public void setDenominacionMonitoreada(String denominacionMonitoreada) {
				this.denominacionMonitoreada = denominacionMonitoreada;
			}
			public void setDenominacionEncontrada(String denominacionEncontrada) {
				this.denominacionEncontrada = denominacionEncontrada;
			}
			public void setPorcentajeCoincidenciaDenominacion(String porcentajeCoincidenciaDenominacion) {
				this.porcentajeCoincidenciaDenominacion = porcentajeCoincidenciaDenominacion;
			}
			@Override
			public String toString() {
				return "{\"denominacionMonitoreada\":\"" + denominacionMonitoreada + "\", \"denominacionEncontrada\":\""
						+ denominacionEncontrada + "\", \"porcentajeCoincidenciaDenominacion\":\""
						+ porcentajeCoincidenciaDenominacion + "\"}";
			} 
			
		}



}
