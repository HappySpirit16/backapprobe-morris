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
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;

public class AuhtorizationBorrower {

	public static byte[] authorizationBorrower(ImageData image, ImageData image1) {
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
		Rectangle rect1 = new Rectangle(400, 780, 140, 30);
//			Rectangle rect2 = new Rectangle(110, 785, 400, 30);

		PdfExtGState state = new PdfExtGState().setFillOpacity(0.1f);
		PdfExtGState state1 = new PdfExtGState().setFillOpacity(0.5f);
		PdfCanvas canvas = new PdfCanvas(pdfDoc.getPage(1));
		PdfCanvas canvas1 = new PdfCanvas(pdfDoc.addNewPage());
		PdfCanvas canvasHeader = new PdfCanvas(pdfDoc.getPage(1));
		PdfCanvas canvasHeader1 = new PdfCanvas(pdfDoc.getPage(2));
		canvas.saveState();
		canvas1.saveState();
		canvasHeader.saveState();
		canvasHeader1.saveState();
		canvas.setExtGState(state);
		canvas1.setExtGState(state);
		canvas.addImageFittedIntoRectangle(image, rect, false);
		canvas.restoreState();
		canvas1.addImageFittedIntoRectangle(image, rect, false);
		canvas1.restoreState();
		canvasHeader.setExtGState(state1);
		canvasHeader.addImageFittedIntoRectangle(image1, rect1, false);
		canvasHeader.restoreState();
		canvasHeader1.setExtGState(state1);
		canvasHeader1.addImageFittedIntoRectangle(image1, rect1, false);
		canvasHeader1.restoreState();

		String text = "Autorizo en mi calidad de Titular de la Información a Duvera Kapital SAS, o quien haga sus veces, represente sus derechos u ostente en el futuro la calidad de deudor, a tratar mis Datos Personales conforme a los lineamientos de la Ley 1226 de 2008 y la Ley 1581 de 2012, o las normas que complementen o modifiquen conforme a las finalidades que se indican a continuación, según la funcionalidad de la plataforma:";
		createParagraph(document, text, 10, false, false, new int[] { 20, 40, 0, 40 }, TextAlignment.JUSTIFIED);
		text = "Toma tu crédito:";
		createParagraph(document, text, 10, false, true, new int[] { 10, 40, 0, 40 }, TextAlignment.JUSTIFIED);
		text = "1.	Conservar y aprovechar el registro original y/o electrónico de la Solicitud de Crédito, ya sea que el crédito se apruebe o no, por el tiempo que sea necesario o el requerido en la ley. \n"
				+ "\n"
				+ "2.	Consultar, solicitar y divulgar información que corresponda y guarde relación con movimientos, facturación, compras, estadísticas, preferencias, movimientos de inventario y demás transacciones comerciales del Titular y estén en custodia y/o administración de información de los proveedores de Duvera Kapital SAS. Esta facultad estará vigente mientras subsista alguna relación comercial y será de único manejo para estadísticas y estudios por parte de Duvera Kapital. \n"
				+ "\n"
				+ "3.	Con fines estadísticos, financieros y/o comerciales, así como para evaluar los riesgos derivados de una posible relación contractual, consultar, informar, reportar, procesar y/o divulgar, a las entidades de consulta de bases de datos o Centrales de Información y Riesgo, todo lo referente al comportamiento (presente, pasado y futuro) del Titular como Usuario, el endeudamiento, y en especial el nacimiento, modificación y extinción de obligaciones contraídas por el Titular o que llegaren a contraer a través de Duvera Kapital SAS.\n"
				+ "4.	Consultar cualquier información sobre las relaciones comerciales que reposen en las bases de datos de entidades públicas y/o privadas, bien fuere en Colombia o en el exterior, así como la de reportar, procesar y distribuir dicha información. \n"
				+ "\n"
				+ "5.	Compartir con los vinculados o aliados comerciales Datos Personales para fines de presentar al Titular ofertas sobre sus servicios y productos, pudiendo revocar la autorización para esta finalidad contactando al Responsable del Tratamiento de los Datos. \n"
				+ "\n"
				+ "6.	Entregar los Datos Personales suministrado por el Titular en esta Solicitud, a terceros cuyo objeto sea similar al de Duvera Kapital SAS y  a quienes Duvera Kapital SAS llegue a ceder los derechos y obligaciones que adquiera, en caso de otorgar el crédito solicitado. \n"
				+ "\n"
				+ "7.	Compartir Datos Personales, a terceras personas ubicados en el territorio nacional o en el extranjero, para realizar servicios relacionados con las finalidades indispensables o asociadas para la prestación del servicio por parte de Duvera Kapital SAS.\n"
				+ "\n"
				+ "8.	Permitir a terceras personas acceder a la información relativa al comportamiento, comercial y financiero presente, pasado y futuro, del Titular con los efectos comerciales y financieros a que haya lugar.\n"
				+ "\n"
				+ "9.	Compartir cierta información del Titular con terceros que están relacionados con el servicio que el Titular ha utilizado, tales como empresas de cobranza, empresas que suministran u ofrezcan servicios y/o productos de seguros, entre otras, así como con terceros que son proveedores de Duvera Kapital SAS, empresas que remiten correos electrónicos masivos u otras - con el fin de proveer un mejor servicio al Titular.\n"
				+ "\n"
				+ "10.	Informar acerca de nuevos servicios y productos que ofrezca Duvera Kapital SAS y/o sus aliados comerciales que sean afines con los que en la actualidad adquiere el Titular o que complementen su portafolio de productos y servicios. El Titular puede decidir sobre la recepción de ofertas comerciales por parte de Duvera Kapital SAS, sus vinculados o aliados comerciales, y que cuando se trate de este tipo de mensajes o publicidad, dirigiéndose a los teléfonos de contacto y correo electrónico establecidos por Duvera Kapital. \n"
				+ "\n"
				+ "11.	Acceder a los Datos Personales del Titular contenidos en la base de datos de administradoras de pensiones y/ demás Operadores de información de seguridad social autorizados por el Ministerio de Salud y Protección Social, para darle Tratamiento en los términos expresados en la Política y para finalidades de gestión de riesgo crediticio tales como: (i) elaboración de scores crediticios, herramientas de validación de ingresos, herramientas predictivas de ingresos, herramientas para evitar el fraude y en general, adelantar una adecuada gestión del riesgo crediticio. (ii) Compararla, contrastarla y complementarla con la información financiera, comercial, crediticio, de servicios y proveniente de terceros países de cualquier proveedor de información o central de crédito formalmente establecido.\n"
				+ "\n"
				+ "12.	Consultar y almacenar referencias personales, familiares o comerciales diligenciadas en la Solicitud de Crédito, para profundizar el conocimiento que éstas tienen del Titular como Solicitante y como un medio de contacto para ubicar al Titular.\n"
				+ "\n"
				+ "13.	Recolectar, almacenar y usar Datos Biométricos (Datos Sensibles) como mecanismo de identificación y autenticación.\n"
				+ "\n"
				+ "14.	Recolectar, usar, comprobar, compartir almacenar, modificar, procesar, monitorear, ordenar, comparar, analizar, consultar Datos Personales y Financieros para la realizar los siguientes procesos: (i) verificación de identidad, (ii) prospección comercial y perfilamiento, (iii) administración y evaluación de riesgo, (iii) cumplimiento de obligaciones contractuales y (iv) demás actividades relacionadas con la prestación de los servicios por parte de Duvera Kapital SAS. \n"
				+ "\n"
				+ "15.	Consultar, actualizar o reportar el nacimiento, ejecución y extinción de las obligaciones del Titular en la base de datos administrada por los operadores de información o bureaus de crédito conforme a la Ley 1266 de 2008. \n"
				+ "\n"
				+ "16.	Compartir en la plataforma Approbe, de manera pública, la información básica de la Solicitud de Crédito para conocimiento de posibles financiadores. \n"
				+ "";
		createParagraph(document, text, 10, false, false, new int[] { 20, 40, 0, 40 }, TextAlignment.JUSTIFIED);

		text = "Firma \n" + "\n" + "Nombre\n" + "\n" + "Fecha\n" + "";

		createParagraph(document, text, 10, false, false, new int[] { 50, 0, 0, 40 }, TextAlignment.JUSTIFIED);
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
