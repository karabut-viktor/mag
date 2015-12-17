package ee.ut.solmir.act.factory;

import ee.ut.solmir.act.model.ACT;
import ee.ut.solmir.act.model.BlockACT;
import japa.parser.ast.expr.VariableDeclarationExpr;

class VariableDeclarationExprParser extends AbstractASTParser<ACT, VariableDeclarationExpr> {

	VariableDeclarationExprParser(ACTFactory actFactory) {
    super(actFactory);
  }

	public ACT parse(VariableDeclarationExpr node) {
    return new BlockACT(node, createAllACTInternal(node.getVars()));
  }
}