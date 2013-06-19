/*******************************************************************************
 * Copyright (c) 2007 - 2010 GreenDeltaTC. All rights reserved. This program and
 * the accompanying materials are made available under the terms of the Mozilla
 * Public License v1.1 which accompanies this distribution, and is available at
 * http://www.openlca.org/uploads/media/MPL-1.1.html
 * 
 * Contributors: GreenDeltaTC - initial API and implementation
 * www.greendeltatc.com tel.: +49 30 4849 6030 mail: gdtc@greendeltatc.com
 ******************************************************************************/
package org.openlca.core.application.navigation.actions;

import java.util.List;

import org.eclipse.jface.action.Action;
import org.openlca.core.application.Messages;
import org.openlca.core.application.db.Database;
import org.openlca.core.application.navigation.CategoryElement;
import org.openlca.core.application.navigation.INavigationElement;
import org.openlca.core.application.views.navigator.Navigator;
import org.openlca.core.database.BaseDao;
import org.openlca.core.model.Category;
import org.openlca.core.resources.ImageType;
import org.openlca.ui.Error;
import org.openlca.ui.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Delete a category via the navigation tree.
 */
public class DeleteCategoryAction extends Action implements INavigationAction {

	private Category category;
	private INavigationElement parentElement;

	public DeleteCategoryAction() {
		setText(Messages.NavigationView_RemoveCategoryText);
		setImageDescriptor(ImageType.DELETE_ICON.getDescriptor());
	}

	@Override
	public boolean accept(INavigationElement element) {
		if (!(element instanceof CategoryElement))
			return false;
		CategoryElement e = (CategoryElement) element;
		category = (Category) e.getData();
		parentElement = element.getParent();
		return true;
	}

	public boolean accept(List<INavigationElement> elements) {
		return false;
	}

	@Override
	public void run() {
		if (category == null)
			return;
		if (category.getChildCategories().length != 0) {
			// TODO: models in category !
			Error.showBox("The category is not empty.");
			return;
		}
		boolean b = Question.ask("Delete",
				"Do you really want to delete the selected category?");
		if (!b)
			return;
		delete();
	}

	private void delete() {
		try {
			BaseDao<Category> dao = Database.get().createDao(Category.class);
			Category parent = category.getParentCategory();
			if (parent != null) {
				parent.remove(category);
				category.setParentCategory(null);
				dao.update(parent);
			}
			dao.delete(category);
			Navigator.refresh(parentElement);
		} catch (Exception e) {
			Logger log = LoggerFactory.getLogger(getClass());
			log.error("failed to delete category " + category, e);
		}
	}

}
