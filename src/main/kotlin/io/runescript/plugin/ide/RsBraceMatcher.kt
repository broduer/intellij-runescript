package io.runescript.plugin.ide

import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType
import io.runescript.plugin.lang.psi.RsElementTypes

class RsBraceMatcher : PairedBraceMatcher {


    override fun getPairs(): Array<BracePair> {
        return PAIRS
    }

    override fun isPairedBracesAllowedBeforeType(lbraceType: IElementType, contextType: IElementType?): Boolean {
        return true
    }

    override fun getCodeConstructStart(file: PsiFile?, openingBraceOffset: Int): Int {
        return openingBraceOffset
    }

    companion object {
        private val PAIRS = arrayOf(
            BracePair(RsElementTypes.LBRACE, RsElementTypes.RBRACE, true),
            BracePair(RsElementTypes.LPAREN, RsElementTypes.RPAREN, false),
            BracePair(RsElementTypes.LBRACKET, RsElementTypes.RBRACKET, false)
        )
    }
}