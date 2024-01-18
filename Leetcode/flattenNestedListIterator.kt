import java.util.*

// https://leetcode.com/problems/flatten-nested-list-iterator/


// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
class NestedInteger {
    // Constructor initializes an empty nested list.
    constructor()

//    // Constructor initializes a single integer.
//    constructor(value: Int)
//
//    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    fun isInteger(): Boolean {
        return true
    }
//
//
//    // @return the single integer that this NestedInteger holds, if it holds a single integer
//    // Return null if this NestedInteger holds a nested list
    fun getInteger(): Int?{
        return 1
    }

//
//    // Set this NestedInteger to hold a single integer.
//    fun setInteger(value: Int): Unit
//
//    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
//    fun add(ni: NestedInteger): Unit
//
//    // @return the nested list that this NestedInteger holds, if it holds a nested list
//    // Return null if this NestedInteger holds a single integer
    fun getList(): List<NestedInteger> {
        return listOf<NestedInteger>()
    }
}


class NestedIterator(nestedList: List<NestedInteger>) {
    val nt = Stack<NestedInteger>()
    init {
        for (i in nestedList.reversed()){
            if( i.isInteger() || !i.getList().isEmpty())
                nt.push(i)
        }

    }

    fun next(): Int {
        while (!nt.isEmpty() && !nt.peek().isInteger()){
            val c = nt.pop()
            for (i in c.getList().reversed())
                if( i.isInteger() || !i.getList().isEmpty())
                    nt.push(i)
        }
        return nt.pop().getInteger()!!
    }

    fun hasNext(): Boolean {
        while (!nt.isEmpty()) {
            if (nt.peek().isInteger())
                return true
            val c = nt.pop()
            for (i in c.getList().reversed())
                if (i.isInteger() || !i.getList().isEmpty())
                    nt.push(i)
        }
        return false
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * var obj = NestedIterator(nestedList)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */