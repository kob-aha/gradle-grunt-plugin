package com.moowork.gradle.grunt

import com.moowork.gradle.node.task.NodeTask
import org.gradle.api.GradleException

class GruntTask
    extends NodeTask
{
    private final static String GRUNT_SCRIPT = 'node_modules/grunt-cli/bin/grunt';

    public GruntTask()
    {
        this.group = 'Grunt';
    }

    @Override
    void exec()
    {
        def extParams = GruntExtension.get(this.project)
        def localGrunt = this.project.file( "${extParams.workDir}/${GRUNT_SCRIPT}" )
        if ( !localGrunt.isFile() )
        {
            throw new GradleException(
                "Grunt-CLI not installed in node_modules, please first run 'gradle ${GruntPlugin.GRUNT_INSTALL_NAME}'" )
        }

        setScript( localGrunt )
        super.exec()
    }
}
