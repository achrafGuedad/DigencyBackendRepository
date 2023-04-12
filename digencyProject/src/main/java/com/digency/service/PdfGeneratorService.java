package com.digency.service;


import com.digency.entities.Personne;
import com.lowagie.text.*;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;
import sun.font.FontFamily;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Service
public class PdfGeneratorService {


    public void export(HttpServletResponse response,Personne personne) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(18);

        Paragraph paragraph1 = new Paragraph("CarteProfessionelle", fontTitle);
        paragraph1.setAlignment(Paragraph.ALIGN_CENTER);


        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontParagraph.setSize(12);


        Paragraph paragraph3 = new Paragraph("Prénom : "+personne.getPrenom(), fontParagraph);
        paragraph3.setAlignment(Paragraph.ALIGN_LEFT);


        Paragraph paragraph4 = new Paragraph("Nom : ", fontParagraph);
        paragraph4.setAlignment(Paragraph.ALIGN_LEFT);


        Paragraph paragraph5 = new Paragraph("cin : ", fontParagraph);
        paragraph5.setAlignment(Paragraph.ALIGN_LEFT);


        Paragraph paragraph6 = new Paragraph("Profession : ", fontParagraph);
        paragraph6.setAlignment(Paragraph.ALIGN_LEFT);


        Paragraph paragraph7 = new Paragraph("Type de carte : ", fontParagraph);
        paragraph7.setAlignment(Paragraph.ALIGN_LEFT);


        Paragraph paragraph8 = new Paragraph("Date de Naissance : ", fontParagraph);
        paragraph8.setAlignment(Paragraph.ALIGN_LEFT);

        Paragraph paragraph9 = new Paragraph("Image : ", fontParagraph);
        paragraph9.setAlignment(Paragraph.ALIGN_RIGHT);

        /*BaseFont bf=BaseFont.createFont("src/main/resources/Amiri-regular.ttf",BaseFont.IDENTITY_H,BaseFont.EMBEDDED);
        Font font=new Font(bf,12,Font.NORMAL);
        Paragraph arabicText = new Paragraph("مرحبا بالعالم");
        arabicText.setFont(FontFactory.getFont("Arial Unicode MS", BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
*/

        document.add(paragraph1);
        document.add(paragraph3);
        document.add(paragraph4);
        document.add(paragraph5);
        document.add(paragraph6);
        document.add(paragraph7);
        document.add(paragraph8);
        document.add(paragraph9);
        document.close();

    }


}
