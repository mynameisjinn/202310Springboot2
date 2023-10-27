package com.hello.core.discount;

import com.hello.core.member.Member;

public interface Discount {

    /**
     * Get the discount
     * @param member
     * @param price
     * @return discounted price
     */
    int discount(Member member, int price);
}
