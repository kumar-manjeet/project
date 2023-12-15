package com.tms.services;

import java.util.List;

import com.tms.models.Feedback;
import com.tms.models.Query;
import com.tms.models.RegisterComplain;
import com.tms.vo.ComplainVo;
import com.tms.vo.FeedbackVo;
import com.tms.vo.QueryVo;

public interface CasesService {

	public Query saveQuery(QueryVo query);

	public RegisterComplain saveComplain(ComplainVo complain);

	public Feedback saveFeedback(FeedbackVo feedback);

	public List<Query> getPendingQuery(String status);

	public List<RegisterComplain> getPendingComplain(String status);

	public Query updateQuery(Long queryId, QueryVo updatedQuery);

	List<Query> getByTerminalId(String id);

	List<Query> getByMobileNumber(String mobileNumber);

	List<Query> getByEmail(String email);

}
