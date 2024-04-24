/*
 * This project is licensed under the open source MPL V2.
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */
package com.mifos.core.objects.db

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MeetingDate(
    var year: Int = 0,

    var month: Int = 0,

    var day: Int = 0
) : Parcelable