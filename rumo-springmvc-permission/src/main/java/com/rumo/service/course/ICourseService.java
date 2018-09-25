package com.rumo.service.course;

import com.rumo.pojo.Params;
import com.rumo.vo.ServerResponse;

public interface ICourseService {
	public ServerResponse findCourses(Params params);
}
