# Letteriser
A tiny utility that takes a string and decomoposes it to the letters of the Hungarian alphabet.

## Description
The program takes lines of strings from standard inpput and returns a list of strings of the letters of the Hungarian alphabet. So 'sz', 'ny', 'dzs', etc. are treated as 1 unit (as they are according to Hungarian spelling and grammar). Their long forms like 'ccs' and 'ssz' are treated as two two letters. Upper-case letters are converted to lower-case letters.

```
> százalék
["sz", "á", "z", "a", "l", "é", "k"]
> könyv
["k", "ö", "ny", "v"]
> asszony
["a", "sz", "sz", "o", "ny"]
```

Inputs are read until we enter the string `exit`

## Execution
Simply compile and execute the `Main.java` file.
```
javac Main.java
java Main
```
