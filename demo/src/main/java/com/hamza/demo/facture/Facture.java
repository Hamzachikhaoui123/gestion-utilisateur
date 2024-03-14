package com.hamza.demo.facture;

import com.hamza.demo.payment.Payment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid2")
    private String id;

    private String ref;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment-id")
    private Payment payment;
}
