package com.inventarium.repositories;

import com.inventarium.models.Transaction;
import com.inventarium.models.Transaction.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    // Métodos removidos temporariamente pois não temos productId na nova Transaction
    // List<Transaction> findByProductId(Long productId);
    // List<Transaction> findByProductIdOrderByDateDesc(Long productId);
    // long countByProductId(Long productId);
    
    List<Transaction> findByTypeOrderByDateDesc(TransactionType type);
    
    @Query("SELECT t FROM Transaction t WHERE t.date BETWEEN :startDate AND :endDate ORDER BY t.date DESC")
    List<Transaction> findByDateBetween(@Param("startDate") LocalDateTime startDate, 
                                       @Param("endDate") LocalDateTime endDate);
    
    List<Transaction> findAllByOrderByDateDesc();
    
    List<Transaction> findByUsuarioId(Long usuarioId);
}
