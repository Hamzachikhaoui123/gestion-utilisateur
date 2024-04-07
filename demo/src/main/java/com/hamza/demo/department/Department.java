package com.hamza.demo.department;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid2")
    private String Id;
    private String name;
}
