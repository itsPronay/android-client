package com.mifos.core.objects.templates.loans

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Created by Rajan Maurya on 16/07/16.
 */
@Parcelize
data class InterestCalculationPeriodTypeOptions(
    var id: Int? = null,

    var code: String? = null,

    var value: String? = null
) : Parcelable