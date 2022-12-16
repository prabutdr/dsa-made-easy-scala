package com.prabutdr.ch02.recursion

class TowerOfHanoiWithRecursionSuite extends munit.FunSuite {
    val stacks = List(
      List(),
      List(1),
      List(1, 2, 3),
      List(1, 7, 100, 200, 500, 1000, 9999),
      (1 to 10).toList
    )

    stacks.foreach { stack =>
        test(
          s"It should move stack of numbers from source to destination tower - ${stack
                  .mkString("[", ", ", "]")}"
        ) {
            val fromTower = Tower("A", stack: _*)
            val toTower = Tower("B")
            val auxTower = Tower("C")
            TowerOfHanoi.solveByRecursion(fromTower, toTower, auxTower)

            assertEquals(toTower.toList, stack)
        }
    }

    stacks.foreach { stack =>
        test(
          s"Source tower should be empty after move - ${stack.mkString("[", ", ", "]")}"
        ) {
            val fromTower = Tower("A", stack: _*)
            val toTower = Tower("B")
            val auxTower = Tower("C")
            TowerOfHanoi.solveByRecursion(fromTower, toTower, auxTower)

            assert(fromTower.isEmpty)
        }
    }

    stacks.foreach { stack =>
        test(
          s"Auxiliary tower should be empty after move - ${stack.mkString("[", ", ", "]")}"
        ) {
            val fromTower = Tower("A", stack: _*)
            val toTower = Tower("B")
            val auxTower = Tower("C")
            TowerOfHanoi.solveByRecursion(fromTower, toTower, auxTower)

            assert(auxTower.isEmpty)
        }
    }

    stacks.foreach { stack =>
        test(
          s"Movement count should be minimal - ${stack.mkString("[", ", ", "]")}"
        ) {
            val fromTower = Tower("A", stack: _*)
            val toTower = Tower("B")
            val auxTower = Tower("C")
            val moves = TowerOfHanoi.solveByRecursion(fromTower, toTower, auxTower)
            val expectedMinimalMoves = Math.pow(2, stack.size) - 1

            assertEquals(moves.size, expectedMinimalMoves.toInt)
        }
    }

}
