package io.runescript.plugin.ide.inspections

import com.intellij.codeInspection.*
import com.intellij.psi.PsiElementVisitor
import io.runescript.plugin.ide.RsBundle
import io.runescript.plugin.lang.psi.RsDynamicExpression
import io.runescript.plugin.lang.psi.RsStringLiteralExpression
import io.runescript.plugin.lang.psi.RsVisitor
import io.runescript.plugin.lang.psi.type.type

class RuneScriptUnresolvedReferenceInspection : LocalInspectionTool() {

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object : RsVisitor() {
            override fun visitStringLiteralExpression(o: RsStringLiteralExpression) {
                val reference = o.reference ?: return
                val resolved = reference.resolve()
                if (resolved == null) {
                    holder.registerProblem(
                        if (o.stringLiteralContent.node.firstChildNode == null) o else o.stringLiteralContent,
                        RsBundle.message("inspection.error.unresolved.reference", o.stringLiteralContent.text),
                        ProblemHighlightType.LIKE_UNKNOWN_SYMBOL
                    )
                }
            }
            override fun visitDynamicExpression(o: RsDynamicExpression) {
                val reference = o.reference?: return
                val resolved = reference.resolve()
                if (resolved==null) {
                    holder.registerProblem(
                        o.nameLiteral,
                        RsBundle.message("inspection.error.unresolved.reference", o.nameLiteral.text),
                        ProblemHighlightType.LIKE_UNKNOWN_SYMBOL
                    )
                }
            }
        }
    }

}