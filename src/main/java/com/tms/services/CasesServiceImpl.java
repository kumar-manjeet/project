package com.tms.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.models.Feedback;
import com.tms.models.Query;
import com.tms.models.RegisterComplain;
import com.tms.repositories.ComplainRepository;
import com.tms.repositories.FeedbackRepository;
import com.tms.repositories.QueryRepository;
import com.tms.vo.ComplainVo;
import com.tms.vo.FeedbackVo;
import com.tms.vo.QueryVo;

@Service
public class CasesServiceImpl implements CasesService {

	@Autowired
	private QueryRepository queryRepository;

	@Autowired
	private ComplainRepository complainRepository;

	@Autowired
	private FeedbackRepository feedbackRepository;

	@Override
	public Query saveQuery(QueryVo queryvo) {
		Query query = new Query();
		BeanUtils.copyProperties(queryvo, query);
		return queryRepository.save(query);
	}

	@Override
	public RegisterComplain saveComplain(ComplainVo complain) {
		RegisterComplain registerComplain = new RegisterComplain();
		BeanUtils.copyProperties(complain, registerComplain);
		return complainRepository.save(registerComplain);
	}

	@Override
	public Feedback saveFeedback(FeedbackVo feedbackvo) {
		Feedback feedback = new Feedback();
		BeanUtils.copyProperties(feedbackvo, feedback);
		return feedbackRepository.save(feedback);
	}

	@Override
	public List<Query> getPendingQuery(String status) {
		return queryRepository.findByStatus(status);
	}

	@Override
	public List<RegisterComplain> getPendingComplain(String status) {
		return complainRepository.findByStatus(status);
	}

	@Override
	public List<Query> getByTerminalId(String id) {
		return queryRepository.findByTerminalId(id);
	}

	@Override
	public List<Query> getByMobileNumber(String mobileNumber) {
		return queryRepository.findByMobileNumber(mobileNumber);
	}

	@Override
	public List<Query> getByEmail(String email) {
		return queryRepository.findByEmail(email);
	}

	@Override
	public Query updateQuery(Long queryId, QueryVo updatedQuery) {
		Optional<Query> queryOptional = queryRepository.findById(queryId);

		if (queryOptional.isPresent()) {
			Query existingEntity = queryOptional.get();
			existingEntity.setEmail(updatedQuery.getEmail());
			return queryRepository.save(existingEntity);
		} else {
			// Handle entity not found
			return null;
		}
	}

}
