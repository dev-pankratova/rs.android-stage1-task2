package subtask3

class Abbreviation {
    private lateinit var answer: String
    fun abbreviationFromA(a: String, b: String): String {
        val myA = a.toLowerCase()
        val myB = b.toLowerCase()
        val list: MutableList<String> = mutableListOf()
        
        for (i in myA.indices) {
            for (k in myB.indices) {
                if (myA[i] == myB[k]) {
                    list.add(myA[i].toString())
                }
            }
        }

        val qwerty = java.lang.String.join("", list)
        answer = if (b == qwerty.toUpperCase()) "YES"
        else "NO"

        return (answer)
    }
}
