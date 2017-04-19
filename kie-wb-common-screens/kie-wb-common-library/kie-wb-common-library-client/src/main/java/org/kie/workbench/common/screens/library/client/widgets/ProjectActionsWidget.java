/*
 * Copyright 2017 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kie.workbench.common.screens.library.client.widgets;

import javax.inject.Inject;

import org.guvnor.common.services.project.client.security.ProjectController;
import org.guvnor.common.services.project.context.ProjectContext;
import org.guvnor.common.services.project.model.Project;
import org.kie.workbench.common.screens.library.client.util.LibraryPlaces;
import org.kie.workbench.common.screens.projecteditor.client.build.BuildExecutor;
import org.uberfire.client.mvp.UberElement;
import org.uberfire.mvp.Command;

public class ProjectActionsWidget {

    public interface View extends UberElement<ProjectActionsWidget>,
                                  BuildExecutor.View {

    }

    private View view;

    private BuildExecutor buildExecutor;

    private LibraryPlaces libraryPlaces;

    private Command showSettingsCommand;

    private ProjectContext projectContext;

    private ProjectController projectController;

    @Inject
    public ProjectActionsWidget(final View view,
                                final BuildExecutor buildExecutor,
                                final LibraryPlaces libraryPlaces,
                                final ProjectContext projectContext,
                                final ProjectController projectController) {
        this.view = view;
        this.buildExecutor = buildExecutor;
        this.libraryPlaces = libraryPlaces;
        this.projectContext = projectContext;
        this.projectController = projectController;
    }

    public void init(final Command showSettingsCommand) {
        this.showSettingsCommand = showSettingsCommand;
        view.init(this);
        buildExecutor.init(view);
    }

    public void goToProjectSettings() {
        showSettingsCommand.execute();
    }

    public void compileProject() {
        if (userCanBuildProject()) {
            buildExecutor.triggerBuild();
        }
    }

    public void buildAndDeployProject() {
        if (userCanBuildProject()) {
            buildExecutor.triggerBuildAndDeploy();
        }
    }

    public void goToMessages() {
        libraryPlaces.goToMessages();
    }

    public boolean userCanBuildProject() {
        final Project activeProject = projectContext.getActiveProject();
        return projectController.canBuildProjects() && projectController.canBuildProject(activeProject);
    }

    public View getView() {
        return view;
    }
}
