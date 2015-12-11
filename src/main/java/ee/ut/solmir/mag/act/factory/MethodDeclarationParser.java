package ee.ut.solmir.mag.act.factory;

import japa.parser.ast.body.MethodDeclaration;
import ee.ut.solmir.mag.act.model.BlockACT;
import ee.ut.solmir.mag.act.model.MethodACT;

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