/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pilat.repository;

import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import org.pilat.model.CourtDepartmentName;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Pilat
 */
public interface CourtDepartmentNameRepository extends CrudRepository<CourtDepartmentName, Long>{
    @Query("select cdn.courtDepartmentName1 from CourtDepartmentName cdn")
    ArrayList<String> getCourtDepartmentName1();
    @Query("select cdn.courtDepartmentName2 from CourtDepartmentName cdn")
    ArrayList<String> getCourtDepartmentName2();
    @Query("select cdn.courtDepartmentName3 from CourtDepartmentName cdn")
    ArrayList<String> getCourtDepartmentName3();
    @Query("select cdn.courtDepartmentName4 from CourtDepartmentName cdn")
    ArrayList<String> getCourtDepartmentName4();
    @Query("select cdn.courtDepartmentName5 from CourtDepartmentName cdn")
    ArrayList<String> getCourtDepartmentName5();
    @Query("select cdn.courtDepartmentName6 from CourtDepartmentName cdn")
    ArrayList<String> getCourtDepartmentName6();
    @Query("select cdn.courtDepartmentName7 from CourtDepartmentName cdn")
    ArrayList<String> getCourtDepartmentName7();
    @Query("select cdn.courtDepartmentName8 from CourtDepartmentName cdn")
    ArrayList<String> getCourtDepartmentName8();    
}
