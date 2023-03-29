package com.jpmc.theater.discounts;

import com.jpmc.theater.Showing;

public interface Discount {

    /**
     * @return
     */
    public double getDiscount(Showing showing);
}
