package de.sebastianbenz.task.resource;

import static java.util.Collections.emptySet;

import java.util.Set;

import org.eclipse.xtext.resource.IEObjectDescription;

import com.google.common.collect.Sets;

public class Descriptions {

	public static final String TAG_KEY = "tags";
	public static final String SEPARATOR = "|";
	public static Set<String> tagsOf(IEObjectDescription description) {
		String userData = description.getUserData(TAG_KEY);
		if(userData == null || userData.length() == 0){
			return emptySet();
		}
		String[] tags = userData.split("\\" + SEPARATOR);
		Set<String> result = Sets.newHashSetWithExpectedSize(tags.length);
		for (String tag : tags) {
			result.add(tag);
		}
		return result;
	}

}
