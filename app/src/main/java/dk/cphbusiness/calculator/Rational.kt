package dk.cphbusiness.calculator

data class Rational(val n: Int, val d: Int) {

    val gcd: Int by lazy {
        gcd(n, d)
        }

    private fun gcd(a: Int, b: Int): Int =
        if (b == 0) a
        else gcd(b, a%b)

    operator fun times(other: Rational) = Rational(n*other.n, d*other.d)

    operator fun times(other: Int) = copy(n = n*other)

    operator fun div(other: Rational): Rational {
        return Rational(
                this.n *other.d,
                this.d *other.n
                )
        }

    operator fun plus(other: Rational) =
            Rational(other.d*n + d*other.n, d*other.d)

    operator fun minus(other: Rational) =
            Rational(other.d*n - d*other.n, d*other.d)

    override fun toString() = "${n/gcd}/${d/gcd}" // 66/21 gcd = 3 - 22/7

    }

operator fun Int.times(other: Rational) = other.copy(n = this*other.n)

fun main(args: Array<String>) {
    val a = Rational(22, 7)
    val b = Rational(76,3)
    val c = a + b
    val d = a*7
    val e = 4*a
    println(c)
    }