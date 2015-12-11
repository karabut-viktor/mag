package ee.ut.solmir.mag.act.factory;

import japa.parser.ast.Node;
import ee.ut.solmir.mag.act.model.ACT;

interface ASTParser<T1 extends ACT, T2 extends Node> {
	T1 parse(T2 node);
}