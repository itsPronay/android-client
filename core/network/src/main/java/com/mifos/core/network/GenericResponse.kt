/*
 * This project is licensed under the open source MPL V2.
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */
package com.mifos.core.network

/**
 * Created by ishankhanna on 24/06/14.
 */
class GenericResponse {
    var responseFields = HashMap<String, Any>()
    override fun toString(): String {
        return "GenericResponse{" +
                "responseFields=" + responseFields +
                '}'
    }
}