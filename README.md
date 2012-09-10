[![Build Status](https://gradle-cloudbees-plugin.ci.cloudbees.com/job/snapshot/badge/icon)](https://gradle-cloudbees-plugin.ci.cloudbees.com/job/snapshot/)
[![CloudBees](http://www.cloudbees.com/sites/default/files/Button-Built-on-CB-1.png)](https://gradle-cloudbees-plugin.ci.cloudbees.com/)

Usage:

buildscript {
	repositories {
		maven { url 'https://repository-gradle-cloudbees-plugin.forge.cloudbees.com/release' }
		mavenCentral()
	}
	dependencies {
		classpath(
				'org.gradle:gradle-cloudbees-plugin:1.1.1'
				)
	}
}

apply plugin: 'cloudbees'

cloudbees {
	apiKey = 'A9B1930BE39758C6'
	secret = '2HBOOTVQ3VADNVOKVD1NLKZMQRY8MKIQ7743NQTLQBO='
	appId = 'gradle-cloudbees-plugin/sample'
}