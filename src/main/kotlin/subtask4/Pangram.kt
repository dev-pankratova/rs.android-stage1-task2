package subtask4

class Pangram {

    private lateinit var subStr: ArrayList<String>
    private var countLetterArray: MutableList<Int> = mutableListOf()
    lateinit var sub: CharArray
    private var alphabets: MutableList<Char> = arrayListOf(
        'a',
        'b',
        'c',
        'd',
        'e',
        'f',
        'g',
        'h',
        'i',
        'j',
        'k',
        'l',
        'm',
        'n',
        'o',
        'p',
        'q',
        'r',
        's',
        't',
        'u',
        'v',
        'w',
        'x',
        'y',
        'z'
    )
    private val vowelsList: List<Char> = listOf('a', 'e', 'i', 'o', 'u', 'y')
    private val vowelsCapList: List<Char> = listOf('A', 'E', 'I', 'O', 'U', 'Y')
    private val consonantsList: List<Char> = listOf(
        'b',
        'c',
        'd',
        'f',
        'g',
        'h',
        'j',
        'k',
        'l',
        'm',
        'n',
        'p',
        'q',
        'r',
        's',
        't',
        'v',
        'w',
        'x',
        'z'
    )
    private val consonantsCapList: List<Char> = listOf(
        'B',
        'C',
        'D',
        'F',
        'G',
        'H',
        'J',
        'K',
        'L',
        'M',
        'N',
        'P',
        'Q',
        'R',
        'S',
        'T',
        'V',
        'W',
        'X',
        'Z'
    )
    private var xLowList: List<Char> = listOf()
    private var xCapList: List<Char> = listOf()
    fun getResult(inputString: String): String {
        var resultString = " "
        var countLetter: Int?
        var tmp: String
        var tmpCount: Int
        val strChar = inputString.trim().toLowerCase().toCharArray()
        //pangram check
        var jj = 0
        var unic = 0
        for (i in strChar.indices) {
            val inp = strChar[i]
            if (alphabets.contains(inp)) {
                alphabets.remove(inp)
                jj += 1
            } else if (strChar.contains('\uF8FF')) {
                unic = 1
            }
        }
        //checking for latin letters in inputString
        if ((jj >= 1) || unic == 1) {
            if (alphabets.isEmpty()) {
                //inputString is pangram
                xLowList = vowelsList
                xCapList = vowelsCapList
            } else {
                //inputString is not pangram
                xLowList = consonantsList
                xCapList = consonantsCapList
            }
            subStr = inputString.trim().replace("\n", "")
                .split(" ") as ArrayList<String> // line separation by removing spaces

            var subStrLength = subStr.size - 1
            //delete empty elements in the array
            for (i in 0..subStrLength) {
                if (i > subStrLength) break
                while (subStr[i] == "") {
                    if (subStr[i] == "") {
                        subStr.removeAt(i)
                        subStrLength -= 1
                    }
                }
            }
            //adding a number before the word
            for (i in 0 until subStr.size) {
                sub = subStr[i].toCharArray()
                val ll = sub.indices
                countLetter = 0
                for (k in ll) {
                    for (q in xLowList.indices) {
                        if (sub[k].isLowerCase() && sub[k] == xLowList[q]) {
                            subStr[i] = subStr[i].replace(sub[k], sub[k].toUpperCase())
                            countLetter += 1
                        } else if (sub[k].isUpperCase() && sub[k] == xCapList[q]) {
                            countLetter += 1
                        }
                    }
                }
                subStr[i] = countLetter.toString() + subStr[i]
                countLetterArray.add(countLetter)
            }

            //sorting
            var isSorted = true
            while (isSorted) {
                isSorted = false
                for (j in 0 until countLetterArray.size - 1) {
                    if (countLetterArray[j] > countLetterArray[j + 1]) {
                        tmpCount = countLetterArray[j]
                        countLetterArray[j] = countLetterArray[j + 1]
                        countLetterArray[j + 1] = tmpCount

                        tmp = subStr[j]
                        subStr[j] = subStr[j + 1]
                        subStr[j + 1] = tmp
                        isSorted = true
                    }
                }
            }
            resultString = subStr.joinToString(separator = " ")
        }
        //if lack of latin letters
        else resultString = ""

        return (resultString)
    }
}
