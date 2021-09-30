package kt

import datetime.DatetimeFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
 * @author felix <tinylambda@gmail.com>
 * Created on 2021-09-30
 */
class KtDateFormat {
}

fun main() {
    val d = LocalDate.now()
    val fmt = DateTimeFormatter.ofPattern("yyyyMMdd")
    println(d.format(fmt))
}