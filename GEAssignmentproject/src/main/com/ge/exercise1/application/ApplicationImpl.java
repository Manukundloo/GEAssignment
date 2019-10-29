package main.com.ge.exercise1.application;

import java.util.ArrayList;
import java.util.Collection;

import main.com.ge.exercise1.Application;
import main.com.ge.exercise1.Group;
import main.com.ge.exercise1.User;

public class ApplicationImpl extends Application {

	private UserImpl userImpl;
	private GroupImpl groupImpl;

	public ApplicationImpl(String id, String name) {
		super(id, name);

	}

	@Override
	public Collection<User> getUsers() {

		Collection<User> users = new ArrayList<User>();
		users.add(userImpl);

		return users;
	}

	@Override
	public User getUser(String userId) {
		userImpl = new UserImpl(getId(), getName());
		return userImpl;
	}

	@Override
	public Collection<Group> getGroups() {
		Collection<Group> groups = new ArrayList<Group>();
		groups.add(groupImpl);

		return groups;
	}

	@Override
	public Group getGroup(String groupId) {

		groupImpl = new GroupImpl(getId(), getName());
		return groupImpl;
	}

}
