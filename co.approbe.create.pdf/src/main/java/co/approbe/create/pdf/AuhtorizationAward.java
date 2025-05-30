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

public class AuhtorizationAward {

	public static byte[] auhtorizationAward(ImageData image, ImageData image1) {
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
		PdfCanvas canvasHeader = new PdfCanvas(pdfDoc.getPage(1));
		canvas.saveState();
		canvasHeader.saveState();
		canvas.setExtGState(state);
		canvas.addImageFittedIntoRectangle(image, rect, false);
		canvas.restoreState();
		canvasHeader.setExtGState(state1);
		canvasHeader.addImageFittedIntoRectangle(image1, rect1, false);
		canvasHeader.restoreState();

		String text = "Autorizo en mi calidad de Titular de la Información a Duvera Kapital SAS, o quien haga sus veces, represente sus derechos u ostente en el futuro la calidad de acreedor, a tratar mis Datos Personales conforme a los lineamientos de la Ley 1226 de 2008 y la Ley 1581 de 2012, o las normas que complementen o modifiquen conforme a las finalidades que se indican a continuación, según la funcionalidad de la plataforma:";

		createParagraph(document, text, 10, false, false, new int[] { 20, 30, 0, 30 }, TextAlignment.JUSTIFIED);
		text = "Financia:";

		createParagraph(document, text, 10, false, true, new int[] { 10, 30, 0, 30 }, TextAlignment.JUSTIFIED);
		text = "1.	Compartir Datos Personales, a terceras personas ubicados en el territorio nacional o en el extranjero, para realizar servicios relacionados con las finalidades indispensables o asociadas para la prestación del servicio por parte de Duvera Kapital SAS\n"
				+ "\n"
				+ "2.	Informar acerca de nuevos servicios y productos que ofrezca Duvera Kapital SAS y/o sus aliados comerciales que sean afines con los que en la actualidad adquiere el Titular o que complementen su portafolio de productos y servicios. El Titular puede decidir sobre la recepción de ofertas comerciales por parte de Duvera Kapital SAS, sus vinculados o aliados comerciales, y que cuando se trate de este tipo de mensajes o publicidad, dirigiéndose a los teléfonos de contacto y correo electrónico establecidos por Duvera Kapital. \n"
				+ "\n"
				+ "3.	Recolectar, almacenar y usar Datos Biométricos (Datos Sensibles) como mecanismo de identificación y autenticación \n"
				+ "\n"
				+ "4.	Recolectar, usar, comprobar, compartir almacenar, modificar, procesar, monitorear, ordenar, comparar, analizar, consultar Datos Personales y Financieros para la realizar los siguientes procesos: (i) verificación de identidad, (ii) prospección comercial y perfilamiento, (iii) administración y evaluación de riesgo, (iii) cumplimiento de obligaciones contractuales y (iv) demás servicios relacionados con las finalidades indispensables de la actividad. \n"
				+ "\n"
				+ "Declaro que he sido informado sobre mis derechos como Titular de la Información, los cuales están reconocidos en la normativa nacional, en especial los relativos a: (i) Conocer, actualizar y rectificar mis Datos Personales frente a los Responsables o Encargados del Tratamiento; (ii) Solicitar prueba de la Autorización otorgada al Responsable, salvo cuando expresamente se exceptúe como requisito para el Tratamiento, de conformidad con lo previsto en el artículo 10 de la Ley 1581 de 2012; (iii) Ser informado por el Responsable del Tratamiento, previa solicitud, respecto del uso que le ha dado a mis Datos Personales; (iv) Presentar ante la Superintendencia de Industria y Comercio quejas por infracciones a lo dispuesto en la legislación vigente, previo agotamiento del trámite de consulta o reclamo ante Duvera Kapital SAS previsto como requisito de procedibilidad en el artículo 16 de la Ley 1581 de 2012; (v) Revocar la Autorización y/o solicitar la supresión mis Datos Personales cuando en el Tratamiento no se respeten los principios, derechos y garantías constitucionales y legales.; (vi) Acceder en forma gratuita a mis Datos Personales que hayan sido objeto de Tratamiento; y (vii) Abstenerme de suministrar Datos Sensibles.\n"
				+ "\n"
				+ "Estos derechos los podré ejercer a través del correo electrónico legal@approbe.co canal dispuesto por Duvera Kapital SAS para la atención al público, para la atención de requerimientos relacionados con el tratamiento de mis Datos Personales y el ejercicio de los derechos mencionados en esta autorización. \n"
				+ "\n"
				+ "Manifiesto que la presente autorización me fue solicitada y puesta de presente antes de suministrar los Datos Personales y que la suscribo de forma libre y voluntaria una vez leída en su totalidad. Declaro que conozco igualmente que la Política de Tratamiento de Datos Personales puede ser consultada en la página web https://www.approbe.co\n"
				+ "";

		createParagraph(document, text, 10, false, false, new int[] { 20, 30, 0, 30 }, TextAlignment.JUSTIFIED);

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
