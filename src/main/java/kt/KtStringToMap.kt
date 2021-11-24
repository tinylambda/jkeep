package kt

import com.google.common.collect.Maps.newHashMap
import org.apache.commons.lang3.StringUtils

/**
 * @author felix <tinylambda@gmail.com>
 * Created on 2021-11-24
 */
class KtStringToMap {
}

fun main() {
    val s: String = "p_date=20211122/id_type=OAID/x=/zz";
    val m: MutableMap<String, String> = newHashMap();
    s.split("/").forEach { pair ->
        val kv: List<String> = pair.split("=")
        if (kv.filter { StringUtils.isNotEmpty(it) }.size == 2) {
            m[kv[0]] = kv[1]
        }
    }
    println(m)
}