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
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.RoundDotsBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;

public class Promissory {

	public static byte[] promissory(ImageData image, ImageData image2, String name, String numberId, String address,
			String phone, String numberCredit, String lenderId, String nameLender) {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PdfWriter writer = new PdfWriter(outputStream);
		// Creating a PdfDocument
		PdfDocument pdfDoc = new PdfDocument(writer);

		// Adding a new page
		pdfDoc.addNewPage();
		Border border = Border.NO_BORDER;
		// Creating a Document
		Document document = new Document(pdfDoc);

		ImageData data;
		float[] anchos = { 1F };
		Table tablaEncabezado = new Table(anchos);
		tablaEncabezado.setWidth(550F);

		tablaEncabezado.addCell("PAGARÉ Y CARTA DE INSTRUCCIONES").setBorder(Border.NO_BORDER);
		tablaEncabezado.setMarginTop(20);
		tablaEncabezado.setFontColor(WebColors.getRGBColor("#FFFFFF"));
		tablaEncabezado.setBackgroundColor(WebColors.getRGBColor("#999FA7"));
		tablaEncabezado.setTextAlignment(TextAlignment.CENTER);
		// tablaEncabezado.setTextAlignment(TextAlignment.CENTER);
		tablaEncabezado.setFontSize(12);
//				        tablaEncabezado.setOpacity(0.5F);
		tablaEncabezado.setBorder(new RoundDotsBorder(0.1F));
		Rectangle rect2 = new Rectangle(20, 680, 700, 150);
		PdfExtGState state = new PdfExtGState().setFillOpacity(0.1f);
		PdfCanvas canvas = new PdfCanvas(pdfDoc.getPage(1));
		PdfCanvas canvas1 = new PdfCanvas(pdfDoc.addNewPage());
		PdfCanvas canvasHeader = new PdfCanvas(pdfDoc.getPage(1));
		PdfCanvas canvasHeader1 = new PdfCanvas(pdfDoc.getPage(2));
		Canvas canvasEncabezado;
		Canvas canvasEncabezado1;

		canvasEncabezado = new Canvas(canvasHeader, rect2);
		canvasEncabezado.add(tablaEncabezado).setBorder(Border.NO_BORDER);

		canvasEncabezado1 = new Canvas(canvasHeader1, rect2);
		canvasEncabezado1.add(tablaEncabezado).setBorder(Border.NO_BORDER);

		// Creating a table
		float[] pointColumnWidths = { 280F, 280F };
		Table table = new Table(pointColumnWidths);

		// Adding cells to the table
		table.addCell(new Cell().add(new Paragraph("PAGARÉ No. \n"+numberCredit))).setFontSize(8);
		table.addCell(new Cell().add(new Paragraph(
				"Fecha de vencimiento:\n" + "Día                      Mes                              Año \n" + "")));
		table.addCell(new Cell().add(new Paragraph("Capital:\n" + "$ \n" + "")));
		table.addCell(new Cell().add(new Paragraph("Intereses Remuneratorios:\n" + "$\n" + "")));
		table.addCell(new Cell().add(new Paragraph("Intereses de Mora:\n" + "$ \n" + "")));
		table.addCell(new Cell().add(new Paragraph("Otros Valores:\n" + "$ \n" + "")));

		table.setBold();
		table.setMargins(20, 18, 0, 18);
		// Adding Table to document
		document.add(table);
		float[] pointColumnWidths1 = { 560F };
		Table table1 = new Table(pointColumnWidths1);
		table1.addCell(new Cell().add(new Paragraph("Lugar de Pago: ")));
		table1.setMargins(0, 18, 0, 18);
		document.add(table1);
		float[] pointColumnWidths2 = { 560F };
		Table table2 = new Table(pointColumnWidths2);
		table2.addCell(new Cell().add(new Paragraph(
				"Quien(es) suscribe(n) el presente Pagaré físico o desmaterializado, mayor(es) de edad, identificado(s) como aparece al pie de mi(nuestras) firma(s), en adelante el(los) “DEUDOR(ES)” obrando en nombre propio, me(nos) obligo(amos) a pagar solidaria e incondicionalmente al financiador:\n"
						+ "\n"
						+ "  		          NOMBRE DEL FINANCIADOR: "+nameLender+" \n"
						+ "\n" + "  		          DOCUMENTO: "+lenderId+" \n" + "\n"
						+ " en adelante “EL ACREEDOR” o al legítimo tenedor de este Pagaré, en la Fecha de Vencimiento y Lugar de Pago arriba indicados las sumas por Capital, Intereses Remuneratorios, Intereses de Mora y Otros Valores relacionados arriba, que comprenden los valores señalados en las instrucciones de diligenciamiento contenidas en el presente documento. \n"
						+ "De conformidad con el artículo 622 del código de comercio, autorizo(amos) de manera irrevocable EL ACREEDOR sin necesidad de notificación previa, a llenar los espacios en blanco dejados en este instrumento de acuerdo con las siguientes instrucciones:\n"
						+ "\n" + "PRIMERO. El número del PAGARÉ será aquel que EL ACREEDOR libremente le asigne.\n"
						+ "\n"
						+ "SEGUNDO. El espacio en blanco correspondiente a CAPITAL será diligenciado con el valor de aquellas sumas que de acuerdo con los registros contables DEL ACREEDOR le adeude(mos) en la fecha de diligenciamiento del Pagaré, por concepto de operaciones activas de crédito o en general por cualquier cuenta deudora a mi(nuestro) cargo y a su favor. Para la efectividad de la presente estipulación reconozco(cemos) como válidos sin reserva alguna los asientos contables del acreedor.\n"
						+ "\n"
						+ "TERCERO. El espacio en blanco correspondiente a INTERESES REMUNERATORIOS será diligenciado con la sumatoria de los valores adeudados por el(los) DEUDOR(ES) AL ACREEDOR por conceptos de intereses remuneratorios o de plazo y que se hayan causado sobre el CAPITAL hasta la FECHA DE VENCIMIENTO.\n"
						+ "\n"
						+ "CUARTO.  El espacio en blanco correspondiente a INTERESES DE MORA será diligenciado con la sumatoria de los valores causados hasta la FECHA DE VENCIMIENTO de este Pagaré por concepto de intereses de mora derivados del Capital, calculados con base en la tasa máxima de mora permitida por la Ley para el periodo que corresponda.\n"
						+ "\n"
						+ "QUINTO. El espacio en blanco correspondiente a OTROS VALORES incluirá la sumatoria de los valores que se hayan causado como consecuencia de la cobranza prejudicial y judicial de las obligaciones a cargo del(los) DEUDOR(ES) y a favor DEL ACREEDOR y los impuestos que se causen por la creación y ejecución de este Pagaré, así como primas de seguros.\n"
						+ "\n"
						+ "SEXTO. Serán a cargo del DEUDOR todas las sumas causadas en el recaudo judicial y extrajudicial de la obligación acá contenida, incluyendo dentro de ellas los GASTOS Y HONORARIOS DE COBRANZA, en los términos definidos en las disposiciones DEL ACREEDOR, las cuales declaro(amos) conocer.\n"
						+ "\n"
						+ "SÉPTIMO. El espacio en blanco correspondiente a la FECHA DE VENCIMIENTO corresponde al día, mes y año en que el Pagaré sea diligenciado por el ACREEDOR por considerarlo necesario para su cobro, especialmente cuando: (a) Se presente incumplimiento de cualquiera de las obligaciones contraídas por el(los) DEUDOR(ES) con EL ACREEDOR o falsedad en sus declaraciones; (b) El(Los) DEUDOR(ES) fuere(n) demandado(s) ejecutivamente por terceros; (c) El (Los) DEUDOR(ES) no actualice(n) su información en caso de tener modificaciones; (d) El (Los) DEUDOR(ES) sea(n) vinculado(s) o condenado(s) a cualquier investigación penal, en especial las relacionadas con delitos de lavado de activos y financiación del terrorismo o sea(n) incluido(s) en listas inhibitorias; (e) En caso de muerte del(los) DEUDOR(ES); (f) En los demás casos autorizados por la ley.\n"
						+ "\n"
						+ "OCTAVO. El espacio en blanco correspondiente al LUGAR DE PAGO será diligenciado con el lugar del domicilio del(los) DEUDOR(ES) o cualquier otro lugar en donde EL ACREEDOR pueda demandar al(los) DEUDOR(ES).\n"
						+ "\n"
						+ "NOVENO. Expresamente renuncio(amos) y excuso(amos) AL ACREEDOR de cualquier presentación para el cobro o pago del presente instrumento, así como su protesto y/o cualquier requerimiento judicial o extrajudicial encaminado a hacer efectivas las obligaciones acá contenidas.\n"
						+ "\n"
						+ "DÉCIMO. Autorizo(amos) AL ACREEDOR o cualquier tenedor legítimo de este Pagaré a realizar la ACELERACIÓN DEL PLAZO para que, sin necesidad de requerimiento judicial o extrajudicial para constituirme(nos) en mora y/o cumplimiento, declare vencido el plazo de esta obligación o de las cuotas que constituyan el saldo y exigirme(nos) su pago total inmediato, judicial o extrajudicialmente, sin perjuicio de su facultad de restituir el plazo en las condiciones previstas por la ley, en los siguientes casos:\n"
						+ "\n"
						+ "a.	Cuando incumpla(mos) o retarde(mos) el incumplimiento de cualquiera de las obligaciones derivadas del presente documento o por mora en el pago de capital, intereses o cualquier suma de cualquier obligación que directa o indirectamente tenga(mos) con el beneficiario. "
						+ "b.	Cuando el deudor y/o cualquiera de los representantes legales de éste llegaren a ser: (i) vinculado(s) por parte de las autoridades competentes a cualquier tipo de investigación en su país o cualquier otro país por delitos de narcotráfico, terrorismo, secuestro, lavado de activos, financiación del terrorismo y administración de recursos relacionados con actividades terroristas u otros delitos relacionados con el lavado de activos y financiación del terrorismo; (ii) incluido(s) en listas para el control de lavado de activos y financiación del terrorismo administradas por cualquier autoridad nacional o extrajera, tales como la lista de la Oficina de Control de Activos Extranjeros – OFAC emitida por el Departamento del Tesoro de los Estados Unidos de Norte América, la lista de la Organización de las Naciones Unidas y otras listas publicas relacionadas con el tema de lavado de activos y financiación del terrorismo; o (iii) condenado(s) por las autoridades competentes en cualquier tipo de proceso judicial relacionado con la comisión de los anteriores delitos;\n"
						+ "c.	Cuando incumpla(mos) cualquier otra obligación que tuviera(mos) para con terceros;\n"
						+ "d.	Si mis (nuestros) bienes son perseguidos o embargados por terceros en ejercicio de cualquier acción.\n"
						+ "e.	Si a juicio del beneficiario o del tenedor legítimo se presenta variación en una cualquiera de mis (nuestras) situaciones financiera, jurídica, económica o en el esquema de propiedad o administración, con respecto a aquellas sobre las cuales fue aprobado el crédito, de manera tal que ponga en peligro el pago oportuno de las obligaciones consignadas en este instrumento.\n"
						+ "\n"
						+ "UNDÉCIMO. Acepto(amos) expresamente cualquier CESIÓN O ENDOSO que a cualquier título efectúe EL ACREEDOR respecto de este Pagaré, y reconozco(emos) desde ya al endosatario o cesionario dentro de cualquier proceso judicial.\n"
						+ "\n"
						+ "DUODÉCIMO. Acepto(amos) los GASTOS E IMPUESTOS derivados del otorgamiento del presente título valor serán a mi(nuestro) cargo.\n"
						+ "\n"
						+ "DÉCIMO TERCERO. El Pagaré diligenciado presta MÉRITO EJECUTIVO, pudiendo EL ACREEDOR en consecuencia iniciar el ejercicio de sus derechos acudiendo a las acciones que estime contundentes.\n"
						+ "\n"
						+ "DÉCIMO CUARTO. Autorizo(mos) AL ACREEDOR a quien represente sus derechos o al tenedor legítimo de este Pagaré, a realizar consultas, reportes, actualizaciones de información general crediticia en bases de datos disponibles y ante las Centrales de Información De Riesgo Crediticio legalmente establecidas a que haya lugar, así como a efectuar reportes sobre mi(nuestros) datos de contacto y mi(nuestro) comportamiento o hábito crediticio derivados de cualquier relación comercial o financiera.\n"
						+ "")));
		table2.setFontSize(7);
		table2.setMargins(20, 18, 0, 18);
		table2.setTextAlignment(TextAlignment.JUSTIFIED);
		document.add(table2);

		float[] pointColumnWidthsTitleBorrower = { 560F };
		Table tableTitleBorrower = new Table(pointColumnWidthsTitleBorrower);
		tableTitleBorrower.addCell(new Cell().add(new Paragraph("DEUDOR")));
		tableTitleBorrower.setMargins(0, 18, 0, 18);
		tableTitleBorrower.setFontSize(10);
		tableTitleBorrower.setFontColor(WebColors.getRGBColor("#FFFFFF"));
		tableTitleBorrower.setTextAlignment(TextAlignment.CENTER);
		tableTitleBorrower.setBackgroundColor(WebColors.getRGBColor("#323E4F"));
		document.add(tableTitleBorrower);

		float[] pointColumnWidthsBorrower = { 560F };
		Table tableBorrower = new Table(pointColumnWidthsBorrower);
		tableBorrower.addCell(new Cell().add(new Paragraph("Firma:\n" + "____________________________________________\n"
				+ "\n" + "Nombre: " + name + "\n" + "____________________________________________\n" + "\n"
				+ "No. de Documento: " + numberId + "\n" + "____________________________________________\n" + "\n"
				+ "Dirección: " + address + "\n" + "____________________________________________\n"
				+ "                                                                                                  \n"
				+ "Teléfono: " + phone + "\n" + "____________________________________________\n" + "")));
		tableBorrower.setMargins(0, 18, 0, 18);
		tableBorrower.setFontSize(8);
		document.add(tableBorrower);

		float[] pointColumnWidthsTitleBorrower1 = { 560F };
		Table tableTitleBorrower1 = new Table(pointColumnWidthsTitleBorrower1);
		tableTitleBorrower1.addCell(new Cell().add(new Paragraph("FIRMA INTERMEDIARIO FINANCIERO (ENDOSO)")));
		tableTitleBorrower1.setMargins(0, 18, 0, 18);
		tableTitleBorrower1.setFontSize(10);
		tableTitleBorrower1.setFontColor(WebColors.getRGBColor("#FFFFFF"));
		tableTitleBorrower1.setTextAlignment(TextAlignment.CENTER);
		tableTitleBorrower1.setBackgroundColor(WebColors.getRGBColor("#323E4F"));
		document.add(tableTitleBorrower1);

		float[] pointColumnWidthsAward = { 560F };
		Table tableAward = new Table(pointColumnWidthsAward);
		tableAward.addCell(
				new Cell().add(new Paragraph("Firma:\n" + "____________________________________________\n" + "")));
		tableAward.setMargins(0, 18, 0, 18);
		tableAward.setFontSize(8);
		document.add(tableAward);
		document.close();
		System.out.println("PDF Created");

		return outputStream.toByteArray();
	}

}
