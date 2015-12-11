package ee.ut.solmir.mag.act.factory;

import japa.parser.ast.expr.VariableDeclarationExpr;
import ee.ut.solmir.mag.act.model.ACT;
import ee.ut.solmir.mag.act.model.BlockACT;

class VariableDeclarationExprParser extends AbstractASTParser<ACT, VariableDeclarationExpr> {

	VariableDeclarationExprParser(ACTFactory actFactory) {
    super(actFactory);
  }

	public ACT parse(VariableDeclarationExpr node) {
    return new BlockACT(node, createAllACTInternal(node.getVars()));
  }
}