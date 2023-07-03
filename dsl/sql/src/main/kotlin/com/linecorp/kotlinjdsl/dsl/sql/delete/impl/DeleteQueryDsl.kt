package com.linecorp.kotlinjdsl.dsl.sql.delete.impl

import com.linecorp.kotlinjdsl.dsl.sql.delete.DeleteQueryWhereStep
import com.linecorp.kotlinjdsl.query.sql.DeleteQuery
import com.linecorp.kotlinjdsl.query.sql.Predicate
import com.linecorp.kotlinjdsl.query.sql.SqlQueryable
import com.linecorp.kotlinjdsl.query.sql.TableReference
import com.linecorp.kotlinjdsl.query.sql.impl.And
import com.linecorp.kotlinjdsl.query.sql.impl.Or

class DeleteQueryDsl<T : Any> private constructor(
    private val builder: DeleteQueryBuilder<T>,
) : DeleteQueryWhereStep<T> {
    constructor(table: TableReference<T>) : this(DeleteQueryBuilder(table))

    override fun where(predicate: Predicate): SqlQueryable<DeleteQuery<T>> {
        builder.where(predicate)

        return this
    }

    override fun whereAnd(vararg predicates: Predicate): SqlQueryable<DeleteQuery<T>> {
        builder.where(And(predicates.toList()))

        return this
    }

    override fun whereAnd(predicates: Collection<Predicate>): SqlQueryable<DeleteQuery<T>> {
        builder.where(And(predicates))

        return this
    }

    override fun whereOr(vararg predicates: Predicate): SqlQueryable<DeleteQuery<T>> {
        builder.where(Or(predicates.toList()))

        return this
    }

    override fun whereOr(predicates: Collection<Predicate>): SqlQueryable<DeleteQuery<T>> {
        builder.where(Or(predicates))

        return this
    }

    override fun toQuery(): DeleteQuery<T> {
        return builder.build()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as DeleteQueryDsl<*>

        return builder == other.builder
    }

    override fun hashCode(): Int {
        return builder.hashCode()
    }

    override fun toString(): String {
        return "DeleteQueryDsl(" +
            "builder=$builder)"
    }
}
