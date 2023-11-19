"""

    remove_factor(target, factor)

Remove specified factor from an integer.

# Examples

```
julia> remove_factor(56, 2)
7

julia> remove_factor(56, 7)
8
```
"""
remove_factor(target, factor) =
    if (target % factor != 0) target
    else remove_factor(Int(target / factor), factor) end


function get_max_factor(target, elems, factors)
    if target == 1 return last(factors) end
    if length(elems) == 0 return -1 end
    header = first(elems)
    filtered = filter(x -> x % header != 0, elems)
    nfactors = vcat(factors, [header])
    if target % header == 0
        ntarget = remove_factor(target, header)
        nelem = filter(x -> x <= target, filtered)
        println("Prime factor found: $header, get max factor of $ntarget")
        get_max_factor(ntarget, nelem, nfactors)
    else
        println("Non-factor prime: $header, test next prime for $target")
        get_max_factor(target, filtered, nfactors)
    end
end


"""

    max_prime_factor(inp, [upper])

Find the largest prime factor of a given positive integer

# Parameters

* inp: the given integer
* upper: the estimated upper boundary of the largest prime factor

# Examples

```
julia> max_prime_factor(13195)
29

julia> max_prime_factor(446571)
59
```
"""
max_prime_factor(inp, upper=Int(1e6)) = get_max_factor(inp, 2:upper, [])

target = 600851475143
println("Max prime factor of $(target) is $(max_prime_factor(target))")
