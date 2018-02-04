/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pilat.repository;

import org.springframework.data.repository.CrudRepository;
import org.pilat.model.Scan;

/**
 *
 * @author Pilat
 */
public interface ScanRepository extends CrudRepository<Scan, Long>{
    
}
