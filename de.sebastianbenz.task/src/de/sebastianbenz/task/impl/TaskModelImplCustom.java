/*******************************************************************************
 * Copyright (c) 2008 - 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.sebastianbenz.task.impl;

import org.eclipse.emf.common.util.EList;

import de.sebastianbenz.task.Content;

public class TaskModelImplCustom extends
		de.sebastianbenz.task.impl.TaskModelImpl {

	private boolean childrenResolved = false;

	@Override
	public EList<Content> getChildren() {
		EList<Content> theChildren = super.getChildren();
		if (!childrenResolved) {
			childrenResolved = true;
			for (Content current : getContents()) {
				if (current.getParent() != null) {
				//	theChildren.add(current);
				}
			}
		}
		return theChildren;
	}

}
