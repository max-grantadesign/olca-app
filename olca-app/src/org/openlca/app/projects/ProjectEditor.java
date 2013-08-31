/*******************************************************************************
 * Copyright (c) 2007 - 2010 GreenDeltaTC. All rights reserved. This program and
 * the accompanying materials are made available under the terms of the Mozilla
 * Public License v1.1 which accompanies this distribution, and is available at
 * http://www.openlca.org/uploads/media/MPL-1.1.html
 * 
 * Contributors: GreenDeltaTC - initial API and implementation
 * www.greendeltatc.com tel.: +49 30 4849 6030 mail: gdtc@greendeltatc.com
 ******************************************************************************/
package org.openlca.app.projects;

import org.eclipse.core.runtime.IProgressMonitor;
import org.openlca.app.editors.ModelEditor;
import org.openlca.core.editors.IEditor;
import org.openlca.core.model.Project;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ibm.icu.util.Calendar;

public class ProjectEditor extends ModelEditor<Project> implements IEditor {

	public static String ID = "editors.project";
	private Logger log = LoggerFactory.getLogger(getClass());

	public ProjectEditor() {
		super(Project.class);
	}

	@Override
	protected void addPages() {
		try {
			addPage(new ProjectInfoPage(this));
			addPage(new ProjectSetupPage(this));
		} catch (Exception e) {
			log.error("failed to add page", e);
		}
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		getModel().setLastModificationDate(Calendar.getInstance().getTime());
		super.doSave(monitor);
	}

}