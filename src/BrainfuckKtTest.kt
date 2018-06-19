import org.junit.Test

class BrainfuckKtTest{

    @Test fun testNum() {
        val answer = eval("test")
        assert(answer == "test")
    }
}