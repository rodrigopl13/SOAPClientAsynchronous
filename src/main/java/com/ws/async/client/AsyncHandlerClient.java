/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.async.client;

import com.ws.async.SoapAsyncEJB;
import com.ws.async.SoapAsyncEJBService;
import com.ws.async.handler.AsyncClientHandler;

/**
 *
 * @author rodrigo
 */
public class AsyncHandlerClient {
    public static void main(String[] args) {
        SoapAsyncEJBService service = new SoapAsyncEJBService();
        SoapAsyncEJB port = service.getSoapAsyncEJBPort();
        AsyncClientHandler handler = new AsyncClientHandler();
        port.getMovieAsync(1, handler);
        
    }
}
