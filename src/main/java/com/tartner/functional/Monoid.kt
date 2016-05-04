package com.tartner.functional

import java.util.*

interface Monoid<T> {
    fun zero(): T;
    fun operation(t1: T, t2: T): T;
}

class IntegerAdditionMonoid: Monoid<Int> {
    override fun zero() : Int { return 0; }

    override fun operation(t1 : Int, t2 : Int) : Int {
        return t1 + t2;
    }
}

class ListMonoid<A>: Monoid<List<A>> {
    override fun zero() : List<A> {
        return listOf();
    }

    override fun operation(t1 : List<A>, t2 : List<A>) : List<A> {
        val both = ArrayList<A>(t1.size + t2.size)
        both.addAll(t1);
        both.addAll(t2);
        return both;
    }
}
