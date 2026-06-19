package dev.adrian.akar.component.input

import java.text.DecimalFormatSymbols
import java.util.Locale

actual fun getPlatformLocaleSymbols(): AkarLocaleSymbols {
    val symbols = DecimalFormatSymbols.getInstance(Locale.getDefault())

    return AkarLocaleSymbols(
        groupingSeparator = symbols.groupingSeparator,
        decimalSeparator = symbols.decimalSeparator
    )
}