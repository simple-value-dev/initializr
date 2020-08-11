/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.spring.initializr.generator.buildsystem;

import java.util.LinkedHashMap;
import java.util.function.Function;

import io.spring.initializr.generator.version.VersionReference;

/**
 * A {@link BuildItemContainer} implementation for dependencies.
 *
 * @author Stephane Nicoll
 */
public class DependencyContainer extends BuildItemContainer<String, Dependency> {

	DependencyContainer(Function<String, Dependency> itemResolver) {
		super(new LinkedHashMap<>(), itemResolver);
	}

	/**
	 * Register a {@link Dependency} with the specified {@code id} and a managed version.
	 * @param id the id of the dependency
	 * @param groupId the groupId
	 * @param artifactId the artifactId
	 * @param scope the {@link DependencyScope}
	 */
	public void add(String id, String groupId, String artifactId, DependencyScope scope) {
		add(id, new Dependency(groupId, artifactId, scope));
	}

	/**
	 * Register a {@link Dependency} with the specified {@code id}, version and
	 * {@link DependencyScope scope}.
	 * @param id the id of the dependency
	 * @param groupId the groupId
	 * @param artifactId the artifactId
	 * @param version the {@link VersionReference}
	 * @param scope the {@link DependencyScope}
	 */
	public void add(String id, String groupId, String artifactId,
			VersionReference version, DependencyScope scope) {
		add(id, new Dependency(groupId, artifactId, version, scope));
	}

	/**
	 * Register a {@link Dependency} with the specified {@code id}, version,
	 * {@link DependencyScope scope} and type.
	 * @param id the id of the dependency
	 * @param groupId the groupId
	 * @param artifactId the artifactId
	 * @param version the {@link VersionReference}
	 * @param scope the {@link DependencyScope}
	 * @param type the artifact type
	 */
	public void add(String id, String groupId, String artifactId,
			VersionReference version, DependencyScope scope, String type) {
		add(id, new Dependency(groupId, artifactId, version, scope, type));
	}

}
