package kt

interface I {
    fun fun1(name: String)
    fun fun2(name: String)
}


class A : I {
    override fun fun1(name: String) {
        TODO("Not yet implemented")
    }

    override fun fun2(name: String) {
        println("your name is $name")
    }
}


fun main() {
    val a = A()
    a.fun2("Felix")  // this is OK
    a.fun1("Felix")  // this will trigger kotlin.NotImplementedError
}