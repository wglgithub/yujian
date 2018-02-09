package com.topmobile.test;

import java.util.List;

import com.google.common.collect.Lists;
import com.topmobile.util.Constants;

public class ListsTest {

	public static void main(String[] args) {
		List<String> inviteRange = Lists.newArrayList(Constants.Role.SUPPER_ADMIN,Constants.Role.DAI_LI);
		System.out.println(inviteRange);
	}
}
