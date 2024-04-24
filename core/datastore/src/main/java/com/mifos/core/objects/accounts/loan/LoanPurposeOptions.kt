/*
 * This project is licensed under the open source MPL V2.
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */
package com.mifos.core.objects.accounts.loan

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by nellyk on 2/25/2016.
 */
@Parcelize
data class LoanPurposeOptions (
    var id : Int  = 0,

    var name: String? = null
) : Parcelable