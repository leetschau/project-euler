# Environment Setup

## Python

Python scripts use [The light format](https://jupytext.readthedocs.io/en/latest/formats-scripts.html#the-light-format):

Setup Python environment with:

```sh
$ poetry install
$ poetry run ipython
>>> %run myalgo.py  # load script into REPL
>>> help(myfunc)  # show function docstrings
```

## Scala

```sh
$ asdf install scala-cli  // or install with `devbox`
$ scala-cli repl  // evaluate in REPL, Scala version::3.3.1
scala> :load myalgo.sc  // load script into REPL

$ scala-cli probn.sc  // run script
```

## Jalia

Download Julia tarball and extract to ~/.local/opt.
```sh
cd ~/.local/bin
ln -s ~/.local/opt/julia-1.9.3/bin/julia julia
julia
```

Develop script:
```sh
$ julia myalgo.jl  # run script

$ julia
julia> include("myalgo.jl")  # load script into REPL
julia> ?myfunc  # show function docstrings
```

## R

```sh
apt install r-base
R
```

## Haskell

```sh
stack repl
```
