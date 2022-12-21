package com.prabutdr.ch02.recursion

import scala.collection.mutable.ArrayBuffer

def allBinaries(n: Int): List[String] =
    val result = ArrayBuffer[String]()
    val digits = Array.ofDim[Byte](n)

    def binary(pos: Int): Unit =
        if pos >= n then result.append(digits.mkString)
        else
            digits(pos) = 0
            binary(pos + 1)
            digits(pos) = 1
            binary(pos + 1)

    if n > 0 then binary(pos = 0)
    result.toList

@main def checkAllBinaries =
    println(allBinaries(2))
