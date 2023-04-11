package com.xfactor.openlibrary.controllers;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xfactor.openlibrary.domain.Loan;
import com.xfactor.openlibrary.repositories.LoanRepository;

@RestController
@RequestMapping("loan")
public class LoanController {

    private LoanRepository loanRepository;

    public LoanController(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @PostMapping("/saveLoan")
    public Loan saveLoan(@RequestBody Loan loan) {
        loanRepository.save(loan);
        return loan;
    }

    @GetMapping("/getAll")
    public List<Loan> getAllLoan() {
        return loanRepository.findAll();
    }

}