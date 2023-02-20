package com.bilalkose.weatherapi.exception;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

@Component
public class RestTemplateErrorHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return (response.getStatusCode().is4xxClientError() || response.getStatusCode().is5xxServerError());
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        if(response.getStatusCode().is5xxServerError()){
            //handle serverError
            throw new GeneralException(response.getStatusText());
        }
        else if(response.getStatusCode().is4xxClientError()){
            //handle clientError
            throw new GeneralException(response.getStatusText());
        }
    }
}
