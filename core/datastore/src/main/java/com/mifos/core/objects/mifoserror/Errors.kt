/*
 * This project is licensed under the open source MPL V2.
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */
package com.mifos.core.objects.mifoserror

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Errors(
    var developerMessage: String = "",

    var defaultUserMessage: String = "",

    var userMessageGlobalisationCode: String = "",

    var parameterName: String? = null,
) : Parcelable