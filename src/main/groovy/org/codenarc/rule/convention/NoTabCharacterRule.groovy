/*
 * Copyright 2015 the original author or authors.
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
package org.codenarc.rule.convention

import org.codenarc.rule.AbstractRule
import org.codenarc.rule.Violation
import org.codenarc.source.SourceCode

/**
 * Checks that all source files do not contain the tab character
 *
 * @author Yuriy Chulovskyy
 */
class NoTabCharacterRule extends AbstractRule {
    String name = 'NoTabCharacter'
    int priority = 3
    String tabCharacter = '\t'

    @Override
    void applyTo(SourceCode sourceCode, List violations) {
        if (sourceCode.getText().contains(tabCharacter)) {
            violations.add(new Violation(rule: this, message: 'The tab character is not allowed in source files'))
        }
    }
}

