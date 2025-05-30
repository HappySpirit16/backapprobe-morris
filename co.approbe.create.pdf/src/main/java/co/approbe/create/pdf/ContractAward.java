package co.approbe.create.pdf;

import java.io.ByteArrayOutputStream;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.kernel.colors.WebColors;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.extgstate.PdfExtGState;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;

public class ContractAward {

	public static byte[] contractAward(ImageData image, ImageData image1, String name, String numberId) {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		PdfWriter writer = new PdfWriter(outputStream);
		// Creating a PdfDocument
		PdfDocument pdfDoc = new PdfDocument(writer);
		// Creating a Document
		Document document = new Document(pdfDoc);
		// Adding a new page
		pdfDoc.addNewPage();
		Paragraph parag = new Paragraph();
		parag.add("CONTRATO DE CORRETAJE DE FINANCIAMIENTO");
		parag.setTextAlignment(TextAlignment.CENTER);
		parag.setFontSize(12);
		parag.setFontColor(WebColors.getRGBColor("#808080"));

		Rectangle rect = new Rectangle(100, 250, 400, 400);
		Rectangle rect1 = new Rectangle(50, 790, 80, 25);
		Rectangle rect2 = new Rectangle(110, 775, 400, 30);

		PdfExtGState state = new PdfExtGState().setFillOpacity(0.1f);
		PdfExtGState state1 = new PdfExtGState().setFillOpacity(0.5f);
		PdfCanvas canvas = new PdfCanvas(pdfDoc.getPage(1));
		PdfCanvas canvas1 = new PdfCanvas(pdfDoc.addNewPage());
		PdfCanvas canvas2 = new PdfCanvas(pdfDoc.addNewPage());
		PdfCanvas canvas3 = new PdfCanvas(pdfDoc.addNewPage());
		PdfCanvas canvas4 = new PdfCanvas(pdfDoc.addNewPage());
		PdfCanvas canvas5 = new PdfCanvas(pdfDoc.addNewPage());
		PdfCanvas canvasHeader = new PdfCanvas(pdfDoc.getPage(1));
		PdfCanvas canvasHeader1 = new PdfCanvas(pdfDoc.getPage(2));
		PdfCanvas canvasHeader2 = new PdfCanvas(pdfDoc.getPage(3));
		PdfCanvas canvasHeader3 = new PdfCanvas(pdfDoc.getPage(4));
		PdfCanvas canvasHeader4 = new PdfCanvas(pdfDoc.getPage(5));
		PdfCanvas canvasHeader5 = new PdfCanvas(pdfDoc.getPage(6));
		Canvas canvasEncabezado;

		canvas.saveState();
		canvas1.saveState();
		canvas2.saveState();
		canvas3.saveState();
		canvas4.saveState();
		canvas5.saveState();
		canvasHeader.saveState();
		canvasHeader1.saveState();
		canvasHeader2.saveState();
		canvasHeader3.saveState();
		canvasHeader4.saveState();
		canvasHeader5.saveState();
		canvas.setExtGState(state);
		canvas1.setExtGState(state);
		canvas2.setExtGState(state);
		canvas3.setExtGState(state);
		canvas4.setExtGState(state);
		canvas5.setExtGState(state);
		canvas.addImageFittedIntoRectangle(image, rect, false);
		canvas.restoreState();
		canvas1.addImageFittedIntoRectangle(image, rect, false);
		canvas1.restoreState();
		canvas2.addImageFittedIntoRectangle(image, rect, false);
		canvas2.restoreState();
		canvas3.addImageFittedIntoRectangle(image, rect, false);
		canvas3.restoreState();
		canvas4.addImageFittedIntoRectangle(image, rect, false);
		canvas4.restoreState();
		canvas5.addImageFittedIntoRectangle(image, rect, false);
		canvas5.restoreState();
		canvasHeader.setExtGState(state1);
		canvasHeader.addImageFittedIntoRectangle(image1, rect1, false);
		canvasHeader.restoreState();
		canvasHeader1.setExtGState(state1);
		canvasHeader1.addImageFittedIntoRectangle(image1, rect1, false);
		canvasHeader1.restoreState();
		canvasHeader2.setExtGState(state1);
		canvasHeader2.addImageFittedIntoRectangle(image1, rect1, false);
		canvasHeader2.restoreState();
		canvasHeader3.setExtGState(state1);
		canvasHeader3.addImageFittedIntoRectangle(image1, rect1, false);
		canvasHeader3.restoreState();
		canvasHeader4.setExtGState(state1);
		canvasHeader4.addImageFittedIntoRectangle(image1, rect1, false);
		canvasHeader4.restoreState();
		canvasHeader5.setExtGState(state1);
		canvasHeader5.addImageFittedIntoRectangle(image1, rect1, false);
		canvasHeader5.restoreState();

		canvasEncabezado = new Canvas(canvasHeader, rect2);
		canvasEncabezado.add(parag);
		canvasEncabezado = new Canvas(canvasHeader1, rect2);
		canvasEncabezado.add(parag);
		canvasEncabezado = new Canvas(canvasHeader2, rect2);
		canvasEncabezado.add(parag);
		canvasEncabezado = new Canvas(canvasHeader3, rect2);
		canvasEncabezado.add(parag);
		canvasEncabezado = new Canvas(canvasHeader4, rect2);
		canvasEncabezado.add(parag);
		canvasEncabezado = new Canvas(canvasHeader5, rect2);
		canvasEncabezado.add(parag);

		String text = "1.	Integridad: La Financiación se genera en total observancia y cumplimiento de los parámetros de negociación contenidos dentro de los “Términos & condiciones del uso de la Plataforma” que se encuentra en la página principal de la plataforma Approbe. \n"
				+ "\n"
				+ "2.	Función: Approbe proporcionará los servicios de corretaje, por medio del cual este último, tiene la posición de corredor para buscar potenciales financiadores. Debido a lo anterior, Approbe tendrá la facultad de realizar Ofertas de Préstamo a través de su plataforma con destino a los potenciales financiadores.\n"
				+ "\n"
				+ "3.	Oferta del Préstamo: La Oferta de Préstamo es emitida por un Usuario que desee obtener la financiación (De ahora en adelante “Tomador” o “Deudor”), y es dirigida al Usuario que desea financiarlo ( De ahora en adelante “Financiador”) a través de sus canales digitales de Approbe. \n"
				+ "";
		createParagraph(document, text, 11, false, false, new int[] { 30, 40, 0, 40 }, TextAlignment.JUSTIFIED);
		text = "3.1.	La Oferta de Préstamo solo es válida para el Deudor que aparezca como destinatario de la misma.  \n"
				+ "3.2.	En ningún caso, la Oferta de Préstamo podrá extenderse a un familiar o conocido del Deudor o cualquier otro tercero.  \n"
				+ "3.3.	La Oferta de Préstamo estará vigente durante el plazo indicado en dicha Oferta. \n" + "";
		createParagraph(document, text, 11, false, false, new int[] { 10, 40, 0, 50 }, TextAlignment.JUSTIFIED);
		text = "4.	Aceptación expresa. Previo a cualquier actividad de financiamiento, el financiador debe aceptar expresamente que quiere financiar, teniendo en cuenta información como (pero sin limitarse): el Tomador, la tasa de interés, la modalidad de crédito, objetivo de la financiación, plazos de pago entre otros; que serán señalados dentro de la Oferta de Préstamo. ";
		createParagraph(document, text, 11, false, false, new int[] { 30, 40, 0, 40 }, TextAlignment.JUSTIFIED);
		text = "4.1.	Con la Aceptación, el Deudor reconoce y acepta que deberá al Usuario Financiador, en los plazos convenidos sujetos al efectivo desembolso del Préstamo en los términos indicados, el Importe del Préstamo y los demás valores que se indiquen en el Contrato, el pagaré y/o demás documentos que incorporarán las condiciones del Préstamo.\n"
				+ "4.2.	Una vez acordado el Préstamo en virtud de la Aceptación por parte del Deudor y el Usuario Financiador, y en el evento que Approbe no conozca una razón adicional para el no otorgamiento, Approbe desembolsará el Importe en moneda de curso legal en Colombia, neto de deducciones por Cargos.\n"
				+ "";
		createParagraph(document, text, 11, false, false, new int[] { 10, 40, 0, 50 }, TextAlignment.JUSTIFIED);
		text = "5.	Actualización de información: Approbe tendrá la obligación de entregar información periódica, es necesario, la cual contendrá: (i) El valor de la cuota a pagar, con la discriminación del pago de capital, intereses y primas de seguros y otros rubros, si los hay;(ii) El capital pendiente de pago;(iii) La tasa de interés aplicada a dicho periodo, y si esta fue ajustada conforme los límites máximos legales permitidos; (iv) Una explicación y los datos utilizados para liquidar la respectiva cuota; y (v) Fechas de vencimiento y de pago.\n"
				+ "\n"
				+ "6.	Desembolso: El Deudor consiente expresamente la utilización del Depósito de Dinero de Pagos GDE S.A. - Powwi como la forma exclusiva para el desembolso del Préstamo. Pagos GDE S.A. - Powwi en su calidad de Entidad Financiera se limitará única y exclusivamente al ofrecimiento del producto financiero (Depósito de Dinero), por tal razón, en ningún caso será responsable frente al otorgamiento de prestamo y/o las condiciones de financiación, asi como tampoco, frente a este y los demás servicios ofrecidos por Approbe.\n"
				+ "\n"
				+ "7.	Remuneración: El Préstamo devengará Intereses Remuneratorios calculados de acuerdo con la tasa efectiva anual que se establece en las Condiciones Particulares sobre el Importe del Préstamo pendiente de reembolso y hasta el reintegro completo del Importe del Préstamo. \n"
				+ "\n"
				+ "8.	Deducciones: El Préstamo devengará cargos comisiones y gastos adicionales que sean aplicables (en adelante los «Cargos»), que se establece en las Condiciones Particulares sobre el Importe del Préstamo pendiente de reembolso y hasta el reintegro completo del Importe del Préstamo. \n"
				+ "\n" + "9.	Obligaciones de Approbe:  \n" + "";
		createParagraph(document, text, 11, false, false, new int[] { 30, 40, 0, 40 }, TextAlignment.JUSTIFIED);
		text = "9.1.	Suministrar, de manera previa a la negociación, información general sobre las Ofertas de Prestamo que se realicen en desarrollo de las actividades \n"
				+ "9.2.	Pagar el abono del dinero de los intereses remuneratorios \n"
				+ "9.3.	Enviar mensualmente información general sobre las operaciones de financiamiento que se han realizado. \n"
				+ "9.4.	Proporcionar, en el momento en el que el cliente lo requiera, todo tipo de información relevante con respecto a la financiamiento \n"
				+ "9.5.	Todas las comunicaciones del financiador deben ser por escrito, lo que incluye servicios de correo electrónico y otros servicios de mensajería electrónica. \n"
				+ "9.6.	Mantener la confidencialidad sobre las actividades de Approbe, a menos que ellos mismos autoricen la divulgación de la información.\n"
				+ "";
		createParagraph(document, text, 11, false, false, new int[] { 10, 40, 0, 50 }, TextAlignment.JUSTIFIED);
		text = "10.	Abono: El abono del dinero para la financiación aprobada se puede hacer efectivo mediante transferencia bancaria al Depósito de Dinero creado en Pagos GDE S.A. - Powwi. De la misma forma, el abono del dinero de los intereses remuneratorios del financiamiento se realizará por medio del mismo Depósito de Dinero.\n"
				+ "\n"
				+ "11.	Mora: Si El Deudor no realiza el pago del capital o de los intereses compensatorios en los plazos y montos pactados por las Partes, se causarán intereses moratorios sobre el saldo en mora y por el tiempo que dure la misma, a la tasa máxima de interés moratorio permitida, certificada por la Superintendencia Financiera. EL DEUDOR pagará también al Financiador, en caso de cobro judicial o extrajudicial, todos los gastos que demande su cobranza, incluyendo los honorarios razonables de abogados. \n"
				+ "";
		createParagraph(document, text, 11, false, false, new int[] { 30, 40, 0, 40 }, TextAlignment.JUSTIFIED);
		text = "11.1.	Para el cobro judicial o extrajudicial, El Financiador da poder amplio y suficiente a Approbe para que realice las gestiones necesarias hasta obtener los intereses debidos. \n"
				+ "11.2.	En caso de presentarse cualquiera de los eventos que se estipulan a continuación, habrá lugar a la declaratoria de vencimiento anticipado del plazo del préstamo con mora de treinta (30) días en el pago de cualquiera de las cuotas de capital y/o intereses del crédito o de los gastos que de él se deriven. Ocurrido, se podrá declarar, y sin necesidad de requerimiento al Deudor, de pleno derecho la caducidad del plazo o término otorgado para la cancelación del mutuo y exigir el pago inmediato del capital y de intereses compensatorios adeudados, así como, de los gastos. \n"
				+ "";
		createParagraph(document, text, 11, false, false, new int[] { 30, 40, 0, 50 }, TextAlignment.JUSTIFIED);
		text = "12.	Pagaré: Con el fin de garantizar el pago del préstamo y el cumplimiento de las demás obligaciones que surgirán a cargo del Deudor, este se obliga a emitir un Pagaré en blanco con carta de instrucciones a favor del Financiador, en el cual se incorporarán las obligaciones dinerarias contraídas por el Deudor a favor del Financiador. Documentos que contendrán todos los requisitos de un título valor y en consecuencia conservará su autonomía. \n"
				+ "\n"
				+ "13.	Terminación del contrato Las siguientes son razones justificadas para la terminación de este contrato\n"
				+ "";
		createParagraph(document, text, 11, false, false, new int[] { 30, 40, 0, 40 }, TextAlignment.JUSTIFIED);
		text = "13.1.	Negligencia de Approbe en el cumplimiento de las obligaciones asumidas.\n"
				+ "13.2.	Práctica de actos, por parte de Approbe, que den lugar a un descrédito comercial del financiador ante terceros \n"
				+ "13.3.	Por razones de circunstancias imprevistas o de fuerza mayor, que puedan significar la posibilidad de pérdidas en el negocio; \n"
				+ "13.4.	En el caso en que Approbe identifique el origen ilícito o que los servicios de intermediación pueden ir contra el marco normativo, éste tiene la facultad de dar por terminado el contrato de manera unilateral, mediante la notificación correspondiente y la devolución de dinero respectivo, observando la multa estipulada.\n"
				+ "13.5.	Por la cancelación del Depósito de Dinero constituido en Pagos GDE S.A. - Powwi, conforme a las causales establecidas en el Reglamento de Depósito de Powwi, disponible para consulta en www.powwi.co\n"
				+ "";
		createParagraph(document, text, 11, false, false, new int[] { 10, 40, 0, 50 }, TextAlignment.JUSTIFIED);

		text = "14.	Duración: La duración de este contrato estará sujeto a las condiciones las cuales se quiere realizar el corretaje. En este caso, es obligación de la parte informar 90 días antes con el objetivo que Approbe reembolse el valor ofrecido como financiamiento de inmediato al mandante. \n"
				+ " \n" + " \n" + " \n" + " \n" + " \n" + "15.	Responsabilidad: \n";
		createParagraph(document, text, 11, false, false, new int[] { 30, 40, 0, 40 }, TextAlignment.JUSTIFIED);
		text = "15.1.	Approbe se responsabiliza de los perjuicios directos sufridos por el financiador y que tengan causa inmediata en dolo o negligencia del personal al servicio de Ia financiamiento. \n"
				+ "15.2.	Approbe NO será responsable de los perjuicios causados cuando la prestación de sus servicios no sea posible por motivos que no sean imputables a la organización interna y, especialmente, por los causados por demoras o deficiencias en los servicios, de comunicación o transmisión de datos ajenos. \n"
				+ "15.3.	Approbe NO será responsable por el resultado de la financiación. Todas las estimaciones o simulaciones de portafolio evidenciadas son ilustrativas y pueden o no corresponder al resultado final del financiamiento. Por ende, la rentabilidad o ganancia ilustrada, no garantiza que sea la generada en el futuro. La rentabilidad que se muestre no incluye el efecto de las comisiones de suscripción y rescate, ni el impuesto a la renta. \n"
				+ "15.4.	Approbe No asume responsabilidad por el posible retraso, falla en el rendimiento o la interrupción en la prestación de los Servicios que pueda resultar directa o indirectamente de cualquier causa o circunstancia más allá de su control razonable, incluyendo, pero sin limitarse a fallas en los equipos o las líneas de comunicación electrónica o mecánica, robo, errores del operador, clima severo, terremoto o desastres naturales, pandemias, huelgas u otros problemas laborales, guerras, o restricciones gubernamentales\n"
				+ "";
		createParagraph(document, text, 11, false, false, new int[] { 10, 40, 0, 50 }, TextAlignment.JUSTIFIED);
		text = "16.	Autorización para cobro de garantía: El Financiador acepta y autoriza de forma expresa a Approbe a i) Realizar la gestión de cobro de acuerdo con la política de cobranza, ii) Gestionar ante el Fondo de Garantías de Antioquia o ante cualquier otro tercero afianzador el cobro del monto financiado actuando Approbe en representación del Financiador, iii) Recibir el pago de la garantía para posteriormente reembolsar al Financiador la suma correspondiente y iv) Realizar cualquier tipo de gestion relacionada con el proceso de cobro de la obligación ante terceros. \n"
				+ "\n"
				+ "17.	Resolución de conflictos: Toda diferencia o controversia originada en o relacionada con el presente contrato, debe ser resuelta por Las Partes directamente dentro de un plazo de treinta (30) días hábiles luego de notificada. Para agotar la etapa de arreglo directo, la Parte que considere que existe un conflicto lo manifestará por escrito indicando (i) los motivos de la inconformidad, (ii) las causas que originan la inconformidad, (iii) la solución propuesta al conflicto que deberá ser diferente a la terminación del contrato. Entregada esta reclamación, Las Partes deberán procurar el arreglo directo en el plazo indicado. Si concluido tal procedimiento, Las Partes no llegaren a ningún acuerdo, el conflicto será sometido a juicio, y para tal elijen las partes el foro de la ciudad de Bogotá. \n"
				+ "\n"
				+ "18.	Confidencialidad. Para los efectos de este Contrato, “Información Confidencial” significará toda información escrita, electrónica o verbal aplicable a, o relacionada con la ejecución de este Contrato y proporcionada por una de las Partes (la “Parte que Divulga”) a la otra (la “Parte Receptora”). \n"
				+ "\n"
				+ "La Parte que Divulga, declara que tiene todos los derechos, propiedad e intereses sobre la Información Confidencial para revelarla a la Parte Receptora.\n"
				+ "\n"
				+ "La Parte Receptora acuerda y reconoce que la Información Confidencial, en la medida en que ello sea legalmente posible hacerlo: (i) será devuelta a la Parte que Divulga o será destruida o eliminada a solicitud de la Parte que Divulga, (ii) no será revelada sin previo consentimiento escrito de la Parte que Divulga a ninguna persona diferente a los empleados, agentes y subcontratistas de la Parte que Recibe que tengan que conocer la Información Confidencial o alguna parte de ella que se relacione con la ejecución de este Contrato y (iii) no será para fines diferentes a los establecidos en el presente Contrato.\n"
				+ "\n"
				+ "La obligación de confidencialidad contenida en esta cláusula no se aplica a información que (i) ya estuviera en posesión de la Parte Receptora en el momento de la divulgación a, o adquisición por, la Parte Receptora, (ii) sea revelada a la Parte Receptora por un tercero, (iii) esté disponible al público o sea de dominio público por causa diferente a un acto u omisión de la Parte Receptora, o (iv) sea solicitada por autoridad competente. \n"
				+ "\n"
				+ "La obligación de confidencialidad aquí prevista tendrá el carácter de indefinida y por ello, Approbe una vez culminado el presente corretaje procederá a eliminar, suprimir y/o destruir la información del financiador, entregando un certificado del procedimiento llevado a cabo. Ahora en el caso que por disposición legal Approbe deba conservar la Información Confidencial, dicha circunstancia deberá ser comunicada al Mandante, comprometiéndose Approbe a no hacer uso de la Información Confidencial para fines diferentes a los establecidos en las disposiciones legales y en el presente Contrato. \n"
				+ " \n"
				+ "19.	Firma electrónica. Las Partes, con la suscripción del presente Contrato, y en los términos de la Ley 527 de 1999 y el Decreto 2364 de 2012 y demás normas que la modifiquen, adicionen, sustituyan o deroguen aceptan recibir y enviar comunicaciones, efectuar transacciones, crear documentos electrónicos y demás registros realizados a través de la Plataforma, incorporando a los mismos el mecanismo de Firma Electrónica dispuesta por Approbe a través de la Plataforma de Approbe.  \n"
				+ "";
		createParagraph(document, text, 11, false, false, new int[] { 20, 40, 0, 40 }, TextAlignment.JUSTIFIED);
		text = "19.1.	Las Partes aceptan que el presente Contrato es creado mediante mecanismos electrónicos y en tal virtud, aceptan firmar electrónicamente el mismo mediante la utilización de la firma electrónica dispuesta en la Plataforma. \n"
				+ "19.2.	Con esta aceptación, las Partes están de acuerdo con que la firma electrónica del presente Contrato, este se reputará auténtico, íntegro y sin lugar a repudio del mismo; lo anterior, por cuanto el método utilizado para tal efecto es confiable y apropiado para ello. \n"
				+ "19.3.	Las Partes aceptan que el presente Contrato es electrónico y para todos los efectos, permanecerá íntegro y disponible para su consulta en las bases de datos dispuestas por la plataforma de Approbe., y en esa medida Approbe se compromete a contar durante toda la vigencia del Contrato parámetros de seguridad adecuados que permitan garantizar su conservación, trazabilidad, existencia y reproducción.\n"
				+ "\n" + "\n" + "\n" + "\n" + "\n";
		createParagraph(document, text, 11, false, false, new int[] { 40, 40, 0, 50 }, TextAlignment.JUSTIFIED);
		;

		text = "Corredor,                                                                                Financiador,\n"
				+ "\n" + "\n" + "\n"
				+ "Kenny Silva Gonzalez                                                            	 	 \n"
				+ "C.C. 1.032.375.009                                                                Nombre " + name
				+ "\n" + "Duvera Kapital                                                         			   C.C. "
				+ numberId + " \n"
				+ "NIT. 901.499.036-5                                                       				          \n";

		createParagraph(document, text, 10, false, false, new int[] { 30, 0, 0, 45 }, TextAlignment.JUSTIFIED);
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
