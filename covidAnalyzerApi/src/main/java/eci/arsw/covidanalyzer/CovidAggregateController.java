package eci.arsw.covidanalyzer;

import eci.arsw.covidanalyzer.model.Result;
import eci.arsw.covidanalyzer.model.ResultType;
import eci.arsw.covidanalyzer.service.ICovidAggregateService;

import java.util.UUID;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CovidAggregateController {
	
	//@Autowired
    ICovidAggregateService covidAggregateService;
    
    
    

    //TODO: Implemente todos los metodos POST que hacen falta.

    @RequestMapping(value = "/covid/result/true-positive", method = RequestMethod.POST)
    public ResponseEntity addTruePositiveResult(Result result) {
        
        covidAggregateService.aggregateResult(result, ResultType.TRUE_POSITIVE);
        
        return null;
    }

    //TODO: Implemente todos los metodos GET que hacen falta.

    @RequestMapping(value = "/covid/result/true-positive", method = RequestMethod.GET)
    public ResponseEntity getTruePositiveResult() {
        //TODO
        covidAggregateService.getResult(ResultType.TRUE_POSITIVE);
        return ResponseEntity.ok("Hello World");
    }
    
    @RequestMapping(value = "/covid/result/true-negative", method = RequestMethod.GET)
    public ResponseEntity getTrueNegativeResult(Result result) {
    	covidAggregateService.getResult(ResultType.TRUE_NEGATIVE);
    	return ResponseEntity.ok("Hello World");
    }
    
    @RequestMapping(value = "/covid/result/false-positive", method = RequestMethod.GET)
    public ResponseEntity getTrueFalsePositiveResult(Result result) {
    	covidAggregateService.getResult(ResultType.FALSE_POSITIVE);
    	return ResponseEntity.ok("Hello World");
    }
    
    @RequestMapping(value = "/covid/result/false-negative", method = RequestMethod.GET)
    public ResponseEntity getTrueFalseNegativeResult(Result result) {
    	covidAggregateService.getResult(ResultType.FALSE_NEGATIVE);
    	return ResponseEntity.ok("Hello World");
    }
    
    @RequestMapping(value = "/covid/result/true-negative", method = RequestMethod.POST)
    public ResponseEntity addTrueNegativeResult(Result result) {
        //TODO
        covidAggregateService.aggregateResult(result, ResultType.TRUE_NEGATIVE);
        return null;
    }
    
    @RequestMapping(value = "/covid/result/false-positive", method = RequestMethod.POST)
    public ResponseEntity addTrueFalsePositiveResult(Result result) {
        //TODO
        covidAggregateService.aggregateResult(result, ResultType.FALSE_POSITIVE);
        return null;
    }
    
    @RequestMapping(value = "/covid/result/false-negative", method = RequestMethod.POST)
    public ResponseEntity addTrueFalseNegativeResult(Result result) {
        //TODO
        covidAggregateService.aggregateResult(result, ResultType.FALSE_NEGATIVE);
        return null;
    }


    //TODO: Implemente el método.

    @RequestMapping(value = "/covid/result/persona/{id}", method = RequestMethod.PUT)
    public ResponseEntity savePersonaWithMultipleTests(@PathVariable UUID id, @RequestBody ResultType tipo) {
        //TODO
    	JSONObject O;
        covidAggregateService.upsertPersonWithMultipleTests(id,tipo);
        return null;
    }
    
}