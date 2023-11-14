# Largest Prime Factor

The prime factors of $13195$ are $5, 7, 13$ and $29$.
What is the largest prime factor of the number $600851475143$?

```scala
import scala.annotation.tailrec

def max_prime_factor(inp: Long): Long = {
  @tailrec
  def get_max_factor(target: Long,
                  elems: List[Long],
                  factors: List[Long]): Long =
    if (elems.length == 0) {
      factors.last
    } else {
      val header = elems.head
      val nfactors = if (target % header == 0) factors :+ header else factors
      val filtered = elems.filter(_ % header != 0)
      get_max_factor(target, filtered, nfactors)
    }
  
  get_max_factor(inp, Range.Long(2L, inp, 1).toList, List())
}
```
