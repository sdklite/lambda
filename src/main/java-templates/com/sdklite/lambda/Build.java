package com.sdklite.lambda;

/**
 * The build properties
 * 
 * @author johnsonlee
 */
public interface Build {

    String GROUP_ID = "${project.groupId}";

    String ARTIFACT_ID = "${project.artifactId}";

    String VERSION = "${project.version}";

}
