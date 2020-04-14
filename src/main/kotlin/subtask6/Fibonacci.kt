package subtask6

class Fibonacci {

    fun productFibonacciSequenceFor(n: Int): IntArray {
        val myList: ArrayList<Int> = arrayListOf()
        var array: IntArray? = null
        var sum: Int = 0
        val f = IntArray(20)
        f[0] = 0
        f[1] = 1

        for (i in 2 until f.size) {
            f[i] = f[i - 1] + f[i - 2]
            sum = f[i - 1] * f[i - 2]
            if (sum == n) {
                myList.add(f[i - 2])
                myList.add(f[i - 1])
                myList.add(1)
                break
            } else if (sum > n) {
                myList.add(f[i - 2])
                myList.add(f[i - 1])
                myList.add(0)
                break
            }
        }
        array = myList.toIntArray()

        return array

    }
}
