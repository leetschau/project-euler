# Problem 2: Even Fibonacci Numbers

Each new term in the Fibonacci sequence is generated by adding the previous two terms.
By starting with 1 and 2, the first 10 terms will be:

    1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...

By considering the terms in the Fibonacci sequence whose values do not exceed
four million, find the sum of the even-valued terms.

```python
# iterative:
f1, f2, acc = 1, 2, 2
while f2 < 4e6:
    f3 = f1 + f2
    acc = acc + (f3 if f3 % 2 == 0 else 0)
    f1, f2 = f2, f3

assert acc == 4613732


# generator:
def fib_gen(upper: int):
    f1, f2 = 1, 2
    while f2 < upper:
        yield f2 if f2 % 2 == 0 else 0
        f1, f2 = f2, f1 + f2

assert sum(fib_gen(4e6)) == 4613732
```

```scala
val fibs: LazyList[Int] = 1 #:: 2 #:: fibs.zip(fibs.tail).map(n => n._1 + n._2)
assert(fibs.takeWhile(_ < 4e6).filter(_ % 2 == 0).sum == 4613732)
```

