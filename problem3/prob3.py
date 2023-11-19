from typing import List

def remove_factor(target: int, factor: int) -> int:
    if target % factor:
        return target
    else:
        return remove_factor(target // factor, factor)


def get_max_factor(target: int, elems: List[int], factors: List[int]) -> int:
    if target == 1:
        return factors[-1]

    if len(elems) == 0:
      return -1

    header = elems[0]
    filtered = list(filter(lambda x: x % header != 0, elems))
    nfactors = factors + [header]
    if target % header == 0:
        ntarget = remove_factor(target, header)
        nelem = list(filter(lambda x: x <= ntarget, filtered))
        print(f"Prime factor found: {header}, get max factor of {ntarget}")
        return get_max_factor(ntarget, nelem, nfactors)
    else:
      print(f"Non-factor prime: {header}, test next prime for {target}")
      return get_max_factor(target, filtered, nfactors)


def max_prime_factor(inp: int, upper: int=int(1e6)) -> int:
    return get_max_factor(inp, list(range(2, upper)), [])


target = 13195
target = 446571
target = 600851475143

max_prime_factor(target)
