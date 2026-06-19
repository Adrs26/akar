package dev.adrian.akar.component.input

import platform.Foundation.NSLocale
import platform.Foundation.currentLocale
import platform.Foundation.decimalSeparator
import platform.Foundation.groupingSeparator

actual fun getPlatformLocaleSymbols(): AkarLocaleSymbols {
    val locale = NSLocale.currentLocale

    val grouping = locale.groupingSeparator.firstOrNull() ?: ','
    val decimal = locale.decimalSeparator.firstOrNull() ?: '.'

    return AkarLocaleSymbols(
        groupingSeparator = grouping,
        decimalSeparator = decimal
    )
}