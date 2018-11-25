/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.async.handler;

import com.ws.async.GetMovieResponse;
import com.ws.async.Movie;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;

/**
 *
 * @author rodrigo
 */
public class AsyncClientHandler implements AsyncHandler<GetMovieResponse>{

    private GetMovieResponse response;
    
    @Override
    public void handleResponse(Response<GetMovieResponse> res) {
        try {
            response = res.get();
            Movie m = response.getReturn();
            System.out.println("Result id from hanlder = "+m.getId());
            System.out.println("Result release date from handler = "+m.getReleaseDate());
        } catch (InterruptedException ex) {
            Logger.getLogger(AsyncClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(AsyncClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
