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

public class MutualContract {

	public static byte[] mutualContract(ImageData image, ImageData image1, String numberId, String name, String lenderId, String nameLender) {

		int lengthName=name.length();
		int lengthId=numberId.length();
		int lengthNameLender=nameLender.length();
		int lengthIdLender=lenderId.length();
		
		if (!nameLender.equals("   ")) {
			for (int i=lengthNameLender;i<83;i++) {
				nameLender=nameLender+" ";
			}
			for (int i=lengthIdLender;i<77;i++) {
				lenderId=lenderId+" ";
			}
		}else {
			for (int i=lengthNameLender;i<95;i++) {
				nameLender=nameLender+" ";
			}
			for (int i=lengthIdLender;i<87;i++) {
				lenderId=lenderId+" ";
			}
		}
		
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
		PdfCanvas canvas2 = new PdfCanvas(pdfDoc.addNewPage());
		PdfCanvas canvas3 = new PdfCanvas(pdfDoc.addNewPage());
		PdfCanvas canvas4 = new PdfCanvas(pdfDoc.addNewPage());
		PdfCanvas canvasHeader = new PdfCanvas(pdfDoc.getPage(1));
		PdfCanvas canvasHeader1 = new PdfCanvas(pdfDoc.getPage(2));
		PdfCanvas canvasHeader2 = new PdfCanvas(pdfDoc.getPage(3));
		PdfCanvas canvasHeader3 = new PdfCanvas(pdfDoc.getPage(4));
		PdfCanvas canvasHeader4 = new PdfCanvas(pdfDoc.getPage(5));

		canvas.saveState();
		canvas1.saveState();
		canvas2.saveState();
		canvas3.saveState();
		canvas4.saveState();
		canvasHeader.saveState();
		canvasHeader1.saveState();
		canvasHeader2.saveState();
		canvasHeader3.saveState();
		canvasHeader4.saveState();
		canvas.setExtGState(state);
		canvas1.setExtGState(state);
		canvas2.setExtGState(state);
		canvas3.setExtGState(state);
		canvas4.setExtGState(state);
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

		String text = "CONTRATO DE MUTUO";
		createParagraph(document, text, 10, false, false, new int[] { 30, 0, 0, 0 }, TextAlignment.CENTER);
		text = "Las partes de común acuerdo pactan de forma libre y voluntaria realizar un contrato de mutuo entre ellas teniendo en cuenta las siguientes";
		createParagraph(document, text, 10, false, false, new int[] { 10, 20, 0, 20 }, TextAlignment.JUSTIFIED);
		text = "Definiciones";
		createParagraph(document, text, 10, true, true, new int[] { 10, 0, 0, 0 }, TextAlignment.CENTER);
		text = "1.	Mutuante: Persona natural o jurídica registrada en la plataforma Approbe bajo el perfil de Financiador.  \n"
				+ "2.	Mutuario: Persona natural registrada en la plataforma Approbe bajo el perfil de Deudor.\n"
				+ "3.	Oferta de financiación: A partir de la Solicitud de Préstamo y del estudio posterior de las condiciones de pago del Usuario Deudor, se realiza una Oferta con las condiciones de intereses, pagos y plazos que el Usuario Financiador puede acceder a financiar.\n"
				+ "4.	Condiciones de financiación:  Especificaciones de la financiación donde se incluye valor, tasa de interés, plazos de pago y demás condiciones relevantes para el desarrollo del negocio.\n"
				+ "";
		createParagraph(document, text, 10, false, false, new int[] { 10, 20, 0, 40 }, TextAlignment.JUSTIFIED);
		text = "Consideraciones";
		createParagraph(document, text, 10, true, true, new int[] { 10, 0, 0, 0 }, TextAlignment.CENTER);
		text = "1.	Que Approbe es una plataforma desarrollada por Duvera Kapital SAS quien actúa como corredor para la financiación de determinados recursos por parte del MUTUANTE hacia el MUTUARIO. \n"
				+ "2.	El MUTUANTE es una persona natural o jurídica que cuenta con plena capacidad para realizar la financiación de ciertos recursos a favor del MUTUARIO de acuerdo con lo pactado en los documentos “Oferta de financiación ” y en las “Condiciones de financiación”.. \n"
				+ "3.	El MUTUANTE acepta financiar al MUTUARIO con recursos propios provenientes de fuentes legales de acuerdo con la “Oferta de financiación” seleccionada en la plataforma Approbe.\n"
				+ "4.	El MUTUARIO es una persona natural que cuenta con plena capacidad para solicitar y aceptar financiación por parte del MUTUANTE.\n"
				+ "5.	La identificación de las partes será confidencial. Tanto el MUTUANTE como el MUTUARIO están plenamente identificados dentro de la plataforma Approbe.\n"
				+ "";
		createParagraph(document, text, 10, false, false, new int[] { 10, 20, 0, 40 }, TextAlignment.JUSTIFIED);
		text = "Anexos";
		createParagraph(document, text, 10, true, true, new int[] { 10, 0, 0, 0 }, TextAlignment.CENTER);
		text = "El presente contrato cuenta los los siguientes anexos que son parte integral del contrato:";
		createParagraph(document, text, 10, false, false, new int[] { 10, 20, 0, 55 }, TextAlignment.JUSTIFIED);
		text = "a.	Anexo 1 - Oferta de Financiación \n" + "b.	Anexo 2 - Condiciones de financiación\n"
				+ "c.	Anexo 3 - Tratamiento de Datos Personales, Autorizaciones, Declaraciones y Gastos de Fondo de Garantías de Antioquia\n"
				+ "";
		createParagraph(document, text, 10, false, false, new int[] { 10, 20, 0, 65 }, TextAlignment.JUSTIFIED);
		text = "Así las cosas, MUTUANTE y MUTUARIO convienen celebrar el presente Contrato de Mutuo (en adelante “Contrato”), de acuerdo con las siguientes";
		createParagraph(document, text, 10, false, false, new int[] { 10, 20, 0, 40 }, TextAlignment.JUSTIFIED);
		text = "CLÁUSULAS";
		createParagraph(document, text, 10, false, false, new int[] { 10, 0, 0, 0 }, TextAlignment.CENTER);
		text = "1.	El MUTUANTE da en mutuo a EL MUTUARIO, la suma establecida y aceptada por EL MUTUARIO en la plataforma Approbe y que se incluye en detalle en el Anexo 1 - Oferta de financiación y en el Anexo 2 - Condiciones de financiación. \n"
				+ "\n"
				+ "2.	El MUTUARIO  está obligado a desembolsar la suma pactada y aceptada en la “Oferta de Préstamo” en la mayor brevedad posible por medio de la cuenta Powwi creada para tal fin.\n"
				+ "\n"
				+ "3.	El término de restitución del valor total dado en mutuo, se efectuará en el plazo y cuotas estipuladas y previamente aceptadas por EL MUTUARIO, las cuales corresponden al término establecido en la Oferta de Préstamo, el cual, hace parte integral del presente Contrato. \n"
				+ "\n"
				+ "4.	El mutuo devengará un interés establecido en la Oferta de Préstamo, a favor de EL MUTUANTE sobre el capital, el cual deberá ser abonado por EL MUTUARIO en los plazos vencidos estipulados en la Oferta de Préstamo. Los intereses compensatorios se computarán desde la fecha de producido el desembolso hasta la fecha en la que EL MUTUARIO hiciera íntegra y efectiva devolución y reembolso de la totalidad de capital junto con los intereses que se hayan causado, para lo cual, se incluirá el primer día del desembolso y se excluirá el último. PARÁGRAFO PRIMERO: EL MUTUARIO reconoce y acepta que deberá a EL MUTUANTE, además de la cifra otorgada a título de mutuo, los gastos que se computarán junto con los intereses compensatorios. Los gastos adicionales incluirán: utilización de la Plataforma, gastos de cobranza e intereses moratorios en caso de que hubiere lugar al cobro de estos, junto con los cobros imputables de acuerdo con el documento “Costos y tarifas” publicados en la plataforma, incluyendo los costos de desembolso, aquellos relacionados con el cobro al Gravamen a los Movimientos Financieros y demas asociados a costos bancarios. Los gastos, si los hubiere, serán calculados exclusivamente hasta la fecha de devolución consignada en la Oferta de Préstamo, todo ello conforme el sistema, cantidad, monto y periodicidad indicados en la Oferta de Préstamo.\n"
				+ "\n"
				+ "5.	El pago del capital, de los intereses y de los gastos, deberá ser efectuado por medio de los canales habilitados para tal fin dentro de las fechas estipuladas y aceptadas por las Partes dentro de la Plataforma y señalados en la Oferta de Préstamo. \n"
				+ "\n"
				+ "6.	Si EL MUTUARIO no realiza el pago del capital o de los intereses compensatorios en los plazos y montos pactados por las Partes, se causarán intereses moratorios sobre el saldo en mora y por el tiempo que dure la misma, a la tasa máxima de interés moratorio permitida, certificada por la Superintendencia Financiera. EL MUTUARIO pagará también a EL MUTUANTE, en caso de cobro judicial o extrajudicial, todos los gastos que demande su cobranza, incluyendo los honorarios razonables de abogados. \n"
				+ "\n"
				+ "7.	Además de lo estipulado en la Política de Crédito publicada en la plataforma Approbe.co, en caso de presentarse cualquiera de los eventos que se estipulan a continuación, habrá lugar a la declaratoria de vencimiento anticipado del plazo del préstamo por parte de EL MUTUANTE: \n"
				+ "";
		createParagraph(document, text, 10, false, false, new int[] {15, 20, 0, 40 }, TextAlignment.JUSTIFIED);
		text = "a.	La mora de treinta (30) días de EL MUTUARIO en el pago de cualquiera de las cuotas de capital y/o intereses del crédito o de los gastos que de él se deriven.\n"
				+ "\n"
				+ "b.	Si EL MUTUARIO solicita el concurso preventivo de sus acreedores o su propia iliquidez o insolvencia, o ésta le fuera solicitada por terceros y no es desestimada dentro de la oportunidad procesal por EL MUTUARIO; \n"
				+ "";
		createParagraph(document, text, 10, false, false, new int[] { 10, 20, 0, 55 }, TextAlignment.JUSTIFIED);

		text = "PARÁGRAFO PRIMERO: Ocurrido alguno de los eventos antes enunciados o producida la mora, que se causará por el mero vencimiento del plazo, EL MUTUANTE podrá a su arbitrio, y sin necesidad de requerimiento a EL MUTUARIO, declarar de pleno derecho la caducidad del plazo o término otorgado para la cancelación del mutuo y exigir a EL MUTUARIO el pago inmediato del capital y de intereses compensatorios adeudados, así como de los gastos.\n"
				+ "\n"
				+ "PARÁGRAFO SEGUNDO: EL MUTUARIO estará en la obligación de informar a EL MUTUANTE al respecto de llegar a presentarse alguna de las circunstancias contempladas en la presente cláusula.\n"
				+ "\n";
		createParagraph(document, text, 10, false, false, new int[] { 15, 20, 20, 50 }, TextAlignment.JUSTIFIED);
		text = "8.	La falta de ejercicio por parte de EL MUTUANTE de cualquiera de los derechos que este Contrato le otorga como a acreedor y tenedor del Título Valor, así como, el otorgamiento a EL MUTUARIO, bajo cualquier forma jurídica, de una prórroga en los plazos pactados, no implicará la renuncia a estos derechos ni a sus garantías, ni impedirá a EL MUTUANTE ejercer tales derechos u otros en lo sucesivo. \n"
				+ "\n"
				+ "9.	EL MUTUARIO podrá hacer el pago del capital adeudado antes de la fecha de vencimiento del plazo total, caso en el cual, cancelará los intereses de plazo mencionados en la cláusula tercera de conformidad con la Oferta de Préstamo, los cuales serán liquidados hasta el día del pago total del capital.\n"
				+ "     En caso de abonos parciales a capital, el interés de plazo de dicha cláusula se liquidará sobre el   saldo de capital que se adeuda.\n"
				+ "\n"
				+ "10.	El presente Contrato tiene el carácter de Título Ejecutivo conforme a las normas civiles y comerciales de Colombia, asimismo las Partes acuerdan que presta mérito ejecutivo. \n"
				+ "\n"
				+ "11.	Con el fin de garantizar el pago del préstamo y el cumplimiento de las demás obligaciones que surgirán a cargo de EL MUTUARIO, éste se obliga a suscribir un Pagaré en blanco con carta de instrucciones a favor de EL MUTUANTE, en el cual se incorporarán las obligaciones dinerarias contraídas por EL MUTUARIO a favor de EL MUTUANTE. \n"
				+ "\n"
				+ "12.	Fianza FGA. Las partes acuerdan y aceptan que el presente contrato de mutuo será afianzado por el Fondo de Garantías de Antioquia S.A. (“FGA”) quien prestara el servicio de fianza como mecanismo de cobertura del riesgo de crédito, el cual se efectuará según las condiciones definidas al momento del desembolso, sin que haya lugar a devolución o reintegro por prepago de la obligación crediticia y de acuerdo con el documento de Costos y Tarifas publicado en la página web. \n"
				+ "     Las partes Declaramos conocer que en caso de incumplimiento de la obligación crediticia, FGA pagará la cobertura conferida al otorgante del crédito, según el porcentaje de cobertura pactado y, en consecuencia, operará a favor de FGA la subrogación legal por activa, permitiendo recobrar el valor pagado, momento a partir del cual se generarán intereses de mora y gastos de cobranza. En consecuencia, reconozco que el pago que llegue a realizar FGA no extingue parcial, ni totalmente la obligación del MUTUARIO.\n"
				+ "\n"
				+ "13.	En el evento en que se determine que una estipulación contenida en el presente Contrato es nula, inválida o ineficaz, las demás estipulaciones continuarán vigentes. De ocurrir lo anterior, las Partes se obligan a reemplazar de buena fe dicha disposición de mutuo acuerdo. \n"
				+ "\n"
				+ "14.	El presente Contrato se regirá por la Ley Colombiana, y el domicilio contractual para todos los efectos será la ciudad de Bogotá. \n"
				+ "\n"
				+ "15.	EL MUTUARIO acepta y reconoce que el presente documento se firmará a través del mecanismo de firma electrónica establecido y provisto por AutenTic el cual cumple con los criterios de confiabilidad y apropiabilidad y por medio del cual se garantizan los atributos de autenticidad e integridad necesarios de conformidad con la Ley 527 de 1999 y el Decreto 2364 de 2012.\n"
				+ "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n";
		createParagraph(document, text, 10, false, false, new int[] { 20, 20, 0, 30 }, TextAlignment.JUSTIFIED);
		text = "ANEXO 3  “TRATAMIENTO DE DATOS PERSONALES, AUTORIZACIONES, DECLARACIONES Y GASTOS DE FONDO DE GARANTÍAS DE ANTIOQUIA”";
		createParagraph(document, text, 10, false, false, new int[] { 18, 0, 0, 0 }, TextAlignment.CENTER);
		text = "Autorizo de manera previa, expresa e informada a FGA o a quien ostente en el futuro la calidad de acreedor, para que realice cualquier operación o conjunto de operaciones de tratamiento, tales como la recolección, actualización, almacenamiento, administración, uso, circulación, supresión, cotejo, búsqueda, transmisión, transferencia y/o de cualquier manera realice algún tratamiento de mis datos personales, lo cual incluye pero no se limita a datos de identificación, información de contacto, datos demográficos y datos financieros, para lo siguiente: \n"
				+ "a)	Realizar el tratamiento de mis datos personales suministrados para las siguientes finalidades:\n"
				+ "";
		createParagraph(document, text, 10, false, false, new int[] { 20, 20, 0, 30 }, TextAlignment.JUSTIFIED);
		text = "(i)	Gestionar y llevar a cabo labores de gestión de cobranza del crédito; \n"
				+ "(ii)	Gestionar el cumplimiento de obligaciones legales o contractuales; \n"
				+ "(iii)	Realizar campañas de actualización de datos; \n"
				+ "(iv)	Realizar estudios de seguridad, para la prevención de fraudes, lavado de activos y financiación del terrorismo; \n"
				+ "(v)	Ofrecer y enviar información acerca de actividades comerciales, promocionales, de mercadeo, de productos y servicios tanto propios como de terceros, directamente o a través de terceros contratados para tal fin;\n"
				+ "(vi)	\n"
				+ "(vii)	Actualizar los datos de los titulares de la información con contenido sociodemográfico y socioeconómico, con el fin de generar datos estadísticos para ofrecer productos y servicios propios o de terceros, acorde a los resultados; \n"
				+ "(viii)	 Realizar encuestas de satisfacción concerniente a la gestión de recuperación de cartera y a los servicios prestados por FGA, en las cuales se podrá realizar la actualización de datos personales.\n"
				+ "(ix)	 Compartir, ceder, negociar y vender a terceros y diversos actores del mercado, la información y datos personales del titular, incluido su comportamiento de pago;\n"
				+ "(x)	Consultar la información del titular del dato que repose en bases de datos de entidades públicas o privadas, incluidas multas y sanciones ante las diferentes autoridades administrativas y judiciales, o bases de datos públicas que tengan como función la administración de datos de esta naturaleza;\n"
				+ "(xi)	Proveer reportes de información a las autoridades competentes; \n"
				+ "(xii)	Consultar los datos personales en las centrales de información para conocer el desempeño como deudor, capacidad de pago o para valorar el riesgo;\n"
				+ "(xiii)	Informar y reportar a las centrales de información el comportamiento de pago de mis obligaciones crediticias, o de mis deberes legales de contenido patrimonial respecto a todas las operaciones, que bajo cualquier modalidad, haya celebrado o llegue a celebrar con FGA o quien ostente la calidad de acreedor, que se encuentren a mi cargo; \n"
				+ "(xiv)	Suministrar a las centrales de información, datos relativos a los servicios de fianza, así como a otros atinentes a las relaciones comerciales, financieras y en general, socioeconómicas, entre otras.  \n"
				+ "";
		createParagraph(document, text, 10, false, false, new int[] { 0, 20, 0, 50 }, TextAlignment.JUSTIFIED);
		text = "b)	Remitir vía correo electrónico, mensaje de texto, WhatsApp o cualquier otro medio afín, cualquier tipo de información y/o comunicación en el marco de las anteriores finalidades, la Ley 527 de 1999 y en especial, la notificación previa al reporte negativo de que trata el artículo 12 de la Ley 1266 de 2008 y/o cualquier norma que la modifique o adicione.\n"
				+ "c)	Tratar los datos sobre mi ubicación, datos de mis ordenadores o teléfonos celulares, fotografías, direcciones de correos electrónicos, entre otros, para ser utilizados con fines de autenticación e identificación por medio de mi firma electrónica y/o digital.\n"
				+ "\n"
				+ "d)	Transmitir y transferir mis datos personales, comerciales y financieros, para que sean conocidos y tratados por terceros que, en calidad de proveedores nacionales o extranjeros o en el exterior, presten servicios tecnológicos, logísticos, operativos, de mercadeo, seguridad y apoyo; personas naturales o jurídicas accionistas de FGA o quien ostente su calidad de acreedor, o en general, pertenecientes al mismo grupo empresarial o aliado comercial. \n"
				+ "\n"
				+ "e)	Consultar mis datos personales, crediticios o comerciales ante cualquier operador o base de datos o central de riesgo, además de mis hábitos de pago y cumplimiento de mis obligaciones. Así mismo, para que informe y reporte a dichas entidades el comportamiento de pago de mis obligaciones crediticias, o de mis deberes legales de contenido patrimonial respecto a todas las operaciones, que bajo cualquier modalidad, haya celebrado o llegue a celebrar con FGA o quien ostente la calidad de acreedor, que se encuentren a mi cargo, de tal forma que aquellas entidades presenten una información veraz, pertinente, completa actualizada y exacta de mi desempeño como deudor y/o codeudor. \n"
				+ "\n"
				+ "Declaro que he sido informado de la política de tratamiento de datos personales, la cual puede ser consultada de manera permanente en la página web de FGA:";
		createParagraph(document, text, 10, false, false, new int[] { 20, 20, 0, 30 }, TextAlignment.JUSTIFIED);
		text = "www.fga.com.co. Asimismo, declaro que conozco y entiendo que podré ejercer los derechos de acceso, actualización, rectificación, supresión de mis datos personales, también podré solicitar prueba de esta autorización y podré revocarla siempre y cuando no tenga una obligación legal y contractual de permanecer en la base de datos de FGA. Estos derechos los podré ejercer por medio de los siguientes canales: ";
		createParagraph(document, text, 10, false, true, new int[] { 0, 20, 0, 30 }, TextAlignment.JUSTIFIED);

		float[] pointColumnWidthsTitle = { 360F };
		Table tableTitle = new Table(pointColumnWidthsTitle);
		tableTitle.addCell(new Cell().add(new Paragraph("CANALES HABILITADOS")));
		tableTitle.setMargins(20, 30, 0, 80);
		tableTitle.setFontSize(8);
		tableTitle.setFontColor(WebColors.getRGBColor("#000000"));
		tableTitle.setTextAlignment(TextAlignment.CENTER);
		tableTitle.setBackgroundColor(WebColors.getRGBColor("#B4C6E7"));
		document.add(tableTitle);

		float[] pointColumnWidths = { 120F, 240F };
		Table table = new Table(pointColumnWidths);

		// Adding cells to the table
		table.addCell(new Cell().add(new Paragraph("Correo electrónico 1: ")));
		table.addCell(new Cell().add(new Paragraph("info@fga.com.co")));
		table.addCell(new Cell().add(new Paragraph("Correo electrónico 2: ")));
		table.addCell(new Cell().add(new Paragraph("cobranzas@fga.com.co")));
		table.addCell(new Cell().add(new Paragraph("Página web: ")));
		table.addCell(new Cell().add(new Paragraph("www.fga.com.co")));
		table.addCell(new Cell().add(new Paragraph("Dirección oficina Medellín")));
		table.addCell(new Cell().add(new Paragraph("Carrera 43 A No. 19- 17, Piso 9 Ed. Block Empresarial")));
		table.addCell(new Cell().add(new Paragraph("Dirección oficina Bogotá ")));
		table.addCell(new Cell().add(new Paragraph("Calle 90 No. 19 A 49, Oficina 702, Ed. Bambú")));
		table.setMargins(0, 30, 0, 80);
		table.setFontSize(8);
		document.add(table);
		text = "También declaro conocer y entender que podré presentar quejas ante la Superintendencia de Industria y Comercio por infracciones de las disposiciones de la Ley 1581 de 2012. ";
		createParagraph(document, text, 10, false, false, new int[] { 30, 20, 0, 30 }, TextAlignment.JUSTIFIED);
		text = "El presente Contrato se suscribe a través de firma electrónica, y una copia del mismo será remitida al correo electrónico de las Partes.";
		createParagraph(document, text, 10, false, false, new int[] { 60, 20, 0, 25 }, TextAlignment.JUSTIFIED);
		text = "EL MUTUANTE,                                                                                    EL MUTUARIO,\n"
				+ "\n" + "\n" + "\n"
				+ "______________________                                                            	 ______________________  \n"
				+ "Nombre "+nameLender+" Nombre: "+name+"\n"
				+ "Identificación "+lenderId+" C.C. "+numberId+"\n"
				+ "(Firma electrónica)                                                      				         (Firma incluida electrónicamente)\n";
		createParagraph(document, text, 10, false, false, new int[] { 30, 0, 0, 10 }, TextAlignment.JUSTIFIED);
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
