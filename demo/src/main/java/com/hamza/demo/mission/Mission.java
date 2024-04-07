package com.hamza.demo.mission;

import com.hamza.demo.employee.Employee;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Getter
@Setter
@Entity
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid2")

    private String id;
    private String name;
    private int duration;
    @ManyToMany(mappedBy = "missions")
    private List<Employee>employees;
}
