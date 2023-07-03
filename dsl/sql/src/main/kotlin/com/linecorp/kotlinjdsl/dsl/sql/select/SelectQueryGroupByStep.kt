package com.linecorp.kotlinjdsl.dsl.sql.select

import com.linecorp.kotlinjdsl.query.sql.Expression
import com.linecorp.kotlinjdsl.query.sql.SelectQuery
import com.linecorp.kotlinjdsl.query.sql.SqlQueryable
import kotlin.reflect.KProperty1

interface SelectQueryGroupByStep : SelectQueryHavingStep, SqlQueryable<SelectQuery> {
    fun groupBy(vararg properties: KProperty1<out Any, *>): SelectQueryHavingStep
    fun groupBy(vararg expressions: Expression<*>): SelectQueryHavingStep
    fun groupBy(expressions: Collection<Expression<*>>): SelectQueryHavingStep
}
