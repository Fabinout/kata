class QuatreLDeJacky {
    private val patterns = listOf(PalindromePattern(), ConsecutivePattern(1), ConsecutivePattern(-1), UnSeulChiffreNonZeroPattern())

    fun isInstagrammable(kilometrage: String): Boolean {
        return patterns
                .any { pattern -> pattern.match(kilometrage) }
    }
}

interface Pattern<in Any> {
    fun match(subject: Any): Boolean
}

class PalindromePattern : Pattern<String> {
    override fun match(kilometrage: String): Boolean {
        return kilometrage == kilometrage.reversed()
    }
}

class UnSeulChiffreNonZeroPattern : Pattern<String> {
    override fun match(kilometrage: String): Boolean {
        return kilometrage.filter { c -> c != '0' }.length == 1
    }
}

class ConsecutivePattern(private val pas: Int) : Pattern<String> {

    override fun match(kilometrage: String): Boolean {
        kilometrage.reduce { chiffrePrecedent, chiffre ->
            if (chiffre - chiffrePrecedent == pas) {
                chiffre
            } else return false
        }
        return true
    }
}
