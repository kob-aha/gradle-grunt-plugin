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

        // TODO Check if I need outputs dir

//        getOutputs().dir( 'node_modules/grunt' )
//        getOutputs().dir( 'node_modules/grunt-cli' )
    }

    @TaskAction
    void exec(){

        def extParams = GruntExtension.get(this.project)

        setArgs( ['install', 'grunt-cli', 'grunt', '--prefix', extParams.workDir] )

        super.exec()
    }
}
