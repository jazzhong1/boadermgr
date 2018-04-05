package com.mvc.model.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

public class MemberDao {
	
	public MemberDao() {
		Properties prop=new Properties();
		{
			try {
				prop.load(new BufferedReader(new FileReader("resource/board_query")));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
