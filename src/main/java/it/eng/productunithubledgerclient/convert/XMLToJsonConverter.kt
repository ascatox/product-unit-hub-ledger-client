package it.eng.productunithubledgerclient.convert

import com.google.gson.Gson
import org.leibnizcenter.xml.TerseJson
import org.leibnizcenter.xml.helpers.DomHelper

/**
 * @author ascatox
 */


class XMLToJsonConverter {


    companion object {
        private val COMPACT_WHITE_SPACE = TerseJson.WhitespaceBehaviour.Compact

        fun convert(xmlTocConvert: String): String {

            val document = DomHelper.parse(xmlTocConvert)
            val opts = TerseJson.Options
                    .with(COMPACT_WHITE_SPACE)
                    .and(TerseJson.ErrorBehaviour.ThrowAllErrors)

            val terseDoc = TerseJson(opts).convert(document)
            val json = Gson().toJson(terseDoc)

            return json

        }
    }


}