package main;

import domain.BuildConfig;
import domain.Project;
import xml.Build;
import xml.XMLBuildConfigurationReader;
import yaml.Compile;
import yaml.YamlBuildConfigurationReader;

public class Main {
	
	public static void main(String[] args) {
		XMLBuildConfigurationReader buildConfigurationReader = new XMLBuildConfigurationReader("build.xml");
		final Project xmlProject = buildConfigurationReader.getProject();
		Build build = new Build(xmlProject);
		build.build(1, "dist");
		YamlBuildConfigurationReader yamlConfigReader = new YamlBuildConfigurationReader("build.yaml");
		final BuildConfig yamlBuildConfig = yamlConfigReader.getBuildConfig();
		Compile compile = new Compile(yamlBuildConfig, "dist");
		compile.build(1);
	}
}
