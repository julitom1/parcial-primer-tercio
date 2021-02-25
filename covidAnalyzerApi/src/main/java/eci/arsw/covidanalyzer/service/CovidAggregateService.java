package eci.arsw.covidanalyzer.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import eci.arsw.covidanalyzer.model.Result;
import eci.arsw.covidanalyzer.model.ResultType;

@Service
@Controller
public class CovidAggregateService {
	
	@Autowired
	private CovidAggregateService covidAggregateService;
	
	
	
	public boolean aggregateResult(Result result, ResultType type) {
		return covidAggregateService.aggregateResult(result, type);
	}

    /**
     * Get all the results for the specified result type.
     *
     * @param type
     * @return
     */
    public boolean getResult(ResultType type) {
    	return covidAggregateService.getResult(type);
    }

    /**
     * 
     * @param id
     * @param type
     */
    public void upsertPersonWithMultipleTests(UUID id, ResultType type) {
    	covidAggregateService.upsertPersonWithMultipleTests(id, type);
    }
	
	
	

}
