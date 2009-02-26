/*
 * Copyright 2009 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.codenarc.rule.naming

import org.codehaus.groovy.ast.ClassNode
import org.codenarc.rule.AbstractAstVisitorRule

/**
 * Rule that verifies that the name of a class matches a regular expression. By default it checks that the
 * class name starts with an uppercase letter and is followed by zero or more word characters
 * (letters, numbers or underscores). Implicit classes (i.e. Groovy scripts) are ignored. This rule applies
 * to all classes, including abstract classes and interfaces.
 * <p/>
 * The <code>regex</code> property specifies the regular expression to check the class name against. It is
 * required and cannot be null or empty. It defaults to '[A-Z]\w*'.
 *
 * @see AbstractClassNameRule
 * @see InterfaceNameRule
 *
 * @author Chris Mair
 * @version $Revision: 37 $ - $Date: 2009-02-06 21:31:05 -0500 (Fri, 06 Feb 2009) $
 */
class ClassNameRule extends AbstractAstVisitorRule {
    String name = 'ClassName'
    int priority = 2
    Class astVisitorClass = ClassNameAstVisitor
    String regex = /[A-Z]\w*/
}

class ClassNameAstVisitor extends AbstractTypeNameAstVisitor  {
    protected boolean shouldVisit(ClassNode classNode) {
        return true
    }
}