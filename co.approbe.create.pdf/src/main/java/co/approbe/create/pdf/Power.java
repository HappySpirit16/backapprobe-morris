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

public class Power {

	public static byte[] power(ImageData image, ImageData image1, String numberId, String name, String cellphone, String identification) {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PdfWriter writer = new PdfWriter(outputStream);
		// Creating a PdfDocument
		PdfDocument pdfDoc = new PdfDocument(writer);
		// Creating a Document
		Document document = new Document(pdfDoc);
		// Adding a new page
		pdfDoc.addNewPage();
		// Creating an ImageData object
		Paragraph parag = new Paragraph();
		parag.add("Poder para creación y administración de los recursos \n"
				+ " depositados en el “bolsillo” del Depósito de dinero.");
		parag.setTextAlignment(TextAlignment.CENTER);
		parag.setFontSize(13);
		parag.setFontColor(WebColors.getRGBColor("#808080"));
		parag.setBold();
		Rectangle rect = new Rectangle(100, 250, 400, 400);
		Rectangle rect1 = new Rectangle(30, 770, 100, 30);
		Rectangle rect2 = new Rectangle(100, 750, 400, 60);

		PdfExtGState state = new PdfExtGState().setFillOpacity(0.1f);
		PdfExtGState state1 = new PdfExtGState().setFillOpacity(0.5f);
		PdfCanvas canvas = new PdfCanvas(pdfDoc.getPage(1));
		PdfCanvas canvas1 = new PdfCanvas(pdfDoc.addNewPage());
		PdfCanvas canvasHeader = new PdfCanvas(pdfDoc.getPage(1));
		PdfCanvas canvasHeader1 = new PdfCanvas(pdfDoc.getPage(2));
		Canvas canvasEncabezado;
		Canvas canvasEncabezado1;
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
		canvasEncabezado = new Canvas(canvasHeader, rect2);
		canvasEncabezado.add(parag);

		canvasEncabezado1 = new Canvas(canvasHeader1, rect2);
		canvasEncabezado1.add(parag);
		String parag1 = "Yo "+name+", mayor de edad identificado(a) con "+identification+" número "+numberId+", en mi calidad de titular del(los) Depósito(s) de Dinero Powwi Ágil o Powwi Más No.(s) "+cellphone+ " (en adelante, “Depósito de Dinero”), servicios ofrecidos por la sociedad PAGOS GDE S.A., con NIT No. 901.077.411-3, depósitos constituido(s) con ocasión a la relación jurídica que actualmente tengo con la sociedad Duvera Kapital S.A.S. identificada con NIT No. 901.499.036-5, por medio del presente solicito:";
		// Creating an Area Break
		Paragraph paragraph = new Paragraph(parag1);
		paragraph.setTextAlignment(TextAlignment.JUSTIFIED);
		paragraph.setMargins(50, 30, 0, 30);
		document.add(paragraph);
		String parag2 = "1.	Se permita la creación y/o constitucion de un Depósito de Dinero en Pagos GDE S.A. (Entidad Financiera, vigilada por la Superintendencia Financiera de Colombia), a través de la Plataforma Aprobbe el cual tendrá una destinación exclusiva para el uso de los servicios o productos ofrecidos a través de la plataforma Approbe por Duvera Kapital S.A.S., en los términos del contrato que he suscrito con esta ultima. En este sentido, de manera consciente y voluntaria autorizo expresamente para que en el momento en que se requiera, se debiten los recursos acreditados en mi Depósito de Dinero, en la periodicidad que se requiera, con el único fin de dar cumplimiento a las condiciones y/u obligaciones derivadas del contrato que he suscrito con la sociedad Duvera Kapital S.A.S. \n"
				+ "\n"
				+ "2.	Así mismo, por medio del presente documento otorgo poder especial, amplio y suficiente a la sociedad Duvera Kapital S.A.S., para que, en mi nombre y representación, solicite a Pagos GDE S.A., en cualquier tiempo, los datos e información relacionada con la apertura, administración y comportamiento del Depósito de Dinero de mi titularidad.\n"
				+ "En Consecuencia, la sociedad Duvera Kapital S.A.S. queda autorizada, para solicitar y conocer entre ellos, los depósitos realizados, la rentabilidad si hay lugar a ello, los retiros, los saldos, las cancelaciones, las novedades, etc., y en general, toda aquella información de la que soy titular del producto financiero y que se encuentre asociada al Depósito de Dinero; la cual, podrá estar o no incluida en los extractos proporcionados por Pagos GDE S.A. y sobre los cuales desde ya autorizo entregar copia a Duvera Kapital S.A.S.\n"
				+ "\n"
				+ "3.	Autorizo a Duvera Kapital S.A.S. al cobro del porcentaje de comisión o costos de acuerdo con lo publicado en el documento de Costos y Tarifas de la Plataforma Approbe, siendo esto pagadero con los recursos que se encuentren acreditados a la fecha en mi Depósito de Dinero. \n"
				+ "\n "
				+"\n ";
		Paragraph paragraph2 = new Paragraph(parag2);
		paragraph2.setTextAlignment(TextAlignment.JUSTIFIED);
		paragraph2.setMargins(30, 30, 0, 70);
		document.add(paragraph2);
		String parag3 = "\n"
				+ "El presente poder es irrevocable en los términos del artículo 1279 del Código de Comercio y para que tenga efectos deberá ser entregado por parte de Duvera Kapital S.A.S. a Pagos GDE S.A.\n"
				+ "\n"
				+ "Manifiesto que este poder se confiere bajo el total y completo entendimiento del acuerdo suscrito con Duvera Kapital S.A.S. Comprendo que este poder cumple sus efectos mientras el contrato de prestación de servicios celebrado con Duvera Kapital S.A.S. subsista. \n"
				+ "\n"
				+ "De conformidad con las disposiciones establecidas por la Ley 527/1999 y el Decreto 2364/2012, declaro que convengo y acepto que el presente documento será suscrito a través de autenticación de una OTP (One Time Password) en combinación con el ingreso de la contraseña emitida al momento de la creación de la cuenta en la plataforma de Approbe. Adicionalmente, desde ahora reconozco y acepto que la suscripción del presente poder a través del mecanismo de validación de identidad (Circular Básica Jurídica de la Superintendencia Financiera de Colombia Parte I, Título II, Capítulo I, numeral 2.2.6.3), producirá los mismos efectos jurídicos que si fuere suscrito a través de una firma autógrafa.\n"
				+ "\n" + "\n" + "";
		Paragraph paragraph3 = new Paragraph(parag3);
		paragraph3.setTextAlignment(TextAlignment.JUSTIFIED);
		paragraph3.setMargins(30, 30, 0, 30);
		document.add(paragraph3);
		document.close();
		System.out.println("PDF Created");
		return outputStream.toByteArray();
	}

}
