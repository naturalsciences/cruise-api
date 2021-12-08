/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.naturalsciences.bmdc.cruise.comparator;

import be.naturalsciences.bmdc.cruise.model.ICoordinate;
import java.util.Comparator;

/**
 *
 * @author thomas
 */
public class CoordinateComparator implements Comparator<ICoordinate> {

    public int compare(ICoordinate p1, ICoordinate p2) {
        if (p1.getY() < p2.getY()) {
            return -1;
        }
        if (p1.getY() > p2.getY()) {
            return 1;
        }
        return 0;
    }
}
