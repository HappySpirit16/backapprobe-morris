package co.approbe.create.pdf;

import java.io.ByteArrayOutputStream;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.kernel.colors.WebColors;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.extgstate.PdfExtGState;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;

public class MutualContractCupos {

	public static byte[] mutualContract(ImageData image, ImageData image1, String numberId, String name,
			String lenderId, String nameLender) {

		int lengthName = name.length();
		int lengthId = numberId.length();
		int lengthNameLender = nameLender.length();
		int lengthIdLender = lenderId.length();

		if (!nameLender.equals("   ")) {
			for (int i = lengthNameLender; i < 83; i++) {
				nameLender = nameLender + " ";
			}
			for (int i = lengthIdLender; i < 77; i++) {
				lenderId = lenderId + " ";
			}
		} else {
			for (int i = lengthNameLender; i < 95; i++) {
				nameLender = nameLender + " ";
			}
			for (int i = lengthIdLender; i < 87; i++) {
				lenderId = lenderId + " ";
			}
		}
		System.out.println("ENTRA A CREAR BASE DOCUMENTOS DE CUPO");
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		PdfWriter writer = new PdfWriter(outputStream);
		// Creating a PdfDocument
		PdfDocument pdfDoc = new PdfDocument(writer);
		// Creating a Document
		Document document = new Document(pdfDoc);
		// Adding a new page
		pdfDoc.addNewPage();

		Rectangle rect = new Rectangle(100, 250, 400, 400);
		Rectangle rect1 = new Rectangle(400, 780, 150, 40);
		Rectangle rect2 = new Rectangle(100, 750, 400, 60);

		PdfExtGState state = new PdfExtGState().setFillOpacity(0.1f);
		PdfExtGState state1 = new PdfExtGState().setFillOpacity(0.5f);
		PdfCanvas canvas = new PdfCanvas(pdfDoc.getPage(1));
		PdfCanvas canvas1 = new PdfCanvas(pdfDoc.addNewPage());
//		PdfCanvas canvas2 = new PdfCanvas(pdfDoc.addNewPage());
//		PdfCanvas canvas3 = new PdfCanvas(pdfDoc.addNewPage());
//		PdfCanvas canvas4 = new PdfCanvas(pdfDoc.addNewPage());
		PdfCanvas canvasHeader = new PdfCanvas(pdfDoc.getPage(1));
	//	PdfCanvas canvasHeader1 = new PdfCanvas(pdfDoc.getPage(2));
//		PdfCanvas canvasHeader2 = new PdfCanvas(pdfDoc.getPage(3));
//		PdfCanvas canvasHeader3 = new PdfCanvas(pdfDoc.getPage(4));
//		PdfCanvas canvasHeader4 = new PdfCanvas(pdfDoc.getPage(5));

		canvas.saveState();
	//	canvas1.saveState();
//		canvas2.saveState();
//		canvas3.saveState();
//		canvas4.saveState();
		canvasHeader.saveState();
	//	canvasHeader1.saveState();
//		canvasHeader2.saveState();
//		canvasHeader3.saveState();
//		canvasHeader4.saveState();
		canvas.setExtGState(state);
//		canvas1.setExtGState(state);
//		canvas2.setExtGState(state);
//		canvas3.setExtGState(state);
//		canvas4.setExtGState(state);
//		canvas.addImageFittedIntoRectangle(image, rect, false);
//		canvas.restoreState();
//		canvas1.addImageFittedIntoRectangle(image, rect, false);
//		canvas1.restoreState();
//		canvas2.addImageFittedIntoRectangle(image, rect, false);
//		canvas2.restoreState();
//		canvas3.addImageFittedIntoRectangle(image, rect, false);
//		canvas3.restoreState();
//		canvas4.addImageFittedIntoRectangle(image, rect, false);
//		canvas4.restoreState();
		canvasHeader.setExtGState(state1);
		canvasHeader.addImageFittedIntoRectangle(image1, rect1, false);
		canvasHeader.restoreState();
//		canvasHeader1.setExtGState(state1);
//		canvasHeader1.addImageFittedIntoRectangle(image1, rect1, false);
//		canvasHeader1.restoreState();
//		canvasHeader2.setExtGState(state1);
//		canvasHeader2.addImageFittedIntoRectangle(image1, rect1, false);
//		canvasHeader2.restoreState();
//		canvasHeader3.setExtGState(state1);
//		canvasHeader3.addImageFittedIntoRectangle(image1, rect1, false);
//		canvasHeader3.restoreState();
//		canvasHeader4.setExtGState(state1);
//		canvasHeader4.addImageFittedIntoRectangle(image1, rect1, false);
//		canvasHeader4.restoreState();

		String text = "CONTRATO DE MUTUO";
		System.out.println("CONTRATO DE MUTUO");
		createParagraph(document, text, 10, false, false, new int[] { 15, 0, 0, 0 }, TextAlignment.CENTER);
		text = "Las partes de común acuerdo pactan de forma libre y voluntaria celebrar el presente Contrato de Mutuo. Para efectos de lo anterior, dan su consentimiento electrónico a través de la aceptación de este documento que se refleja con la autenticación que han hecho mediante sus credenciales de acceso e inicialmente, a través de la verificación de un OTP y/o de preguntas tipo Experian para la efectiva creación de dichas credenciales; igualmente, en virtud del estampado cronológico que muestra la inexistencia de alteraciones.\n";
		createParagraph(document, text, 10, false, false, new int[] { 10, 20, 0, 20 }, TextAlignment.JUSTIFIED);
		text = "Definiciones";
		createParagraph(document, text, 10, true, true, new int[] { 10, 0, 0, 0 }, TextAlignment.CENTER);
		text = "1.	Financiador: Persona natural o jurídica registrada en la plataforma APPROBE bajo el perfil de Financiador que tiene exceso de liquidez y en ese sentido, prestará una suma de dinero a favor del Deudor.  \n"
				+ "2.	Deudor: Persona natural registrada en la plataforma APPROBE bajo el perfil del Deudor que requiere de recibir el préstamo de una suma de dinero.\n"
				+ "3.	Mutuo: Se entiende como el contrato de préstamo de dinero realizada entre el Financiador y el Deudor con el fin de financiar la compra de un producto o servicio en un Comercio.\n"
				+ "4.	Detalle de Crédito: Oferta que recibe el Deudor con las condiciones particulares del crédito, incluyendo monto financiado, plazo, intereses y demás condiciones necesarias para la aceptación o rechazo por parte del Deudor.\n"
				+ "5.   Plataforma. Sitio en internet desarrollado por DUVERA KAPITAL S.A.S. bajo el nombre comercial de APPROBE, que permite al Deudor solicitar financiamiento para compras en Comercios aliados para ser financiados de forma libre y voluntaria por un tercero Financiador. En adelante “APPROBE”.\n"
				+ "6.	Capacidad de endeudamiento. Capital máximo que Approbe sugiere como monto de endeudamiento al Deudor sin poner en peligro su integridad financiera o capacidad de pago.\n"
				+ "7.	Comercio(s). Persona natural o jurídica que ofrece sus productos o servicios para ser financiados por medio de la plataforma de APPROBE.\n"
				+ "";
		createParagraph(document, text, 10, false, false, new int[] { 10, 20, 0, 40 }, TextAlignment.JUSTIFIED);
		text = "Consideraciones";
		System.out.println("Consideraciones");
		createParagraph(document, text, 10, true, true, new int[] { 10, 0, 0, 0 }, TextAlignment.CENTER);
		text = "1. Las Partes declaran y garantizan que poseen plena capacidad jurídica para celebrar y ejecutar el presente contrato de mutuo, así como para firmar y aceptar cualquier otro documento jurídico vinculante relacionado con este contrato. Ambas partes confirman que han actuado de manera libre, voluntaria y sin ningún tipo de coerción o engaño, y que han leído, comprendido y aceptado todas las cláusulas y condiciones del presente contrato.\n"
				+ "2.	 Las Partes declaran que no requieren de ningún tipo de apoyo, asistencia o representación adicional para la celebración y ejecución del contrato.\n"
				+ "3.	 Las partes declaran y garantizan que los fondos involucrados en el presente contrato de mutuo tienen un origen lícito y que serán utilizados exclusivamente para fines lícitos. Ambas partes se comprometen a cumplir con todas las leyes y regulaciones aplicables en materia de prevención de lavado de activos y financiación del terrorismo. En caso de que se demuestre que los fondos provienen de actividades ilícitas o se destinan a usos ilícitos, el presente contrato será nulo y sin efecto, y las partes asumirán las responsabilidades legales correspondientes.\n"
				+ "4.	 La identificación de las partes será confidencial. Tanto el Financiador como el Deudor están plenamente identificados dentro de la plataforma APPROBE y este como corredor, ha realizado una debida diligencia que ha permitido corroborar la identidad de las partes, su capacidad económica y su procedencia de legalidad.\n"
				+ "";

		createParagraph(document, text, 10, false, false, new int[] { 10, 20, 0, 40 }, TextAlignment.JUSTIFIED);

		text = "De acuerdo con las consideraciones previas, las Partes se obligan de acuerdo con las siguientes:\n";
		createParagraph(document, text, 10, false, false, new int[] { 10, 20, 0, 20 }, TextAlignment.JUSTIFIED);
		text = "Cláusulas";
		System.out.println("Cláusulas");
		createParagraph(document, text, 10, true, true, new int[] { 10, 0, 0, 0 }, TextAlignment.CENTER);
		text = "1.	Objeto. El presente contrato de mutuo tiene por objeto la financiación de productos o servicios ofrecidos por Comercios de acuerdo con el/los Detalle(s) de Crédito aceptado(s) \n"
				+ "2.   Monto Financiado. Corresponde a la sumatoria de los Detalle(s) de Crédito aceptado(s) por el Deudor.\n"
				+ "3.	Desembolso de financiación. El Deudor  acepta de forma expresa el desembolso del Monto Financiado directamente al/los Comercio(s) y  reconoce y acepta que el cumplimiento de las obligaciones derivadas de este contrato se llevará a cabo mediante pagos directos a los Comercios."
				+"";
		
		// informacion sobere el seguro 
		createParagraph(document, text, 10, false, false, new int[] { 10, 20, 0, 40 }, TextAlignment.JUSTIFIED);
		text="4.   Seguro de Vida Deudor. \n"
				+"";
		createParagraph(document, text, 10, false, false, new int[] { 10, 20, 0, 40 }, TextAlignment.JUSTIFIED);
				text= " a.  Cobertura Asegurada: El cupo crediticio otorgado bajo este contrato se encuentra amparado por una póliza de Seguro de Vida Deudor suscrita con SURA S.A. Compañía de Seguros (o la aseguradora designada), la cual cubrirá el saldo pendiente del crédito en caso de fallecimiento o invalidez total y permanente del DEUDOR, conforme a los términos, condiciones y exclusiones establecidas en la póliza correspondiente.\n"
				+ " b.  Información y Consulta de la Póliza.\n"
				+"";
				createParagraph(document, text, 10, false, false, new int[] { 10, 20, 0, 65 }, TextAlignment.JUSTIFIED);
				
				text= "    ° El DEUDOR podrá acceder a los detalles completos de la póliza (condiciones generales, coberturas, exclusiones y procedimientos de reclamo) a través del siguiente enlace: ().\n" // colocar Insertar URL de la póliza
				+ "    ° ACLARACIÓN IMPORTANTE: \"APPROBE actúa únicamente como intermediario en la gestión de este seguro. No somos una aseguradora, por lo que no asumimos responsabilidad por decisiones de cobertura, rechazos de reclamos o incumplimientos de la aseguradora. Para mayor información sobre el seguro, consulta directamente con SURA.\"" // tambien va enlace
		        +"";
				createParagraph(document, text, 10, false, false, new int[] { 10, 20, 0, 75 }, TextAlignment.JUSTIFIED);
				text= " c.  Aceptación y Limitación de Responsabilidad:"
						+" ";
				createParagraph(document, text, 10, false, false, new int[] { 10, 20, 0, 65 }, TextAlignment.JUSTIFIED);
				text= "    ° El DEUDOR reconoce que:";
				createParagraph(document, text, 10, false, false, new int[] { 10, 20, 0, 75 }, TextAlignment.JUSTIFIED);
				text= "      1. La vigencia y aprobación del seguro están sujetas a los criterios de la aseguradora.\n"
				+ "      2. El seguro no extingue la obligación de pago del DEUDOR mientras el crédito esté vigente.\n"
				+ "      3. APPROBE no garantiza la aprobación de reclamos ni asume obligaciones derivadas de la póliza."
				+"";
				createParagraph(document, text, 10, false, false, new int[] { 10, 20, 0, 85 }, TextAlignment.JUSTIFIED);
				text= " d   Procedimiento en Caso de Siniestro:"
						+"";
				createParagraph(document, text, 10, false, false, new int[] { 10, 20, 0, 65 }, TextAlignment.JUSTIFIED);
				text= "    °  En caso de fallecimiento o invalidez del DEUDOR, los beneficiarios o representantes legales deberán notificar el siniestro directamente a SURA y a APPROBE dentro de los plazos establecidos en la póliza.\n"
				+ "    °  APPROBE facilitará la documentación crediticia necesaria para el reclamo, pero no intervendrá en la liquidación o pago por parte de la aseguradora."
				+"";
				createParagraph(document, text, 10, false, false, new int[] { 10, 20, 0, 75 }, TextAlignment.JUSTIFIED);
				text= " e   Modificaciones: APPROBE podrá reemplazar la aseguradora o modificar las condiciones del seguro, previa comunicación al DEUDOR mediante los canales habituales."
				+ "";			
		createParagraph(document, text, 10, false, false, new int[] { 10, 20, 0, 65 }, TextAlignment.JUSTIFIED);		
				text="5.   Obligaciones del Deudor."
				+ "";
		createParagraph(document, text, 10, false, false, new int[] { 10, 20, 0, 40 }, TextAlignment.JUSTIFIED);
	 // HASTA AQUI VOY
		System.out.println("Obligaciones del Deudor");
		text = " a.	 Utilizar el Monto Financiado exclusivamente para la adquisición de productos o servicios del Comercio;\n"
				+ " b.  El Deudor pagará el Monto Financiado, en los términos particulares establecidos en cada uno de los Detalles de Crédito;\n"
				+ " c.	Abstenerse de solicitar modificaciones a los Términos y Condiciones establecidos en  los Detalle(s) de Crédito emitidos por el Comercio;\n"
				+ " d.  Actuar de buena fe en la solicitud de crédito, absteniéndose de realizar cualquier tipo de fraude por medio del uso de la plataforma APPROBE;\n"
				+ " e.	Actualizar por lo menos una vez al año la información suministrada a APPROBE, así como la demás información que sea requerida;\n"
				+ " f.  Suministrar información verídica y la documentación que sea requerida por APPROBE;\n"
				+ " g.	Custodiar y conservar diligentemente las claves y elementos de seguridad asignados, de tal forma que ninguna otra persona pueda hacer uso de ellos;\n"
				+ " h.  Cumplir con las condiciones y protocolos de seguridad indicadas por APPROBE para el uso del crédito publicados en https://www.approbe.co/inicio/tyc."
				+ "";
		createParagraph(document, text, 10, false, false, new int[] { 10, 20, 0, 65 }, TextAlignment.JUSTIFIED);

		text = "6.   Derechos del deudor. El Deudor tendrá los derechos consagrados a lo largo del presente Contrato, así como aquellos consagrados en la Ley 1480 de 2011 y demás normas que la adicionen, modifiquen o complementen."
				+ "";
		createParagraph(document, text, 10, false, false, new int[] { 10, 20, 0, 40 }, TextAlignment.JUSTIFIED);
				text= "7.   Obligaciones del Financiador. El Financiador se obliga al desembolso del Monto Financiado especificado en los Detalles de Credito aceptados por el Deudor a favor del comercio por medio de la gestión de crédito dispuesta por APPROBE;"
				+ "";
		createParagraph(document, text, 10, false, false, new int[] { 10, 20, 0, 40 }, TextAlignment.JUSTIFIED);

		text = " a.  Actualizar por lo menos una vez al año la información suministrada a APPROBE, así como la demás información que sea requerida\n"
				+ " b.  Suministrar información verídica y la documentación que sea requerida por APPROBE;" 
				+ "";
		createParagraph(document, text, 10, false, false, new int[] { 10, 20, 0, 65 }, TextAlignment.JUSTIFIED);
		text = "8.   Obligaciones de APPROBE. APPROBE permitirá el acceso a las partes a la plataforma con el fin de que se lleve a cabo el objeto del contrato cumpliendo con el lleno de los requisitos legales;"
				+ "";
		createParagraph(document, text, 10, false, false, new int[] { 10, 20, 0, 40 }, TextAlignment.JUSTIFIED);
		text = " a.  APPROBE se obliga a realizar el registro del Financiador y del Deudor en su plataforma, haciendo la debida diligencia de validación de identidad de cada una de las partes;\n"
				+ " b.  APPROBE pondrá a disposición del Deudor servicios de soporte, incluido soporte tecnológico y servicio al cliente dentro de los horarios establecidos para tal propósito con el objetivo de brindar el servicio de forma adecuada para el cumplimiento del presente contrato;\n"
				+ " c.  APPROBE garantizará al menos un canal de recaudo accesible para que el Deudor pueda realizar el pago de sus cuotas de crédito.\n"
				+ " d.  APPROBE informará al Deudor con la debida antelación sobre los medios y fechas de pago de las cuotas de crédito, llevará a cabo la gestión de cobranzas correspondiente generando paz y salvos, extractos y reporte ante centrales de información de acuerdo con la Política interna de cobranzas.\n"
				+ " e.  APPROBE se obliga con el Financiador y éste autoriza a realizar la gestión de cobro prejurídico y jurídico dado el evento de mora o incumplimiento de la obligación de pago del Deudor.";
		createParagraph(document, text, 10, false, false, new int[] { 10, 20, 0, 65 }, TextAlignment.JUSTIFIED);
		text = "9.   Capacidad disponible. La Capacidad disponible a favor del Deudor podrá ser usada para financiación de productos o servicios ofrecidos por los Comercios de acuerdo con los términos de financiación incluidos en el Detalle de Crédito."
				+ "";
		createParagraph(document, text, 10, false, false, new int[] { 10, 20, 0, 40 }, TextAlignment.JUSTIFIED);

		text = " a.  El monto  sugerido como Capacidad disponible será vigente por el término de un (1) año, una vez transcurrido el término, el Deudor podrá solicitar una nueva Capacidad disponible;\n"
				+ " b.  Las cuotas pagadas por el Deudor serán abonadas a la Capacidad disponible;\n"
				+ " c.  APPROBE podrá realizar auditorías relacionadas con la Capacidad disponible del  Deudor y a su discreción podrá negar el uso de los recursos o disminuir la Capacidad disponible en caso de evidenciar una desmejora en el comportamiento de crédito del Deudor;\n"
				+ " d.  APPROBE no se obliga a disponer del monto sugerido en la Capacidad disponible, el desembolso del dinero está sujeto a la aprobación del Financiador.\n"
				+ " e.  APPROBE podrá en cualquier momento establecer límites y restricciones al uso de la Capacidad disponible en caso de que se evidencien posibles fraudes con las mismas, y el Financiador autoriza a APPROBE para tal efecto.";
		createParagraph(document, text, 10, false, false, new int[] { 10, 20, 0, 65 }, TextAlignment.JUSTIFIED);
		text = "10.   Bloqueos. Si el Deudor entra en mora superior a quince (15) días calendario en el pago de alguna de las cuotas establecidas en el(los) Detalle(s) de Crédito o en cualquier otro producto de APPROBE, la Capacidad disponible será bloqueada temporalmente y no podrá hacer uso de este en ningún caso hasta que el Deudor  se ponga al día en sus obligaciones.";
		createParagraph(document, text, 10, false, false, new int[] { 10, 20, 0, 40 }, TextAlignment.JUSTIFIED);

		text = " a.  Si el Deudor entra en mora superior a treinta (30) días calendario en el pago de alguna de las cuotas establecidas en el(los) Detalle(s) de Crédito o en cualquier otro producto de APPROBE, la Capacidad disponible quedará bloqueada de forma permanente"
				+ "";
		createParagraph(document, text, 10, false, false, new int[] { 10, 20, 0, 65 }, TextAlignment.JUSTIFIED);

		text = "11.   Vigencia. La vigencia del presente contrato es indefinida.\n"
				+ "12.   Pago. El Deudor podrá realizar el pago a través del siguiente link https://payments.approbe.co o por los medios autorizados que APPROBE disponga para tal fin. "
				+ "";
		createParagraph(document, text, 10, false, false, new int[] { 10, 20, 0, 40 }, TextAlignment.JUSTIFIED);
		text = " a.  El Deudor  deberá realizar el pago mensual de por lo menos el valor definido como pago mínimo, que será señalado en los estados de cuenta en la plataforma APPROBE;\n"
				+ " b.  El Deudor podrá realizar pagos adicionales cuando lo considere pertinente, e incluso pagos anticipados de acuerdo con la cláusula 13. Cuando el Deudor realice el pago mínimo, el pago se imputará en el orden que se señala a continuación: ";
		createParagraph(document, text, 10, false, false, new int[] { 10, 20, 0, 65 }, TextAlignment.JUSTIFIED);
		text = "   a.  Impuestos (de existir) \n"
				+ "   b.  Gastos de cobranza (de existir);\n"
				+ "   c.  Gastos de administración descritos en la página https://www.approbe.co/inicio/costos;\n"
				+ "   d.  Intereses de mora (de existir)\n"
				+ "   e.  Intereses remuneratorios; y\n"
				+ "   f.  Capital adeudado.\n";
		createParagraph(document, text, 10, false, false, new int[] { 10, 20, 0, 75 }, TextAlignment.JUSTIFIED);
		text = "Una vez realizado el pago mínimo, cualquier pago adicional se aplicará directamente al capital adeudado.\n";
		createParagraph(document, text, 10, false, false, new int[] { 10, 20, 0, 20 }, TextAlignment.JUSTIFIED);
		text = "13.   Intereses. El Deudor deberá pagar al Financiador la totalidad de las cuotas adeudadas en capital más los intereses remuneratorios y demás tarifas y comisiones aceptados en el(los) Detalle(s) de Crédito  en los plazos allí señalados so pena de entrar en mora inmediata en su obligación, en cuyo caso deberá pagar adicionalmente intereses moratorios sobre el saldo de capital vencido, los cuales serán liquidados por APPROBE a la tasa máxima legalmente permitida que se encuentre vigente al momento de incumplir con el pago mínimo señalado en los estados de cuenta. La tasa de intereses moratorios se actualiza según disposiciones de La Superintendencia Financiera para créditos de consumo. ";
		createParagraph(document, text, 10, false, false, new int[] { 10, 20, 0, 40 }, TextAlignment.JUSTIFIED);
		text = " a.  El Deudor reconoce y acepta que deberá al Financiador, además de la cifra otorgada a título de Mutuo, los gastos que se computarán junto con los intereses compensatorios.Los gastos adicionales que no constituyen intereses remuneratorios incluirán aquellos dispuestos en la página https://www.approbe.co/inicio/costos, si perjuicio del cobro de gastos de cobranza, intereses moratorios, costos de desembolso, cobro al Gravamen a los Movimientos Financieros y demás costos bancarios. Los gastos, si los hubiere, serán calculados exclusivamente hasta la fecha de devolución consignada en el Detalle de Crédito, todo ello conforme el sistema, cantidad, monto y periodicidad indicados en el Detalle de Crédito. El Deudor pagará también al Financiador, en caso de cobro judicial o extrajudicial, todos los gastos que demande su cobranza, incluyendo los honorarios razonables de abogados."
				+ "";
		createParagraph(document, text, 10, false, false, new int[] { 10, 20, 0, 65 }, TextAlignment.JUSTIFIED);
		text = "14.   Pago anticipado. El Deudor podrá realizar pagos anticipados de crédito, en tal caso cancelará los intereses de plazo mencionados en la Cláusula 12 de conformidad con el Detalle de Crédito, los cuales serán liquidados hasta el día del pago total del capital sin incurrir en ningún tipo de penalización. En caso de que el Deudor realice abonos parciales a capital, el interés de plazo de dicha cláusula se liquidará sobre el saldo de capital que se adeuda.\n"
				+ "15.   Mora. La mora se producirá de pleno derecho y en forma automática al Vencimiento de cualquier Cuota, sin necesidad de reconvención judicial, constitución en mora o requerimiento alguno, frente a los cuales renuncia expresa y completamente el Usuario Deudor, conforme las fechas establecidas en el cronograma de cancelación de Cuotas informado en la Oferta de Préstamo, si éstas no hubieran sido canceladas en la fecha correspondiente en su totalidad o en el caso de vencimiento por aceleración.\n"
				+ "En caso de mora, todas las sumas vencidas causarán, durante el tiempo que persistiera dicha mora y hasta la fecha de pago efectiva (antes y después de cualquier sentencia o pronunciamiento judicial) un Interés Moratorio, por lo que el Usuario Deudor deberá pagar al Usuario Financiador dicho Interés, cuya tasa será la máxima legal permitida. Los Intereses Moratorios se devengarán sobre saldos impagos desde la fecha de la mora y hasta el pago efectivo de los mismos.";
		createParagraph(document, text, 10, false, false, new int[] { 10, 20, 0, 40 }, TextAlignment.JUSTIFIED);
		text = "En el evento de mora de las obligaciones a cargo del Usuario Deudor y/o incumplimiento de cualquier de las obligaciones contraídas por el Usuario Deudor, el Usuario Financiador podrá declarar vencida y exigir el pago de cualquier suma derivada del Préstamo otorgado al Usuario Deudor y/o de cualquier servicio prestado por la Plataforma de Préstamos y/o Approbe al Usuario Deudor. \n"
				+ "Approbe podrá percibir del Usuario Financiador, si así lo requiere, una comisión por acciones y gestión de cobranza, en aquellos casos en que el Usuario Deudor esté en mora y dicha mora hubiera generado la necesidad de Approbe de realizar acciones de gestión de cobranza del Préstamo adeudado. \r\n"
				+ "En este caso, (i) La gestión de cobro prejudicial se inicia a partir del primer día de mora utilizando cualquiera de estos canales; (ii) Los gastos de cobranza están a cargo del Usuario Deudor y se liquidan: A. Se trasladan al Usuario Deudor a partir del día de la mora, sobre cada Cuota u obligación que presente incumplimiento de pago. B. Los gastos de cobranza corresponden a un porcentaje del valor y de acuerdo con el tiempo que lleva en mora el Usuario Deudor (altura de la mora) de acuerdo con la Política de cobranza publicada en la página https://www.approbe.co/inicio/bnpl. \r\n"
				+ "A los anteriores se les deberá adicionar el IVA, en el evento que aplique. \n" + "";
		createParagraph(document, text, 10, false, false, new int[] { 10, 20, 0, 20 }, TextAlignment.JUSTIFIED);

		text="16.   Gestión de cobranza. El Deudor entiende y acepta con la firma de este documento, que APPROBE está facultado para la realización de la gestión de cobranza en etapa prejurídica y jurídica, razón por la cual puede realizar reportes en centrales de riesgo así como de autorizar a terceros para el cobro de la obligación de acuerdo a la Política de Cobranza publicada en la página web.";
		createParagraph(document, text, 10, false, false, new int[] { 10, 20, 0, 40 }, TextAlignment.JUSTIFIED);
		text="a.  El Deudor será responsable de asumir todos los gastos de cobranza asociados con la recuperación de cartera vencida resultado del cumplimiento del presente contrato.\n"
				+ "El Deudor autoriza a APPROBE para que le sean cobrados todos los gastos de cobranza que deben ser pagados a terceros, en caso de incurrir en ellos, a través de los canales que disponga APPROBE,";
		createParagraph(document, text, 10, false, false, new int[] { 10, 20, 0, 65 }, TextAlignment.JUSTIFIED);
		text="17.   Estados de cuenta. APPROBE pondrá a disposición del Deudor, por cualquier medio, un estado de cuenta mensual que contenga las sumas que resulten a su cargo como Deudor por concepto de capital, intereses, comisiones y demás cargos aplicables, en virtud del uso de la Capacidad disponible. El estado de cuenta contendrá cualquier información adicional que APPROBE estime pertinente.\n"
			 +"18.   Vencimiento anticipado del plazo. Además de lo estipulado en la Política de Crédito publicada en la plataforma en la página web, en caso de presentarse cualquiera de los eventos que se estipulan a continuación, habrá lugar a la declaratoria de vencimiento anticipado del plazo de pago de la totalidad de el(los) Detalle(s) de Crédito por parte de el Deudor:";
		createParagraph(document, text, 10, false, false, new int[] { 10, 20, 0, 40 }, TextAlignment.JUSTIFIED);
		
		text="i.  La mora de treinta (30) días de el Deudor en el pago de cualquiera de las cuotas de capital o intereses del crédito o de los gastos que de él se deriven;\n"
			+"ii.  Si el Deudor solicita el concurso preventivo de sus acreedores o su propia iliquidez o insolvencia, o ésta le fuera solicitada por terceros y no es desestimada dentro de la oportunidad procesal por el Deudor;"; 	
		createParagraph(document, text, 10, false, false, new int[] { 10, 20, 0, 70 }, TextAlignment.JUSTIFIED);
		
		text="a.   Ocurrido alguno de los eventos antes enunciados o producida la mora, que se causará por el mero vencimiento del plazo en el pago de una o varias cuotas originadas con la aceptación del el(los) Detalle(s) de Crédito el Financiador podrá a su arbitrio, y sin necesidad de requerimiento al Deudor, declarar de pleno derecho la caducidad del plazo o término otorgado para la cancelación del Mutuo y exigir al Deudor el pago inmediato del capital y de intereses compensatorios adeudados, así como de los gastos asociados a la cobranza.\n"
		     +"b.  El Deudor estará en la obligación de informar a APPROBE al respecto de llegar a presentarse alguna de las circunstancias contempladas en la presente Cláusula.";
		createParagraph(document, text, 10, false, false, new int[] { 10, 20, 0, 65 }, TextAlignment.JUSTIFIED);
		
		text="19.   Reserva de derechos del Financiador. La falta de ejercicio por parte del Financiador  de cualquiera de los derechos que este Contrato de Mutuo le otorga como Financiador y beneficiario del Título Valor que garantiza el presente Contrato, así como, el otorgamiento al Deudor, bajo cualquier forma jurídica, de una prórroga en los plazos pactados, no implicará la renuncia a estos derechos ni a sus garantías, ni impedirá al Financiador ejercer tales derechos u otros en lo sucesivo.\n"
		     +"20.   Garantía. El presente Contrato de Mutuo tiene el carácter de Título Ejecutivo conforme a las normas civiles y comerciales de Colombia, las Partes acuerdan que presta mérito ejecutivo."; 
		createParagraph(document, text, 10, false, false, new int[] { 10, 20, 0, 40 }, TextAlignment.JUSTIFIED);		
		
		text="a.  Con el fin de garantizar el pago del Monto financiado y el cumplimiento de las demás obligaciones que surgirán a cargo de el Deudor, éste se obliga a suscribir un Pagaré en blanco con carta de instrucciones a favor del Financiador, en el cual se incorporarán las obligaciones dinerarias contraídas por el Deudor a favor del  Financiador.\n"
				+"b.  Las partes autorizan a APPROBE a realizar el endoso a terceros con fines de recaudo de cartera de acuerdo con su Política de Cobranzas";
		createParagraph(document, text, 10, false, false, new int[] { 10, 20, 0, 65 }, TextAlignment.JUSTIFIED);	
		
		text="21.   Fianza FGA. Las partes acuerdan y aceptan que el presente contrato de mutuo será afianzado por el Fondo de Garantías de Antioquia S.A. (“FGA”) quien prestará el servicio de fianza como mecanismo de cobertura del riesgo de crédito, el cual se efectuará según las condiciones definidas al momento del desembolso, sin que haya lugar a devolución o reintegro por prepago de la obligación crediticia y de acuerdo con el documento de Costos y Tarifas publicado en la página web.\n"
				+"Las partes Declaramos conocer que, en caso de incumplimiento de la obligación crediticia, FGA pagará la cobertura conferida al otorgante del crédito, según el porcentaje de cobertura pactado y, en consecuencia, operará a favor de FGA la subrogación legal por activa, permitiendo recobrar el valor pagado, momento a partir del cual se generarán intereses de mora y gastos de cobranza. En consecuencia, reconozco que el pago que llegue a realizar FGA no extingue parcial, ni totalmente la obligación del Deudor.\n"
		     +"22.   Nulidad, Invalidez e Ineficacia. En el evento en que se determine que una estipulación contenida en el presente Contrato de Mutuo es nula, inválida o ineficaz, las demás estipulaciones continuarán vigentes. De ocurrir lo anterior, las Partes se obligan a reemplazar de buena fe dicha disposición de mutuo acuerdo.\n"
		     +"23.   Terminación. La relación surgida con la aceptación del presente Contrato es a término indefinido. No obstante, el contrato podrá darse por terminado por el Deudor en cualquier momento enviar la petición al correo electrónico info@approbe.co con un preaviso de noventa (90) días a la fecha estimada de terminación y por  parte de APPROBE en los siguientes casos:";
		createParagraph(document, text, 10, false, false, new int[] { 10, 20, 0, 40 }, TextAlignment.JUSTIFIED);
		
		text="a.  Por decisión unilateral de APPROBE sin justa causa en cualquier momento. La terminación con base en la presente causal no generará a favor de ninguna de las Partes el pago de suma alguna por concepto de indemnización, penalidad o cualquier otro concepto.\n"
				+ "b.  En caso de incumplimiento por parte del Deudor de las obligaciones previstas en Cláusula 4, específicamente de los numerales 4.a, 4.c, 4.d, 4.f. del Contrato, APPROBE podrá dar por terminado el Contrato de forma inmediata sin necesidad de notificación previa.\n"
				+"c.  Por inclusión del Deudor en el boletín de responsables fiscales expedido por la Contraloría General de la República, en el Sistema para la Administración del Riesgo del Lavado de Activos y Financiación del Terrorismo SARLAFT o en las listas restrictivas de la ONU o de OFAC.\n"
				+"d.  Si el Deudor hubiera incurrido en falsedad, inexactitud u omisión material, con culpa o dolo, respecto de la información provista a Approbe o cualquiera de sus afiliadas o vinculadas.\n"
				+"e.  Si durante el plazo de vigencia del Contrato el Deudor llegare a resultar condenados en una investigación de cualquier tipo (penal, administrativa, etc.) relacionada con corrupción, soborno, lavado de dinero o financiamiento del terrorismo, o fuesen incluidos en listas de control como las de la ONU, OFAC, así en Colombia no se hubiere iniciado la investigación  penal.\n"
		        +"f.  Si el Deudor tuviera conductas que hicieran presumir razonablemente una actuación fraudulenta y/o no ajustada a derecho.";
		createParagraph(document, text, 10, false, false, new int[] { 10, 20, 0, 65 }, TextAlignment.JUSTIFIED);
		
		text="24.   Efectos de la Terminación. En caso de terminación del contrato, Approbe declarará vencidas las obligaciones contraídas y exigirá el pago de cualquier suma derivada del Detalle de Crédito otorgado al Deudor, antes de su vencimiento inicial, con la aceleración de las demás obligaciones a cargo del Deudor, las cuales deberán pagarse automáticamente por el Deudor, una vez Approbe le comunique sobre dicha aceleración y vencimiento anticipado sin necesidad de trámite judicial o extrajudicial alguno. En tal caso, el Importe del Préstamo, los Intereses Remuneratorios, los Intereses Moratorios, los Cargos y costos impositivos, y cualquier otra sumas debida, se considerarán íntegramente debidos por el Deudor y exigibles a éste se mantendrá vigente los Términos y condiciones de el(los) Detalle(s) de Crédito aprobados y desembolsados a favor del Deudor.\n"
				+"25.   Ley Aplicable. El presente Contrato de Mutuo se regirá por la Ley Colombiana, y el lugar de ejecución para todos los efectos será la ciudad de Bogotá; por ende, será esta la ciudad de  jurisdicción territorial.\n"
				+"26.   Cesión. El Financiador podrá ceder su posición contractual y en la medida que APPROBE como intermediario pondrá a disposición el canal de pago, se encuentra autorizado por las partes para dirigir dichos recursos al nuevo financiador.\n"
				+"27.   Autorización de tratamiento de datos personales. Con la aceptación del presente Contrato el Deudor autoriza a APPROBE en calidad de responsable del tratamiento de datos personales, de manera previa, expresa e informada a que trate sus datos personales suministrados en la solicitud de la Capacidad disponible o los que llegue a suministrar, de acuerdo con su Política de Tratamiento de Datos Personales dispuesta en la página web y conforme a la Ley 1581 de 2012 y a la Ley 1266 de 2008, sus decretos reglamentarios y cualquier otra norma que las modifique, adicione o sustituya de tiempo en tiempo. Para el ejercicio de estos derechos, el Deudor podrá comunicarse con el siguiente correo electrónico legal@approbe.co.\n"
				+"28.   Derecho de retracto. De conformidad con el artículo 47 de la Ley 1480 de 2011, y únicamente en el evento en que el Contrato no haya comenzado a ejecutarse, esto es, que se hubiere aprobado crédito, el Deudor podrá ejercer el derecho de retracto dentro de los cinco (5) días hábiles siguientes a la realización de la solicitud del crédito. En el evento en que el Deudor haga uso del derecho de retracto, APPROBE no expondrá la solicitud inicial al financiador a su favor. Para ejercer el derecho de retracto, el Deudor debe enviar la petición al correo electrónico info@approbe.co o a los canales que APPROBE disponga para tal fin. En cualquier caso, y una vez utilizado el monto desembolsado, evento en el cual no aplica el derecho de retracto, el Deudor puede realizar un prepago total de sus obligaciones.\n"
			    +"29.   Modificaciones. Las modificaciones, limitaciones, supresiones o adiciones a este Contrato se informarán al Deudor por cualquier medio que se estime eficaz para tal fin. En caso de que el Deudor no esté de acuerdo con las modificaciones incorporadas, podrá hacer uso de la facultad de terminación unilateral de la relación contractual, en los términos indicados en este Contrato. Cualquier tipo de modificación que desmejore las condiciones del Deudor, deberán contar con su aprobación previa, antes de ser implementadas. Si el Deudor no está de acuerdo con la modificación del Contrato, APPROBE podrá dar por terminada la relación contractual.";	
		createParagraph(document, text, 10, false, false, new int[] { 10, 20, 0, 40 }, TextAlignment.JUSTIFIED);
		// hasta aqui
	
		document.close();
		System.out.println("PDF Created");
		return outputStream.toByteArray();
	}

	public static void createParagraph(Document document, String text, int fontSize, boolean bold, boolean underline,
			int[] margins, TextAlignment alignment) {
		Paragraph paragraph = new Paragraph(text);
		paragraph.setTextAlignment(alignment);
		paragraph.setMargins(margins[0], margins[1], margins[2], margins[3]);
		if (underline)
			paragraph.setUnderline();
		paragraph.setFontSize(fontSize);
		if (bold)
			paragraph.setBold();
		document.add(paragraph);
	}

}
