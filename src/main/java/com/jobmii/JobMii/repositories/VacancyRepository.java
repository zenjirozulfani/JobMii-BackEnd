package com.jobmii.JobMii.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jobmii.JobMii.models.Vacancy;

@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, Integer> {

}
