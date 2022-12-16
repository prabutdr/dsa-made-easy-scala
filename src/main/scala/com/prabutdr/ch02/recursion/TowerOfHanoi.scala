package com.prabutdr.ch02.recursion

import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Stack

class Tower(name: String, disks: Int*):
    private var diskStack = Stack[Int]()

    disks.foreach(push(_))

    def push(disk: Int): Unit =
        // println(s"Adding $disk to $diskStack")
        require(diskStack.isEmpty || diskStack.top > disk)

        diskStack.push(disk)

    def pop(): Int =
        require(!diskStack.isEmpty)

        diskStack.pop()

    def size = diskStack.size

    override def toString(): String =
        diskStack.mkString(s"Tower $name(", ", ", ")")

// object Tower:
//     def apply(disks: Int*): Tower =
//         val tower = new Tower()
//         disks.foreach(tower.add(_))
//         tower

def towerOfHanoi(towerA: Tower, towerB: Tower, towerC: Tower): Unit =
    towerOfHanoi(towerA, towerB, towerC, towerA.size)

def towerOfHanoi(
    towerA: Tower,
    towerB: Tower,
    towerC: Tower,
    diskCount: Int
): Unit =
    // if diskCount == 1 then
    //     println(s"Moving from $towerA to $towerB")
    //     towerB.push(towerA.pop())
    // else
    if diskCount > 0 then
        towerOfHanoi(towerA, towerC, towerB, diskCount - 1)
        println(s"Moving from $towerA to $towerB")
        towerB.push(towerA.pop())
        towerOfHanoi(towerC, towerB, towerA, diskCount - 1)

@main def check =
    val towerA = Tower("A", 3, 2, 1)
    val towerB = Tower("B")
    val towerC = Tower("C")
    println(s"$towerA - $towerB - $towerC")
    towerOfHanoi(towerA, towerB, towerC)
    println(s"$towerA - $towerB - $towerC")
