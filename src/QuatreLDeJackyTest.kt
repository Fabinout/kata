import org.junit.Test

class QuatreLDeJackyTest {

   val la4LDeJacky =  QuatreLDeJacky()

    @Test
    fun test_999999kilometre() {
        val isInstagrammable = la4LDeJacky.isInstagrammable("999999")
        assert(isInstagrammable)
    }

    @Test
    fun test_3874kilometres() {
        val isInstagrammable = la4LDeJacky.isInstagrammable("003874")
        assert(! isInstagrammable)
    }

    @Test
    fun test_888888kilometres() {
        val isInstagrammable = la4LDeJacky.isInstagrammable("888888")
        assert( isInstagrammable)
    }


    @Test
    fun test_chiffresCroissantskilometres() {
        val isInstagrammable = la4LDeJacky.isInstagrammable("123456")
        assert( isInstagrammable)
    }

    @Test
    fun test_chiffresCroissantsNonConsecutif() {
        val isInstagrammable = la4LDeJacky.isInstagrammable("123567")
        assert(! isInstagrammable)
    }

    @Test
    fun test_chiffresDecroissantsConsecutifs() {
        val isInstagrammable = la4LDeJacky.isInstagrammable("987654")
        assert( isInstagrammable)
    }

    @Test
    fun test_palindrome() {
        val isInstagrammable = la4LDeJacky.isInstagrammable("157751")
        assert( isInstagrammable)
    }

    @Test
    fun test_unSeulChiffreNonZero() {
        val isInstagrammable = la4LDeJacky.isInstagrammable("000700")
        assert( isInstagrammable)
    }

}

