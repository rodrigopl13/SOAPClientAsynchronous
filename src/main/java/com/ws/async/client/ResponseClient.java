/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.async.client;

import com.ws.async.AddMovieResponse;
import com.ws.async.Movie;
import com.ws.async.MovieCategories;
import com.ws.async.ObjectFactory;
import com.ws.async.SoapAsyncEJB;
import com.ws.async.SoapAsyncEJBService;
import java.util.GregorianCalendar;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Response;

/**
 *
 * @author rodrigo
 */
public class ResponseClient {
    public static void main(String[] args) {
        SoapAsyncEJBService service = new SoapAsyncEJBService();
        SoapAsyncEJB port = service.getSoapAsyncEJBPort();
        Movie movie = new ObjectFactory().createMovie();
        movie.setName("newMovie");
        movie.setRate((short) 9);
        movie.setCategory(MovieCategories.THRILLER);
        GregorianCalendar today = new GregorianCalendar();
        try {
            XMLGregorianCalendar release = DatatypeFactory.newInstance().newXMLGregorianCalendar(today);
            movie.setReleaseDate(release);
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(ResponseClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        Response<AddMovieResponse> holder = port.addMovieAsync(movie);
        
        for (int i = 0; i < 50; i++) {
            if(i % 5 == 0)
                System.out.println("Haciendo otras cosas "+ i);
        }
        
        try {
            Movie response = holder.get().getReturn();
            System.out.println("Response id = "+response.getId());
            System.out.println("Response release = "+response.getReleaseDate());
        } catch (InterruptedException ex) {
            Logger.getLogger(ResponseClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(ResponseClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
