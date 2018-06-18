fun eval(expr: Expr): Int =
        when (expr) {
            is Num -> 0
            is Sum -> 0
            else -> throw IllegalArgumentException("Unknown expression")
        }

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr
