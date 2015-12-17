package ee.ut.solmir.act.factory;

import ee.ut.solmir.act.model.ACT;
import japa.parser.ast.Node;

interface ASTParser<T1 extends ACT, T2 extends Node> {
	T1 parse(T2 node);
}