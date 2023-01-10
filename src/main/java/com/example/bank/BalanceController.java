package com.example.bank;

import com.example.bank.model.TransferBalance;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Slf4j
@RestController("/balance")
@AllArgsConstructor
public class BalanceController { //получить баланс счёта либо пополнить

    private final BankService bankService;
    @GetMapping("/{accountId}")
    public BigDecimal getBalance(@PathVariable Long accountId){ //Получает из Id
        return bankService.getBalance(accountId);

    }

    @PostMapping("/add")
    public BigDecimal add(@RequestBody TransferBalance transferBalance){ //Получает из Id
        return bankService.addMoney(transferBalance.getTo(), transferBalance.getAmount());
    }

    @PostMapping("/transfer")
    public void transfer(@RequestBody TransferBalance transferBalance ){ //Получает из Id
        bankService.maketransfer(transferBalance);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String handle(IllegalArgumentException e){
        log.error(e.getMessage());
        return "MAMA, Pizdec";
    }

}
