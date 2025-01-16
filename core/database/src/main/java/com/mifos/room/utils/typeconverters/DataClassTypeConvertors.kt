package com.mifos.room.utils.typeconverters

import androidx.room.TypeConverter
import com.mifos.core.entity.accounts.loan.ActualDisbursementDate_Table.date
import com.mifos.core.entity.accounts.loan.Summary
import com.mifos.core.entity.accounts.loan.Timeline
import com.mifos.core.entity.accounts.savings.SavingsAccountWithAssociations
import com.mifos.core.entity.client.Currency
import com.mifos.core.objects.account.loan.AmortizationType
import com.mifos.core.objects.account.loan.InterestCalculationPeriodType
import com.mifos.core.objects.account.loan.InterestRateFrequencyType
import com.mifos.core.objects.account.loan.InterestType
import com.mifos.core.objects.account.loan.RepaymentFrequencyType
import com.mifos.core.objects.account.loan.RepaymentSchedule
import com.mifos.core.objects.account.loan.TermPeriodFrequencyType
import com.mifos.core.objects.account.saving.ChargeCalculationType
import com.mifos.core.objects.account.saving.ChargeTimeType
import com.mifos.core.objects.account.saving.InterestCalculationDaysInYearType
import com.mifos.core.objects.account.saving.InterestCalculationType
import com.mifos.core.objects.account.saving.InterestCompoundingPeriodType
import com.mifos.core.objects.account.saving.InterestPostingPeriodType
import com.mifos.core.objects.account.saving.LockinPeriodFrequencyType
import com.mifos.room.entities.accounts.loans.ActualDisbursementDate
import com.mifos.room.entities.accounts.loans.LoanType
import com.mifos.room.entities.accounts.savings.DepositType
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

/**
 * Created by Pronay Sarker on 15/01/2025 (8:15 PM)
 */
class DataClassTypeConvertors {

    @TypeConverter
    fun currencyToJson(currency: Currency?): String? {
        return currency?.let { Json.encodeToString(it) }
    }

    @TypeConverter
    fun jsonToCurrency(json: String?): Currency? {
        return json?.let { Json.decodeFromString(it) }
    }

    @TypeConverter
    fun fromTermPeriodFrequencyType(type: TermPeriodFrequencyType?): String? {
        return type?.let { Json.encodeToString(type) }
    }

    @TypeConverter
    fun toTermPeriodFrequencyType(json: String?): TermPeriodFrequencyType? {
        return json?.let { Json.decodeFromString(json) }
    }

    @TypeConverter
    fun fromRepaymentFrequencyType(type: RepaymentFrequencyType?): String? {
        return type?.let { Json.encodeToString(type) }
    }

    @TypeConverter
    fun toRepaymentFrequencyType(json: String?): RepaymentFrequencyType? {
        return json?.let { Json.decodeFromString(json) }
    }

    @TypeConverter
    fun fromInterestRateFrequencyType(type: InterestRateFrequencyType?): String? {
        return type?.let { Json.encodeToString(type) }
    }

    @TypeConverter
    fun toInterestRateFrequencyType(json: String?): InterestRateFrequencyType? {
        return json?.let { Json.decodeFromString(json) }
    }

    @TypeConverter
    fun fromAmortizationType(type: AmortizationType?): String? {
        return type?.let { Json.encodeToString(type) }
    }

    @TypeConverter
    fun toAmortizationType(json: String?): AmortizationType? {
        return json?.let { Json.decodeFromString(json) }
    }

    @TypeConverter
    fun fromInterestType(type: InterestType?): String? {
        return type?.let { Json.encodeToString(type) }
    }

    @TypeConverter
    fun toInterestType(json: String?): InterestType? {
        return json?.let { Json.decodeFromString(json) }
    }

    @TypeConverter
    fun fromInterestCalculationPeriodType(type: InterestCalculationPeriodType?): String? {
        return type?.let { Json.encodeToString(type) }
    }

    @TypeConverter
    fun toInterestCalculationPeriodType(json: String?): InterestCalculationPeriodType? {
        return json?.let { Json.decodeFromString(json) }
    }

    @TypeConverter
    fun fromTimeline(timeline: Timeline?): String? {
        return timeline?.let { Json.encodeToString(timeline) }
    }

    @TypeConverter
    fun toTimeline(json: String?): Timeline? {
        return json?.let { Json.decodeFromString(json) }
    }

    @TypeConverter
    fun fromSummary(summary: Summary?): String? {
        return summary?.let { Json.encodeToString(summary) }
    }

    @TypeConverter
    fun toSummary(json: String?): Summary? {
        return json?.let { Json.decodeFromString(json) }
    }

    @TypeConverter
    fun fromLoanType(type: LoanType?): String? {
        return type?.let { Json.encodeToString(type) }
    }

    @TypeConverter
    fun toLoanType(json: String?): LoanType? {
        return json?.let { Json.decodeFromString(json) }
    }

    @TypeConverter
    fun fromRepaymentSchedule(type: RepaymentSchedule?): String? {
        return type?.let { Json.encodeToString(type) }
    }

    @TypeConverter
    fun toRepaymentSchedule(json: String?): RepaymentSchedule? {
        return json?.let { Json.decodeFromString(json) }
    }

    @TypeConverter
    fun fromActualDisbursementDate(date: ActualDisbursementDate?): String? {
        return date?.let { Json.encodeToString(date) }
    }

    @TypeConverter
    fun toActualDisbursementDate(json: String?): ActualDisbursementDate? {
        return json?.let { Json.decodeFromString(json) }
    }

    @TypeConverter
    fun fromChargeTimeType(type: ChargeTimeType?): String? {
        return type?.let { Json.encodeToString(type) }
    }

    @TypeConverter
    fun toChargeTimeType(json: String?): ChargeTimeType? {
        return json?.let { Json.decodeFromString(json) }
    }

    @TypeConverter
    fun fromChargeCalculationType(type: ChargeCalculationType?): String? {
        return type?.let { Json.encodeToString(type) }
    }

    @TypeConverter
    fun toChargeCalculationType(json: String?): ChargeCalculationType? {
        return json?.let { Json.decodeFromString(json) }
    }

    @TypeConverter
    fun fromDepositType(type: DepositType?): String? {
        return type?.let { Json.encodeToString(type) }
    }

    @TypeConverter
    fun toDepositType(json: String?): DepositType? {
        return json?.let { Json.decodeFromString(json) }
    }

    @TypeConverter
    fun fromInterestCompoundingPeriodType(type: InterestCompoundingPeriodType?): String? {
        return type?.let { Json.encodeToString(type) }
    }

    @TypeConverter
    fun toInterestCompoundingPeriodType(json: String?): InterestCompoundingPeriodType? {
        return json?.let { Json.decodeFromString(json) }
    }

    @TypeConverter
    fun fromInterestPostingPeriodType(type: InterestPostingPeriodType?): String? {
        return type?.let { Json.encodeToString(type) }
    }

    @TypeConverter
    fun toInterestPostingPeriodType(json: String?): InterestPostingPeriodType? {
        return json?.let { Json.decodeFromString(json) }
    }

    @TypeConverter
    fun fromInterestCalculationType(type: InterestCalculationType?): String? {
        return type?.let { Json.encodeToString(type) }
    }

    @TypeConverter
    fun toInterestCalculationType(json: String?): InterestCalculationType? {
        return json?.let { Json.decodeFromString(json) }
    }

    @TypeConverter
    fun fromInterestCalculationDaysInYearType(type: InterestCalculationDaysInYearType?): String? {
        return type?.let { Json.encodeToString(type) }
    }

    @TypeConverter
    fun toInterestCalculationDaysInYearType(json: String?): InterestCalculationDaysInYearType? {
        return json?.let { Json.decodeFromString(json) }
    }

    @TypeConverter
    fun fromLockinPeriodFrequencyType(type: LockinPeriodFrequencyType?): String? {
        return type?.let { Json.encodeToString(type) }
    }

    @TypeConverter
    fun toLockinPeriodFrequencyType(json: String?): LockinPeriodFrequencyType? {
        return json?.let { Json.decodeFromString(json) }
    }

    @TypeConverter
    fun fromSavingsAccountWithAssociations(account : SavingsAccountWithAssociations?) : String? {
        return account?.let { Json.encodeToString(account) }
    }

    @TypeConverter
    fun toSavingsAccountWithAssociations(json : String?) : SavingsAccountWithAssociations? {
        return json?.let { Json.decodeFromString(json) }
    }

}