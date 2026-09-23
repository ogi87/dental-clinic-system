package rs.ac.bg.fon.ps.common.communication;

import java.io.Serializable;

public class Response implements Serializable {

    private ResponseType responseType;
    private Object result;
    private Exception exception;

    public Response() {
    }

    public Response(ResponseType responseType, Object result, Exception exception) {
        this.responseType = responseType;
        this.result = result;
        this.exception = exception;
    }

    public ResponseType getResponseType() {
        return responseType;
    }

    public void setResponseType(ResponseType responseType) {
        this.responseType = responseType;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}