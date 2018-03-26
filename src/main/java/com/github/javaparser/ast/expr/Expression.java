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
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.metamodel.ExpressionMetaModel;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import javax.annotation.Generated;

import com.github.javaparser.Consumer;
import com.github.javaparser.TokenRange;
import com.github.javaparser.resolution.types.ResolvedType;

import static com.github.javaparser.utils.CodeGenerationUtils.f;


/**
 * A base class for all expressions.
 *
 * @author Julio Vilmar Gesser
 */
public abstract class Expression extends Node {

    @AllFieldsConstructor
    public Expression() {
        this(null);
    }

    /**
     * This constructor is used by the parser and is considered private.
     */
    @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
    public Expression(TokenRange tokenRange) {
        super(tokenRange);
        customInitialization();
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
    public Expression clone() {
        return (Expression) accept(new CloneVisitor(), null);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
    public ExpressionMetaModel getMetaModel() {
        return JavaParserMetaModel.expressionMetaModel;
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.ReplaceMethodGenerator")
    public boolean replace(Node node, Node replacementNode) {
        if (node == null)
            return false;
        return super.replace(node, replacementNode);
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public boolean isAnnotationExpr() {
        return false;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public AnnotationExpr asAnnotationExpr() {
        throw new IllegalStateException(f("%s is not an AnnotationExpr", this));
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public boolean isArrayAccessExpr() {
        return false;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public ArrayAccessExpr asArrayAccessExpr() {
        throw new IllegalStateException(f("%s is not an ArrayAccessExpr", this));
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public boolean isArrayCreationExpr() {
        return false;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public ArrayCreationExpr asArrayCreationExpr() {
        throw new IllegalStateException(f("%s is not an ArrayCreationExpr", this));
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public boolean isArrayInitializerExpr() {
        return false;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public ArrayInitializerExpr asArrayInitializerExpr() {
        throw new IllegalStateException(f("%s is not an ArrayInitializerExpr", this));
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public boolean isAssignExpr() {
        return false;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public AssignExpr asAssignExpr() {
        throw new IllegalStateException(f("%s is not an AssignExpr", this));
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public boolean isBinaryExpr() {
        return false;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public BinaryExpr asBinaryExpr() {
        throw new IllegalStateException(f("%s is not an BinaryExpr", this));
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public boolean isBooleanLiteralExpr() {
        return false;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public BooleanLiteralExpr asBooleanLiteralExpr() {
        throw new IllegalStateException(f("%s is not an BooleanLiteralExpr", this));
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public boolean isCastExpr() {
        return false;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public CastExpr asCastExpr() {
        throw new IllegalStateException(f("%s is not an CastExpr", this));
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public boolean isCharLiteralExpr() {
        return false;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public CharLiteralExpr asCharLiteralExpr() {
        throw new IllegalStateException(f("%s is not an CharLiteralExpr", this));
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public boolean isClassExpr() {
        return false;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public ClassExpr asClassExpr() {
        throw new IllegalStateException(f("%s is not an ClassExpr", this));
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public boolean isConditionalExpr() {
        return false;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public ConditionalExpr asConditionalExpr() {
        throw new IllegalStateException(f("%s is not an ConditionalExpr", this));
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public boolean isDoubleLiteralExpr() {
        return false;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public DoubleLiteralExpr asDoubleLiteralExpr() {
        throw new IllegalStateException(f("%s is not an DoubleLiteralExpr", this));
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public boolean isEnclosedExpr() {
        return false;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public EnclosedExpr asEnclosedExpr() {
        throw new IllegalStateException(f("%s is not an EnclosedExpr", this));
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public boolean isFieldAccessExpr() {
        return false;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public FieldAccessExpr asFieldAccessExpr() {
        throw new IllegalStateException(f("%s is not an FieldAccessExpr", this));
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public boolean isInstanceOfExpr() {
        return false;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public InstanceOfExpr asInstanceOfExpr() {
        throw new IllegalStateException(f("%s is not an InstanceOfExpr", this));
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public boolean isIntegerLiteralExpr() {
        return false;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public IntegerLiteralExpr asIntegerLiteralExpr() {
        throw new IllegalStateException(f("%s is not an IntegerLiteralExpr", this));
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public boolean isLambdaExpr() {
        return false;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public LambdaExpr asLambdaExpr() {
        throw new IllegalStateException(f("%s is not an LambdaExpr", this));
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public boolean isLiteralExpr() {
        return false;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public LiteralExpr asLiteralExpr() {
        throw new IllegalStateException(f("%s is not an LiteralExpr", this));
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public boolean isLiteralStringValueExpr() {
        return false;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public LiteralStringValueExpr asLiteralStringValueExpr() {
        throw new IllegalStateException(f("%s is not an LiteralStringValueExpr", this));
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public boolean isLongLiteralExpr() {
        return false;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public LongLiteralExpr asLongLiteralExpr() {
        throw new IllegalStateException(f("%s is not an LongLiteralExpr", this));
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public boolean isMarkerAnnotationExpr() {
        return false;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public MarkerAnnotationExpr asMarkerAnnotationExpr() {
        throw new IllegalStateException(f("%s is not an MarkerAnnotationExpr", this));
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public boolean isMethodCallExpr() {
        return false;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public MethodCallExpr asMethodCallExpr() {
        throw new IllegalStateException(f("%s is not an MethodCallExpr", this));
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public boolean isMethodReferenceExpr() {
        return false;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public MethodReferenceExpr asMethodReferenceExpr() {
        throw new IllegalStateException(f("%s is not an MethodReferenceExpr", this));
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public boolean isNameExpr() {
        return false;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public NameExpr asNameExpr() {
        throw new IllegalStateException(f("%s is not an NameExpr", this));
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public boolean isNormalAnnotationExpr() {
        return false;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public NormalAnnotationExpr asNormalAnnotationExpr() {
        throw new IllegalStateException(f("%s is not an NormalAnnotationExpr", this));
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public boolean isNullLiteralExpr() {
        return false;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public NullLiteralExpr asNullLiteralExpr() {
        throw new IllegalStateException(f("%s is not an NullLiteralExpr", this));
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public boolean isObjectCreationExpr() {
        return false;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public ObjectCreationExpr asObjectCreationExpr() {
        throw new IllegalStateException(f("%s is not an ObjectCreationExpr", this));
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public boolean isSingleMemberAnnotationExpr() {
        return false;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public SingleMemberAnnotationExpr asSingleMemberAnnotationExpr() {
        throw new IllegalStateException(f("%s is not an SingleMemberAnnotationExpr", this));
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public boolean isStringLiteralExpr() {
        return false;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public StringLiteralExpr asStringLiteralExpr() {
        throw new IllegalStateException(f("%s is not an StringLiteralExpr", this));
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public boolean isSuperExpr() {
        return false;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public SuperExpr asSuperExpr() {
        throw new IllegalStateException(f("%s is not an SuperExpr", this));
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public boolean isThisExpr() {
        return false;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public ThisExpr asThisExpr() {
        throw new IllegalStateException(f("%s is not an ThisExpr", this));
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public boolean isTypeExpr() {
        return false;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public TypeExpr asTypeExpr() {
        throw new IllegalStateException(f("%s is not an TypeExpr", this));
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public boolean isUnaryExpr() {
        return false;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public UnaryExpr asUnaryExpr() {
        throw new IllegalStateException(f("%s is not an UnaryExpr", this));
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public boolean isVariableDeclarationExpr() {
        return false;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public VariableDeclarationExpr asVariableDeclarationExpr() {
        throw new IllegalStateException(f("%s is not an VariableDeclarationExpr", this));
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public void ifAnnotationExpr(Consumer<AnnotationExpr> action) {
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public void ifArrayAccessExpr(Consumer<ArrayAccessExpr> action) {
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public void ifArrayCreationExpr(Consumer<ArrayCreationExpr> action) {
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public void ifArrayInitializerExpr(Consumer<ArrayInitializerExpr> action) {
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public void ifAssignExpr(Consumer<AssignExpr> action) {
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public void ifBinaryExpr(Consumer<BinaryExpr> action) {
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public void ifBooleanLiteralExpr(Consumer<BooleanLiteralExpr> action) {
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public void ifCastExpr(Consumer<CastExpr> action) {
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public void ifCharLiteralExpr(Consumer<CharLiteralExpr> action) {
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public void ifClassExpr(Consumer<ClassExpr> action) {
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public void ifConditionalExpr(Consumer<ConditionalExpr> action) {
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public void ifDoubleLiteralExpr(Consumer<DoubleLiteralExpr> action) {
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public void ifEnclosedExpr(Consumer<EnclosedExpr> action) {
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public void ifFieldAccessExpr(Consumer<FieldAccessExpr> action) {
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public void ifInstanceOfExpr(Consumer<InstanceOfExpr> action) {
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public void ifIntegerLiteralExpr(Consumer<IntegerLiteralExpr> action) {
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public void ifLambdaExpr(Consumer<LambdaExpr> action) {
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public void ifLiteralExpr(Consumer<LiteralExpr> action) {
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public void ifLiteralStringValueExpr(Consumer<LiteralStringValueExpr> action) {
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public void ifLongLiteralExpr(Consumer<LongLiteralExpr> action) {
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public void ifMarkerAnnotationExpr(Consumer<MarkerAnnotationExpr> action) {
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public void ifMethodCallExpr(Consumer<MethodCallExpr> action) {
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public void ifMethodReferenceExpr(Consumer<MethodReferenceExpr> action) {
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public void ifNameExpr(Consumer<NameExpr> action) {
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public void ifNormalAnnotationExpr(Consumer<NormalAnnotationExpr> action) {
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public void ifNullLiteralExpr(Consumer<NullLiteralExpr> action) {
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public void ifObjectCreationExpr(Consumer<ObjectCreationExpr> action) {
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public void ifSingleMemberAnnotationExpr(Consumer<SingleMemberAnnotationExpr> action) {
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public void ifStringLiteralExpr(Consumer<StringLiteralExpr> action) {
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public void ifSuperExpr(Consumer<SuperExpr> action) {
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public void ifThisExpr(Consumer<ThisExpr> action) {
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public void ifTypeExpr(Consumer<TypeExpr> action) {
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public void ifUnaryExpr(Consumer<UnaryExpr> action) {
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public void ifVariableDeclarationExpr(Consumer<VariableDeclarationExpr> action) {
    }

    public ResolvedType calculateResolvedType() {
        return getSymbolResolver().calculateType(this);
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public AnnotationExpr toAnnotationExpr() {
        return null;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public ArrayAccessExpr toArrayAccessExpr() {
        return null;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public ArrayCreationExpr toArrayCreationExpr() {
        return null;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public ArrayInitializerExpr toArrayInitializerExpr() {
        return null;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public AssignExpr toAssignExpr() {
        return null;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public BinaryExpr toBinaryExpr() {
        return null;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public BooleanLiteralExpr toBooleanLiteralExpr() {
        return null;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public CastExpr toCastExpr() {
        return null;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public  CharLiteralExpr toCharLiteralExpr() {
        return null;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public ClassExpr toClassExpr() {
        return null;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public ConditionalExpr toConditionalExpr() {
        return null;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public DoubleLiteralExpr toDoubleLiteralExpr() {
        return null;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public EnclosedExpr toEnclosedExpr() {
        return null;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public FieldAccessExpr toFieldAccessExpr() {
        return null;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public InstanceOfExpr toInstanceOfExpr() {
        return null;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public IntegerLiteralExpr toIntegerLiteralExpr() {
        return null;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public LambdaExpr toLambdaExpr() {
        return null;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public LiteralExpr toLiteralExpr() {
        return null;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public LiteralStringValueExpr toLiteralStringValueExpr() {
        return null;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public LongLiteralExpr toLongLiteralExpr() {
        return null;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public MarkerAnnotationExpr toMarkerAnnotationExpr() {
        return null;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public MethodCallExpr toMethodCallExpr() {
        return null;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public MethodReferenceExpr toMethodReferenceExpr() {
        return null;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public NameExpr toNameExpr() {
        return null;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public NormalAnnotationExpr toNormalAnnotationExpr() {
        return null;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public NullLiteralExpr toNullLiteralExpr() {
        return null;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public ObjectCreationExpr toObjectCreationExpr() {
        return null;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public SingleMemberAnnotationExpr toSingleMemberAnnotationExpr() {
        return null;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public StringLiteralExpr toStringLiteralExpr() {
        return null;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public SuperExpr toSuperExpr() {
        return null;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public ThisExpr toThisExpr() {
        return null;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public TypeExpr toTypeExpr() {
        return null;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public UnaryExpr toUnaryExpr() {
        return null;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public VariableDeclarationExpr toVariableDeclarationExpr() {
        return null;
    }
}
