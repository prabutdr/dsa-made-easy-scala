package com.prabutdr.ch02.recursion

class PossibleBinariesSuite extends munit.FunSuite {
    val dataSet = List(
      (0, List()),
      (1, List("0", "1")),
      (2, List("00", "01", "10", "11")),
      (3, List("000", "001", "010", "011", "100", "101", "110", "111"))
    )

    dataSet.foreach { data =>
        test(s"Possible binary combination for size ${data._1} is ${data._2}") {
            assertEquals(allBinaries(data._1), data._2);
        }
    }

    val dataSetToCheckResultSize = List(1, 2, 3, 5, 10)
    dataSetToCheckResultSize.foreach { n =>
        test(s"Number of possible binaries for size $n should be 2^$n") {
            assertEquals(allBinaries(n).size, math.pow(2, n).toInt)
        }
    }
}
