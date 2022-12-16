package com.prabutdr.ch02.recursion

import scala.collection.mutable.Stack

class Tower(name: String, disks: Int*):
    private var diskStack = Stack[Int]()

    disks.reverse.foreach(push(_))

    def push(disk: Int): Unit =
        require(diskStack.isEmpty || diskStack.top > disk)

        diskStack.push(disk)

    def pop(): Int =
        require(!diskStack.isEmpty)

        diskStack.pop()

    def size = diskStack.size
    def isEmpty = diskStack.isEmpty
    def toList = diskStack.toList

    override def toString(): String =
        diskStack.mkString(s"Tower $name(", ", ", ")")

def towerOfHanoi(
    fromTower: Tower,
    toTower: Tower,
    auxiliaryTower: Tower
): Unit =
    towerOfHanoi(fromTower, toTower, auxiliaryTower, fromTower.size)

def towerOfHanoi(
    fromTower: Tower,
    toTower: Tower,
    auxiliaryTower: Tower,
    diskCount: Int
): Unit =
    if diskCount > 0 then
        towerOfHanoi(fromTower, auxiliaryTower, toTower, diskCount - 1)
        // println(s"Moving from $fromTower to $toTower")
        toTower.push(fromTower.pop())
        towerOfHanoi(auxiliaryTower, toTower, fromTower, diskCount - 1)

@main def check =
    val towerA = Tower("A", 1, 2, 3)
    val towerB = Tower("B", 4)
    val towerC = Tower("C")
    println(s"$towerA - $towerB - $towerC")
    towerOfHanoi(towerA, towerB, towerC)
    println(s"$towerA - $towerB - $towerC")
