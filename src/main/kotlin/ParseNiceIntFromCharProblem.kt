import kotlin.math.abs
import kotlin.math.round

    fun main() {
       var time = race(850, 750, 70)
        time.forEach { println(it) }
    }

    fun race(speedA: Int, speedB: Int, headStart: Int): IntArray {
        var array = IntArray(3) { -1 }
        if (speedA > speedB) return array

        val seconds = 60 * 60
        val speedASecond = speedA.toFloat() / seconds
        val speedBSecond = speedB.toFloat() / seconds
        val delta = abs(speedASecond - speedBSecond)
        var allSeconds = round(headStart / delta)

        if (allSeconds >= seconds) {
            array[0] = (allSeconds / seconds).toInt()
            allSeconds -= array[0] * seconds
        } else
            array[0] = 0

        if (allSeconds >= 60) {
            array[1] = (allSeconds / 60).toInt()
            allSeconds -= array[1] * 60
        } else
            array[0] = 0

        array[2] = round(allSeconds).toInt()
        return array
    }


