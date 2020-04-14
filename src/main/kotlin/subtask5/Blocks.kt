package subtask5

import java.time.LocalDate
import java.time.LocalDate.now
import java.time.LocalDate.parse
import java.time.Period
import java.time.format.DateTimeFormatter
import kotlin.math.abs
import kotlin.reflect.KClass

class Blocks {

    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
        lateinit var blockC: Any
            when (blockB) {
                String::class -> {
                    blockC = ""
                    for (i in blockA.indices) {
                        if (blockA[i] is String) {
                            blockC += blockA[i]
                        }
                    }
                }
                Int::class -> {
                    blockC = 0
                    for (i in blockA.indices) {
                        if (blockA[i] is Int) blockC += blockA[i].toString().toInt()
                    }
                }
                LocalDate::class -> {
                    val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
                    val nowDate: LocalDate = now()
                    var dateNearNow: LocalDate? = null
                    var minDays = 1000
                    for (i in blockA.indices) {
                        if (blockA[i] is LocalDate) {
                            val x = parse(blockA[i].toString())
                            val period = Period.between(nowDate, x)
                            val diff = period.days
                            if (abs(diff) < minDays) {
                                minDays = diff
                                dateNearNow = x
                            }
                        }
                    }
                    blockC = formatter.format(dateNearNow)
                }
            }
        return blockC
    }
}