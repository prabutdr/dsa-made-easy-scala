package com.prabutdr.ch02.recursion

import scala.collection.mutable.Stack
import scala.collection.mutable.ArrayBuffer

class Tower(val name: String, disks: Int*):
    private var diskStack = Stack[Int]()

    disks.reverse.foreach(push(_))

    def push(disk: Int): Unit =
        require(diskStack.isEmpty || top > disk)

        diskStack.push(disk)

    def pop(): Int =
        require(!diskStack.isEmpty)

        diskStack.pop()

    def size = diskStack.size
    def isEmpty = diskStack.isEmpty
    def toList = diskStack.toList
    def top = diskStack.top

    override def toString(): String =
        diskStack.mkString(s"Tower $name(", ", ", ")")

object TowerOfHanoi:
    def solveByRecursion(
        fromTower: Tower,
        toTower: Tower,
        auxiliaryTower: Tower
    ): List[String] =
        val moves = ArrayBuffer[String]()
        solveByRecursion(fromTower, toTower, auxiliaryTower, fromTower.size, moves)
        moves.toList

    private def solveByRecursion(
        fromTower: Tower,
        toTower: Tower,
        auxiliaryTower: Tower,
        diskCount: Int,
        moves: ArrayBuffer[String]
    ): Unit =
        if diskCount > 0 then
            solveByRecursion(fromTower, auxiliaryTower, toTower, diskCount - 1, moves)
            val disk = fromTower.pop()
            moves += s"Move disk $disk from ${fromTower.name} to ${toTower.name}"
            toTower.push(disk)
            solveByRecursion(auxiliaryTower, toTower, fromTower, diskCount - 1, moves)

    def solveByIteration(
        fromTower: Tower,
        toTower: Tower,
        auxiliaryTower: Tower
    ): Unit =
        val (targetTower, auxTower) =
            if fromTower.size % 2 == 0 then (auxiliaryTower, toTower)
            else (toTower, auxiliaryTower)

        val moveCount = (Math.pow(2, fromTower.size) - 1).toInt
        for move <- 1 to moveCount do
            if move % 3 == 1 then performValidMove(fromTower, targetTower)
            else if move % 3 == 2 then performValidMove(fromTower, auxTower)
            else performValidMove(targetTower, auxTower)

    private def performValidMove(tower1: Tower, tower2: Tower): Unit =
        if tower1.isEmpty then tower1.push(tower2.pop())
        else if tower2.isEmpty then tower2.push(tower1.pop())
        else if tower1.top < tower2.top then tower2.push(tower1.pop())
        else tower1.push(tower2.pop())

@main def check =
    val towerA = Tower("A", 1, 2, 3)
    val towerB = Tower("B", 4)
    val towerC = Tower("C")
    println(s"$towerA - $towerB - $towerC")
    // val moves = TowerOfHanoi.solveByRecursion(towerA, towerB, towerC)
    // println(s"$towerA - $towerB - $towerC")
    // moves.foreach(println)

    TowerOfHanoi.solveByIteration(towerA, towerB, towerC)
    println(s"$towerA - $towerB - $towerC")
