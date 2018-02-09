package com.topmobile.service;

import java.util.List;

import com.topmobile.entry.Malls;

public interface MallsService {

	int insertOne(Malls mall);

	List<Malls> findAll();

}
