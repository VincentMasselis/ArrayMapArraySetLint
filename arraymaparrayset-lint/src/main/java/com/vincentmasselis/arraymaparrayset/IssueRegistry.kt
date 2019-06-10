package com.vincentmasselis.arraymaparrayset

import com.android.tools.lint.detector.api.CURRENT_API
import com.android.tools.lint.detector.api.Issue

internal const val PRIORITY = 10 // Does not matter anyways within Lint.

@Suppress("unused")
class IssueRegistry : com.android.tools.lint.client.api.IssueRegistry() {

    override val api = CURRENT_API

    override val issues: List<Issue> = listOf(
        ISSUE_MUTABLE_MAP_CALL,
        ISSUE_MUTABLE_SET_CALL
    )
}
