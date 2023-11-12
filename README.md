# Environment Setup

## Python

Python scripts use [The light format](https://jupytext.readthedocs.io/en/latest/formats-scripts.html#the-light-format):

Setup Python environment with:

```sh
poetry install
poetry run ipython
```

## Jalia

Download Julia tarball and extract to ~/.local/opt.
```sh
cd ~/.local/bin
ln -s ~/.local/opt/julia-1.9.3/bin/julia julia
julia  # v1.9.3
```

## R

```sh
devbox global add R
R  # v4.3.1
```

## Scala

```sh
devbox global add scala-cli  // or install with `asdf`
scala-cli repl  // Scala version::3.3.1
```

## Haskell

```sh
stack repl  -- Stack version: lts-18.3
```
