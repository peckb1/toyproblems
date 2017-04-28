package com.github.peckb1.topcoder.practice.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * You are working in an advertising agency. There are 100 billboards owned by your agency, numbered from 1 to 100.
 * <p>
 * You clients send you requests, one after another. Each request is the number of the billboard on which the
 * client would like to place his advertisement.
 * <p>
 * Initially all billboards are empty. Each time you receive a request, you act as follows.
 * If the corresponding billboard is empty, you satisfy the request and occupy the billboard
 * with the client's advertisement. If the corresponding billboard is occupied, you reject the request.
 * <p>
 * You are given a requests containing the requests in the order you receive them. Return the number of rejected requests.
 * <p>
 * This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction
 * of this information without the prior written consent of TopCoder, Inc. is strictly prohibited.
 * (c)2003, TopCoder, Inc. All rights reserved.
 */
public class AdvertisingAgency {

    public int numberOfRejections(int[] requests) {
        Set<Integer> filledBillboards = new HashSet<>();

        for (int billboardRequestIndex : requests) {
            filledBillboards.add(billboardRequestIndex);
        }

        return requests.length - filledBillboards.size();
    }

}
