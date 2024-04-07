package com.hamza.demo.employee;

import com.hamza.demo.adress.Address;
import com.hamza.demo.department.Department;
import com.hamza.demo.mission.Mission;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid2")
    private String id;
    @Column(nullable = false,unique = true)
    private String indentifier;
    @Column(nullable = false)
    private  String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    private LocalDate birthdate;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EmployeeRole role;
    @OneToOne
    @JoinColumn(name = "address-id")
    private Address address;
    @ManyToOne()
    @JoinColumn(name = "department_id")
    private Department department;
    @ManyToMany
    @JoinTable(name = "employee_mission",joinColumns = @JoinColumn(name = "employee_id"),inverseJoinColumns = @JoinColumn(name = "mission_id"))

    private List<Mission>missions;
}
