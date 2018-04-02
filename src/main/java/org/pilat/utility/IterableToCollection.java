/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pilat.utility;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Pilat
 */
@Component
public class IterableToCollection {
    
public static <E> List<E> makeCollection(Iterable<E> iter) {
    System.out.println("ITERACJA" + iter.toString());
    List<E> list = new ArrayList<E>();
    for (E item : iter) {
        list.add(item);
        System.out.println(list.toString());
    }
    System.out.println("KOLEKCJA" + list.toString());
    return list;
}
}
