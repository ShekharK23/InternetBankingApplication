package com.app.bank.controller;


import com.app.bank.entity.DebitCard;
import com.app.bank.service.IDebitCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/debit-cards")
public class DebitCardController {
	

    @Autowired
    private IDebitCardService debitCardService;

    @PostMapping("/create")
    public long createDebitCard(@RequestBody DebitCard debitCard) {
        return debitCardService.saveDebitCardDetails(debitCard);
    }

    @GetMapping("/{debitCardNumber}")
    public DebitCard getDebitCard(@PathVariable long debitCardNumber) {
        return debitCardService.getDebitCardByDebitCardNumber(debitCardNumber);
    }

    @PutMapping("/{debitCardNumber}/change-pin")
    public DebitCard changePin(@PathVariable long debitCardNumber, @RequestParam int newPin) {
        return debitCardService.changePin(debitCardNumber, newPin);
    }

    @GetMapping("/{debitCardNumber}/check-expiry")
    public String checkExpiry(@PathVariable long debitCardNumber) {
        return debitCardService.checkExpiry(debitCardNumber);
    }

    @PutMapping("/{debitCardNumber}/request-new-card")
    public DebitCard requestNewCard(@PathVariable long debitCardNumber) {
        return debitCardService.requestNewCard(debitCardNumber);
    }
}
