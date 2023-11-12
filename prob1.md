# Problem 1: Multiples of 3 or 5

If we list all the natural numbers below 10 that are multiples of 3 or 5,
we get 3, 5, 6 and 9. The sum of these multiples is 23.

Find the sum of all the multiples of 3 or 5 below 1000.

```python
sol = sum([i for i in range(1000) if (i % 3 == 0) or (i % 5 == 0)])
assert sol == 233168
```

```julia
sol = sum([x for x in 0:(1000 - 1) if (x % 3 == 0) || (x % 5 == 0)])
@assert sol == 233168
```

```r
data <- 1:(1000-1)
sol <- sum(data[data %% 3 == 0 | data %% 5 == 0])
stopifnot(sol == 233168)
```

```scala
val sol = (for (x <- Range(0, 1000) if (x % 3 == 0) || (x % 5 == 0)) yield x).sum
assert(sol == 233168)
```

```haskell
sol = sum [i | i <- [1 .. 1000 - 1], mod i 3 == 0 || mod i 5 == 0]
sol == 233168
```
