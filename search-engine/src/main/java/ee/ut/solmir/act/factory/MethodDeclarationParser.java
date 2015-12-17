package ee.ut.solmir.act.factory;

import ee.ut.solmir.act.model.BlockACT;
import ee.ut.solmir.act.model.MethodACT;
import japa.parser.ast.body.MethodDeclaration;

class MethodDeclarationParser extends AbstractASTParser<MethodACT, MethodDeclaration> {
	MethodDeclarationParser(ACTFactory actFactory) {
    super(actFactory);
  }

	public MethodACT parse(MethodDeclaration node) {
		String name = node.getName();
		BlockACT body = (BlockACT) createACTInternal(node.getBody());
    return new MethodACT(node, name, body);
  }
}