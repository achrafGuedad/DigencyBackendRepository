package com.digency.web;


import com.digency.dao.PersonneDao;
import com.digency.entities.Personne;
import com.digency.service.PdfGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;



import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonneRestController {



    @Autowired
    private PersonneDao personneDao;

    @Autowired
    private PdfGeneratorService pdfGeneratorService;





    // compress the image bytes before storing it in the database
    public static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
        }
        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

        return outputStream.toByteArray();
    }








    @GetMapping("/pdf/generate/{idPersonne}")
    public void generatePDF(HttpServletResponse response,@PathVariable("idPersonne") int idPersonne) throws IOException {
        Personne personneToFind= personneDao.getById(idPersonne);

        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        this.pdfGeneratorService.export(response,personneToFind);
    }




    @PostMapping(value="/upload" ,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Integer>  uploadImage( @RequestParam(value ="nom") String nom,@RequestParam(value ="nomArabe") String nomArabe,
                                           @RequestParam(value ="prenom") String prenom,@RequestParam(value ="prenomArabe") String prenomArabe,
                                           @RequestParam(value ="dateNaissance") String dateNaissance,@RequestParam(value ="cin") String cin,
                                           @RequestParam(value ="typeCarte") String typeCarte,@RequestParam(value ="profession") String profession,
                                           @RequestParam(value ="imageFile",required = true) MultipartFile imageFile) throws IOException {


                 Personne p=new Personne();
                 p.setNom(nom);
                 p.setNomArabe(nomArabe);
                 p.setPrenom(prenom);
                 p.setPrenomArabe(prenomArabe);
                 p.setDateNaissance(dateNaissance);
                 p.setCin(cin);
                 p.setTypeCarte(typeCarte);
                 p.setProfession(profession);
                 p.setImage(compressBytes(imageFile.getBytes()));



        /*response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
*/
                 personneDao.save(p);
                // generatePDF(p.getNom());
        return  ResponseEntity.ok(p.getIdPersonne());

    }








}
