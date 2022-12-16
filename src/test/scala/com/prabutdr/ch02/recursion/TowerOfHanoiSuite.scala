package com.prabutdr.ch02.recursion

class TowerOfHanoiSuite extends munit.FunSuite {
    val stacks = List(
      List(),
      List(1),
      List(1, 2, 3),
      List(1, 7, 100, 200, 500, 1000, 9999)
    )

    stacks.foreach { stack =>
        test(
          s"It should move stack of numbers from source to destination tower - ${stack
                  .mkString("[", ", ", "]")}"
        ) {
            val fromTower = Tower("A", stack: _*)
            val toTower = Tower("B")
            val auxTower = Tower("C")
            towerOfHanoi(fromTower, toTower, auxTower)

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
            towerOfHanoi(fromTower, toTower, auxTower)

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
            towerOfHanoi(fromTower, toTower, auxTower)

            assert(auxTower.isEmpty)
        }
    }

}
