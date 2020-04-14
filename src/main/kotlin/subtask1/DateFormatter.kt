package subtask1

import java.util.*

class DateFormatter {

    fun toTextDay(day: String, month: String, year: String): String {
        var textDayOfTheWeek: String? = null
        var textMonth: String? = null
        val outString: String?
        val idMonth: Int = month.toInt() - 1

        val isLeapYYear = GregorianCalendar().isLeapYear(year.toInt())
        if (!isLeapYYear && month.toInt() == 2 && day.toInt() == 29) outString =
            "Такого дня не существует"
        else {
            if (month.toInt() > 12) outString = "Такого дня не существует"
            else {
                val myCal: Calendar = GregorianCalendar(
                    year.toInt(),
                    idMonth,
                    day.toInt()
                )// устанавливаем нужную нам дату

                when (myCal.get(Calendar.MONTH)) {
                    0 -> textMonth = "января"
                    1 -> textMonth = "февраля"
                    2 -> textMonth = "марта"
                    3 -> textMonth = "апреля"
                    4 -> textMonth = "мая"
                    5 -> textMonth = "июня"
                    6 -> textMonth = "июля"
                    7 -> textMonth = "августа"
                    8 -> textMonth = "сентября"
                    9 -> textMonth = "октября"
                    10 -> textMonth = "ноября"
                    11 -> textMonth = "декабря"
                }

                when (myCal.get(Calendar.DAY_OF_WEEK)) {
                    2 -> textDayOfTheWeek = "понедельник"
                    3 -> textDayOfTheWeek = "вторник"
                    4 -> textDayOfTheWeek = "среда"
                    5 -> textDayOfTheWeek = "четверг"
                    6 -> textDayOfTheWeek = "пятница"
                    7 -> textDayOfTheWeek = "суббота"
                    1 -> textDayOfTheWeek = "воскресенье"
                }
                outString = "$day $textMonth, $textDayOfTheWeek"
            }
        }
        return (outString)
    }
}

