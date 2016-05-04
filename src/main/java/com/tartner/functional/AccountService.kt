package com.tartner.functional

import java.util.*

interface AccountService<Account, Amount, Balance> {
    fun open(no: String, name: String, openingDate: Either<Throwable, Date>):
        Reader<AccountRepository, Try<Account>>

    fun close(no: String, closeDate: Either<Throwable, Date>)
        : Reader<AccountRepository, Try<Account>>

    fun debit(no: String, amount: Amount)
        : Reader<AccountRepository, Try<Account>>

    fun credit(no: String, amount: Amount)
        : Reader<AccountRepository, Try<Account>>

    fun balance(no: String): Reader<AccountRepository, Try<Balance>>
}

class Either<T, U> {

}

interface AccountRepository {

}

