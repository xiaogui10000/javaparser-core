/*
 * Copyright (C) 2007-2010 Júlio Vilmar Gesser.
 * Copyright (C) 2011, 2013-2016 The JavaParser Team.
 *
 * This file is part of JavaParser.
 *
 * JavaParser can be used either under the terms of
 * a) the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 * b) the terms of the Apache License
 *
 * You should have received a copy of both licenses in LICENCE.LGPL and
 * LICENCE.APACHE. Please refer to those files for details.
 *
 * JavaParser is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 */
package com.github.javaparser.ast.expr;

import com.github.javaparser.ast.AllFieldsConstructor;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import static com.github.javaparser.utils.Utils.assertNotNull;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.metamodel.BinaryExprMetaModel;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.printer.Printable;
import javax.annotation.Generated;

import com.github.javaparser.Consumer;
import com.github.javaparser.TokenRange;


/**
 * An expression with an expression on the left, an expression on the right, and an operator in the middle.
 * It supports the operators that are found the the BinaryExpr.Operator enum.
 * <br/><code>a && b</code>
 * <br/><code>155 * 33</code>
 *
 * @author Julio Vilmar Gesser
 */
public final class BinaryExpr extends Expression {

    public enum Operator implements Printable {

        OR("||", null),
        AND("&&", null),
        BINARY_OR("|", AssignExpr.Operator.BINARY_OR),
        BINARY_AND("&", AssignExpr.Operator.BINARY_AND),
        XOR("^", AssignExpr.Operator.XOR),
        EQUALS("==", null),
        NOT_EQUALS("!=", null),
        LESS("<", null),
        GREATER(">", null),
        LESS_EQUALS("<=", null),
        GREATER_EQUALS(">=", null),
        LEFT_SHIFT("<<", AssignExpr.Operator.LEFT_SHIFT),
        SIGNED_RIGHT_SHIFT(">>", AssignExpr.Operator.SIGNED_RIGHT_SHIFT),
        UNSIGNED_RIGHT_SHIFT(">>>", AssignExpr.Operator.UNSIGNED_RIGHT_SHIFT),
        PLUS("+", AssignExpr.Operator.PLUS),
        MINUS("-", AssignExpr.Operator.MINUS),
        MULTIPLY("*", AssignExpr.Operator.MULTIPLY),
        DIVIDE("/", AssignExpr.Operator.DIVIDE),
        REMAINDER("%", AssignExpr.Operator.REMAINDER);

        private final String codeRepresentation;

        private final AssignExpr.Operator assignOperatorEquivalent;

        Operator(String codeRepresentation, AssignExpr.Operator assignOperatorEquivalent) {
            this.codeRepresentation = codeRepresentation;
            this.assignOperatorEquivalent = assignOperatorEquivalent;
        }

        public String asString() {
            return codeRepresentation;
        }

        public AssignExpr.Operator toAssignOperator() {
            return assignOperatorEquivalent;
        }
    }

    private Expression left;

    private Expression right;

    private Operator operator;

    public BinaryExpr() {
        this(null, new BooleanLiteralExpr(), new BooleanLiteralExpr(), Operator.EQUALS);
    }

    @AllFieldsConstructor
    public BinaryExpr(Expression left, Expression right, Operator operator) {
        this(null, left, right, operator);
    }

    /**
     * This constructor is used by the parser and is considered private.
     */
    @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
    public BinaryExpr(TokenRange tokenRange, Expression left, Expression right, Operator operator) {
        super(tokenRange);
        setLeft(left);
        setRight(right);
        setOperator(operator);
        customInitialization();
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.AcceptGenerator")
    public <R, A> R accept(final GenericVisitor<R, A> v, final A arg) {
        return v.visit(this, arg);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.AcceptGenerator")
    public <A> void accept(final VoidVisitor<A> v, final A arg) {
        v.visit(this, arg);
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public Expression getLeft() {
        return left;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public Operator getOperator() {
        return operator;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public Expression getRight() {
        return right;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public BinaryExpr setLeft(final Expression left) {
        assertNotNull(left);
        if (left == this.left) {
            return (BinaryExpr) this;
        }
        notifyPropertyChange(ObservableProperty.LEFT, this.left, left);
        if (this.left != null)
            this.left.setParentNode(null);
        this.left = left;
        setAsParentNodeOf(left);
        return this;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public BinaryExpr setOperator(final Operator operator) {
        assertNotNull(operator);
        if (operator == this.operator) {
            return (BinaryExpr) this;
        }
        notifyPropertyChange(ObservableProperty.OPERATOR, this.operator, operator);
        this.operator = operator;
        return this;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public BinaryExpr setRight(final Expression right) {
        assertNotNull(right);
        if (right == this.right) {
            return (BinaryExpr) this;
        }
        notifyPropertyChange(ObservableProperty.RIGHT, this.right, right);
        if (this.right != null)
            this.right.setParentNode(null);
        this.right = right;
        setAsParentNodeOf(right);
        return this;
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.RemoveMethodGenerator")
    public boolean remove(Node node) {
        if (node == null)
            return false;
        return super.remove(node);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
    public BinaryExpr clone() {
        return (BinaryExpr) accept(new CloneVisitor(), null);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
    public BinaryExprMetaModel getMetaModel() {
        return JavaParserMetaModel.binaryExprMetaModel;
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.ReplaceMethodGenerator")
    public boolean replace(Node node, Node replacementNode) {
        if (node == null)
            return false;
        if (node == left) {
            setLeft((Expression) replacementNode);
            return true;
        }
        if (node == right) {
            setRight((Expression) replacementNode);
            return true;
        }
        return super.replace(node, replacementNode);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public boolean isBinaryExpr() {
        return true;
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public BinaryExpr asBinaryExpr() {
        return this;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public void ifBinaryExpr(Consumer<BinaryExpr> action) {
        action.accept(this);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public BinaryExpr toBinaryExpr() {
        return this;
    }
}
