/*******************************************************************************
* Copyright (c) 2008 - 2010 itemis AG (http://www.itemis.eu) and others.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*******************************************************************************/
package de.sebastianbenz.task.impl;


public class NoteImplCustom extends de.sebastianbenz.task.impl.NoteImpl {

	
	@Override
	public String getValue() {
		return getText().trim();
	}
	
}