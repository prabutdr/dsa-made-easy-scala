package com.prabutdr.ch02.recursion

def isSorted(nums: Array[Int]): Boolean =
    def sorted(idx: Int): Boolean =
        if idx >= nums.length then true
        else nums(idx - 1) <= nums(idx) && sorted(idx + 1)

    sorted(1)
