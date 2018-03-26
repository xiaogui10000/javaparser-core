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
import com.github.javaparser.metamodel.AssignExprMetaModel;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.printer.Printable;
import javax.annotation.Generated;
import com.github.javaparser.TokenRange;
import java.util.function.Consumer;
import java.util.Optional;

/**
 * An assignment expression. It supports the operators that are found the the AssignExpr.Operator enum.
 * <br/><code>a=5</code>
 * <br/><code>time+=500</code>
 * <br/><code>watch.time+=500</code>
 * <br/><code>(((time)))=100*60</code>
 * <br/><code>peanut[a]=true</code>
 *
 * @author Julio Vilmar Gesser
 */
public final class AssignExpr extends Expression {

    public enum Operator implements Printable {

        ASSIGN("=", null),
        PLUS("+=", BinaryExpr.Operator.PLUS),
        MINUS("-=", BinaryExpr.Operator.MINUS),
        MULTIPLY("*=", BinaryExpr.Operator.MULTIPLY),
        DIVIDE("/=", BinaryExpr.Operator.DIVIDE),
        BINARY_AND("&=", BinaryExpr.Operator.BINARY_AND),
        BINARY_OR("|=", BinaryExpr.Operator.BINARY_OR),
        XOR("^=", BinaryExpr.Operator.XOR),
        REMAINDER("%=", BinaryExpr.Operator.REMAINDER),
        LEFT_SHIFT("<<=", BinaryExpr.Operator.LEFT_SHIFT),
        SIGNED_RIGHT_SHIFT(">>=", BinaryExpr.Operator.SIGNED_RIGHT_SHIFT),
        UNSIGNED_RIGHT_SHIFT(">>>=", BinaryExpr.Operator.UNSIGNED_RIGHT_SHIFT);

        private final String codeRepresentation;

        private final BinaryExpr.Operator binaryOperatorEquivalent;

        Operator(String codeRepresentation, BinaryExpr.Operator binaryOperatorEquivalent) {
            this.codeRepresentation = codeRepresentation;
            this.binaryOperatorEquivalent = binaryOperatorEquivalent;
        }

        public String asString() {
            return codeRepresentation;
        }

        public Optional<BinaryExpr.Operator> toBinaryOperator() {
            return Optional.ofNullable(binaryOperatorEquivalent);
        }
    }

    private Expression target;

    private Expression value;

    private Operator operator;

    public AssignExpr() {
        this(null, new NameExpr(), new StringLiteralExpr(), Operator.ASSIGN);
    }

    @AllFieldsConstructor
    public AssignExpr(Expression target, Expression value, Operator operator) {
        this(null, target, value, operator);
    }

    /**
     * This constructor is used by the parser and is considered private.
     */
    @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
    public AssignExpr(TokenRange tokenRange, Expression target, Expression value, Operator operator) {
        super(tokenRange);
        setTarget(target);
        setValue(value);
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
    public Operator getOperator() {
        return operator;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public Expression getTarget() {
        return target;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public Expression getValue() {
        return value;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public AssignExpr setOperator(final Operator operator) {
        assertNotNull(operator);
        if (operator == this.operator) {
            return (AssignExpr) this;
        }
        notifyPropertyChange(ObservableProperty.OPERATOR, this.operator, operator);
        this.operator = operator;
        return this;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public AssignExpr setTarget(final Expression target) {
        assertNotNull(target);
        if (target == this.target) {
            return (AssignExpr) this;
        }
        notifyPropertyChange(ObservableProperty.TARGET, this.target, target);
        if (this.target != null)
            this.target.setParentNode(null);
        this.target = target;
        setAsParentNodeOf(target);
        return this;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public AssignExpr setValue(final Expression value) {
        assertNotNull(value);
        if (value == this.value) {
            return (AssignExpr) this;
        }
        notifyPropertyChange(ObservableProperty.VALUE, this.value, value);
        if (this.value != null)
            this.value.setParentNode(null);
        this.value = value;
        setAsParentNodeOf(value);
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
    public AssignExpr clone() {
        return (AssignExpr) accept(new CloneVisitor(), null);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
    public AssignExprMetaModel getMetaModel() {
        return JavaParserMetaModel.assignExprMetaModel;
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.ReplaceMethodGenerator")
    public boolean replace(Node node, Node replacementNode) {
        if (node == null)
            return false;
        if (node == target) {
            setTarget((Expression) replacementNode);
            return true;
        }
        if (node == value) {
            setValue((Expression) replacementNode);
            return true;
        }
        return super.replace(node, replacementNode);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public boolean isAssignExpr() {
        return true;
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public AssignExpr asAssignExpr() {
        return this;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public void ifAssignExpr(Consumer<AssignExpr> action) {
        action.accept(this);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public Optional<AssignExpr> toAssignExpr() {
        return Optional.of(this);
    }
}