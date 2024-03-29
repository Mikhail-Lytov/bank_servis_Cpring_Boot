package com.example.bank;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Repository
public class BalanceRepository {
    private final Map<Long, BigDecimal> storage = new HashMap<>(Map.of(1L, BigDecimal.TWO));

    public BigDecimal getBalanceForId(Long accountId) {
        return storage.get(accountId);
    }

    public void save(Long id, BigDecimal amount) {
        storage.put(id, amount);
    }
}
