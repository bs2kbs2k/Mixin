/*
 * This file is part of Mixim, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.asm.mixim.injection.struct;

import org.objectweb.asm.tree.AnnotationNode;
import org.objectweb.asm.tree.MethodNode;
import org.spongepowered.asm.mixim.injection.ModifyArg;
import org.spongepowered.asm.mixim.injection.code.Injector;
import org.spongepowered.asm.mixim.injection.invoke.ModifyArgInjector;
import org.spongepowered.asm.mixim.injection.struct.InjectionInfo.AnnotationType;
import org.spongepowered.asm.mixim.injection.struct.InjectionInfo.HandlerPrefix;
import org.spongepowered.asm.mixim.transformer.MiximTargetContext;
import org.spongepowered.asm.util.Annotations;

/**
 * Information about a {@link ModifyArg} injector
 */
@AnnotationType(ModifyArg.class)
@HandlerPrefix("modify")
public class ModifyArgInjectionInfo extends InjectionInfo {

    public ModifyArgInjectionInfo(MiximTargetContext mixim, MethodNode method, AnnotationNode annotation) {
        super(mixim, method, annotation);
    }
    
    @Override
    protected Injector parseInjector(AnnotationNode injectAnnotation) {
        int index = Annotations.<Integer>getValue(injectAnnotation, "index", -1);
        
        return new ModifyArgInjector(this, index);
    }
    
    @Override
    protected String getDescription() {
        return "Argument modifier method";
    }
    
}
