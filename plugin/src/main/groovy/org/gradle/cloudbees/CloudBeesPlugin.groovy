package org.gradle.cloudbees;

import org.gradle.api.Plugin
import org.gradle.api.Project

import com.cloudbees.api.BeesClient
import com.cloudbees.api.HashWriteProgress

class CloudBeesPlugin implements Plugin<Project>{

	void apply(Project target) {
		
		target.extensions.create("cloudbees", CloudBeesPluginExtension)
		
		target.task('cloudbees', dependsOn: 'war') << {
			
			String apiUrl = "https://api.cloudbees.com/api";
			
			BeesClient client = new BeesClient(
				apiUrl,
				target.cloudbees.apiKey,
				target.cloudbees.secret,
				"xml",
				"1.0")
			
			client.applicationDeployWar(
				target.cloudbees.appId,
				null, 
				'Deployed by Gradle', 
				target.file(target.war.archivePath), 
				null, 
				new HashWriteProgress());
		}
	}

}

class CloudBeesPluginExtension {
	String apiKey
	String secret
	String appId
}
