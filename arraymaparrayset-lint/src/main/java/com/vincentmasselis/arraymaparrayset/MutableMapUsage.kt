package com.vincentmasselis.arraymaparrayset

import com.android.tools.lint.detector.api.*
import com.android.tools.lint.detector.api.Category.Companion.CORRECTNESS
import com.android.tools.lint.detector.api.Scope.JAVA_FILE
import com.android.tools.lint.detector.api.Severity.WARNING
import com.intellij.psi.PsiMethod
import org.jetbrains.uast.UCallExpression
import java.util.*

val ISSUE_MUTABLE_MAP_CALL = Issue.create(
    "MutableMapUsage",
    "Usage of mutable maps instead of ArrayMap",
    "The mutableMapOf method returns an instance of a HashMap which is generally less efficient than ArrayMap. Learn more here https://developer.android.com/reference/android/support/v4/util/ArrayMap",
    CORRECTNESS, PRIORITY, WARNING,
    Implementation(MutableMapUsage::class.java, EnumSet.of(JAVA_FILE))
)

class MutableMapUsage : Detector(), Detector.UastScanner {

    override fun getApplicableMethodNames() = listOf("mutableMapOf", "toMutableMap")

    override fun visitMethodCall(context: JavaContext, node: UCallExpression, method: PsiMethod) {
        when (node.methodName) {
            "mutableMapOf" -> context
                .report(
                    ISSUE_MUTABLE_MAP_CALL,
                    node,
                    context.getNameLocation(node),
                    "Update using an arrayMapOf() instead of a mutableMapOf()",
                    LintFix.create().replace().text("mutableMapOf").with("arrayMapOf").autoFix().build()
                )
            "toMutableMap" -> context
                .report(
                    ISSUE_MUTABLE_MAP_CALL,
                    node,
                    context.getNameLocation(node),
                    "Update using an toArrayMap() instead of a mutableMapOf()",
                    LintFix.create().replace().text("toMutableMap").with("toArrayMap").autoFix().build()
                )

        }
    }
}