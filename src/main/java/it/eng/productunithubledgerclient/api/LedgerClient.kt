package it.eng.productunithubledgerclient.api

/**
 * @author ascatox
 */


interface LedgerClient {

    fun retrieveOperationResult()
    fun storeProcessStepResult()
    fun storeOperationResult()


}