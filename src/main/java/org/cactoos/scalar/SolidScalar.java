/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2017-2018 Yegor Bugayenko
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.cactoos.scalar;

import org.cactoos.Func;
import org.cactoos.Scalar;
import org.cactoos.func.SolidFunc;

/**
 * Cached and synchronized version of a Scalar.
 *
 * <p>Objects of this class are thread safe.
 *
 * @author Yegor Bugayenko (yegor256@gmail.com)
 * @version $Id$
 * @param <T> Type of result
 * @see StickyScalar
 * @see SyncScalar
 * @since 0.24
 */
public final class SolidScalar<T> implements Scalar<T> {

    /**
     * Func.
     */
    private final Func<Boolean, T> func;

    /**
     * Ctor.
     * @param scalar The Scalar to cache
     */
    public SolidScalar(final Scalar<T> scalar) {
        this.func = new SolidFunc<>(
            input -> scalar.value()
        );
    }

    @Override
    public T value() throws Exception {
        return this.func.apply(true);
    }
}
