package com.prabutdr.ch02.recursion

class IsArraySortedSuite extends munit.FunSuite {
    val sortedArrays = List(
      Array[Int](),
      Array(1),
      Array(1, 2),
      Array(7, 10, 15),
      (1 to 100).toArray
    )

    sortedArrays.foreach { array =>
        test(s"${array.mkString("[", ", ", "]")} is sorted") {
            assert(isSorted(array))
        }
    }

    val unsortedArrays = List(
      Array(2, 1),
      Array(100, 200, 1, 0)
    )

    unsortedArrays.foreach { array =>
        test(s"${array.mkString("[", ", ", "]")} is not sorted") {
            assert(!isSorted(array))
        }
    }

}
