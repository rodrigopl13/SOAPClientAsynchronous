/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.async.handler;

import com.ws.async.GetMovieResponse;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;

/**
 *
 * @author rodrigo
 */
public class AsyncClientHandler implements AsyncHandler<GetMovieResponse>{

    @Override
    public void handleResponse(Response<GetMovieResponse> res) {
        
    }
    
}
