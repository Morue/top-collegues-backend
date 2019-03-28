package dev.top.controller;

import java.util.List;
import dev.top.entities.Collegue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import dev.top.service.CollegueService;


@RestController
@RequestMapping("/collegues")
public class CollegueController {

	@Autowired
    private CollegueService collegueService;
	
	@GetMapping
    public List<Collegue> findAll() {
        return this.collegueService.findAll();
    }
	// PATCH /collegues/PSEUDO
	@PatchMapping("/{pseudo}")
	public Collegue voter(@PathVariable String pseudo, @RequestBody VoteWeb vote) {
		
		return this.collegueService.voter(pseudo, vote.getAction());
		
		
	}
}