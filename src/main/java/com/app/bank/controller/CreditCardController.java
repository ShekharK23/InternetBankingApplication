package com.app.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.app.bank.entity.CreditCard;
import com.app.bank.service.ICreditCardService;

@RestController
@RequestMapping("/creditcard")
public class CreditCardController {

    @Autowired
    private ICreditCardService creditCardService;

    @PostMapping("/save")
    public long saveCreditCardDetails(@RequestBody CreditCard creditCard) {
        return creditCardService.saveCreditCardDetails(creditCard);
    }

    @GetMapping("/{creditCardNumber}")
    public CreditCard getCreditCardByCreditCardNumber(@PathVariable long creditCardNumber) {
        return creditCardService.getCreditCardByCreditCardNumber(creditCardNumber);
    }

    @PutMapping("/changepin/{creditCardNumber}")
    public CreditCard changePin(@PathVariable long creditCardNumber, @RequestParam int newPin) {
        return creditCardService.changePin(creditCardNumber, newPin);
    }

    @GetMapping("/checkexpiry/{creditCardNumber}")
    public String checkExpiry(@PathVariable long creditCardNumber) {
        return creditCardService.checkExpiry(creditCardNumber);
    }

    @PostMapping("/requestnewcard/{creditCardNumber}")
    public CreditCard requestNewCard(@PathVariable long creditCardNumber) {
        return creditCardService.requestNewCard(creditCardNumber);
    }
}
