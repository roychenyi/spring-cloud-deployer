/*
 * Copyright 2016 the original author or authors.
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

package org.springframework.cloud.deployer.spi.local;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.cloud.deployer.spi.task.TaskLauncher;
import org.springframework.cloud.deployer.spi.test.AbstractTaskLauncherIntegrationTests;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Integration tests for {@link LocalTaskLauncher}.
 *
 * @author Eric Bottard
 */
@SpringApplicationConfiguration(classes = LocalTaskLauncherIntegrationTests.Config.class)
public class LocalTaskLauncherIntegrationTests extends AbstractTaskLauncherIntegrationTests {

	@Autowired
	private TaskLauncher taskLauncher;

	@Override
	protected TaskLauncher taskLauncher() {
		return taskLauncher;
	}

	@Configuration
	@EnableConfigurationProperties(LocalDeployerProperties.class)
	public static class Config {

		@Bean
		public TaskLauncher taskLauncher(LocalDeployerProperties properties) {
			return new LocalTaskLauncher(properties);
		}
	}

}
