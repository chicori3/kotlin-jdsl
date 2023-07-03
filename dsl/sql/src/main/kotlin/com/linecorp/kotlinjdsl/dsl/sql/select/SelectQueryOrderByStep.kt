package com.linecorp.kotlinjdsl.dsl.sql.select

import com.linecorp.kotlinjdsl.query.sql.SelectQuery
import com.linecorp.kotlinjdsl.query.sql.Sort
import com.linecorp.kotlinjdsl.query.sql.SqlQueryable

interface SelectQueryOrderByStep : SelectQueryLimitStep, SqlQueryable<SelectQuery> {
    fun orderBy(vararg sorts: Sort): SelectQueryLimitStep
    fun orderBy(sorts: Collection<Sort>): SelectQueryLimitStep
}
