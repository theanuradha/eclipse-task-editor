/*******************************************************************************
 * Copyright (c) 2011 Sebastian Benz.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sebastian Benz - initial API and implementation
 *******************************************************************************/
/*
 * generated by Xtext
 */
package de.sebastianbenz.task;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;


public class ParserTest extends AbstractTest {

	@Test
	public void parseRootProject() throws Exception {
		assertThat(parse("Project:\n"), are(Project.class));
		assertThat(parse(" Project:\n"), are(Project.class));
		assertThat(parse("	Project:\n"), are(Project.class));
		assertThat(parse("  Project:\n"), are(Project.class));
		assertThat(parse("		Project:\n"), are(Project.class));
		assertThat(parse("	 Project:\n"), are(Project.class));
		assertThat(parse("	  Project:\n"), are(Project.class));
	}

	@Test
	public void parseRootProjectWithLineBreak() throws Exception {
		assertThat(parse("Project:\n"), are(Project.class));
		assertThat(parse("Project-:\n"), are(Project.class));
		assertThat(parse("Project:\n "), are(Project.class));
		assertThat(parse("Project:\n	"), are(Project.class));
	}

	@Test
	public void parseMixedContent() throws Exception {
		assertThat(parse("note\nProject:\n"), are(Note.class, Project.class));
	}
	
	@Test
	public void parseOpenTask() throws Exception {
		assertThat(parse("- a task\n"), are(Task.class));
		assertThat(parse(" - a task\n"), are(Task.class));
		assertThat(parse("		- a task\n"), are(Task.class));
		assertThat(parse("- a task :\n"), are(Task.class));
		assertThat(parse("- a task\n"), are(Task.class));
		assertThat(parse("- a task\n "), are(Task.class));
		assertThat(parse("- a task\n	"), are(Task.class));
	}

	@Test
	public void parseClosedTask() throws Exception {
		assertThat(parse("- a task@done\n"), are(Task.class));
		assertThat(parse(" - a task @done\n"), are(Task.class));
		assertThat(parse("		- a task@done\n"), are(Task.class));
		assertThat(parse("- a task :@done\n"), are(Task.class));
		assertThat(parse("- a task @done\n"), are(Task.class));
		assertThat(parse("- a task@done\n "), are(Task.class));
		assertThat(parse("- a task @done\n	"), are(Task.class));
	}

	@Test
	public void parseDoneTag() throws Exception {
		assertThat(tagsOf(firstTask(parse("- a task@done\n"))), is("@done"));
	}

	@Test
	public void parseOtherTag() throws Exception {
		assertThat(tagsOf(firstTask(parse("- a task@today\n"))), is("@today"));
	}

	@Test
	public void parseEmptyLines() throws Exception {
		assertThat(parse("\nProject:\n"), are(Project.class));
		assertThat(parse("	\nProject:\n"), are(Project.class));
		assertThat(parse("Project:\n  \n"), are(Project.class));
		assertThat(parse("Project:\n\n\nProject:\n"),
				are(Project.class, Project.class));
	}
}
