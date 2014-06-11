package com.moowork.gradle.grunt

import com.moowork.gradle.node.task.NpmTask
import org.gradle.api.tasks.TaskAction

class GruntInstallTask
    extends NpmTask
{
    public GruntInstallTask()
    {
        super()

        this.group = 'Grunt'
        this.description = "Runs 'npm install grunt-cli grunt' to install grunt-cli"

    }

    @TaskAction
    void exec(){

        def extParams = GruntExtension.get(this.project)

        setArgs( ['install', 'grunt-cli', 'grunt', '--prefix', extParams.workDir] )

        getOutputs().dir( "${extParams.workDir}/node_modules/grunt" )
        getOutputs().dir( "${extParams.workDir}/node_modules/grunt-cli" )

        super.exec()
    }
}
