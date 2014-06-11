package sample.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleRestService {

	@RequestMapping("/greet")
	public String greet(){
		return "hello";
	}
}
