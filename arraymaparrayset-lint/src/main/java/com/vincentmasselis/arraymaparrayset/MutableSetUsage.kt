package com.vincentmasselis.arraymaparrayset

import com.android.tools.lint.detector.api.*
import com.android.tools.lint.detector.api.Category.Companion.CORRECTNESS
import com.android.tools.lint.detector.api.Scope.JAVA_FILE
import com.android.tools.lint.detector.api.Severity.WARNING
import com.intellij.psi.PsiMethod
import org.jetbrains.uast.UCallExpression
import java.util.*

val ISSUE_MUTABLE_SET_CALL = Issue.create(
    "MutableSetUsage",
    "Usage of mutable sets instead of ArraySet",
    "The mutableSetOf method returns an instance of a HashSet which is generally less efficient than ArraySet. Learn more here https://developer.android.com/reference/android/support/v4/util/ArraySet",
    CORRECTNESS, PRIORITY, WARNING,
    Implementation(MutableSetUsage::class.java, EnumSet.of(JAVA_FILE))
)

class MutableSetUsage : Detector(), Detector.UastScanner {

    override fun getApplicableMethodNames() = listOf("mutableSetOf", "toMutableSet")

    override fun visitMethodCall(context: JavaContext, node: UCallExpression, method: PsiMethod) {
        when (node.methodName) {
            "mutableSetOf" -> context
                .report(
                    ISSUE_MUTABLE_SET_CALL,
                    node,
                    context.getNameLocation(node),
                    "Replace by arraySetOf() instead of a mutableSetOf()",
                    LintFix.create().replace().text("mutableSetOf").with("arraySetOf").autoFix().build()
                )
            "toMutableSet" -> context
                .report(
                    ISSUE_MUTABLE_SET_CALL,
                    node,
                    context.getNameLocation(node),
                    "Replace by toArraySet() instead of a toMutableSet()",
                    LintFix.create().replace().text("toMutableSet").with("toArraySet").autoFix().build()
                )

        }
    }
}