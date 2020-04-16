package subtask6

class Fibonacci {

    fun productFibonacciSequenceFor(n: Int): IntArray {
        val myList: ArrayList<Int> = arrayListOf()
        val array: IntArray

        val f = IntArray(20)
        f[0] = 0
        f[1] = 1

        var a = 0
        var b = 1
        var c = 0
        var myN: Int = 0
        var myN2: Int = 0

        //first way
        do {
            c = a + b
            myN = a * b
            myN2 = b * c
            if (myN == n) {
                myList.add(a)
                myList.add(b)
                myList.add(1)
                break
            } else if (myN > n) {
                myList.add(a)
                myList.add(b)
                myList.add(0)
                break
            }
            a = b
            b = c
        } while (myN < n || n < myN2)

        //second way
        /*for (i in 2 until f.size) {
            f[i] = f[i - 1] + f[i - 2]
            myN = f[i - 1] * f[i - 2]
            if (myN == n) {
                myList.add(f[i - 2])
                myList.add(f[i - 1])
                myList.add(1)
                break
            } else if (myN > n) {
                myList.add(f[i - 2])
                myList.add(f[i - 1])
                myList.add(0)
                break
            }
        }*/

        array = myList.toIntArray()

        return array

    }
}
