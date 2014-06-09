package com.moowork.gradle.grunt

import org.gradle.api.Project

class GruntExtension
{
    final static String NAME = 'grunt'

    def File workDir

    GruntExtension( final Project project )
    {
        this.workDir = new File( project.projectDir, 'grunt' )
    }

    static GruntExtension get( final Project project )
    {
        return project.extensions.getByType( GruntExtension )
    }
}
