package ee.ut.solmir.mag.act.factory;

import japa.parser.ast.expr.MethodCallExpr;

import java.util.List;

import ee.ut.solmir.mag.act.model.ExprACT;
import ee.ut.solmir.mag.act.model.MethodCallACT;

class MethodCallExprParser extends AbstractASTParser< MethodCallACT,  MethodCallExpr> {
	MethodCallExprParser(ACTFactory actFactory) {
    super(actFactory);
  }

	public MethodCallACT parse(MethodCallExpr node) {
		List<ExprACT> argsACTs = createAllACTInternal(node.getArgs());
    return new MethodCallACT(node, node.getScope() == null ? "this" : node.getScope().toString(), node.getName(), argsACTs);
  }
}