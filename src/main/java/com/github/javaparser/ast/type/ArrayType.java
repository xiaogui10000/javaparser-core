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
package com.github.javaparser.ast.type;

import com.github.javaparser.Consumer;
import com.github.javaparser.TokenRange;
import com.github.javaparser.ast.AllFieldsConstructor;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.MarkerAnnotationExpr;
import com.github.javaparser.ast.expr.MemberValuePair;
import com.github.javaparser.ast.expr.NormalAnnotationExpr;
import com.github.javaparser.ast.expr.SingleMemberAnnotationExpr;
import com.github.javaparser.ast.nodeTypes.NodeWithAnnotations;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metamodel.ArrayTypeMetaModel;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.resolution.types.ResolvedArrayType;
import com.github.javaparser.utils.Pair;
import javax.annotation.Generated;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

import static com.github.javaparser.ast.NodeList.nodeList;
import static com.github.javaparser.utils.Utils.assertNotNull;
import static com.github.javaparser.JavaParser.parseExpression;
import static com.github.javaparser.JavaParser.parseName;

/**
 * To indicate that a type is an array, it gets wrapped in an ArrayType for every array level it has.
 * So, int[][] becomes ArrayType(ArrayType(int)).
 */
public final class ArrayType extends ReferenceType implements NodeWithAnnotations<ArrayType> {

    @Override
    public ResolvedArrayType resolve() {
        return getSymbolResolver().toResolvedType(this, ResolvedArrayType.class);
    }

    /**
     * The origin of a pair of array brackets [].
     */
    public enum Origin {

        /**
         * The [] were found on the name, like "int a[]" or "String abc()[][]"
         */
        NAME, /** 
         * The [] were found on the type, like "int[] a" or "String[][] abc()"
         */
        TYPE
    }

    private Type componentType;

    private Origin origin;

    @AllFieldsConstructor
    public ArrayType(Type componentType, Origin origin, NodeList<AnnotationExpr> annotations) {
        this(null, componentType, origin, annotations);
    }

    public ArrayType(Type type, AnnotationExpr... annotations) {
        this(type, Origin.TYPE, nodeList(annotations));
    }

    /**
     * This constructor is used by the parser and is considered private.
     */
    @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
    public ArrayType(TokenRange tokenRange, Type componentType, Origin origin, NodeList<AnnotationExpr> annotations) {
        super(tokenRange, annotations);
        setComponentType(componentType);
        setOrigin(origin);
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
    public Type getComponentType() {
        return componentType;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public ArrayType setComponentType(final Type componentType) {
        assertNotNull(componentType);
        if (componentType == this.componentType) {
            return (ArrayType) this;
        }
        notifyPropertyChange(ObservableProperty.COMPONENT_TYPE, this.componentType, componentType);
        if (this.componentType != null)
            this.componentType.setParentNode(null);
        this.componentType = componentType;
        setAsParentNodeOf(componentType);
        return this;
    }

    /**
     * Takes lists of arrayBracketPairs, assumes the lists are ordered left to right and the pairs are ordered left to
     * right, mirroring the actual code. The type gets wrapped in ArrayTypes so that the outermost ArrayType corresponds
     * to the rightmost ArrayBracketPair.
     */
    @SafeVarargs
    public static Type wrapInArrayTypes(Type type, List<ArrayBracketPair>... arrayBracketPairLists) {
        for (int i = arrayBracketPairLists.length - 1; i >= 0; i--) {
            final List<ArrayBracketPair> arrayBracketPairList = arrayBracketPairLists[i];
            if (arrayBracketPairList != null) {
                for (int j = arrayBracketPairList.size() - 1; j >= 0; j--) {
                    ArrayBracketPair pair = arrayBracketPairList.get(j);
                    TokenRange tokenRange = null;
                    if (type.getTokenRange()!=null && pair.getTokenRange()!=null) {
                        tokenRange = new TokenRange(type.getTokenRange().getBegin(), pair.getTokenRange().getEnd());
                    }
                    type = new ArrayType(tokenRange, type, pair.getOrigin(), pair.getAnnotations());
                    if (tokenRange != null) {
                        type.setRange(tokenRange.toRange());
                    }
                }
            }
        }
        return type;
    }

    /**
     * Takes a type that may be an ArrayType. Unwraps ArrayTypes until the element type is found.
     *
     * @return a pair of the element type, and the unwrapped ArrayTypes, if any.
     */
    public static Pair<Type, List<ArrayBracketPair>> unwrapArrayTypes(Type type) {
        final List<ArrayBracketPair> arrayBracketPairs = new ArrayList<>(0);
        while (type instanceof ArrayType) {
            ArrayType arrayType = (ArrayType) type;
            arrayBracketPairs.add(new ArrayBracketPair(type.getTokenRange()!=null?type.getTokenRange():null, arrayType.getOrigin(), arrayType.getAnnotations()));
            type = arrayType.getComponentType();
        }
        return new Pair<>(type, arrayBracketPairs);
    }

    /**
     * Helper class that stores information about a pair of brackets in a non-recursive way
     * (unlike ArrayType.)
     */
    public static class ArrayBracketPair {

        private TokenRange tokenRange;

        private NodeList<AnnotationExpr> annotations = new NodeList<>();

        private Origin origin;

        public ArrayBracketPair(TokenRange tokenRange, Origin origin, NodeList<AnnotationExpr> annotations) {
            setTokenRange(tokenRange);
            setAnnotations(annotations);
            setOrigin(origin);
        }

        public NodeList<AnnotationExpr> getAnnotations() {
            return annotations;
        }

        public ArrayBracketPair setAnnotations(NodeList<AnnotationExpr> annotations) {
            this.annotations = assertNotNull(annotations);
            return this;
        }

        public ArrayBracketPair setTokenRange(TokenRange range) {
            this.tokenRange = range;
            return this;
        }

        public TokenRange getTokenRange() {
            return tokenRange;
        }

        public Origin getOrigin() {
            return origin;
        }

        public ArrayBracketPair setOrigin(Origin origin) {
            this.origin = assertNotNull(origin);
            return this;
        }
    }

    @Override
    public ArrayType setAnnotations(NodeList<AnnotationExpr> annotations) {
        return (ArrayType) super.setAnnotations(annotations);
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public Origin getOrigin() {
        return origin;
    }

    @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
    public ArrayType setOrigin(final Origin origin) {
        assertNotNull(origin);
        if (origin == this.origin) {
            return (ArrayType) this;
        }
        notifyPropertyChange(ObservableProperty.ORIGIN, this.origin, origin);
        this.origin = origin;
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
    public String asString() {
        return componentType.asString() + "[]";
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
    public ArrayType clone() {
        return (ArrayType) accept(new CloneVisitor(), null);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
    public ArrayTypeMetaModel getMetaModel() {
        return JavaParserMetaModel.arrayTypeMetaModel;
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.ReplaceMethodGenerator")
    public boolean replace(Node node, Node replacementNode) {
        if (node == null)
            return false;
        if (node == componentType) {
            setComponentType((Type) replacementNode);
            return true;
        }
        return super.replace(node, replacementNode);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public boolean isArrayType() {
        return true;
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public ArrayType asArrayType() {
        return this;
    }

    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public void ifArrayType(Consumer<ArrayType> action) {
        action.accept(this);
    }

    @Override
    @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
    public ArrayType toArrayType() {
        return this;
    }
    
    // for NodeWithAnnotations
    public AnnotationExpr getAnnotation(int i) {
        return getAnnotations().get(i);
    }

    @SuppressWarnings("unchecked")
    public ArrayType setAnnotation(int i, AnnotationExpr element) {
        getAnnotations().set(i, element);
        return (ArrayType) this;
    }

    @SuppressWarnings("unchecked")
    public ArrayType addAnnotation(AnnotationExpr element) {
        getAnnotations().add(element);
        return (ArrayType) this;
    }

    /**
     * Annotates this
     *
     * @param name the name of the annotation
     * @return this
     */
    @SuppressWarnings("unchecked")
    public ArrayType addAnnotation(String name) {
        NormalAnnotationExpr annotation = new NormalAnnotationExpr(
                parseName(name), new NodeList<MemberValuePair>());
        getAnnotations().add(annotation);
        return (ArrayType) this;
    }

    /**
     * Annotates this
     *
     * @param name the name of the annotation
     * @return the {@link NormalAnnotationExpr} added
     */
    @SuppressWarnings("unchecked")
    public NormalAnnotationExpr addAndGetAnnotation(String name) {
        NormalAnnotationExpr annotation = new NormalAnnotationExpr(
                parseName(name), new NodeList<MemberValuePair>());
        getAnnotations().add(annotation);
        return annotation;
    }

    /**
     * Annotates this node and automatically add the import
     *
     * @param clazz the class of the annotation
     * @return this
     */
    public ArrayType addAnnotation(Class<? extends Annotation> clazz) {
        tryAddImportToParentCompilationUnit(clazz);
        return addAnnotation(clazz.getSimpleName());
    }

    /**
     * Annotates this node and automatically add the import
     *
     * @param clazz the class of the annotation
     * @return the {@link NormalAnnotationExpr} added
     */
    public NormalAnnotationExpr addAndGetAnnotation(Class<? extends Annotation> clazz) {
        tryAddImportToParentCompilationUnit(clazz);
        return addAndGetAnnotation(clazz.getSimpleName());
    }

    /**
     * Annotates this with a marker annotation
     *
     * @param name the name of the annotation
     * @return this
     */
    @SuppressWarnings("unchecked")
    public ArrayType addMarkerAnnotation(String name) {
        MarkerAnnotationExpr markerAnnotationExpr = new MarkerAnnotationExpr(
                parseName(name));
        getAnnotations().add(markerAnnotationExpr);
        return (ArrayType) this;
    }

    /**
     * Annotates this with a marker annotation and automatically add the import
     *
     * @param clazz the class of the annotation
     * @return this
     */
    public ArrayType addMarkerAnnotation(Class<? extends Annotation> clazz) {
        tryAddImportToParentCompilationUnit(clazz);
        return addMarkerAnnotation(clazz.getSimpleName());
    }

    /**
     * Annotates this with a single member annotation
     *
     * @param name the name of the annotation
     * @param expression the part between ()
     * @return this
     */
    @SuppressWarnings("unchecked")
    public ArrayType addSingleMemberAnnotation(String name, Expression expression) {
        SingleMemberAnnotationExpr singleMemberAnnotationExpr = new SingleMemberAnnotationExpr(
                parseName(name), expression);
        getAnnotations().add(singleMemberAnnotationExpr);
        return (ArrayType) this;
    }

    /**
     * Annotates this with a single member annotation
     *
     * @param name the name of the annotation
     * @param value the value, don't forget to add \"\" for a string value
     * @return this
     */
    public ArrayType addSingleMemberAnnotation(String name, String value) {
        return addSingleMemberAnnotation(name, parseExpression(value));
    }

    /**
     * Annotates this with a single member annotation and automatically add the import
     *
     * @param clazz the class of the annotation
     * @param value the value, don't forget to add \"\" for a string value
     * @return this
     */
    public ArrayType addSingleMemberAnnotation(Class<? extends Annotation> clazz,
                                        String value) {
        tryAddImportToParentCompilationUnit(clazz);
        return addSingleMemberAnnotation(clazz.getSimpleName(), value);
    }

    /**
     * Check whether an annotation with this name is present on this element
     *
     * @param annotationName the name of the annotation
     * @return true if found, false if not
     */
    public boolean isAnnotationPresent(String annotationName) {
       // return getAnnotations().stream().anyMatch(a -> a.getName().getIdentifier().equals(annotationName));
    	for (AnnotationExpr a : getAnnotations()) {
			if(a.getName().getIdentifier().equals(annotationName)) return true;
		}
    	return false;
    }

    /**
     * Check whether an annotation with this class is present on this element
     *
     * @param annotationClass the class of the annotation
     * @return true if found, false if not
     */
    public  boolean isAnnotationPresent(Class<? extends Annotation> annotationClass) {
        return isAnnotationPresent(annotationClass.getSimpleName());
    }

    /**
     * Try to find an annotation by its name
     *
     * @param annotationName the name of the annotation
     */
    public AnnotationExpr getOptionalAnnotationByName(String annotationName) {
       // return getAnnotations().stream().filter(a -> a.getName().getIdentifier().equals(annotationName)).findFirst();
    	for (AnnotationExpr a : getAnnotations()) {
		   if(a.getName().getIdentifier().equals(annotationName))	return a;
		}
    	return null;
    }
    
    public AnnotationExpr getAnnotationByName(String annotationName){
    	NodeList<AnnotationExpr> annotationList =getAnnotations();
    	for (AnnotationExpr annotationExpr : annotationList) {
			if(annotationExpr.getName().getIdentifier().equals(annotationName)) return annotationExpr;
		}
    	return null;
    }

    /**
     * Try to find an annotation by its class
     *
     * @param annotationClass the class of the annotation
     */
    public AnnotationExpr getOptionalAnnotationByClass(Class<? extends Annotation> annotationClass) {
        return getOptionalAnnotationByName(annotationClass.getSimpleName());
    }
    
    public AnnotationExpr getAnnotationByClass(Class<? extends Annotation> annotationClass) {
    	AnnotationExpr optional=getOptionalAnnotationByName(annotationClass.getSimpleName());
    	if(optional!=null) return optional;
    	else return null;
    }
}
