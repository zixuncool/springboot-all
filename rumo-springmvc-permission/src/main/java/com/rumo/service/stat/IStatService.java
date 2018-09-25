package com.rumo.service.stat;

import com.rumo.pojo.Params;
import com.rumo.vo.ServerResponse;

public interface IStatService {
	public ServerResponse findStats(Params params);
}
