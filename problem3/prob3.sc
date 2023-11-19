import scala.annotation.tailrec

/** Find the largest prime factor of a given positive integer
  *
  * @param inp the given integer
  * @param upper the estimated upper boundary of the largest prime factor
  */
def max_prime_factor(inp: Long, upper: Int = 1000000) = {
  @tailrec
  def remove_factor(target: Long, factor: Long): Long =
    if (target % factor != 0) target
    else remove_factor(target / factor, factor)

  assert(remove_factor(56, 2) == 7)

  @tailrec
  def get_max_factor(target: Long,
                  elems: Vector[Long],
                  factors: Vector[Long]): Option[Long] = {
    if (target == 1) {
      return Some(factors.last)
    }
    if (elems.length == 0) {
      println(s"Max primer factor is larger than $upper, please try a larger upper")
      return None
    }
    val header = elems.head
    val filtered = elems.filter(_ % header != 0)
    val nfactors = factors :+ header
    if (target % header == 0) {
      val ntarget = remove_factor(target, header)
      val nelem = filtered.filter(_ <= ntarget)
      println(s"Prime factor found: $header, get max factor of $ntarget")
      get_max_factor(ntarget, nelem, nfactors)
    } else {
      println(s"Non-factor prime: $header, test next prime for $target")
      get_max_factor(target, filtered, nfactors)
    }
  }
  
  get_max_factor(inp, Range.Long(2L, upper, 1).toVector, Vector())
}

// val target = 13195
// val target = 446571
val target = 600851475143L
max_prime_factor(target) match
  case Some(res) => println(s"Max prime factor of $target is: $res")
  case None => println("")
