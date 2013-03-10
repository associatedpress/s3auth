/**
 * Copyright (c) 2012, s3auth.com
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met: 1) Redistributions of source code must retain the above
 * copyright notice, this list of conditions and the following
 * disclaimer. 2) Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following
 * disclaimer in the documentation and/or other materials provided
 * with the distribution. 3) Neither the name of the s3auth.com nor
 * the names of its contributors may be used to endorse or promote
 * products derived from this software without specific prior written
 * permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT
 * NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL
 * THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.s3auth.hosts;

import com.jcabi.aspects.Immutable;
import com.jcabi.aspects.Loggable;
import javax.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Default implementation of domain.
 *
 * @author Yegor Bugayenko (yegor@tpc2.com)
 * @version $Id$
 * @since 0.0.1
 */
@SuppressWarnings("PMD.TooManyMethods")
@Immutable
@ToString
@EqualsAndHashCode(of = "origin")
final class DefaultDomain implements Domain {

    /**
     * The original domain.
     */
    private final transient Domain origin;

    /**
     * Public ctor.
     * @param name Name of it
     * @param key Key of it
     * @param secret Secret of it
     * @param region The region of S3 bucket
     * @checkstyle ParameterNumber (3 lines)
     */
    public DefaultDomain(@NotNull final String name, @NotNull final String key,
        @NotNull final String secret, @NotNull final String region) {
        this(
            new Domain() {
                @Override
                public String name() {
                    return name;
                }
                @Override
                public String key() {
                    return key;
                }
                @Override
                public String secret() {
                    return secret;
                }
                @Override
                public String region() {
                    return region;
                }
            }
        );
    }

    /**
     * Public ctor.
     * @param domain The domain
     */
    public DefaultDomain(@NotNull final Domain domain) {
        this.origin = domain;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    @Loggable(Loggable.DEBUG)
    public String name() {
        return this.origin.name().trim();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    @Loggable(Loggable.DEBUG)
    public String key() {
        return this.origin.key().trim();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    @Loggable(Loggable.DEBUG)
    public String secret() {
        return this.origin.secret().trim();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NotNull
    @Loggable(Loggable.DEBUG)
    public String region() {
        return this.origin.region().trim();
    }

}
