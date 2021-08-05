package kt


class KtReferClass {
    companion object {
        @JvmStatic
        fun test() {
            JavaSampleClass.doSomething()
            JavaSampleClass.testClass(JavaSampleClass::class.java)
            JavaSampleClass.testClass(JavaSampleClass::class.javaPrimitiveType)
        }
    }
}

fun main() {
    KtReferClass.test()
}
