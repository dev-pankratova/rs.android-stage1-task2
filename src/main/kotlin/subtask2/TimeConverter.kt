package subtask2

class TimeConverter {
    private lateinit var returnString: String

    fun toTextFormat(hour: String, minute: String): String {
        var hourText: String? = null
        var minuteText: String? = null

        var hourInt: Int = hour.toInt()
        var minuteInt: Int = minute.toInt()
        val minuteIntInput = minuteInt

        if (minuteInt in 31..59) {
            hourInt += 1
            minuteInt = 60 - minuteInt
        }

        when (minuteInt) {
            1 -> minuteText = "one"
            2 -> minuteText = "two"
            3 -> minuteText = "three"
            4 -> minuteText = "four"
            5 -> minuteText = "five"
            6 -> minuteText = "six"
            7 -> minuteText = "seven"
            8 -> minuteText = "eight"
            9 -> minuteText = "nine"
            10 -> minuteText = "ten"
            11 -> minuteText = "eleven"
            12 -> minuteText = "twelve"
            13 -> minuteText = "thirteen"
            14 -> minuteText = "fourteen"
            16 -> minuteText = "sixteen"
            17 -> minuteText = "seventeen"
            18 -> minuteText = "eighteen"
            19 -> minuteText = "nineteen"
            20 -> minuteText = "twenty"
            21 -> minuteText = "twenty one"
            22 -> minuteText = "twenty two"
            23 -> minuteText = "twenty three"
            24 -> minuteText = "twenty four"
            25 -> minuteText = "twenty five"
            26 -> minuteText = "twenty six"
            27 -> minuteText = "twenty seven"
            28 -> minuteText = "twenty eight"
            29 -> minuteText = "twenty nine"
        }

        when (hourInt) {
            1 -> hourText = "one"
            2 -> hourText = "two"
            3 -> hourText = "three"
            4 -> hourText = "four"
            5 -> hourText = "five"
            6 -> hourText = "six"
            7 -> hourText = "seven"
            8 -> hourText = "eight"
            9 -> hourText = "nine"
            10 -> hourText = "ten"
            11 -> hourText = "eleven"
            12 -> hourText = "twelve"
        }

        returnString = when (minuteIntInput) {
            0 -> "$hourText o' clock"
            in 1..29 -> {
                if (minuteIntInput == 15) "quarter past $hourText"
                else
                    "$minuteText minutes past $hourText"
            }
            30 -> "half past $hourText"
            in 31..59 -> {
                if (minuteIntInput == 45) "quarter to $hourText"
                else
                    "$minuteText minutes to $hourText"
            }
            else -> ""
        }

        return (returnString)
    }
}
