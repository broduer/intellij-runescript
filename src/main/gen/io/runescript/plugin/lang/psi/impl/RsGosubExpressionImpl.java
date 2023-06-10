// This class is automatically generated. Do not edit.
package io.runescript.plugin.lang.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static io.runescript.plugin.lang.psi.RsElementTypes.*;
import io.runescript.plugin.lang.psi.mixin.RsGosubExpressionMixin;
import io.runescript.plugin.lang.psi.*;

public class RsGosubExpressionImpl extends RsGosubExpressionMixin implements RsGosubExpression {

  public RsGosubExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull RsVisitor visitor) {
    visitor.visitGosubExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RsVisitor) accept((RsVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public RsArgumentList getArgumentList() {
    return PsiTreeUtil.getChildOfType(this, RsArgumentList.class);
  }

  @Override
  @NotNull
  public RsNameLiteral getNameLiteral() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, RsNameLiteral.class));
  }

  @Override
  @NotNull
  public PsiElement getTilde() {
    return notNullChild(findChildByType(TILDE));
  }

}
