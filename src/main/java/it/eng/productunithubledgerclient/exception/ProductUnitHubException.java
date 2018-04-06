package it.eng.productunithubledgerclient.exception;

public class ProductUnitHubException extends Exception {

    public ProductUnitHubException() {
        super();
    }

    public ProductUnitHubException(String message) {
        super(message);
    }

    public ProductUnitHubException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductUnitHubException(Throwable cause) {
        super(cause);
    }

    protected ProductUnitHubException(String message, Throwable cause, boolean enableSuppression, boolean
            writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }



}

