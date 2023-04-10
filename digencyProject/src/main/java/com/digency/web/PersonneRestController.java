package com.digency.web;


import com.digency.dao.PersonneDao;
import com.digency.entities.Personne;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonneRestController {


    @GetMapping("/my")
    public String sendOTP() {
        return "hello world";
    }


    @Autowired
    private PersonneDao personneDao;




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
    @PostMapping(value="/upload" ,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?>  uploadImage( @RequestParam(value ="data") String data) throws IOException {

        ObjectMapper objectMapper=new ObjectMapper();

        Personne p=objectMapper.readValue(data,Personne.class);

        System.out.println(p.getCin()+p.getNom());





        //Personne personne = new Personne();
        //personne.setImage(compressBytes(file.getBytes()));
         //System.out.println(data.nom)
        //personneDao.save(personne);


       /* (file.getOriginalFilename(), file.getContentType(),
                compressBytes(file.getBytes()));*/

       /* Personne img = new Personne(file.getOriginalFilename(), file.getContentType(),
                compressBytes(file.getBytes()));*/

        /* Personne personne=new Personne();
        byte[] im=compressBytes(p.getImage());
        personne.setImage(im);
        personne.setNom(p.getNom());
        personne.setNomArabe(p.getNomArabe());
        personne.setPrenom(p.getPrenom());
        personne.setPrenomArabe(p.getPrenomArabe());
        personne.setCin(p.getCin());
        personne.setDateNaissance(p.getDateNaissance());
        personneDao.save(personne);*/
        return  ResponseEntity.ok("data has been saved");
    }








}
