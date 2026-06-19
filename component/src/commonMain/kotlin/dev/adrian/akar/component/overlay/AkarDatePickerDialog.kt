package dev.adrian.akar.component.overlay

import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import dev.adrian.akar.component.button.AkarTextButton
import dev.adrian.akar.core.theme.AkarTheme
import kotlinx.datetime.TimeZone
import kotlinx.datetime.atStartOfDayIn
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock
import kotlin.time.Instant

@Composable
fun AkarDatePickerDialog(
    dismissLabel: String,
    confirmLabel: String,
    onDismiss: () -> Unit,
    onDateSelected: (Long?) -> Unit,
    initialSelectedDateMillis: Long? = null,
    selectableDates: SelectableDates = AkarDateValidators.allDates()
) {
    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = initialSelectedDateMillis,
        selectableDates = selectableDates
    )

    DatePickerDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            AkarTextButton(
                label = confirmLabel,
                onClick = {
                    onDateSelected(datePickerState.selectedDateMillis)
                    onDismiss()
                }
            )
        },
        dismissButton = {
            AkarTextButton(
                label = dismissLabel,
                onClick = onDismiss,
                contentColor = AkarTheme.colors.onSurface
            )
        }
    ) {
        DatePicker(datePickerState)
    }
}

object AkarDateValidators {
    fun allDates() = DatePickerDefaults.AllDates

    fun maxToday() = object : SelectableDates {
        override fun isSelectableDate(utcTimeMillis: Long): Boolean {
            return utcTimeMillis <= Clock.System.now().toEpochMilliseconds()
        }

        override fun isSelectableYear(year: Int): Boolean {
            val currentYear = Clock.System.now()
                .toLocalDateTime(TimeZone.currentSystemDefault())
                .year
            return year <= currentYear
        }
    }

    fun dateRange(
        minDateMillis: Long? = null,
        maxDateMillis: Long? = null
    ) = object : SelectableDates {
        override fun isSelectableDate(utcTimeMillis: Long): Boolean {
            val isAfterMin = minDateMillis?.let { utcTimeMillis >= it.toStartOfDayUTC() } ?: true
            val isBeforeMax = maxDateMillis?.let { utcTimeMillis <= it.toStartOfDayUTC() } ?: true
            return isAfterMin && isBeforeMax
        }

        override fun isSelectableYear(year: Int): Boolean {
            val minYear = minDateMillis?.toYearUTC() ?: 1900
            val maxYear = maxDateMillis?.toYearUTC() ?: 2100
            return year in minYear..maxYear
        }
    }
}

private fun Long.toYearUTC(): Int {
    return Instant
        .fromEpochMilliseconds(this)
        .toLocalDateTime(TimeZone.UTC)
        .year
}

private fun Long.toStartOfDayUTC(): Long {
    return Instant
        .fromEpochMilliseconds(this)
        .toLocalDateTime(TimeZone.UTC)
        .date
        .atStartOfDayIn(TimeZone.UTC)
        .toEpochMilliseconds()
}