package kt

import com.google.common.collect.Maps.newHashMap

/**
 * @author felix <tinylambda@gmail.com>
 * Created on 2021-11-23
 */
class KotlinMapPut {
    private val myMap: MutableMap<String, String> = newHashMap()

    fun put(key: String, value: String) {
        myMap[key] = value
    }

    fun show() {
        println(myMap)
    }
}


fun main() {
    val myClass = KotlinMapPut()
    myClass.put("a", "100")
    myClass.show()
}
