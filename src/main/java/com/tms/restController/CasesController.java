package com.tms.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.tms.models.Query;
import com.tms.models.RegisterComplain;
import com.tms.models.reponse.ResponseDto;
import com.tms.services.CasesService;
import com.tms.utils.StatusResponse;
import com.tms.vo.ComplainVo;
import com.tms.vo.FeedbackVo;
import com.tms.vo.QueryVo;

@RestController
public class CasesController {

	@Autowired
	private CasesService casesService;

	@PostMapping("/saveQuery")
	public ResponseDto queryCases(@RequestBody QueryVo queryvo) {
		ResponseDto response = new ResponseDto();
		try {
			casesService.saveQuery(queryvo);
			response.setStatus(StatusResponse.Success);
			response.setMessage("Query added successfully");
			response.setData(queryvo);
		} catch (Exception e) {
			response.setStatus(StatusResponse.Failed);
			response.setMessage("An error occurred: " + e.getMessage());
			e.printStackTrace();
		}
		return response;
	}

	@PostMapping("/saveComplain")
	public ResponseDto complainCases(@RequestBody ComplainVo complain) {
		ResponseDto response = new ResponseDto();
		try {
			casesService.saveComplain(complain);
			response.setStatus(StatusResponse.Success);
			response.setMessage("Complain added successfully");
			response.setData(complain);
		} catch (Exception e) {
			response.setStatus(StatusResponse.Failed);
			response.setMessage("An error occurred: " + e.getMessage());
			e.printStackTrace();
		}
		return response;
	}

	@PostMapping("/saveFeedback")
	public ResponseDto feedbackCases(@RequestBody FeedbackVo feedback) {
		ResponseDto response = new ResponseDto();
		try {
			casesService.saveFeedback(feedback);
			response.setStatus(StatusResponse.Success);
			response.setMessage("Feedback added successfully");
			response.setData(feedback);
		} catch (Exception e) {
			response.setStatus(StatusResponse.Failed);
			response.setMessage("An error occurred: " + e.getMessage());
			e.printStackTrace();
		}
		return response;
	}

	@PostMapping("/pendingQuery")
	public List<Query> getPendingQuery(@RequestParam String status) {
		List<Query> pendingQuery = casesService.getPendingQuery(status);
		return pendingQuery;
	}

	@PostMapping("/pendingComplain")
	public List<RegisterComplain> getPendingcomplain(@RequestParam String status) {
		List<RegisterComplain> pendingComplain = casesService.getPendingComplain(status);
		return pendingComplain;
	}

	@PutMapping("/editQuery")
	public Query updateQuery(@RequestParam Long queryId, @RequestBody QueryVo updatedQuery) {
		return casesService.updateQuery(queryId, updatedQuery);
	}

	@PostMapping("/searchQuery")
	public List<Query> searchBasedOnParam(@RequestParam(required = false) String terminalId,
			@RequestParam(required = false) String mobileNumber, @RequestParam(required = false) String email) {
		if (terminalId != null) {
			return casesService.getByTerminalId(terminalId);
		} else if (mobileNumber != null) {
			return casesService.getByMobileNumber(mobileNumber);
		} else if (email != null) {
			return casesService.getByEmail(email);
		} else {
			// Handle if no search parameters are provided
			return null;
		}
	}
}
